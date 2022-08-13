package net.minecraft.client.util;

import net.minecraft.crash.CrashReport;

/**
 *
 */
public class ReportedException extends RuntimeException {

    /**
     * Instance of CrashReport.
     */
    private final CrashReport theReportedExceptionCrashReport;

    /**
     *
     */
    public ReportedException(CrashReport report) {
    	theReportedExceptionCrashReport = report;
    }

    /**
     * Gets the CrashReport wrapped by this exception.
     */
    public CrashReport getCrashReport() {
        return null;
    }

    /**
     *
     */
    @Override
    public Throwable getCause() {
        return null;
    }

    /**
     *
     */
    @Override
    public String getMessage() {
        return null;
    }

}