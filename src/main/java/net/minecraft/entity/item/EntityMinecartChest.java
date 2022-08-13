package net.minecraft.entity.item;

import net.minecraft.block.BlockChest;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class EntityMinecartChest extends EntityMinecartContainer
{
    public EntityMinecartChest(World worldIn)
    {
        super(worldIn);
    }

    public EntityMinecartChest(World worldIn, double p_i1715_2_, double p_i1715_4_, double p_i1715_6_)
    {
        super(worldIn, p_i1715_2_, p_i1715_4_, p_i1715_6_);
    }

    public void killMinecart(DamageSource p_94095_1_)
    {
        super.killMinecart(p_94095_1_);

        if (this.field_70170_p.func_82736_K().func_82766_b("doEntityDrops"))
        {
            this.dropItemWithOffset(Item.func_150898_a(Blocks.field_150486_ae), 1, 0.0F);
        }
    }

    /**
     * Returns the number of slots in the inventory.
     */
    public int func_70302_i_()
    {
        return 27;
    }

    public EntityMinecart.EnumMinecartType getMinecartType()
    {
        return EntityMinecart.EnumMinecartType.CHEST;
    }

    public IBlockState getDefaultDisplayTile()
    {
        return Blocks.field_150486_ae.func_176223_P().withProperty(BlockChest.FACING, EnumFacing.NORTH);
    }

    public int getDefaultDisplayTileOffset()
    {
        return 8;
    }

    public String getGuiID()
    {
        return "minecraft:chest";
    }

    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        return new ContainerChest(playerInventory, this, playerIn);
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
