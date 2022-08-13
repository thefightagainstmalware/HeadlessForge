package net.minecraft.entity.item;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.Explosion;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.DamageSource;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.block.state.IBlockState;

/**
 *
 */
public class EntityMinecartTNT extends EntityMinecart {

    /**
     *
     */
    private int minecartTNTFuse;

    /**
     *
     */
    public EntityMinecartTNT(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityMinecartTNT(World worldIn,
                             double p_i1728_2_,
                             double p_i1728_4_,
                             double p_i1728_6_) {
        super(worldIn, p_i1728_2_, p_i1728_4_, p_i1728_6_);
    }

    /**
     *
     */
    public EntityMinecart.EnumMinecartType getMinecartType() {
        return null;
    }

    /**
     *
     */
    @Override
    public IBlockState getDefaultDisplayTile() {
        return null;
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        return;
    }

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean attackEntityFrom(DamageSource source,
                                    float amount) {
        return true;
    }

    /**
     *
     */
    @Override
    public void killMinecart(DamageSource p_94095_1_) {
        return;
    }

    /**
     * Makes the minecart explode.
     */
    protected void explodeCart(double p_94103_1_) {
        return;
    }

    /**
     *
     */
    @Override
    public void fall(float distance,
                     float damageMultiplier) {
        return;
    }

    /**
     * Called every tick the minecart is on an activator rail. Args: x, y, z, is the rail receiving power
     */
    @Override
    public void onActivatorRailPass(int x,
                                    int y,
                                    int z,
                                    boolean receivingPower) {
        return;
    }

    /**
     *
     */
    @Override
    public void handleStatusUpdate(byte id) {
        return;
    }

    /**
     * Ignites this TNT cart.
     */
    public void ignite() {
        return;
    }

    /**
     * Gets the remaining fuse time in ticks.
     */
    public int getFuseTicks() {
        return 0;
    }

    /**
     * Returns true if the TNT minecart is ignited.
     */
    public boolean isIgnited() {
        return true;
    }

    /**
     * Explosion resistance of a block relative to this entity
     */
    @Override
    public float getExplosionResistance(Explosion explosionIn,
                                        World worldIn,
                                        BlockPos pos,
                                        IBlockState blockStateIn) {
        return 0;
    }

    /**
     *
     */
    @Override
    public boolean verifyExplosion(Explosion explosionIn,
                                   World worldIn,
                                   BlockPos pos,
                                   IBlockState blockStateIn,
                                   float p_174816_5_) {
        return true;
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    protected void readEntityFromNBT(NBTTagCompound tagCompund) {
        return;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    protected void writeEntityToNBT(NBTTagCompound tagCompound) {
        return;
    }

    /**
     * Get the name of this object. For players this returns their username
     */
    @Override
    public String getName() {
        return null;
    }

    /**
     * Get the formatted ChatComponent that will be used for the sender's username in chat
     *
     * @return
     */
    @Override
    public IChatComponent getDisplayName() {
        return null;
    }
}