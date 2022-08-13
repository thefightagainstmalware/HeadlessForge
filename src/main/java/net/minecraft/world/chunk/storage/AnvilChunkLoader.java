package net.minecraft.world.chunk.storage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.NextTickListEntry;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.NibbleArray;
import net.minecraft.world.storage.IThreadedFileIO;
import net.minecraft.world.storage.ThreadedFileIOBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AnvilChunkLoader implements IChunkLoader, IThreadedFileIO
{
    private static final Logger logger = LogManager.getLogger();
    private Map<ChunkCoordIntPair, NBTTagCompound> chunksToRemove = new ConcurrentHashMap();
    private Set<ChunkCoordIntPair> pendingAnvilChunksCoordinates = Collections.<ChunkCoordIntPair>newSetFromMap(new ConcurrentHashMap());

    /** Save directory for chunks using the Anvil format */
    private final File chunkSaveLocation;
    private boolean field_183014_e = false;

    public AnvilChunkLoader(File chunkSaveLocationIn)
    {
        this.chunkSaveLocation = chunkSaveLocationIn;
    }

    /**
     * Loads the specified(XZ) chunk into the specified world.
     */
    public Chunk loadChunk(World worldIn, int x, int z) throws IOException
    {
        ChunkCoordIntPair chunkcoordintpair = new ChunkCoordIntPair(x, z);
        NBTTagCompound nbttagcompound = (NBTTagCompound)this.chunksToRemove.get(chunkcoordintpair);

        if (nbttagcompound == null)
        {
            DataInputStream datainputstream = RegionFileCache.getChunkInputStream(this.chunkSaveLocation, x, z);

            if (datainputstream == null)
            {
                return null;
            }

            nbttagcompound = CompressedStreamTools.read(datainputstream);
        }

        return this.checkedReadChunkFromNBT(worldIn, x, z, nbttagcompound);
    }

    /**
     * Wraps readChunkFromNBT. Checks the coordinates and several NBT tags.
     */
    protected Chunk checkedReadChunkFromNBT(World worldIn, int x, int z, NBTTagCompound p_75822_4_)
    {
        if (!p_75822_4_.func_150297_b("Level", 10))
        {
            logger.error("Chunk file at " + x + "," + z + " is missing level data, skipping");
            return null;
        }
        else
        {
            NBTTagCompound nbttagcompound = p_75822_4_.func_74775_l("Level");

            if (!nbttagcompound.func_150297_b("Sections", 9))
            {
                logger.error("Chunk file at " + x + "," + z + " is missing block data, skipping");
                return null;
            }
            else
            {
                Chunk chunk = this.readChunkFromNBT(worldIn, nbttagcompound);

                if (!chunk.isAtLocation(x, z))
                {
                    logger.error("Chunk file at " + x + "," + z + " is in the wrong location; relocating. (Expected " + x + ", " + z + ", got " + chunk.xPosition + ", " + chunk.zPosition + ")");
                    nbttagcompound.func_74768_a("xPos", x);
                    nbttagcompound.func_74768_a("zPos", z);
                    chunk = this.readChunkFromNBT(worldIn, nbttagcompound);
                }

                return chunk;
            }
        }
    }

    public void saveChunk(World worldIn, Chunk chunkIn) throws MinecraftException, IOException
    {
        worldIn.checkSessionLock();

        try
        {
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            nbttagcompound.func_74782_a("Level", nbttagcompound1);
            this.writeChunkToNBT(chunkIn, worldIn, nbttagcompound1);
            this.addChunkToPending(chunkIn.getChunkCoordIntPair(), nbttagcompound);
        }
        catch (Exception exception)
        {
            logger.error((String)"Failed to save chunk", (Throwable)exception);
        }
    }

    protected void addChunkToPending(ChunkCoordIntPair p_75824_1_, NBTTagCompound p_75824_2_)
    {
        if (!this.pendingAnvilChunksCoordinates.contains(p_75824_1_))
        {
            this.chunksToRemove.put(p_75824_1_, p_75824_2_);
        }

        ThreadedFileIOBase.getThreadedIOInstance().queueIO(this);
    }

    /**
     * Returns a boolean stating if the write was unsuccessful.
     */
    public boolean writeNextIO()
    {
        if (this.chunksToRemove.isEmpty())
        {
            if (this.field_183014_e)
            {
                logger.info("ThreadedAnvilChunkStorage ({}): All chunks are saved", new Object[] {this.chunkSaveLocation.getName()});
            }

            return false;
        }
        else
        {
            ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair)this.chunksToRemove.keySet().iterator().next();
            boolean lvt_3_1_;

            try
            {
                this.pendingAnvilChunksCoordinates.add(chunkcoordintpair);
                NBTTagCompound nbttagcompound = (NBTTagCompound)this.chunksToRemove.remove(chunkcoordintpair);

                if (nbttagcompound != null)
                {
                    try
                    {
                        this.func_183013_b(chunkcoordintpair, nbttagcompound);
                    }
                    catch (Exception exception)
                    {
                        logger.error((String)"Failed to save chunk", (Throwable)exception);
                    }
                }

                lvt_3_1_ = true;
            }
            finally
            {
                this.pendingAnvilChunksCoordinates.remove(chunkcoordintpair);
            }

            return lvt_3_1_;
        }
    }

    private void func_183013_b(ChunkCoordIntPair p_183013_1_, NBTTagCompound p_183013_2_) throws IOException
    {
        DataOutputStream dataoutputstream = RegionFileCache.getChunkOutputStream(this.chunkSaveLocation, p_183013_1_.chunkXPos, p_183013_1_.chunkZPos);
        CompressedStreamTools.write(p_183013_2_, dataoutputstream);
        dataoutputstream.close();
    }

    /**
     * Save extra data associated with this Chunk not normally saved during autosave, only during chunk unload.
     * Currently unused.
     */
    public void saveExtraChunkData(World worldIn, Chunk chunkIn) throws IOException
    {
    }

    /**
     * Called every World.tick()
     */
    public void chunkTick()
    {
    }

    /**
     * Save extra data not associated with any Chunk.  Not saved during autosave, only during world unload.  Currently
     * unused.
     */
    public void saveExtraData()
    {
        try
        {
            this.field_183014_e = true;

            while (true)
            {
                if (this.writeNextIO())
                {
                    continue;
                }
            }
        }
        finally
        {
            this.field_183014_e = false;
        }
    }

    /**
     * Writes the Chunk passed as an argument to the NBTTagCompound also passed, using the World argument to retrieve
     * the Chunk's last update time.
     */
    private void writeChunkToNBT(Chunk chunkIn, World worldIn, NBTTagCompound p_75820_3_)
    {
        p_75820_3_.setByte("V", (byte)1);
        p_75820_3_.func_74768_a("xPos", chunkIn.xPosition);
        p_75820_3_.func_74768_a("zPos", chunkIn.zPosition);
        p_75820_3_.setLong("LastUpdate", worldIn.func_82737_E());
        p_75820_3_.setIntArray("HeightMap", chunkIn.getHeightMap());
        p_75820_3_.setBoolean("TerrainPopulated", chunkIn.isTerrainPopulated());
        p_75820_3_.setBoolean("LightPopulated", chunkIn.isLightPopulated());
        p_75820_3_.setLong("InhabitedTime", chunkIn.getInhabitedTime());
        ExtendedBlockStorage[] aextendedblockstorage = chunkIn.getBlockStorageArray();
        NBTTagList nbttaglist = new NBTTagList();
        boolean flag = !worldIn.provider.getHasNoSky();

        for (ExtendedBlockStorage extendedblockstorage : aextendedblockstorage)
        {
            if (extendedblockstorage != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Y", (byte)(extendedblockstorage.getYLocation() >> 4 & 255));
                byte[] abyte = new byte[extendedblockstorage.getData().length];
                NibbleArray nibblearray = new NibbleArray();
                NibbleArray nibblearray1 = null;

                for (int i = 0; i < extendedblockstorage.getData().length; ++i)
                {
                    char c0 = extendedblockstorage.getData()[i];
                    int j = i & 15;
                    int k = i >> 8 & 15;
                    int l = i >> 4 & 15;

                    if (c0 >> 12 != 0)
                    {
                        if (nibblearray1 == null)
                        {
                            nibblearray1 = new NibbleArray();
                        }

                        nibblearray1.set(j, k, l, c0 >> 12);
                    }

                    abyte[i] = (byte)(c0 >> 4 & 255);
                    nibblearray.set(j, k, l, c0 & 15);
                }

                nbttagcompound.setByteArray("Blocks", abyte);
                nbttagcompound.setByteArray("Data", nibblearray.getData());

                if (nibblearray1 != null)
                {
                    nbttagcompound.setByteArray("Add", nibblearray1.getData());
                }

                nbttagcompound.setByteArray("BlockLight", extendedblockstorage.getBlocklightArray().getData());

                if (flag)
                {
                    nbttagcompound.setByteArray("SkyLight", extendedblockstorage.getSkylightArray().getData());
                }
                else
                {
                    nbttagcompound.setByteArray("SkyLight", new byte[extendedblockstorage.getBlocklightArray().getData().length]);
                }

                nbttaglist.func_74742_a(nbttagcompound);
            }
        }

        p_75820_3_.func_74782_a("Sections", nbttaglist);
        p_75820_3_.setByteArray("Biomes", chunkIn.getBiomeArray());
        chunkIn.setHasEntities(false);
        NBTTagList nbttaglist1 = new NBTTagList();

        for (int i1 = 0; i1 < chunkIn.getEntityLists().length; ++i1)
        {
            for (Entity entity : chunkIn.getEntityLists()[i1])
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();

                if (entity.writeToNBTOptional(nbttagcompound1))
                {
                    chunkIn.setHasEntities(true);
                    nbttaglist1.func_74742_a(nbttagcompound1);
                }
            }
        }

        p_75820_3_.func_74782_a("Entities", nbttaglist1);
        NBTTagList nbttaglist2 = new NBTTagList();

        for (TileEntity tileentity : chunkIn.getTileEntityMap().values())
        {
            NBTTagCompound nbttagcompound2 = new NBTTagCompound();
            tileentity.func_145841_b(nbttagcompound2);
            nbttaglist2.func_74742_a(nbttagcompound2);
        }

        p_75820_3_.func_74782_a("TileEntities", nbttaglist2);
        List<NextTickListEntry> list = worldIn.getPendingBlockUpdates(chunkIn, false);

        if (list != null)
        {
            long j1 = worldIn.func_82737_E();
            NBTTagList nbttaglist3 = new NBTTagList();

            for (NextTickListEntry nextticklistentry : list)
            {
                NBTTagCompound nbttagcompound3 = new NBTTagCompound();
                ResourceLocation resourcelocation = (ResourceLocation)Block.field_149771_c.getNameForObject(nextticklistentry.func_151351_a());
                nbttagcompound3.func_74778_a("i", resourcelocation == null ? "" : resourcelocation.toString());
                nbttagcompound3.func_74768_a("x", nextticklistentry.field_180282_a.func_177958_n());
                nbttagcompound3.func_74768_a("y", nextticklistentry.field_180282_a.func_177956_o());
                nbttagcompound3.func_74768_a("z", nextticklistentry.field_180282_a.func_177952_p());
                nbttagcompound3.func_74768_a("t", (int)(nextticklistentry.field_77180_e - j1));
                nbttagcompound3.func_74768_a("p", nextticklistentry.field_82754_f);
                nbttaglist3.func_74742_a(nbttagcompound3);
            }

            p_75820_3_.func_74782_a("TileTicks", nbttaglist3);
        }
    }

    /**
     * Reads the data stored in the passed NBTTagCompound and creates a Chunk with that data in the passed World.
     * Returns the created Chunk.
     */
    private Chunk readChunkFromNBT(World worldIn, NBTTagCompound p_75823_2_)
    {
        int i = p_75823_2_.getInteger("xPos");
        int j = p_75823_2_.getInteger("zPos");
        Chunk chunk = new Chunk(worldIn, i, j);
        chunk.setHeightMap(p_75823_2_.getIntArray("HeightMap"));
        chunk.setTerrainPopulated(p_75823_2_.getBoolean("TerrainPopulated"));
        chunk.setLightPopulated(p_75823_2_.getBoolean("LightPopulated"));
        chunk.setInhabitedTime(p_75823_2_.getLong("InhabitedTime"));
        NBTTagList nbttaglist = p_75823_2_.getTagList("Sections", 10);
        int k = 16;
        ExtendedBlockStorage[] aextendedblockstorage = new ExtendedBlockStorage[k];
        boolean flag = !worldIn.provider.getHasNoSky();

        for (int l = 0; l < nbttaglist.func_74745_c(); ++l)
        {
            NBTTagCompound nbttagcompound = nbttaglist.func_150305_b(l);
            int i1 = nbttagcompound.getByte("Y");
            ExtendedBlockStorage extendedblockstorage = new ExtendedBlockStorage(i1 << 4, flag);
            byte[] abyte = nbttagcompound.getByteArray("Blocks");
            NibbleArray nibblearray = new NibbleArray(nbttagcompound.getByteArray("Data"));
            NibbleArray nibblearray1 = nbttagcompound.func_150297_b("Add", 7) ? new NibbleArray(nbttagcompound.getByteArray("Add")) : null;
            char[] achar = new char[abyte.length];

            for (int j1 = 0; j1 < achar.length; ++j1)
            {
                int k1 = j1 & 15;
                int l1 = j1 >> 8 & 15;
                int i2 = j1 >> 4 & 15;
                int j2 = nibblearray1 != null ? nibblearray1.get(k1, l1, i2) : 0;
                achar[j1] = (char)(j2 << 12 | (abyte[j1] & 255) << 4 | nibblearray.get(k1, l1, i2));
            }

            extendedblockstorage.setData(achar);
            extendedblockstorage.setBlocklightArray(new NibbleArray(nbttagcompound.getByteArray("BlockLight")));

            if (flag)
            {
                extendedblockstorage.setSkylightArray(new NibbleArray(nbttagcompound.getByteArray("SkyLight")));
            }

            extendedblockstorage.removeInvalidBlocks();
            aextendedblockstorage[i1] = extendedblockstorage;
        }

        chunk.setStorageArrays(aextendedblockstorage);

        if (p_75823_2_.func_150297_b("Biomes", 7))
        {
            chunk.setBiomeArray(p_75823_2_.getByteArray("Biomes"));
        }

        NBTTagList nbttaglist1 = p_75823_2_.getTagList("Entities", 10);

        if (nbttaglist1 != null)
        {
            for (int k2 = 0; k2 < nbttaglist1.func_74745_c(); ++k2)
            {
                NBTTagCompound nbttagcompound1 = nbttaglist1.func_150305_b(k2);
                Entity entity = EntityList.func_75615_a(nbttagcompound1, worldIn);
                chunk.setHasEntities(true);

                if (entity != null)
                {
                    chunk.addEntity(entity);
                    Entity entity1 = entity;

                    for (NBTTagCompound nbttagcompound4 = nbttagcompound1; nbttagcompound4.func_150297_b("Riding", 10); nbttagcompound4 = nbttagcompound4.func_74775_l("Riding"))
                    {
                        Entity entity2 = EntityList.func_75615_a(nbttagcompound4.func_74775_l("Riding"), worldIn);

                        if (entity2 != null)
                        {
                            chunk.addEntity(entity2);
                            entity1.func_70078_a(entity2);
                        }

                        entity1 = entity2;
                    }
                }
            }
        }

        NBTTagList nbttaglist2 = p_75823_2_.getTagList("TileEntities", 10);

        if (nbttaglist2 != null)
        {
            for (int l2 = 0; l2 < nbttaglist2.func_74745_c(); ++l2)
            {
                NBTTagCompound nbttagcompound2 = nbttaglist2.func_150305_b(l2);
                TileEntity tileentity = TileEntity.createAndLoadEntity(nbttagcompound2);

                if (tileentity != null)
                {
                    chunk.addTileEntity(tileentity);
                }
            }
        }

        if (p_75823_2_.func_150297_b("TileTicks", 9))
        {
            NBTTagList nbttaglist3 = p_75823_2_.getTagList("TileTicks", 10);

            if (nbttaglist3 != null)
            {
                for (int i3 = 0; i3 < nbttaglist3.func_74745_c(); ++i3)
                {
                    NBTTagCompound nbttagcompound3 = nbttaglist3.func_150305_b(i3);
                    Block block;

                    if (nbttagcompound3.func_150297_b("i", 8))
                    {
                        block = Block.func_149684_b(nbttagcompound3.getString("i"));
                    }
                    else
                    {
                        block = Block.getBlockById(nbttagcompound3.getInteger("i"));
                    }

                    worldIn.func_180497_b(new BlockPos(nbttagcompound3.getInteger("x"), nbttagcompound3.getInteger("y"), nbttagcompound3.getInteger("z")), block, nbttagcompound3.getInteger("t"), nbttagcompound3.getInteger("p"));
                }
            }
        }

        return chunk;
    }
}
