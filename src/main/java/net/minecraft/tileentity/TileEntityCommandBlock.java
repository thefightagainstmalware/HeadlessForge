package net.minecraft.tileentity;

import io.netty.buffer.ByteBuf;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.server.CommandBlockLogic;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class TileEntityCommandBlock extends TileEntity
{
    private final CommandBlockLogic commandBlockLogic = new CommandBlockLogic()
    {
        public BlockPos func_180425_c()
        {
            return TileEntityCommandBlock.this.pos;
        }
        public Vec3 func_174791_d()
        {
            return new Vec3((double)TileEntityCommandBlock.this.pos.func_177958_n() + 0.5D, (double)TileEntityCommandBlock.this.pos.func_177956_o() + 0.5D, (double)TileEntityCommandBlock.this.pos.func_177952_p() + 0.5D);
        }
        public World func_130014_f_()
        {
            return TileEntityCommandBlock.this.getWorld();
        }
        public void setCommand(String command)
        {
            super.setCommand(command);
            TileEntityCommandBlock.this.func_70296_d();
        }
        public void updateCommand()
        {
            TileEntityCommandBlock.this.getWorld().func_175689_h(TileEntityCommandBlock.this.pos);
        }
        public int func_145751_f()
        {
            return 0;
        }
        public void func_145757_a(ByteBuf p_145757_1_)
        {
            p_145757_1_.writeInt(TileEntityCommandBlock.this.pos.func_177958_n());
            p_145757_1_.writeInt(TileEntityCommandBlock.this.pos.func_177956_o());
            p_145757_1_.writeInt(TileEntityCommandBlock.this.pos.func_177952_p());
        }
        public Entity func_174793_f()
        {
            return null;
        }
    };

    public void func_145841_b(NBTTagCompound compound)
    {
        super.func_145841_b(compound);
        this.commandBlockLogic.writeDataToNBT(compound);
    }

    public void func_145839_a(NBTTagCompound compound)
    {
        super.func_145839_a(compound);
        this.commandBlockLogic.readDataFromNBT(compound);
    }

    /**
     * Allows for a specialized description packet to be created. This is often used to sync tile entity data from the
     * server to the client easily. For example this is used by signs to synchronise the text to be displayed.
     */
    public Packet getDescriptionPacket()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.func_145841_b(nbttagcompound);
        return new S35PacketUpdateTileEntity(this.pos, 2, nbttagcompound);
    }

    public boolean func_183000_F()
    {
        return true;
    }

    public CommandBlockLogic getCommandBlockLogic()
    {
        return this.commandBlockLogic;
    }

    public CommandResultStats func_175124_c()
    {
        return this.commandBlockLogic.getCommandResultStats();
    }
}
