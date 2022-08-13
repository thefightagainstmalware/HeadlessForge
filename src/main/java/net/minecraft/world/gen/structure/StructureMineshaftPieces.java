package net.minecraft.world.gen.structure;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

@SuppressWarnings("incomplete-switch")
public class StructureMineshaftPieces
{
    private static final List<WeightedRandomChestContent> CHEST_CONTENT_WEIGHT_LIST = Lists.newArrayList(new WeightedRandomChestContent[] {new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 10), new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 3, 5), new WeightedRandomChestContent(Items.redstone, 0, 4, 9, 5), new WeightedRandomChestContent(Items.field_151100_aR, EnumDyeColor.BLUE.getDyeDamage(), 4, 9, 5), new WeightedRandomChestContent(Items.field_151045_i, 0, 1, 2, 3), new WeightedRandomChestContent(Items.field_151044_h, 0, 3, 8, 10), new WeightedRandomChestContent(Items.bread, 0, 1, 3, 15), new WeightedRandomChestContent(Items.iron_pickaxe, 0, 1, 1, 1), new WeightedRandomChestContent(Item.func_150898_a(Blocks.rail), 0, 4, 8, 1), new WeightedRandomChestContent(Items.melon_seeds, 0, 2, 4, 10), new WeightedRandomChestContent(Items.pumpkin_seeds, 0, 2, 4, 10), new WeightedRandomChestContent(Items.saddle, 0, 1, 1, 3), new WeightedRandomChestContent(Items.iron_horse_armor, 0, 1, 1, 1)});

    public static void registerStructurePieces()
    {
        MapGenStructureIO.registerStructureComponent(StructureMineshaftPieces.Corridor.class, "MSCorridor");
        MapGenStructureIO.registerStructureComponent(StructureMineshaftPieces.Cross.class, "MSCrossing");
        MapGenStructureIO.registerStructureComponent(StructureMineshaftPieces.Room.class, "MSRoom");
        MapGenStructureIO.registerStructureComponent(StructureMineshaftPieces.Stairs.class, "MSStairs");
    }

    private static StructureComponent func_175892_a(List<StructureComponent> listIn, Random rand, int x, int y, int z, EnumFacing facing, int type)
    {
        int i = rand.nextInt(100);

        if (i >= 80)
        {
            StructureBoundingBox structureboundingbox = StructureMineshaftPieces.Cross.func_175813_a(listIn, rand, x, y, z, facing);

            if (structureboundingbox != null)
            {
                return new StructureMineshaftPieces.Cross(type, rand, structureboundingbox, facing);
            }
        }
        else if (i >= 70)
        {
            StructureBoundingBox structureboundingbox1 = StructureMineshaftPieces.Stairs.func_175812_a(listIn, rand, x, y, z, facing);

            if (structureboundingbox1 != null)
            {
                return new StructureMineshaftPieces.Stairs(type, rand, structureboundingbox1, facing);
            }
        }
        else
        {
            StructureBoundingBox structureboundingbox2 = StructureMineshaftPieces.Corridor.func_175814_a(listIn, rand, x, y, z, facing);

            if (structureboundingbox2 != null)
            {
                return new StructureMineshaftPieces.Corridor(type, rand, structureboundingbox2, facing);
            }
        }

        return null;
    }

    private static StructureComponent func_175890_b(StructureComponent componentIn, List<StructureComponent> listIn, Random rand, int x, int y, int z, EnumFacing facing, int type)
    {
        if (type > 8)
        {
            return null;
        }
        else if (Math.abs(x - componentIn.getBoundingBox().field_78897_a) <= 80 && Math.abs(z - componentIn.getBoundingBox().field_78896_c) <= 80)
        {
            StructureComponent structurecomponent = func_175892_a(listIn, rand, x, y, z, facing, type + 1);

            if (structurecomponent != null)
            {
                listIn.add(structurecomponent);
                structurecomponent.buildComponent(componentIn, listIn, rand);
            }

            return structurecomponent;
        }
        else
        {
            return null;
        }
    }

    public static class Corridor extends StructureComponent
    {
        private boolean hasRails;
        private boolean hasSpiders;
        private boolean spawnerPlaced;
        private int sectionCount;

        public Corridor()
        {
        }

        protected void writeStructureToNBT(NBTTagCompound tagCompound)
        {
            tagCompound.setBoolean("hr", this.hasRails);
            tagCompound.setBoolean("sc", this.hasSpiders);
            tagCompound.setBoolean("hps", this.spawnerPlaced);
            tagCompound.func_74768_a("Num", this.sectionCount);
        }

        protected void readStructureFromNBT(NBTTagCompound tagCompound)
        {
            this.hasRails = tagCompound.getBoolean("hr");
            this.hasSpiders = tagCompound.getBoolean("sc");
            this.spawnerPlaced = tagCompound.getBoolean("hps");
            this.sectionCount = tagCompound.getInteger("Num");
        }

        public Corridor(int type, Random rand, StructureBoundingBox structurebb, EnumFacing facing)
        {
            super(type);
            this.coordBaseMode = facing;
            this.boundingBox = structurebb;
            this.hasRails = rand.nextInt(3) == 0;
            this.hasSpiders = !this.hasRails && rand.nextInt(23) == 0;

            if (this.coordBaseMode != EnumFacing.NORTH && this.coordBaseMode != EnumFacing.SOUTH)
            {
                this.sectionCount = structurebb.func_78883_b() / 5;
            }
            else
            {
                this.sectionCount = structurebb.func_78880_d() / 5;
            }
        }

        public static StructureBoundingBox func_175814_a(List<StructureComponent> p_175814_0_, Random rand, int x, int y, int z, EnumFacing facing)
        {
            StructureBoundingBox structureboundingbox = new StructureBoundingBox(x, y, z, x, y + 2, z);
            int i;

            for (i = rand.nextInt(3) + 2; i > 0; --i)
            {
                int j = i * 5;

                switch (facing)
                {
                    case NORTH:
                        structureboundingbox.field_78893_d = x + 2;
                        structureboundingbox.field_78896_c = z - (j - 1);
                        break;

                    case SOUTH:
                        structureboundingbox.field_78893_d = x + 2;
                        structureboundingbox.field_78892_f = z + (j - 1);
                        break;

                    case WEST:
                        structureboundingbox.field_78897_a = x - (j - 1);
                        structureboundingbox.field_78892_f = z + 2;
                        break;

                    case EAST:
                        structureboundingbox.field_78893_d = x + (j - 1);
                        structureboundingbox.field_78892_f = z + 2;
                }

                if (StructureComponent.findIntersecting(p_175814_0_, structureboundingbox) == null)
                {
                    break;
                }
            }

            return i > 0 ? structureboundingbox : null;
        }

        public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand)
        {
            int i = this.getComponentType();
            int j = rand.nextInt(4);

            if (this.coordBaseMode != null)
            {
                switch (this.coordBaseMode)
                {
                    case NORTH:
                        if (j <= 1)
                        {
                            StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a, this.boundingBox.field_78895_b - 1 + rand.nextInt(3), this.boundingBox.field_78896_c - 1, this.coordBaseMode, i);
                        }
                        else if (j == 2)
                        {
                            StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a - 1, this.boundingBox.field_78895_b - 1 + rand.nextInt(3), this.boundingBox.field_78896_c, EnumFacing.WEST, i);
                        }
                        else
                        {
                            StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78893_d + 1, this.boundingBox.field_78895_b - 1 + rand.nextInt(3), this.boundingBox.field_78896_c, EnumFacing.EAST, i);
                        }

                        break;

                    case SOUTH:
                        if (j <= 1)
                        {
                            StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a, this.boundingBox.field_78895_b - 1 + rand.nextInt(3), this.boundingBox.field_78892_f + 1, this.coordBaseMode, i);
                        }
                        else if (j == 2)
                        {
                            StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a - 1, this.boundingBox.field_78895_b - 1 + rand.nextInt(3), this.boundingBox.field_78892_f - 3, EnumFacing.WEST, i);
                        }
                        else
                        {
                            StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78893_d + 1, this.boundingBox.field_78895_b - 1 + rand.nextInt(3), this.boundingBox.field_78892_f - 3, EnumFacing.EAST, i);
                        }

                        break;

                    case WEST:
                        if (j <= 1)
                        {
                            StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a - 1, this.boundingBox.field_78895_b - 1 + rand.nextInt(3), this.boundingBox.field_78896_c, this.coordBaseMode, i);
                        }
                        else if (j == 2)
                        {
                            StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a, this.boundingBox.field_78895_b - 1 + rand.nextInt(3), this.boundingBox.field_78896_c - 1, EnumFacing.NORTH, i);
                        }
                        else
                        {
                            StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a, this.boundingBox.field_78895_b - 1 + rand.nextInt(3), this.boundingBox.field_78892_f + 1, EnumFacing.SOUTH, i);
                        }

                        break;

                    case EAST:
                        if (j <= 1)
                        {
                            StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78893_d + 1, this.boundingBox.field_78895_b - 1 + rand.nextInt(3), this.boundingBox.field_78896_c, this.coordBaseMode, i);
                        }
                        else if (j == 2)
                        {
                            StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78893_d - 3, this.boundingBox.field_78895_b - 1 + rand.nextInt(3), this.boundingBox.field_78896_c - 1, EnumFacing.NORTH, i);
                        }
                        else
                        {
                            StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78893_d - 3, this.boundingBox.field_78895_b - 1 + rand.nextInt(3), this.boundingBox.field_78892_f + 1, EnumFacing.SOUTH, i);
                        }
                }
            }

            if (i < 8)
            {
                if (this.coordBaseMode != EnumFacing.NORTH && this.coordBaseMode != EnumFacing.SOUTH)
                {
                    for (int i1 = this.boundingBox.field_78897_a + 3; i1 + 3 <= this.boundingBox.field_78893_d; i1 += 5)
                    {
                        int j1 = rand.nextInt(5);

                        if (j1 == 0)
                        {
                            StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, i1, this.boundingBox.field_78895_b, this.boundingBox.field_78896_c - 1, EnumFacing.NORTH, i + 1);
                        }
                        else if (j1 == 1)
                        {
                            StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, i1, this.boundingBox.field_78895_b, this.boundingBox.field_78892_f + 1, EnumFacing.SOUTH, i + 1);
                        }
                    }
                }
                else
                {
                    for (int k = this.boundingBox.field_78896_c + 3; k + 3 <= this.boundingBox.field_78892_f; k += 5)
                    {
                        int l = rand.nextInt(5);

                        if (l == 0)
                        {
                            StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a - 1, this.boundingBox.field_78895_b, k, EnumFacing.WEST, i + 1);
                        }
                        else if (l == 1)
                        {
                            StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78893_d + 1, this.boundingBox.field_78895_b, k, EnumFacing.EAST, i + 1);
                        }
                    }
                }
            }
        }

        protected boolean generateChestContents(World worldIn, StructureBoundingBox boundingBoxIn, Random rand, int x, int y, int z, List<WeightedRandomChestContent> listIn, int max)
        {
            BlockPos blockpos = new BlockPos(this.getXWithOffset(x, z), this.getYWithOffset(y), this.getZWithOffset(x, z));

            if (boundingBoxIn.func_175898_b(blockpos) && worldIn.func_180495_p(blockpos).func_177230_c().func_149688_o() == Material.field_151579_a)
            {
                int i = rand.nextBoolean() ? 1 : 0;
                worldIn.func_180501_a(blockpos, Blocks.rail.func_176203_a(this.getMetadataWithOffset(Blocks.rail, i)), 2);
                EntityMinecartChest entityminecartchest = new EntityMinecartChest(worldIn, (double)((float)blockpos.func_177958_n() + 0.5F), (double)((float)blockpos.func_177956_o() + 0.5F), (double)((float)blockpos.func_177952_p() + 0.5F));
                WeightedRandomChestContent.generateChestContents(rand, listIn, entityminecartchest, max);
                worldIn.func_72838_d(entityminecartchest);
                return true;
            }
            else
            {
                return false;
            }
        }

        public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
        {
            if (this.isLiquidInStructureBoundingBox(worldIn, structureBoundingBoxIn))
            {
                return false;
            }
            else
            {
                int i = 0;
                int j = 2;
                int k = 0;
                int l = 2;
                int i1 = this.sectionCount * 5 - 1;
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 2, 1, i1, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
                this.func_175805_a(worldIn, structureBoundingBoxIn, randomIn, 0.8F, 0, 2, 0, 2, 2, i1, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);

                if (this.hasSpiders)
                {
                    this.func_175805_a(worldIn, structureBoundingBoxIn, randomIn, 0.6F, 0, 0, 0, 2, 1, i1, Blocks.web.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
                }

                for (int j1 = 0; j1 < this.sectionCount; ++j1)
                {
                    int k1 = 2 + j1 * 5;
                    this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, k1, 0, 1, k1, Blocks.oak_fence.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
                    this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 0, k1, 2, 1, k1, Blocks.oak_fence.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);

                    if (randomIn.nextInt(4) == 0)
                    {
                        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, k1, 0, 2, k1, Blocks.field_150344_f.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
                        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 2, k1, 2, 2, k1, Blocks.field_150344_f.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
                    }
                    else
                    {
                        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, k1, 2, 2, k1, Blocks.field_150344_f.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
                    }

                    this.randomlyPlaceBlock(worldIn, structureBoundingBoxIn, randomIn, 0.1F, 0, 2, k1 - 1, Blocks.web.func_176223_P());
                    this.randomlyPlaceBlock(worldIn, structureBoundingBoxIn, randomIn, 0.1F, 2, 2, k1 - 1, Blocks.web.func_176223_P());
                    this.randomlyPlaceBlock(worldIn, structureBoundingBoxIn, randomIn, 0.1F, 0, 2, k1 + 1, Blocks.web.func_176223_P());
                    this.randomlyPlaceBlock(worldIn, structureBoundingBoxIn, randomIn, 0.1F, 2, 2, k1 + 1, Blocks.web.func_176223_P());
                    this.randomlyPlaceBlock(worldIn, structureBoundingBoxIn, randomIn, 0.05F, 0, 2, k1 - 2, Blocks.web.func_176223_P());
                    this.randomlyPlaceBlock(worldIn, structureBoundingBoxIn, randomIn, 0.05F, 2, 2, k1 - 2, Blocks.web.func_176223_P());
                    this.randomlyPlaceBlock(worldIn, structureBoundingBoxIn, randomIn, 0.05F, 0, 2, k1 + 2, Blocks.web.func_176223_P());
                    this.randomlyPlaceBlock(worldIn, structureBoundingBoxIn, randomIn, 0.05F, 2, 2, k1 + 2, Blocks.web.func_176223_P());
                    this.randomlyPlaceBlock(worldIn, structureBoundingBoxIn, randomIn, 0.05F, 1, 2, k1 - 1, Blocks.torch.func_176203_a(EnumFacing.UP.getIndex()));
                    this.randomlyPlaceBlock(worldIn, structureBoundingBoxIn, randomIn, 0.05F, 1, 2, k1 + 1, Blocks.torch.func_176203_a(EnumFacing.UP.getIndex()));

                    if (randomIn.nextInt(100) == 0)
                    {
                        this.generateChestContents(worldIn, structureBoundingBoxIn, randomIn, 2, 0, k1 - 1, WeightedRandomChestContent.func_177629_a(StructureMineshaftPieces.CHEST_CONTENT_WEIGHT_LIST, new WeightedRandomChestContent[] {Items.field_151134_bR.getRandom(randomIn)}), 3 + randomIn.nextInt(4));
                    }

                    if (randomIn.nextInt(100) == 0)
                    {
                        this.generateChestContents(worldIn, structureBoundingBoxIn, randomIn, 0, 0, k1 + 1, WeightedRandomChestContent.func_177629_a(StructureMineshaftPieces.CHEST_CONTENT_WEIGHT_LIST, new WeightedRandomChestContent[] {Items.field_151134_bR.getRandom(randomIn)}), 3 + randomIn.nextInt(4));
                    }

                    if (this.hasSpiders && !this.spawnerPlaced)
                    {
                        int l1 = this.getYWithOffset(0);
                        int i2 = k1 - 1 + randomIn.nextInt(3);
                        int j2 = this.getXWithOffset(1, i2);
                        i2 = this.getZWithOffset(1, i2);
                        BlockPos blockpos = new BlockPos(j2, l1, i2);

                        if (structureBoundingBoxIn.func_175898_b(blockpos))
                        {
                            this.spawnerPlaced = true;
                            worldIn.func_180501_a(blockpos, Blocks.mob_spawner.func_176223_P(), 2);
                            TileEntity tileentity = worldIn.func_175625_s(blockpos);

                            if (tileentity instanceof TileEntityMobSpawner)
                            {
                                ((TileEntityMobSpawner)tileentity).getSpawnerBaseLogic().setEntityName("CaveSpider");
                            }
                        }
                    }
                }

                for (int k2 = 0; k2 <= 2; ++k2)
                {
                    for (int i3 = 0; i3 <= i1; ++i3)
                    {
                        int j3 = -1;
                        IBlockState iblockstate1 = this.getBlockStateFromPos(worldIn, k2, j3, i3, structureBoundingBoxIn);

                        if (iblockstate1.func_177230_c().func_149688_o() == Material.field_151579_a)
                        {
                            int k3 = -1;
                            this.setBlockState(worldIn, Blocks.field_150344_f.func_176223_P(), k2, k3, i3, structureBoundingBoxIn);
                        }
                    }
                }

                if (this.hasRails)
                {
                    for (int l2 = 0; l2 <= i1; ++l2)
                    {
                        IBlockState iblockstate = this.getBlockStateFromPos(worldIn, 1, -1, l2, structureBoundingBoxIn);

                        if (iblockstate.func_177230_c().func_149688_o() != Material.field_151579_a && iblockstate.func_177230_c().func_149730_j())
                        {
                            this.randomlyPlaceBlock(worldIn, structureBoundingBoxIn, randomIn, 0.7F, 1, 0, l2, Blocks.rail.func_176203_a(this.getMetadataWithOffset(Blocks.rail, 0)));
                        }
                    }
                }

                return true;
            }
        }
    }

    public static class Cross extends StructureComponent
    {
        private EnumFacing corridorDirection;
        private boolean isMultipleFloors;

        public Cross()
        {
        }

        protected void writeStructureToNBT(NBTTagCompound tagCompound)
        {
            tagCompound.setBoolean("tf", this.isMultipleFloors);
            tagCompound.func_74768_a("D", this.corridorDirection.getHorizontalIndex());
        }

        protected void readStructureFromNBT(NBTTagCompound tagCompound)
        {
            this.isMultipleFloors = tagCompound.getBoolean("tf");
            this.corridorDirection = EnumFacing.getHorizontal(tagCompound.getInteger("D"));
        }

        public Cross(int type, Random rand, StructureBoundingBox structurebb, EnumFacing facing)
        {
            super(type);
            this.corridorDirection = facing;
            this.boundingBox = structurebb;
            this.isMultipleFloors = structurebb.func_78882_c() > 3;
        }

        public static StructureBoundingBox func_175813_a(List<StructureComponent> listIn, Random rand, int x, int y, int z, EnumFacing facing)
        {
            StructureBoundingBox structureboundingbox = new StructureBoundingBox(x, y, z, x, y + 2, z);

            if (rand.nextInt(4) == 0)
            {
                structureboundingbox.field_78894_e += 4;
            }

            switch (facing)
            {
                case NORTH:
                    structureboundingbox.field_78897_a = x - 1;
                    structureboundingbox.field_78893_d = x + 3;
                    structureboundingbox.field_78896_c = z - 4;
                    break;

                case SOUTH:
                    structureboundingbox.field_78897_a = x - 1;
                    structureboundingbox.field_78893_d = x + 3;
                    structureboundingbox.field_78892_f = z + 4;
                    break;

                case WEST:
                    structureboundingbox.field_78897_a = x - 4;
                    structureboundingbox.field_78896_c = z - 1;
                    structureboundingbox.field_78892_f = z + 3;
                    break;

                case EAST:
                    structureboundingbox.field_78893_d = x + 4;
                    structureboundingbox.field_78896_c = z - 1;
                    structureboundingbox.field_78892_f = z + 3;
            }

            return StructureComponent.findIntersecting(listIn, structureboundingbox) != null ? null : structureboundingbox;
        }

        public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand)
        {
            int i = this.getComponentType();

            switch (this.corridorDirection)
            {
                case NORTH:
                    StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a + 1, this.boundingBox.field_78895_b, this.boundingBox.field_78896_c - 1, EnumFacing.NORTH, i);
                    StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a - 1, this.boundingBox.field_78895_b, this.boundingBox.field_78896_c + 1, EnumFacing.WEST, i);
                    StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78893_d + 1, this.boundingBox.field_78895_b, this.boundingBox.field_78896_c + 1, EnumFacing.EAST, i);
                    break;

                case SOUTH:
                    StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a + 1, this.boundingBox.field_78895_b, this.boundingBox.field_78892_f + 1, EnumFacing.SOUTH, i);
                    StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a - 1, this.boundingBox.field_78895_b, this.boundingBox.field_78896_c + 1, EnumFacing.WEST, i);
                    StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78893_d + 1, this.boundingBox.field_78895_b, this.boundingBox.field_78896_c + 1, EnumFacing.EAST, i);
                    break;

                case WEST:
                    StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a + 1, this.boundingBox.field_78895_b, this.boundingBox.field_78896_c - 1, EnumFacing.NORTH, i);
                    StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a + 1, this.boundingBox.field_78895_b, this.boundingBox.field_78892_f + 1, EnumFacing.SOUTH, i);
                    StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a - 1, this.boundingBox.field_78895_b, this.boundingBox.field_78896_c + 1, EnumFacing.WEST, i);
                    break;

                case EAST:
                    StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a + 1, this.boundingBox.field_78895_b, this.boundingBox.field_78896_c - 1, EnumFacing.NORTH, i);
                    StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a + 1, this.boundingBox.field_78895_b, this.boundingBox.field_78892_f + 1, EnumFacing.SOUTH, i);
                    StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78893_d + 1, this.boundingBox.field_78895_b, this.boundingBox.field_78896_c + 1, EnumFacing.EAST, i);
            }

            if (this.isMultipleFloors)
            {
                if (rand.nextBoolean())
                {
                    StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a + 1, this.boundingBox.field_78895_b + 3 + 1, this.boundingBox.field_78896_c - 1, EnumFacing.NORTH, i);
                }

                if (rand.nextBoolean())
                {
                    StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a - 1, this.boundingBox.field_78895_b + 3 + 1, this.boundingBox.field_78896_c + 1, EnumFacing.WEST, i);
                }

                if (rand.nextBoolean())
                {
                    StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78893_d + 1, this.boundingBox.field_78895_b + 3 + 1, this.boundingBox.field_78896_c + 1, EnumFacing.EAST, i);
                }

                if (rand.nextBoolean())
                {
                    StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a + 1, this.boundingBox.field_78895_b + 3 + 1, this.boundingBox.field_78892_f + 1, EnumFacing.SOUTH, i);
                }
            }
        }

        public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
        {
            if (this.isLiquidInStructureBoundingBox(worldIn, structureBoundingBoxIn))
            {
                return false;
            }
            else
            {
                if (this.isMultipleFloors)
                {
                    this.fillWithBlocks(worldIn, structureBoundingBoxIn, this.boundingBox.field_78897_a + 1, this.boundingBox.field_78895_b, this.boundingBox.field_78896_c, this.boundingBox.field_78893_d - 1, this.boundingBox.field_78895_b + 3 - 1, this.boundingBox.field_78892_f, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
                    this.fillWithBlocks(worldIn, structureBoundingBoxIn, this.boundingBox.field_78897_a, this.boundingBox.field_78895_b, this.boundingBox.field_78896_c + 1, this.boundingBox.field_78893_d, this.boundingBox.field_78895_b + 3 - 1, this.boundingBox.field_78892_f - 1, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
                    this.fillWithBlocks(worldIn, structureBoundingBoxIn, this.boundingBox.field_78897_a + 1, this.boundingBox.field_78894_e - 2, this.boundingBox.field_78896_c, this.boundingBox.field_78893_d - 1, this.boundingBox.field_78894_e, this.boundingBox.field_78892_f, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
                    this.fillWithBlocks(worldIn, structureBoundingBoxIn, this.boundingBox.field_78897_a, this.boundingBox.field_78894_e - 2, this.boundingBox.field_78896_c + 1, this.boundingBox.field_78893_d, this.boundingBox.field_78894_e, this.boundingBox.field_78892_f - 1, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
                    this.fillWithBlocks(worldIn, structureBoundingBoxIn, this.boundingBox.field_78897_a + 1, this.boundingBox.field_78895_b + 3, this.boundingBox.field_78896_c + 1, this.boundingBox.field_78893_d - 1, this.boundingBox.field_78895_b + 3, this.boundingBox.field_78892_f - 1, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
                }
                else
                {
                    this.fillWithBlocks(worldIn, structureBoundingBoxIn, this.boundingBox.field_78897_a + 1, this.boundingBox.field_78895_b, this.boundingBox.field_78896_c, this.boundingBox.field_78893_d - 1, this.boundingBox.field_78894_e, this.boundingBox.field_78892_f, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
                    this.fillWithBlocks(worldIn, structureBoundingBoxIn, this.boundingBox.field_78897_a, this.boundingBox.field_78895_b, this.boundingBox.field_78896_c + 1, this.boundingBox.field_78893_d, this.boundingBox.field_78894_e, this.boundingBox.field_78892_f - 1, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
                }

                this.fillWithBlocks(worldIn, structureBoundingBoxIn, this.boundingBox.field_78897_a + 1, this.boundingBox.field_78895_b, this.boundingBox.field_78896_c + 1, this.boundingBox.field_78897_a + 1, this.boundingBox.field_78894_e, this.boundingBox.field_78896_c + 1, Blocks.field_150344_f.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, this.boundingBox.field_78897_a + 1, this.boundingBox.field_78895_b, this.boundingBox.field_78892_f - 1, this.boundingBox.field_78897_a + 1, this.boundingBox.field_78894_e, this.boundingBox.field_78892_f - 1, Blocks.field_150344_f.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, this.boundingBox.field_78893_d - 1, this.boundingBox.field_78895_b, this.boundingBox.field_78896_c + 1, this.boundingBox.field_78893_d - 1, this.boundingBox.field_78894_e, this.boundingBox.field_78896_c + 1, Blocks.field_150344_f.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, this.boundingBox.field_78893_d - 1, this.boundingBox.field_78895_b, this.boundingBox.field_78892_f - 1, this.boundingBox.field_78893_d - 1, this.boundingBox.field_78894_e, this.boundingBox.field_78892_f - 1, Blocks.field_150344_f.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);

                for (int i = this.boundingBox.field_78897_a; i <= this.boundingBox.field_78893_d; ++i)
                {
                    for (int j = this.boundingBox.field_78896_c; j <= this.boundingBox.field_78892_f; ++j)
                    {
                        if (this.getBlockStateFromPos(worldIn, i, this.boundingBox.field_78895_b - 1, j, structureBoundingBoxIn).func_177230_c().func_149688_o() == Material.field_151579_a)
                        {
                            this.setBlockState(worldIn, Blocks.field_150344_f.func_176223_P(), i, this.boundingBox.field_78895_b - 1, j, structureBoundingBoxIn);
                        }
                    }
                }

                return true;
            }
        }
    }

    public static class Room extends StructureComponent
    {
        private List<StructureBoundingBox> roomsLinkedToTheRoom = Lists.<StructureBoundingBox>newLinkedList();

        public Room()
        {
        }

        public Room(int type, Random rand, int x, int z)
        {
            super(type);
            this.boundingBox = new StructureBoundingBox(x, 50, z, x + 7 + rand.nextInt(6), 54 + rand.nextInt(6), z + 7 + rand.nextInt(6));
        }

        public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand)
        {
            int i = this.getComponentType();
            int j = this.boundingBox.func_78882_c() - 3 - 1;

            if (j <= 0)
            {
                j = 1;
            }

            for (int k = 0; k < this.boundingBox.func_78883_b(); k = k + 4)
            {
                k = k + rand.nextInt(this.boundingBox.func_78883_b());

                if (k + 3 > this.boundingBox.func_78883_b())
                {
                    break;
                }

                StructureComponent structurecomponent = StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a + k, this.boundingBox.field_78895_b + rand.nextInt(j) + 1, this.boundingBox.field_78896_c - 1, EnumFacing.NORTH, i);

                if (structurecomponent != null)
                {
                    StructureBoundingBox structureboundingbox = structurecomponent.getBoundingBox();
                    this.roomsLinkedToTheRoom.add(new StructureBoundingBox(structureboundingbox.field_78897_a, structureboundingbox.field_78895_b, this.boundingBox.field_78896_c, structureboundingbox.field_78893_d, structureboundingbox.field_78894_e, this.boundingBox.field_78896_c + 1));
                }
            }

            for (int k = 0; k < this.boundingBox.func_78883_b(); k = k + 4)
            {
                k = k + rand.nextInt(this.boundingBox.func_78883_b());

                if (k + 3 > this.boundingBox.func_78883_b())
                {
                    break;
                }

                StructureComponent structurecomponent1 = StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a + k, this.boundingBox.field_78895_b + rand.nextInt(j) + 1, this.boundingBox.field_78892_f + 1, EnumFacing.SOUTH, i);

                if (structurecomponent1 != null)
                {
                    StructureBoundingBox structureboundingbox1 = structurecomponent1.getBoundingBox();
                    this.roomsLinkedToTheRoom.add(new StructureBoundingBox(structureboundingbox1.field_78897_a, structureboundingbox1.field_78895_b, this.boundingBox.field_78892_f - 1, structureboundingbox1.field_78893_d, structureboundingbox1.field_78894_e, this.boundingBox.field_78892_f));
                }
            }

            for (int k = 0; k < this.boundingBox.func_78880_d(); k = k + 4)
            {
                k = k + rand.nextInt(this.boundingBox.func_78880_d());

                if (k + 3 > this.boundingBox.func_78880_d())
                {
                    break;
                }

                StructureComponent structurecomponent2 = StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a - 1, this.boundingBox.field_78895_b + rand.nextInt(j) + 1, this.boundingBox.field_78896_c + k, EnumFacing.WEST, i);

                if (structurecomponent2 != null)
                {
                    StructureBoundingBox structureboundingbox2 = structurecomponent2.getBoundingBox();
                    this.roomsLinkedToTheRoom.add(new StructureBoundingBox(this.boundingBox.field_78897_a, structureboundingbox2.field_78895_b, structureboundingbox2.field_78896_c, this.boundingBox.field_78897_a + 1, structureboundingbox2.field_78894_e, structureboundingbox2.field_78892_f));
                }
            }

            for (int k = 0; k < this.boundingBox.func_78880_d(); k = k + 4)
            {
                k = k + rand.nextInt(this.boundingBox.func_78880_d());

                if (k + 3 > this.boundingBox.func_78880_d())
                {
                    break;
                }

                StructureComponent structurecomponent3 = StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78893_d + 1, this.boundingBox.field_78895_b + rand.nextInt(j) + 1, this.boundingBox.field_78896_c + k, EnumFacing.EAST, i);

                if (structurecomponent3 != null)
                {
                    StructureBoundingBox structureboundingbox3 = structurecomponent3.getBoundingBox();
                    this.roomsLinkedToTheRoom.add(new StructureBoundingBox(this.boundingBox.field_78893_d - 1, structureboundingbox3.field_78895_b, structureboundingbox3.field_78896_c, this.boundingBox.field_78893_d, structureboundingbox3.field_78894_e, structureboundingbox3.field_78892_f));
                }
            }
        }

        public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
        {
            if (this.isLiquidInStructureBoundingBox(worldIn, structureBoundingBoxIn))
            {
                return false;
            }
            else
            {
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, this.boundingBox.field_78897_a, this.boundingBox.field_78895_b, this.boundingBox.field_78896_c, this.boundingBox.field_78893_d, this.boundingBox.field_78895_b, this.boundingBox.field_78892_f, Blocks.field_150346_d.func_176223_P(), Blocks.field_150350_a.func_176223_P(), true);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, this.boundingBox.field_78897_a, this.boundingBox.field_78895_b + 1, this.boundingBox.field_78896_c, this.boundingBox.field_78893_d, Math.min(this.boundingBox.field_78895_b + 3, this.boundingBox.field_78894_e), this.boundingBox.field_78892_f, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);

                for (StructureBoundingBox structureboundingbox : this.roomsLinkedToTheRoom)
                {
                    this.fillWithBlocks(worldIn, structureBoundingBoxIn, structureboundingbox.field_78897_a, structureboundingbox.field_78894_e - 2, structureboundingbox.field_78896_c, structureboundingbox.field_78893_d, structureboundingbox.field_78894_e, structureboundingbox.field_78892_f, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
                }

                this.randomlyRareFillWithBlocks(worldIn, structureBoundingBoxIn, this.boundingBox.field_78897_a, this.boundingBox.field_78895_b + 4, this.boundingBox.field_78896_c, this.boundingBox.field_78893_d, this.boundingBox.field_78894_e, this.boundingBox.field_78892_f, Blocks.field_150350_a.func_176223_P(), false);
                return true;
            }
        }

        public void func_181138_a(int p_181138_1_, int p_181138_2_, int p_181138_3_)
        {
            super.func_181138_a(p_181138_1_, p_181138_2_, p_181138_3_);

            for (StructureBoundingBox structureboundingbox : this.roomsLinkedToTheRoom)
            {
                structureboundingbox.offset(p_181138_1_, p_181138_2_, p_181138_3_);
            }
        }

        protected void writeStructureToNBT(NBTTagCompound tagCompound)
        {
            NBTTagList nbttaglist = new NBTTagList();

            for (StructureBoundingBox structureboundingbox : this.roomsLinkedToTheRoom)
            {
                nbttaglist.func_74742_a(structureboundingbox.toNBTTagIntArray());
            }

            tagCompound.func_74782_a("Entrances", nbttaglist);
        }

        protected void readStructureFromNBT(NBTTagCompound tagCompound)
        {
            NBTTagList nbttaglist = tagCompound.getTagList("Entrances", 11);

            for (int i = 0; i < nbttaglist.func_74745_c(); ++i)
            {
                this.roomsLinkedToTheRoom.add(new StructureBoundingBox(nbttaglist.getIntArrayAt(i)));
            }
        }
    }

    public static class Stairs extends StructureComponent
    {
        public Stairs()
        {
        }

        public Stairs(int type, Random rand, StructureBoundingBox structurebb, EnumFacing facing)
        {
            super(type);
            this.coordBaseMode = facing;
            this.boundingBox = structurebb;
        }

        protected void writeStructureToNBT(NBTTagCompound tagCompound)
        {
        }

        protected void readStructureFromNBT(NBTTagCompound tagCompound)
        {
        }

        public static StructureBoundingBox func_175812_a(List<StructureComponent> listIn, Random rand, int x, int y, int z, EnumFacing facing)
        {
            StructureBoundingBox structureboundingbox = new StructureBoundingBox(x, y - 5, z, x, y + 2, z);

            switch (facing)
            {
                case NORTH:
                    structureboundingbox.field_78893_d = x + 2;
                    structureboundingbox.field_78896_c = z - 8;
                    break;

                case SOUTH:
                    structureboundingbox.field_78893_d = x + 2;
                    structureboundingbox.field_78892_f = z + 8;
                    break;

                case WEST:
                    structureboundingbox.field_78897_a = x - 8;
                    structureboundingbox.field_78892_f = z + 2;
                    break;

                case EAST:
                    structureboundingbox.field_78893_d = x + 8;
                    structureboundingbox.field_78892_f = z + 2;
            }

            return StructureComponent.findIntersecting(listIn, structureboundingbox) != null ? null : structureboundingbox;
        }

        public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand)
        {
            int i = this.getComponentType();

            if (this.coordBaseMode != null)
            {
                switch (this.coordBaseMode)
                {
                    case NORTH:
                        StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a, this.boundingBox.field_78895_b, this.boundingBox.field_78896_c - 1, EnumFacing.NORTH, i);
                        break;

                    case SOUTH:
                        StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a, this.boundingBox.field_78895_b, this.boundingBox.field_78892_f + 1, EnumFacing.SOUTH, i);
                        break;

                    case WEST:
                        StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78897_a - 1, this.boundingBox.field_78895_b, this.boundingBox.field_78896_c, EnumFacing.WEST, i);
                        break;

                    case EAST:
                        StructureMineshaftPieces.func_175890_b(componentIn, listIn, rand, this.boundingBox.field_78893_d + 1, this.boundingBox.field_78895_b, this.boundingBox.field_78896_c, EnumFacing.EAST, i);
                }
            }
        }

        public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
        {
            if (this.isLiquidInStructureBoundingBox(worldIn, structureBoundingBoxIn))
            {
                return false;
            }
            else
            {
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 0, 2, 7, 1, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 7, 2, 2, 8, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);

                for (int i = 0; i < 5; ++i)
                {
                    this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5 - i - (i < 4 ? 1 : 0), 2 + i, 2, 7 - i, 2 + i, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
                }

                return true;
            }
        }
    }
}
