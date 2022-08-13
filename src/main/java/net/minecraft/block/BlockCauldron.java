package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBanner;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockCauldron extends Block
{
    public static final PropertyInteger LEVEL = PropertyInteger.create("level", 0, 3);

    public BlockCauldron()
    {
        super(Material.iron, MapColor.stoneColor);
        this.setDefaultState(this.blockState.getBaseState().withProperty(LEVEL, Integer.valueOf(0)));
    }

    /**
     * Add all collision boxes of this Block to the list that intersect with the given mask.
     */
    public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List<AxisAlignedBB> list, Entity collidingEntity)
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        float f = 0.125F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        this.setBlockBoundsForItemRender();
    }

    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean func_149686_d()
    {
        return false;
    }

    /**
     * Called When an Entity Collided with the Block
     */
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        int i = ((Integer)state.getValue(LEVEL)).intValue();
        float f = (float)pos.func_177956_o() + (6.0F + (float)(3 * i)) / 16.0F;

        if (!worldIn.isRemote && entityIn.isBurning() && i > 0 && entityIn.getEntityBoundingBox().minY <= (double)f)
        {
            entityIn.extinguish();
            this.setWaterLevel(worldIn, pos, state, i - 1);
        }
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            ItemStack itemstack = playerIn.field_71071_by.getCurrentItem();

            if (itemstack == null)
            {
                return true;
            }
            else
            {
                int i = ((Integer)state.getValue(LEVEL)).intValue();
                Item item = itemstack.func_77973_b();

                if (item == Items.field_151131_as)
                {
                    if (i < 3)
                    {
                        if (!playerIn.field_71075_bZ.field_75098_d)
                        {
                            playerIn.field_71071_by.func_70299_a(playerIn.field_71071_by.currentItem, new ItemStack(Items.bucket));
                        }

                        playerIn.func_71029_a(StatList.field_181725_I);
                        this.setWaterLevel(worldIn, pos, state, 3);
                    }

                    return true;
                }
                else if (item == Items.glass_bottle)
                {
                    if (i > 0)
                    {
                        if (!playerIn.field_71075_bZ.field_75098_d)
                        {
                            ItemStack itemstack2 = new ItemStack(Items.potionitem, 1, 0);

                            if (!playerIn.field_71071_by.func_70441_a(itemstack2))
                            {
                                worldIn.func_72838_d(new EntityItem(worldIn, (double)pos.func_177958_n() + 0.5D, (double)pos.func_177956_o() + 1.5D, (double)pos.func_177952_p() + 0.5D, itemstack2));
                            }
                            else if (playerIn instanceof EntityPlayerMP)
                            {
                                ((EntityPlayerMP)playerIn).sendContainerToPlayer(playerIn.field_71069_bz);
                            }

                            playerIn.func_71029_a(StatList.field_181726_J);
                            --itemstack.field_77994_a;

                            if (itemstack.field_77994_a <= 0)
                            {
                                playerIn.field_71071_by.func_70299_a(playerIn.field_71071_by.currentItem, (ItemStack)null);
                            }
                        }

                        this.setWaterLevel(worldIn, pos, state, i - 1);
                    }

                    return true;
                }
                else
                {
                    if (i > 0 && item instanceof ItemArmor)
                    {
                        ItemArmor itemarmor = (ItemArmor)item;

                        if (itemarmor.getArmorMaterial() == ItemArmor.ArmorMaterial.LEATHER && itemarmor.hasColor(itemstack))
                        {
                            itemarmor.removeColor(itemstack);
                            this.setWaterLevel(worldIn, pos, state, i - 1);
                            playerIn.func_71029_a(StatList.field_181727_K);
                            return true;
                        }
                    }

                    if (i > 0 && item instanceof ItemBanner && TileEntityBanner.getPatterns(itemstack) > 0)
                    {
                        ItemStack itemstack1 = itemstack.copy();
                        itemstack1.field_77994_a = 1;
                        TileEntityBanner.removeBannerData(itemstack1);

                        if (itemstack.field_77994_a <= 1 && !playerIn.field_71075_bZ.field_75098_d)
                        {
                            playerIn.field_71071_by.func_70299_a(playerIn.field_71071_by.currentItem, itemstack1);
                        }
                        else
                        {
                            if (!playerIn.field_71071_by.func_70441_a(itemstack1))
                            {
                                worldIn.func_72838_d(new EntityItem(worldIn, (double)pos.func_177958_n() + 0.5D, (double)pos.func_177956_o() + 1.5D, (double)pos.func_177952_p() + 0.5D, itemstack1));
                            }
                            else if (playerIn instanceof EntityPlayerMP)
                            {
                                ((EntityPlayerMP)playerIn).sendContainerToPlayer(playerIn.field_71069_bz);
                            }

                            playerIn.func_71029_a(StatList.field_181728_L);

                            if (!playerIn.field_71075_bZ.field_75098_d)
                            {
                                --itemstack.field_77994_a;
                            }
                        }

                        if (!playerIn.field_71075_bZ.field_75098_d)
                        {
                            this.setWaterLevel(worldIn, pos, state, i - 1);
                        }

                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
        }
    }

    public void setWaterLevel(World worldIn, BlockPos pos, IBlockState state, int level)
    {
        worldIn.func_180501_a(pos, state.withProperty(LEVEL, Integer.valueOf(MathHelper.clamp_int(level, 0, 3))), 2);
        worldIn.updateComparatorOutputLevel(pos, this);
    }

    /**
     * Called similar to random ticks, but only when it is raining.
     */
    public void fillWithRain(World worldIn, BlockPos pos)
    {
        if (worldIn.rand.nextInt(20) == 1)
        {
            IBlockState iblockstate = worldIn.func_180495_p(pos);

            if (((Integer)iblockstate.getValue(LEVEL)).intValue() < 3)
            {
                worldIn.func_180501_a(pos, iblockstate.cycleProperty(LEVEL), 2);
            }
        }
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.cauldron;
    }

    public Item getItem(World worldIn, BlockPos pos)
    {
        return Items.cauldron;
    }

    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    public int getComparatorInputOverride(World worldIn, BlockPos pos)
    {
        return ((Integer)worldIn.func_180495_p(pos).getValue(LEVEL)).intValue();
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState func_176203_a(int meta)
    {
        return this.func_176223_P().withProperty(LEVEL, Integer.valueOf(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int func_176201_c(IBlockState state)
    {
        return ((Integer)state.getValue(LEVEL)).intValue();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {LEVEL});
    }
}
