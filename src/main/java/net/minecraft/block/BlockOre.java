package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockOre extends Block
{
    public BlockOre()
    {
        this(Material.rock.getMaterialMapColor());
    }

    public BlockOre(MapColor p_i46390_1_)
    {
        super(Material.rock, p_i46390_1_);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return this == Blocks.field_150365_q ? Items.field_151044_h : (this == Blocks.field_150482_ag ? Items.field_151045_i : (this == Blocks.field_150369_x ? Items.field_151100_aR : (this == Blocks.field_150412_bA ? Items.emerald : (this == Blocks.field_150449_bY ? Items.field_151128_bU : Item.func_150898_a(this)))));
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return this == Blocks.field_150369_x ? 4 + random.nextInt(5) : 1;
    }

    /**
     * Get the quantity dropped based on the given fortune level
     */
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0 && Item.func_150898_a(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune))
        {
            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0)
            {
                i = 0;
            }

            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }

    /**
     * Spawns this Block's drops into the World as EntityItems.
     */
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);

        if (this.getItemDropped(state, worldIn.rand, fortune) != Item.func_150898_a(this))
        {
            int i = 0;

            if (this == Blocks.field_150365_q)
            {
                i = MathHelper.getRandomIntegerInRange(worldIn.rand, 0, 2);
            }
            else if (this == Blocks.field_150482_ag)
            {
                i = MathHelper.getRandomIntegerInRange(worldIn.rand, 3, 7);
            }
            else if (this == Blocks.field_150412_bA)
            {
                i = MathHelper.getRandomIntegerInRange(worldIn.rand, 3, 7);
            }
            else if (this == Blocks.field_150369_x)
            {
                i = MathHelper.getRandomIntegerInRange(worldIn.rand, 2, 5);
            }
            else if (this == Blocks.field_150449_bY)
            {
                i = MathHelper.getRandomIntegerInRange(worldIn.rand, 2, 5);
            }

            this.dropXpOnBlockBreak(worldIn, pos, i);
        }
    }

    public int getDamageValue(World worldIn, BlockPos pos)
    {
        return 0;
    }

    /**
     * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
     * returns the metadata of the dropped item based on the old metadata of the block.
     */
    public int damageDropped(IBlockState state)
    {
        return this == Blocks.field_150369_x ? EnumDyeColor.BLUE.getDyeDamage() : 0;
    }
}
