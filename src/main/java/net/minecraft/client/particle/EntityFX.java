package net.minecraft.client.particle;

import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.client.renderer.WorldRenderer;

/**
 *
 */
public class EntityFX extends Entity {

    /**
     *
     */
    protected int particleTextureIndexX;

    /**
     *
     */
    protected int particleTextureIndexY;

    /**
     *
     */
    protected float particleTextureJitterX;

    /**
     *
     */
    protected float particleTextureJitterY;

    /**
     *
     */
    protected int particleAge;

    /**
     *
     */
    protected int particleMaxAge;

    /**
     *
     */
    protected float particleScale;

    /**
     *
     */
    protected float particleGravity;

    /**
     * The red amount of color. Used as a percentage, 1.0 = 255 and 0.0 = 0.
     */
    protected float particleRed;

    /**
     * The green amount of color. Used as a percentage, 1.0 = 255 and 0.0 = 0.
     */
    protected float particleGreen;

    /**
     * The blue amount of color. Used as a percentage, 1.0 = 255 and 0.0 = 0.
     */
    protected float particleBlue;

    /**
     * Particle alpha
     */
    protected float particleAlpha;

    /**
     * The icon field from which the given particle pulls its texture.
     */
    protected TextureAtlasSprite particleIcon;

    /**
     *
     */
    public static double interpPosX;

    /**
     *
     */
    public static double interpPosY;

    /**
     *
     */
    public static double interpPosZ;

    /**
     *
     */
    protected EntityFX(World worldIn,
                       double posXIn,
                       double posYIn,
                       double posZIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityFX(World worldIn,
                    double xCoordIn,
                    double yCoordIn,
                    double zCoordIn,
                    double xSpeedIn,
                    double ySpeedIn,
                    double zSpeedIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityFX multiplyVelocity(float multiplier) {
        return null;
    }

    /**
     *
     */
    public EntityFX multipleParticleScaleBy(float p_70541_1_) {
        return null;
    }

    /**
     *
     */
    public void setRBGColorF(float particleRedIn,
                             float particleGreenIn,
                             float particleBlueIn) {
        return;
    }

    /**
     * Sets the particle alpha (float)
     */
    public void setAlphaF(float alpha) {
        return;
    }

    /**
     *
     */
    public float getRedColorF() {
        return 0;
    }

    /**
     *
     */
    public float getGreenColorF() {
        return 0;
    }

    /**
     *
     */
    public float getBlueColorF() {
        return 0;
    }

    /**
     *
     */
    public float getAlpha() {
        return 0;
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    @Override
    protected boolean canTriggerWalking() {
        return true;
    }

    /**
     *
     */
    protected void entityInit() {
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
     * Renders the particle
     */
    public void renderParticle(WorldRenderer worldRendererIn,
                               Entity entityIn,
                               float partialTicks,
                               float p_180434_4_,
                               float p_180434_5_,
                               float p_180434_6_,
                               float p_180434_7_,
                               float p_180434_8_) {
        return;
    }

    /**
     *
     */
    public int getFXLayer() {
        return 0;
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
     * Sets the particle's icon.
     */
    public void setParticleIcon(TextureAtlasSprite icon) {
        return;
    }

    /**
     * Public method to set private field particleTextureIndex.
     */
    public void setParticleTextureIndex(int particleTextureIndex) {
        return;
    }

    /**
     *
     */
    public void nextTextureIndexX() {
        return;
    }

    /**
     * If returns false, the item will not inflict any damage against entities.
     */
    @Override
    public boolean canAttackWithItem() {
        return true;
    }

    /**
     *
     */
    @Override
    public String toString() {
        return null;
    }

}