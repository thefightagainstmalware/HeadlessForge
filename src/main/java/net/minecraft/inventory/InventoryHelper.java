package net.minecraft.inventory;

import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class InventoryHelper
{
    private static final Random RANDOM = new Random();

    public static void dropInventoryItems(World worldIn, BlockPos pos, IInventory p_180175_2_)
    {
        func_180174_a(worldIn, (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p(), p_180175_2_);
    }

    public static void func_180176_a(World worldIn, Entity p_180176_1_, IInventory p_180176_2_)
    {
        func_180174_a(worldIn, p_180176_1_.field_70165_t, p_180176_1_.field_70163_u, p_180176_1_.field_70161_v, p_180176_2_);
    }

    private static void func_180174_a(World worldIn, double x, double y, double z, IInventory p_180174_7_)
    {
        for (int i = 0; i < p_180174_7_.func_70302_i_(); ++i)
        {
            ItemStack itemstack = p_180174_7_.getStackInSlot(i);

            if (itemstack != null)
            {
                spawnItemStack(worldIn, x, y, z, itemstack);
            }
        }
    }

    private static void spawnItemStack(World worldIn, double x, double y, double z, ItemStack stack)
    {
        float f = RANDOM.nextFloat() * 0.8F + 0.1F;
        float f1 = RANDOM.nextFloat() * 0.8F + 0.1F;
        float f2 = RANDOM.nextFloat() * 0.8F + 0.1F;

        while (stack.field_77994_a > 0)
        {
            int i = RANDOM.nextInt(21) + 10;

            if (i > stack.field_77994_a)
            {
                i = stack.field_77994_a;
            }

            stack.field_77994_a -= i;
            EntityItem entityitem = new EntityItem(worldIn, x + (double)f, y + (double)f1, z + (double)f2, new ItemStack(stack.func_77973_b(), i, stack.getMetadata()));

            if (stack.func_77942_o())
            {
                entityitem.getEntityItem().func_77982_d((NBTTagCompound)stack.func_77978_p().func_74737_b());
            }

            float f3 = 0.05F;
            entityitem.motionX = RANDOM.nextGaussian() * (double)f3;
            entityitem.motionY = RANDOM.nextGaussian() * (double)f3 + 0.20000000298023224D;
            entityitem.motionZ = RANDOM.nextGaussian() * (double)f3;
            worldIn.func_72838_d(entityitem);
        }
    }
}
