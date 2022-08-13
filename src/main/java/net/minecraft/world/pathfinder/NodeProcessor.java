package net.minecraft.world.pathfinder;

import net.minecraft.world.IBlockAccess;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.IntHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;

/**
 *
 */
public abstract class NodeProcessor extends Object {

    /**
     *
     */
    protected IBlockAccess blockaccess;

    /**
     *
     */
    protected IntHashMap<PathPoint> pointMap;

    /**
     *
     */
    protected int entitySizeX;

    /**
     *
     */
    protected int entitySizeY;

    /**
     *
     */
    protected int entitySizeZ;

    /**
     *
     */
    public NodeProcessor() {
        
    }

    /**
     *
     */
    public void initProcessor(IBlockAccess iblockaccessIn,
                              Entity entityIn) {
        return;
    }

    /**
     * This method is called when all nodes have been processed and PathEntity is created.
     * <a href="../../../../net/minecraft/world/pathfinder/WalkNodeProcessor.html" title="class in net.minecraft.world.pathfinder"><code>WalkNodeProcessor</code></a> uses this to change its field <a href="../../../../net/minecraft/world/pathfinder/WalkNodeProcessor.html#avoidsWater"><code>avoidsWater</code></a>
     */
    public void postProcess() {
        return;
    }

    /**
     * Returns a mapped point or creates and adds one
     */
    protected PathPoint openPoint(int x,
                                  int y,
                                  int z) {
        return null;
    }

    /**
     * Returns given entity's position as PathPoint
     */
    public abstract PathPoint getPathPointTo(Entity entityIn);

    /**
     * Returns PathPoint for given coordinates
     */
    public abstract PathPoint getPathPointToCoords(Entity entityIn,
                                                   double x,
                                                   double y,
                                                   double target);

    /**
     *
     */
    public abstract int findPathOptions(PathPoint[] pathOptions,
                                        Entity entityIn,
                                        PathPoint currentPoint,
                                        PathPoint targetPoint,
                                        float maxDistance);

}