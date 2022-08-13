package net.minecraft.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.material.MapColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

/**
 *
 */
public class BlockDeadBush extends BlockBush  {

    /**
     *
     */
    protected BlockDeadBush() {
        
    }

    /**
     * Get the MapColor for this Block and the given BlockState
     */
    @Override
    public MapColor getMapColor(IBlockState state) {
        return null;
    }

    /**
     * is the block grass, dirt or farmland
     */
    @Override
    protected boolean canPlaceBlockOn(Block ground) {
        return true;
    }

    /**
     * Whether this Block can be replaced directly by other blocks (true for e.g. tall grass)
     */
    @Override
    public boolean isReplaceable(World worldIn,
                                 BlockPos pos) {
        return true;
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    @Override
    public Item getItemDropped(IBlockState state,
                               java.util.Random rand,
                               int fortune) {
        return null;
    }

    /**
     *
     */
    @Override
    public void harvestBlock(World worldIn,
                             EntityPlayer player,
                             BlockPos pos,
                             IBlockState state,
                             TileEntity te) {
        return;
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