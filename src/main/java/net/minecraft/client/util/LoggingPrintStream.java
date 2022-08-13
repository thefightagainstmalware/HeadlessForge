package net.minecraft.client.util;

import org.apache.logging.log4j.LogManager;
import java.io.OutputStream;
import org.apache.logging.log4j.Logger;
import java.io.PrintStream;

/**
 *
 */
public class LoggingPrintStream extends java.io.PrintStream {

    /**
     *
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     *
     */
    private final java.lang.String domain;

    /**
     *
     */
    public LoggingPrintStream(String domainIn,
                              java.io.OutputStream outStream) {
        super(outStream);
        this.domain = domainIn;

    }

    /**
     *
     */
    @Override
    public void println(String p_println_1_) {
        return;
    }

    /**
     *
     */
    @Override
    public void println(Object p_println_1_) {
        return;
    }

    /**
     *
     */
    private void logString(String string) {
        return;
    }

}