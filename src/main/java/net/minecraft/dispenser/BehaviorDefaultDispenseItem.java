package net.minecraft.dispenser;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

/**
 *
 */
public class BehaviorDefaultDispenseItem extends Object implements IBehaviorDispenseItem {

    /**
     *
     */
    public BehaviorDefaultDispenseItem() {
        
    }

    /**
     * Dispenses the specified ItemStack from a dispenser.
     */
    public final ItemStack dispense(IBlockSource source,
                                    ItemStack stack) {
        return null;
    }

    /**
     * Dispense the specified stack, play the dispense sound and spawn particles.
     */
    protected ItemStack dispenseStack(IBlockSource source,
                                      ItemStack stack) {
        return null;
    }

    /**
     *
     */
    public static void doDispense(World worldIn,
                                  ItemStack stack,
                                  int speed,
                                  EnumFacing facing,
                                  IPosition position) {
        return;
    }

    /**
     * Play the dispense sound from the specified block.
     */
    protected void playDispenseSound(IBlockSource source) {
        return;
    }

    /**
     * Order clients to display dispense particles from the specified block and facing.
     */
    protected void spawnDispenseParticles(IBlockSource source,
                                          EnumFacing facingIn) {
        return;
    }

    /**
     *
     */
    private int func_82488_a(EnumFacing facingIn) {
        return 0;
    }

}