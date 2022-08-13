package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

/**
 *
 */
public class RandomPositionGenerator extends Object {

    /**
     * used to store a driection when the user passes a point to move towards or away from. WARNING: NEVER THREAD SAFE.
     * MULTIPLE findTowards and findAway calls, will share this var
     */
    private static Vec3 staticVector;

    /**
     *
     */
    public RandomPositionGenerator() {
        
    }

    /**
     * finds a random target within par1(x,z) and par2 (y) blocks
     */
    public static Vec3 findRandomTarget(EntityCreature entitycreatureIn,
                                        int xz,
                                        int y) {
        return null;
    }

    /**
     * finds a random target within par1(x,z) and par2 (y) blocks in the direction of the point par3
     */
    public static Vec3 findRandomTargetBlockTowards(EntityCreature entitycreatureIn,
                                                    int xz,
                                                    int y,
                                                    Vec3 targetVec3) {
        return null;
    }

    /**
     * finds a random target within par1(x,z) and par2 (y) blocks in the reverse direction of the point par3
     */
    public static Vec3 findRandomTargetBlockAwayFrom(EntityCreature entitycreatureIn,
                                                     int xz,
                                                     int y,
                                                     Vec3 targetVec3) {
        return null;
    }

    /**
     * searches 10 blocks at random in a within par1(x,z) and par2 (y) distance, ignores those not in the direction of
     * par3Vec3, then points to the tile for which creature.getBlockPathWeight returns the highest number
     */
    private static Vec3 findRandomTargetBlock(EntityCreature entitycreatureIn,
                                              int xz,
                                              int y,
                                              Vec3 targetVec3) {
        return null;
    }

}