package net.minecraft.pathfinding;

import net.minecraft.world.IBlockAccess;
import net.minecraft.util.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.world.pathfinder.NodeProcessor;

/**
 *
 */
public class PathFinder extends Object {

    /**
     * The path being generated
     */
    private Path path;

    /**
     * Selection of path points to add to the path
     */
    private PathPoint[] pathOptions;

    /**
     *
     */
    private NodeProcessor nodeProcessor;

    /**
     *
     */
    public PathFinder(NodeProcessor nodeProcessorIn) {
        
    }

    /**
     * Creates a path from one entity to another within a minimum distance
     */
    public PathEntity createEntityPathTo(IBlockAccess blockaccess,
                                         Entity entityFrom,
                                         Entity entityTo,
                                         float dist) {
        return null;
    }

    /**
     * Creates a path from an entity to a specified location within a minimum distance
     */
    public PathEntity createEntityPathTo(IBlockAccess blockaccess,
                                         Entity entityIn,
                                         BlockPos targetPos,
                                         float dist) {
        return null;
    }

    /**
     * Internal implementation of creating a path from an entity to a point
     */
    private PathEntity createEntityPathTo(IBlockAccess blockaccess,
                                          Entity entityIn,
                                          double x,
                                          double y,
                                          double z,
                                          float distance) {
        return null;
    }

    /**
     * Adds a path from start to end and returns the whole path
     */
    private PathEntity addToPath(Entity entityIn,
                                 PathPoint pathpointStart,
                                 PathPoint pathpointEnd,
                                 float maxDistance) {
        return null;
    }

    /**
     * Returns a new PathEntity for a given start and end point
     */
    private PathEntity createEntityPath(PathPoint start,
                                        PathPoint end) {
        return null;
    }

}