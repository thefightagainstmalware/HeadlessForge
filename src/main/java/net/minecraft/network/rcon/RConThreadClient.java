package net.minecraft.network.rcon;

import java.io.ByteArrayOutputStream;
import java.net.Socket;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.io.BufferedInputStream;
import org.apache.logging.log4j.Logger;
import java.net.SocketTimeoutException;
import org.apache.logging.log4j.LogManager;
import java.io.IOException;
import java.io.DataOutputStream;

/**
 *
 */
public class RConThreadClient extends RConThreadBase {

    /**
     *
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * True if the client has succefssfully logged into the RCon, otherwise false
     */
    private boolean loggedIn;

    /**
     * The client's Socket connection
     */
    private java.net.Socket clientSocket;

    /**
     * A buffer for incoming Socket data
     */
    private byte[] buffer;

    /**
     * The RCon password
     */
    private java.lang.String rconPassword;

    /**
     *
     */
    RConThreadClient(IServer p_i1537_1_,
                     java.net.Socket socket) {
        super(p_i1537_1_, "RCON Client: " + socket.getInetAddress());
    }

    /**
     *
     */
    public void run() {
        return;
    }

    /**
     * Sends the given response message to the client
     * @throws java.io.IOException
     */
    private void sendResponse(int p_72654_1_,
                              int p_72654_2_,
                              String message)
                       throws java.io.IOException {
        return;
    }

    /**
     * Sends the standard RCon 'authorization failed' response packet
     * @throws java.io.IOException
     */
    private void sendLoginFailedResponse()
                                  throws java.io.IOException {
        return;
    }

    /**
     * Splits the response message into individual packets and sends each one
     * @throws java.io.IOException
     */
    private void sendMultipacketResponse(int p_72655_1_,
                                         String p_72655_2_)
                                  throws java.io.IOException {
        return;
    }

    /**
     * Closes the client socket
     */
    private void closeSocket() {
        return;
    }

}