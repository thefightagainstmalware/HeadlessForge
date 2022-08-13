package net.minecraft.crash;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class CrashReport extends Object {

    /**
     *
     */
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     * Description of the crash report.
     */
    private final java.lang.String description;

    /**
     * The Throwable that is the "cause" for this crash and Crash Report.
     */
    private final java.lang.Throwable cause;

    /**
     * Category of crash
     */
    private final CrashReportCategory theReportCategory = new CrashReportCategory(this, "System Details");

    /**
     *
     */
    private final java.util.List<CrashReportCategory> crashReportSections = Lists.<CrashReportCategory>newArrayList();

    /**
     * File of crash report.
     */
    private java.io.File crashReportFile;

    /**
     *
     */
    private boolean field_85059_f;

    /**
     *
     */
    private java.lang.StackTraceElement[] stacktrace;

    /**
     *
     */
    public CrashReport(String descriptionIn,
                       Throwable causeThrowable) {
        this.description = descriptionIn;
        this.cause = causeThrowable;
    }

    /**
     * Populates this crash report with initial information about the running server and operating system / java
     * environment
     */
    private void populateEnvironment() {
        return;
    }

    /**
     * Returns the description of the Crash Report.
     */
    public String getDescription() {
        return null;
    }

    /**
     * Returns the Throwable object that is the cause for the crash and Crash Report.
     */
    public Throwable getCrashCause() {
        return null;
    }

    /**
     * Gets the various sections of the crash report into the given StringBuilder
     */
    public void getSectionsInStringBuilder(StringBuilder builder) {
        return;
    }

    /**
     * Gets the stack trace of the Throwable that caused this crash report, or if that fails, the cause .toString().
     */
    public String getCauseStackTraceOrString() {
        return null;
    }

    /**
     * Gets the complete report with headers, stack trace, and different sections as a string.
     */
    public String getCompleteReport() {
        return null;
    }

    /**
     * Gets the file this crash report is saved into.
     */
    public java.io.File getFile() {
        return null;
    }

    /**
     * Saves this CrashReport to the given file and returns a value indicating whether we were successful at doing so.
     */
    public boolean saveToFile(java.io.File toFile) {
        return true;
    }

    /**
     *
     */
    public CrashReportCategory getCategory() {
        return null;
    }

    /**
     * Creates a CrashReportCategory
     */
    public CrashReportCategory makeCategory(String name) {
        return null;
    }

    /**
     * Creates a CrashReportCategory for the given stack trace depth
     */
    public CrashReportCategory makeCategoryDepth(String categoryName,
                                                 int stacktraceLength) {
        return null;
    }

    /**
     * Gets a random witty comment for inclusion in this CrashReport
     */
    private static String getWittyComment() {
        return null;
    }

    /**
     * Creates a crash report for the exception
     */
    public static CrashReport makeCrashReport(Throwable causeIn,
                                              String descriptionIn) {
        return null;
    }

}