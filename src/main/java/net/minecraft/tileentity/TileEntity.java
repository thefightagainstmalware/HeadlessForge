package net.minecraft.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityDispatcher;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public abstract class TileEntity extends Object {

    /**
     *
     */
    private static final Logger logger = null;

    /**
     *
     */
    private static java.util.Map<java.lang.String,java.lang.Class<? extends TileEntity>> nameToClassMap;

    /**
     *
     */
    private static java.util.Map<java.lang.Class<? extends TileEntity>,java.lang.String> classToNameMap;

    /**
     * the instance of the world the tile entity is in.
     */
    protected World worldObj;

    /**
     *
     */
    protected BlockPos pos;

    /**
     *
     */
    protected boolean tileEntityInvalid;

    /**
     *
     */
    private int blockMetadata;

    /**
     * the Block type that this TileEntity is contained within
     */
    protected Block blockType;

    /**
     *
     */
    private boolean isVanilla;

    /**
     * Sometimes default render bounding box: infinite in scope. Used to control rendering on <code>TileEntitySpecialRenderer</code>.
     */
    public static final AxisAlignedBB INFINITE_EXTENT_AABB = null;

    /**
     *
     */
    private NBTTagCompound customTileData;

    /**
     *
     */
    private CapabilityDispatcher capabilities;

    /**
     *
     */
    public TileEntity() {
        
    }

    /**
     * Adds a new two-way mapping between the class and its string name in both hashmaps.
     */
    public static void addMapping(Class<? extends TileEntity> cl,
                                  String id) {
        return;
    }

    /**
     * Returns the worldObj for this tileEntity.
     */
    public World getWorld() {
        return null;
    }

    /**
     * Sets the worldObj for this tileEntity.
     */
    public void setWorldObj(World worldIn) {
        return;
    }

    /**
     * Returns true if the worldObj isn't null.
     */
    public boolean hasWorldObj() {
        return true;
    }

    /**
     *
     */
    public void func_145839_a(NBTTagCompound compound) {
        return;
    }

    /**
     *
     */
    public void func_145841_b(NBTTagCompound compound) {
        return;
    }

    /**
     * Creates a new entity and loads its data from the specified NBT.
     */
    public static TileEntity createAndLoadEntity(NBTTagCompound nbt) {
        return null;
    }

    /**
     *
     */
    public int getBlockMetadata() {
        return 0;
    }

    /**
     * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think it
     * hasn't changed and skip it.
     */
    public void func_70296_d() {
        return;
    }

    /**
     * Returns the square of the distance between this entity and the passed in coordinates.
     */
    public double getDistanceSq(double x,
                                double y,
                                double z) {
        return 0;
    }

    /**
     *
     */
    public double getMaxRenderDistanceSquared() {
        return 0;
    }

    /**
     *
     */
    public BlockPos getPos() {
        return null;
    }

    /**
     * Gets the block type at the location of this entity (client-only).
     */
    public Block getBlockType() {
        return null;
    }

    /**
     * Allows for a specialized description packet to be created. This is often used to sync tile entity data from the
     * server to the client easily. For example this is used by signs to synchronise the text to be displayed.
     */
    public Packet getDescriptionPacket() {
        return null;
    }

    /**
     *
     */
    public boolean isInvalid() {
        return true;
    }

    /**
     * invalidates a tile entity
     */
    public void invalidate() {
        return;
    }

    /**
     * validates a tile entity
     */
    public void validate() {
        return;
    }

    /**
     *
     */
    public boolean receiveClientEvent(int id,
                                      int type) {
        return true;
    }

    /**
     *
     */
    public void updateContainingBlockInfo() {
        return;
    }

    /**
     *
     */
    public void addInfoToCrashReport(CrashReportCategory reportCategory) {
        return;
    }

    /**
     *
     */
    public void setPos(BlockPos posIn) {
        return;
    }

    /**
     *
     */
    public boolean func_183000_F() {
        return true;
    }

    /**
     * Called when you receive a TileEntityData packet for the location this
     * TileEntity is currently in. On the client, the NetworkManager will always
     * be the remote server. On the server, it will be whomever is responsible for
     * sending the packet.
     * @param net The NetworkManager the packet originated from
     * @param pkt The data packet
     */
    public void onDataPacket(NetworkManager net,
                             S35PacketUpdateTileEntity pkt) {
        return;
    }

    /**
     * Called when the chunk this TileEntity is on is Unloaded.
     */
    public void onChunkUnload() {
        return;
    }

    /**
     * Called from Chunk.setBlockIDWithMetadata and Chunk.fillChunk, determines if this tile entity should be re-created when the ID, or Metadata changes.
     * Use with caution as this will leave straggler TileEntities, or create conflicts with other TileEntities if not used properly.
     * @param world Current world
     * @param pos Tile's world position
     * @param oldState The old ID of the block
     * @param newSate The new ID of the block (May be the same)
     * @return true forcing the invalidation of the existing TE, false not to invalidate the existing TE
     */
    public boolean shouldRefresh(World world,
                                 BlockPos pos,
                                 IBlockState oldState,
                                 IBlockState newSate) {
        return true;
    }

    /**
     *
     */
    public boolean shouldRenderInPass(int pass) {
        return true;
    }

    /**
     * Return an <code>AxisAlignedBB</code> that controls the visible scope of a <code>TileEntitySpecialRenderer</code> associated with this <a href="../../../net/minecraft/tileentity/TileEntity.html" title="class in net.minecraft.tileentity"><code>TileEntity</code></a>
     * Defaults to the collision bounding box <code>Block#getCollisionBoundingBoxFromPool(World, int, int, int)</code> associated with the block
     * at this location.
     * @return an appropriately size AxisAlignedBB for the TileEntity
     */
    public AxisAlignedBB getRenderBoundingBox() {
        return null;
    }

    /**
     * Checks if this tile entity knows how to render its 'breaking' overlay effect.
     * If this returns true, The TileEntitySpecialRenderer will be called again with break progress set.
     * @return True to re-render tile with breaking effect.
     */
    public boolean canRenderBreaking() {
        return true;
    }

    /**
     * Gets a <a href="../../../net/minecraft/nbt/NBTTagCompound.html" title="class in net.minecraft.nbt"><code>NBTTagCompound</code></a> that can be used to store custom data for this tile entity.
     * It will be written, and read from disc, so it persists over world saves.
     * @return A compound tag for custom data
     */
    public NBTTagCompound getTileData() {
        return null;
    }

    /**
     * Determines if the player can overwrite the NBT data of this tile entity while they place it using a ItemStack.
     * Added as a fix for MC-75630 - Exploit with signs and command blocks
     * @return True to prevent NBT copy, false to allow.
     */
    public boolean restrictNBTCopy() {
        return true;
    }

    /**
     * Called from the Chunk when this is first added to the world. Override instead of adding
     * if (firstTick) stuff in update. Happens after validate and after it has been placed into the Chunk tileEntity
     * map.
     */
    public void onLoad() {
        return;
    }

    /**
     * If the TileEntitySpecialRenderer associated with this TileEntity can be batched in with another renderers, and won't access the GL state.
     * If TileEntity returns true, then TESR should have the same functionality as (and probably extend) the FastTESR class.
     */
    public boolean hasFastRenderer() {
        return true;
    }

    /**
     * Determines if this object has support for the capability in question on the specific side.
     * The return value of this MIGHT change during runtime if this object gains or looses support
     * for a capability.
     * 
     * Example:
     *   A Pipe getting a cover placed on one side causing it loose the Inventory attachment function for that side.
     * 
     * This is a light weight version of getCapability, intended for metadata uses.
     * @param capability The capability to check
     * @param facing The Side to check from:
     *    CAN BE NULL. Null is defined to represent 'internal' or 'self'
     * @return True if this object supports the capability.
     */
    public boolean hasCapability(Capability<?> capability,
                                 EnumFacing facing) {
        return true;
    }

    /**
     * Retrieves the handler for the capability requested on the specific side.
     * The return value CAN be null if the object does not support the capability.
     * The return value CAN be the same for multiple faces.
     * @param capability The capability to check
     * @param facing The Side to check from:
     *    CAN BE NULL. Null is defined to represent 'internal' or 'self'
     * @return True if this object supports the capability.
     */
    public <T> T getCapability(Capability<T> capability,
                               EnumFacing facing) {
        return null;
    }

    /**
     *
     */
    public void deserializeNBT(NBTTagCompound nbt) {
        return;
    }

    /**
     *
     */
    public NBTTagCompound serializeNBT() {
        return null;
    }

    public void func_147985_d() {}
}