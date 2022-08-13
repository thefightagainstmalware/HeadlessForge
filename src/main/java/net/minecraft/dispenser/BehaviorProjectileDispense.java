package net.minecraft.dispenser;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.IProjectile;
import net.minecraft.util.EnumFacing;

/**
 *
 */
public abstract class BehaviorProjectileDispense extends BehaviorDefaultDispenseItem {

    /**
     *
     */
    public BehaviorProjectileDispense() {
        
    }

    /**
     * Dispense the specified stack, play the dispense sound and spawn particles.
     */
    @Override
    public ItemStack dispenseStack(IBlockSource source,
                                   ItemStack stack) {
        return null;
    }

    /**
     * Play the dispense sound from the specified block.
     */
    @Override
    protected void playDispenseSound(IBlockSource source) {
        return;
    }

    /**
     * Return the projectile entity spawned by this dispense behavior.
     */
    protected abstract IProjectile getProjectileEntity(World worldIn,
                                                       IPosition position);

    /**
     *
     */
    protected float func_82498_a() {
        return 0;
    }

    /**
     *
     */
    protected float func_82500_b() {
        return 0;
    }

}