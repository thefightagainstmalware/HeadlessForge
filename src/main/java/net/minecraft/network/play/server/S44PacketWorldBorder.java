package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.world.border.WorldBorder;

public class S44PacketWorldBorder implements Packet<INetHandlerPlayClient>
{
    private S44PacketWorldBorder.Action action;
    private int size;
    private double centerX;
    private double centerZ;
    private double targetSize;
    private double diameter;
    private long timeUntilTarget;
    private int warningTime;
    private int warningDistance;

    public S44PacketWorldBorder()
    {
    }

    public S44PacketWorldBorder(WorldBorder border, S44PacketWorldBorder.Action actionIn)
    {
        this.action = actionIn;
        this.centerX = border.getCenterX();
        this.centerZ = border.getCenterZ();
        this.diameter = border.func_177741_h();
        this.targetSize = border.func_177751_j();
        this.timeUntilTarget = border.func_177732_i();
        this.size = border.getSize();
        this.warningDistance = border.func_177748_q();
        this.warningTime = border.func_177740_p();
    }

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.action = (S44PacketWorldBorder.Action)buf.readEnumValue(S44PacketWorldBorder.Action.class);

        switch (this.action)
        {
            case SET_SIZE:
                this.targetSize = buf.readDouble();
                break;

            case LERP_SIZE:
                this.diameter = buf.readDouble();
                this.targetSize = buf.readDouble();
                this.timeUntilTarget = buf.readVarLong();
                break;

            case SET_CENTER:
                this.centerX = buf.readDouble();
                this.centerZ = buf.readDouble();
                break;

            case SET_WARNING_BLOCKS:
                this.warningDistance = buf.readVarIntFromBuffer();
                break;

            case SET_WARNING_TIME:
                this.warningTime = buf.readVarIntFromBuffer();
                break;

            case INITIALIZE:
                this.centerX = buf.readDouble();
                this.centerZ = buf.readDouble();
                this.diameter = buf.readDouble();
                this.targetSize = buf.readDouble();
                this.timeUntilTarget = buf.readVarLong();
                this.size = buf.readVarIntFromBuffer();
                this.warningDistance = buf.readVarIntFromBuffer();
                this.warningTime = buf.readVarIntFromBuffer();
        }
    }

    /**
     * Writes the raw packet data to the data stream.
     */
    public void writePacketData(PacketBuffer buf) throws IOException
    {
        buf.writeEnumValue(this.action);

        switch (this.action)
        {
            case SET_SIZE:
                buf.writeDouble(this.targetSize);
                break;

            case LERP_SIZE:
                buf.writeDouble(this.diameter);
                buf.writeDouble(this.targetSize);
                buf.writeVarLong(this.timeUntilTarget);
                break;

            case SET_CENTER:
                buf.writeDouble(this.centerX);
                buf.writeDouble(this.centerZ);
                break;

            case SET_WARNING_BLOCKS:
                buf.writeVarIntToBuffer(this.warningDistance);
                break;

            case SET_WARNING_TIME:
                buf.writeVarIntToBuffer(this.warningTime);
                break;

            case INITIALIZE:
                buf.writeDouble(this.centerX);
                buf.writeDouble(this.centerZ);
                buf.writeDouble(this.diameter);
                buf.writeDouble(this.targetSize);
                buf.writeVarLong(this.timeUntilTarget);
                buf.writeVarIntToBuffer(this.size);
                buf.writeVarIntToBuffer(this.warningDistance);
                buf.writeVarIntToBuffer(this.warningTime);
        }
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(INetHandlerPlayClient handler)
    {
        handler.handleWorldBorder(this);
    }

    public void func_179788_a(WorldBorder border)
    {
        switch (this.action)
        {
            case SET_SIZE:
                border.func_177750_a(this.targetSize);
                break;

            case LERP_SIZE:
                border.func_177738_a(this.diameter, this.targetSize, this.timeUntilTarget);
                break;

            case SET_CENTER:
                border.func_177739_c(this.centerX, this.centerZ);
                break;

            case SET_WARNING_BLOCKS:
                border.func_177747_c(this.warningDistance);
                break;

            case SET_WARNING_TIME:
                border.func_177723_b(this.warningTime);
                break;

            case INITIALIZE:
                border.func_177739_c(this.centerX, this.centerZ);

                if (this.timeUntilTarget > 0L)
                {
                    border.func_177738_a(this.diameter, this.targetSize, this.timeUntilTarget);
                }
                else
                {
                    border.func_177750_a(this.targetSize);
                }

                border.setSize(this.size);
                border.func_177747_c(this.warningDistance);
                border.func_177723_b(this.warningTime);
        }
    }

    public static enum Action
    {
        SET_SIZE,
        LERP_SIZE,
        SET_CENTER,
        INITIALIZE,
        SET_WARNING_TIME,
        SET_WARNING_BLOCKS;
    }
}
