package net.minecraft.entity.item;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;

/**
 *
 */
public class EntityEnderEye extends Entity {

    /**
     * 'x' location the eye should float towards.
     */
    private double targetX;

    /**
     * 'y' location the eye should float towards.
     */
    private double targetY;

    /**
     * 'z' location the eye should float towards.
     */
    private double targetZ;

    /**
     *
     */
    private int despawnTimer;

    /**
     *
     */
    private boolean shatterOrDrop;

    /**
     *
     */
    public EntityEnderEye(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityEnderEye(World worldIn,
                          double x,
                          double y,
                          double z) {
        super(worldIn);
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
    public void moveTowards(BlockPos p_180465_1_) {
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
     * Gets how bright this entity is.
     */
    @Override
    public float getBrightness(float partialTicks) {
        return 0;
    }

    /**
     *
     */
    @Override
    public int getBrightnessForRender(float partialTicks) {
        return 0;
    }

    /**
     * If returns false, the item will not inflict any damage against entities.
     */
    @Override
    public boolean canAttackWithItem() {
        return true;
    }

}