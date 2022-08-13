package net.minecraft.world;

import net.minecraft.profiler.Profiler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.village.VillageCollection;
import net.minecraft.world.border.IBorderListener;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.storage.DerivedWorldInfo;
import net.minecraft.world.storage.ISaveHandler;

public class WorldServerMulti extends WorldServer
{
    private WorldServer delegate;

    public WorldServerMulti(MinecraftServer server, ISaveHandler saveHandlerIn, int dimensionId, WorldServer delegate, Profiler profilerIn)
    {
        super(server, saveHandlerIn, new DerivedWorldInfo(delegate.func_72912_H()), dimensionId, profilerIn);
        this.delegate = delegate;
        delegate.func_175723_af().addListener(new IBorderListener()
        {
            public void onSizeChanged(WorldBorder border, double newSize)
            {
                WorldServerMulti.this.func_175723_af().func_177750_a(newSize);
            }
            public void onTransitionStarted(WorldBorder border, double oldSize, double newSize, long time)
            {
                WorldServerMulti.this.func_175723_af().func_177738_a(oldSize, newSize, time);
            }
            public void onCenterChanged(WorldBorder border, double x, double z)
            {
                WorldServerMulti.this.func_175723_af().func_177739_c(x, z);
            }
            public void onWarningTimeChanged(WorldBorder border, int newTime)
            {
                WorldServerMulti.this.func_175723_af().func_177723_b(newTime);
            }
            public void onWarningDistanceChanged(WorldBorder border, int newDistance)
            {
                WorldServerMulti.this.func_175723_af().func_177747_c(newDistance);
            }
            public void onDamageAmountChanged(WorldBorder border, double newAmount)
            {
                WorldServerMulti.this.func_175723_af().func_177744_c(newAmount);
            }
            public void onDamageBufferChanged(WorldBorder border, double newSize)
            {
                WorldServerMulti.this.func_175723_af().func_177724_b(newSize);
            }
        });
    }

    /**
     * Saves the chunks to disk.
     */
    protected void saveLevel() throws MinecraftException
    {
    }

    public World init()
    {
        this.mapStorage = this.delegate.getMapStorage();
        this.worldScoreboard = this.delegate.func_96441_U();
        String s = VillageCollection.fileNameForProvider(this.provider);
        VillageCollection villagecollection = (VillageCollection)this.mapStorage.loadData(VillageCollection.class, s);

        if (villagecollection == null)
        {
            this.villageCollectionObj = new VillageCollection(this);
            this.mapStorage.setData(s, this.villageCollectionObj);
        }
        else
        {
            this.villageCollectionObj = villagecollection;
            this.villageCollectionObj.setWorldsForAll(this);
        }

        return this;
    }
}
