package net.minecraft.entity.passive;

import net.minecraft.util.BlockPos;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 *
 */
public class EntityMooshroom extends EntityCow {

    /**
     *
     */
    public EntityMooshroom(World worldIn) {
        super(worldIn);
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    @Override
    public boolean interact(EntityPlayer player) {
        return true;
    }

    /**
     *
     */
    @Override
    public EntityMooshroom createChild(EntityAgeable ageable) {
        return null;
    }

    /**
     * Checks if the object is currently shearable
     * Example: Sheep return false when they have no wool
     * @param item The itemstack that is being used, Possible to be null
     * @param world The current world
     * @param pos Block's position in world.
     * @return If this is shearable, and onSheared should be called.
     */
    public boolean isShearable(ItemStack item,
                               IBlockAccess world,
                               BlockPos pos) {
        return true;
    }

    /**
     * Performs the shear function on this object.
     * This is called for both client, and server.
     * The object should perform all actions related to being sheared,
     * except for dropping of the items, and removal of the block.
     * As those are handled by ItemShears itself.
     * 
     * Returns a list of items that resulted from the shearing process.
     * 
     * For entities, they should trust there internal location information
     * over the values passed into this function.
     * @param item The itemstack that is being used, Possible to be null
     * @param world The current world
     * @param pos If this is a block, the block's position in world.
     * @param fortune The fortune level of the shears being used
     * @return A ArrayList containing all items from this shearing. Possible to be null.
     */
    public java.util.List<ItemStack> onSheared(ItemStack item,
                                               IBlockAccess world,
                                               BlockPos pos,
                                               int fortune) {
        return null;
    }

}