package net.minecraft.util;

import java.util.List;
import net.minecraft.network.PacketBuffer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.buffer.Unpooled;

/**
 *
 */
public class MessageDeserializer2 extends ByteToMessageDecoder {

    /**
     *
     */
    public MessageDeserializer2() {
        
    }

    /**
     * 
     * @throws java.lang.Exception
     */
    protected void decode(ChannelHandlerContext p_decode_1_,
                          ByteBuf p_decode_2_,
                          java.util.List<Object> p_decode_3_)
                   throws Exception {
        return;
    }

}