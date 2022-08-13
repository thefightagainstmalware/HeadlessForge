package net.minecraft.world.pathfinder;

import net.minecraft.world.IBlockAccess;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;

/**
 *
 */
public class WalkNodeProcessor extends NodeProcessor {

    /**
     *
     */
    private boolean canEnterDoors;

    /**
     *
     */
    private boolean canBreakDoors;

    /**
     *
     */
    private boolean avoidsWater;

    /**
     *
     */
    private boolean canSwim;

    /**
     *
     */
    private boolean shouldAvoidWater;

    /**
     *
     */
    public WalkNodeProcessor() {
        
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
                                   int z,
                                   int p_176171_5_) {
        return null;
    }

    /**
     * Checks if an entity collides with blocks at a position.
     * Returns 1 if clear, 0 for colliding with any solid block, -1 for water(if avoids water),
     * -2 for lava, -3 for fence and wall, -4 for closed trapdoor, 2 if otherwise clear except for open trapdoor or
     * water(if not avoiding)
     */
    private int getVerticalOffset(Entity entityIn,
                                  int x,
                                  int y,
                                  int z) {
        return 0;
    }

    /**
     *
     */
    public static int func_176170_a(IBlockAccess blockaccessIn,
                                    Entity entityIn,
                                    int x,
                                    int y,
                                    int z,
                                    int sizeX,
                                    int sizeY,
                                    int sizeZ,
                                    boolean avoidWater,
                                    boolean breakDoors,
                                    boolean enterDoors) {
        return 0;
    }

    /**
     *
     */
    public void setEnterDoors(boolean canEnterDoorsIn) {
        return;
    }

    /**
     *
     */
    public void setBreakDoors(boolean canBreakDoorsIn) {
        return;
    }

    /**
     *
     */
    public void setAvoidsWater(boolean avoidsWaterIn) {
        return;
    }

    /**
     *
     */
    public void setCanSwim(boolean canSwimIn) {
        return;
    }

    /**
     *
     */
    public boolean getEnterDoors() {
        return true;
    }

    /**
     *
     */
    public boolean getCanSwim() {
        return true;
    }

    /**
     *
     */
    public boolean getAvoidsWater() {
        return true;
    }

}