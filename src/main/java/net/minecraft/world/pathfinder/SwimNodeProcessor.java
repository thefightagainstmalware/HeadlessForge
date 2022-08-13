package net.minecraft.world.pathfinder;

import net.minecraft.world.IBlockAccess;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;

/**
 *
 */
public class SwimNodeProcessor extends NodeProcessor {

    /**
     *
     */
    public SwimNodeProcessor() {
        
    }

    /**
     *
     */
    @Override
    public void initProcessor(IBlockAccess iblockaccessIn,
                              Entity entityIn) {
        return;
    }

    /**
     * This method is called when all nodes have been processed and PathEntity is created.
     * <a href="../../../../net/minecraft/world/pathfinder/WalkNodeProcessor.html" title="class in net.minecraft.world.pathfinder"><code>WalkNodeProcessor</code></a> uses this to change its field <a href="../../../../net/minecraft/world/pathfinder/WalkNodeProcessor.html#avoidsWater"><code>avoidsWater</code></a>
     */
    @Override
    public void postProcess() {
        return;
    }

    /**
     * Returns given entity's position as PathPoint
     */
    public PathPoint getPathPointTo(Entity entityIn) {
        return null;
    }

    /**
     * Returns PathPoint for given coordinates
     */
    public PathPoint getPathPointToCoords(Entity entityIn,
                                          double x,
                                          double y,
                                          double target) {
        return null;
    }

    /**
     *
     */
    public int findPathOptions(PathPoint[] pathOptions,
                               Entity entityIn,
                               PathPoint currentPoint,
                               PathPoint targetPoint,
                               float maxDistance) {
        return 0;
    }

    /**
     * Returns a point that the entity can safely move to
     */
    private PathPoint getSafePoint(Entity entityIn,
                                   int x,
                                   int y,
                                   int z) {
        return null;
    }

    /**
     *
     */
    private int func_176186_b(Entity entityIn,
                              int x,
                              int y,
                              int z) {
        return 0;
    }

}