package net.minecraft.network;

import net.minecraft.util.IThreadListener;

/**
 *
 */
public class PacketThreadUtil extends Object {

    /**
     *
     */
    public PacketThreadUtil() {
        
    }

    /**
     * 
     * @throws ThreadQuickExitException
     */
    public static <T extends INetHandler> void checkThreadAndEnqueue(Packet<T> p_180031_0_,
                                                                     T p_180031_1_,
                                                                     IThreadListener p_180031_2_)
                                                              throws ThreadQuickExitException {
    }

}