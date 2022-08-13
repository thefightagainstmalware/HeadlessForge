package net.minecraft.entity.projectile;

import java.util.ArrayList;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.DamageSource;
import net.minecraft.block.Block;
import net.minecraft.util.WeightedRandomFishable;
import net.minecraft.item.ItemStack;

/**
 *
 */
public class EntityFishHook extends Entity {

    /**
     *
     */
    public static final java.util.List<WeightedRandomFishable> JUNK = new ArrayList<>();

    /**
     *
     */
    public static final java.util.List<WeightedRandomFishable> TREASURE = new ArrayList<>();

    /**
     *
     */
    public static final java.util.List<WeightedRandomFishable> FISH = new ArrayList<>();
    /**
     *
     */
    private int xTile;

    /**
     *
     */
    private int yTile;

    /**
     *
     */
    private int zTile;

    /**
     *
     */
    private Block inTile;

    /**
     *
     */
    private boolean inGround;

    /**
     *
     */
    public int shake;

    /**
     *
     */
    public EntityPlayer angler;

    /**
     *
     */
    private int ticksInGround;

    /**
     *
     */
    private int ticksInAir;

    /**
     *
     */
    private int ticksCatchable;

    /**
     *
     */
    private int ticksCaughtDelay;

    /**
     *
     */
    private int ticksCatchableDelay;

    /**
     *
     */
    private float fishApproachAngle;

    /**
     *
     */
    public Entity caughtEntity;

    /**
     *
     */
    private int fishPosRotationIncrements;

    /**
     *
     */
    private double fishX;

    /**
     *
     */
    private double fishY;

    /**
     *
     */
    private double fishZ;

    /**
     *
     */
    private double fishYaw;

    /**
     *
     */
    private double fishPitch;

    /**
     *
     */
    private double clientMotionX;

    /**
     *
     */
    private double clientMotionY;

    /**
     *
     */
    private double clientMotionZ;

    /**
     *
     */
    public EntityFishHook(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityFishHook(World worldIn,
                          double x,
                          double y,
                          double z,
                          EntityPlayer anglerIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityFishHook(World worldIn,
                          EntityPlayer fishingPlayer) {
        super(worldIn);
    }

    /**
     *
     */
    public static java.util.List<WeightedRandomFishable> func_174855_j() {
        return null;
    }

    /**
     *
     */
    protected void entityInit() {
        return;
    }

    /**
     * Checks if the entity is in range to render by using the past in distance and comparing it to its average edge
     * length * 64 * renderDistanceWeight Args: distance
     */
    @Override
    public boolean isInRangeToRenderDist(double distance) {
        return true;
    }

    /**
     *
     */
    public void handleHookCasting(double p_146035_1_,
                                  double p_146035_3_,
                                  double p_146035_5_,
                                  float p_146035_7_,
                                  float p_146035_8_) {
        return;
    }

    /**
     *
     */
    @Override
    public void setPositionAndRotation2(double x,
                                        double y,
                                        double z,
                                        float yaw,
                                        float pitch,
                                        int posRotationIncrements,
                                        boolean p_180426_10_) {
        return;
    }

    /**
     * Sets the velocity to the args. Args: x, y, z
     */
    @Override
    public void setVelocity(double x,
                            double y,
                            double z) {
        return;
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        return;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        return;
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        return;
    }

    /**
     *
     */
    public int handleHookRetraction() {
        return 0;
    }

    /**
     *
     */
    private ItemStack getFishingResult() {
        return null;
    }

    /**
     * Will get destroyed next tick.
     */
    @Override
    public void setDead() {
        return;
    }

}