package net.minecraft.util;

import net.minecraft.network.EnumPacketDirection;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

/**
 *
 */
public class MessageSerializer2 extends MessageSerializer {

    /**
     *
     */
    public MessageSerializer2() {
        super(EnumPacketDirection.SERVERBOUND);
    }

    /**
     * 
     * @throws java.lang.Exception
     */
    protected void encode(ChannelHandlerContext p_encode_1_,
                          ByteBuf p_encode_2_,
                          ByteBuf p_encode_3_)
                   throws Exception {
        return;
    }

}