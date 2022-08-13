package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;

public class BlockSilverfish extends Block
{
    public static final PropertyEnum<BlockSilverfish.EnumType> VARIANT = PropertyEnum.<BlockSilverfish.EnumType>create("variant", BlockSilverfish.EnumType.class);

    public BlockSilverfish()
    {
        super(Material.clay);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockSilverfish.EnumType.STONE));
        this.setHardness(0.0F);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 0;
    }

    public static boolean canContainSilverfish(IBlockState blockState)
    {
        Block block = blockState.func_177230_c();
        return blockState == Blocks.field_150348_b.func_176223_P().withProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE) || block == Blocks.field_150347_e || block == Blocks.stonebrick;
    }

    protected ItemStack createStackedBlock(IBlockState state)
    {
        switch ((BlockSilverfish.EnumType)state.getValue(VARIANT))
        {
            case COBBLESTONE:
                return new ItemStack(Blocks.field_150347_e);

            case STONEBRICK:
                return new ItemStack(Blocks.stonebrick);

            case MOSSY_STONEBRICK:
                return new ItemStack(Blocks.stonebrick, 1, BlockStoneBrick.EnumType.MOSSY.getMetadata());

            case CRACKED_STONEBRICK:
                return new ItemStack(Blocks.stonebrick, 1, BlockStoneBrick.EnumType.CRACKED.getMetadata());

            case CHISELED_STONEBRICK:
                return new ItemStack(Blocks.stonebrick, 1, BlockStoneBrick.EnumType.CHISELED.getMetadata());

            default:
                return new ItemStack(Blocks.field_150348_b);
        }
    }

    /**
     * Spawns this Block's drops into the World as EntityItems.
     */
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        if (!worldIn.isRemote && worldIn.func_82736_K().func_82766_b("doTileDrops"))
        {
            EntitySilverfish entitysilverfish = new EntitySilverfish(worldIn);
            entitysilverfish.func_70012_b((double)pos.func_177958_n() + 0.5D, (double)pos.func_177956_o(), (double)pos.func_177952_p() + 0.5D, 0.0F, 0.0F);
            worldIn.func_72838_d(entitysilverfish);
            entitysilverfish.spawnExplosionParticle();
        }
    }

    public int getDamageValue(World worldIn, BlockPos pos)
    {
        IBlockState iblockstate = worldIn.func_180495_p(pos);
        return iblockstate.func_177230_c().func_176201_c(iblockstate);
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        for (BlockSilverfish.EnumType blocksilverfish$enumtype : BlockSilverfish.EnumType.values())
        {
            list.add(new ItemStack(itemIn, 1, blocksilverfish$enumtype.getMetadata()));
        }
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState func_176203_a(int meta)
    {
        return this.func_176223_P().withProperty(VARIANT, BlockSilverfish.EnumType.byMetadata(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int func_176201_c(IBlockState state)
    {
        return ((BlockSilverfish.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {VARIANT});
    }

    public static enum EnumType implements IStringSerializable
    {
        STONE(0, "stone")
                {
                    public IBlockState getModelBlock()
                    {
                        return Blocks.field_150348_b.func_176223_P().withProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE);
                    }
                },
        COBBLESTONE(1, "cobblestone", "cobble")
                {
                    public IBlockState getModelBlock()
                    {
                        return Blocks.field_150347_e.func_176223_P();
                    }
                },
        STONEBRICK(2, "stone_brick", "brick")
                {
                    public IBlockState getModelBlock()
                    {
                        return Blocks.stonebrick.func_176223_P().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.DEFAULT);
                    }
                },
        MOSSY_STONEBRICK(3, "mossy_brick", "mossybrick")
                {
                    public IBlockState getModelBlock()
                    {
                        return Blocks.stonebrick.func_176223_P().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.MOSSY);
                    }
                },
        CRACKED_STONEBRICK(4, "cracked_brick", "crackedbrick")
                {
                    public IBlockState getModelBlock()
                    {
                        return Blocks.stonebrick.func_176223_P().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.CRACKED);
                    }
                },
        CHISELED_STONEBRICK(5, "chiseled_brick", "chiseledbrick")
                {
                    public IBlockState getModelBlock()
                    {
                        return Blocks.stonebrick.func_176223_P().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.CHISELED);
                    }
                };

        private static final BlockSilverfish.EnumType[] META_LOOKUP = new BlockSilverfish.EnumType[values().length];
        private final int meta;
        private final String name;
        private final String unlocalizedName;

        private EnumType(int meta, String name)
        {
            this(meta, name, name);
        }

        private EnumType(int meta, String name, String unlocalizedName)
        {
            this.meta = meta;
            this.name = name;
            this.unlocalizedName = unlocalizedName;
        }

        public int getMetadata()
        {
            return this.meta;
        }

        public String toString()
        {
            return this.name;
        }

        public static BlockSilverfish.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName()
        {
            return this.name;
        }

        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }

        public abstract IBlockState getModelBlock();

        public static BlockSilverfish.EnumType forModelBlock(IBlockState model)
        {
            for (BlockSilverfish.EnumType blocksilverfish$enumtype : values())
            {
                if (model == blocksilverfish$enumtype.getModelBlock())
                {
                    return blocksilverfish$enumtype;
                }
            }

            return STONE;
        }

        static {
            for (BlockSilverfish.EnumType blocksilverfish$enumtype : values())
            {
                META_LOOKUP[blocksilverfish$enumtype.getMetadata()] = blocksilverfish$enumtype;
            }
        }
    }
}
