package net.minecraft.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockSourceImpl implements IBlockSource
{
    private final World worldObj;
    private final BlockPos pos;

    public BlockSourceImpl(World worldIn, BlockPos posIn)
    {
        this.worldObj = worldIn;
        this.pos = posIn;
    }

    public World getWorld()
    {
        return this.worldObj;
    }

    public double getX()
    {
        return (double)this.pos.func_177958_n() + 0.5D;
    }

    public double getY()
    {
        return (double)this.pos.func_177956_o() + 0.5D;
    }

    public double getZ()
    {
        return (double)this.pos.func_177952_p() + 0.5D;
    }

    public BlockPos getBlockPos()
    {
        return this.pos;
    }

    public int getBlockMetadata()
    {
        IBlockState iblockstate = this.worldObj.func_180495_p(this.pos);
        return iblockstate.func_177230_c().func_176201_c(iblockstate);
    }

    public <T extends TileEntity> T getBlockTileEntity()
    {
        return (T)this.worldObj.func_175625_s(this.pos);
    }
}
