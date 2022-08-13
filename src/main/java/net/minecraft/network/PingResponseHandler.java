package net.minecraft.network;

import com.google.common.base.Charsets;
import java.net.InetSocketAddress;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.Logger;
import io.netty.buffer.Unpooled;
import org.apache.logging.log4j.LogManager;
import io.netty.channel.ChannelFutureListener;

/**
 *
 */
public class PingResponseHandler extends ChannelInboundHandlerAdapter {

    /**
     *
     */
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     *
     */
    private NetworkSystem networkSystem;

    /**
     *
     */
    public PingResponseHandler(NetworkSystem networkSystemIn) {
        
    }

    /**
     * 
     * @throws java.lang.Exception
     */
    public void channelRead(ChannelHandlerContext p_channelRead_1_,
                            Object p_channelRead_2_)
                     throws Exception {
        return;
    }

    /**
     *
     */
    private void writeAndFlush(ChannelHandlerContext ctx,
                               ByteBuf data) {
        return;
    }

    /**
     *
     */
    private ByteBuf getStringBuffer(String string) {
        return null;
    }

}