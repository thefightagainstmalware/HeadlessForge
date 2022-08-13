package net.minecraft.crash;

import java.util.ArrayList;

import net.minecraft.util.BlockPos;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

/**
 *
 */
public class CrashReportCategory extends Object {

    /**
     *
     */
    private final CrashReport crashReport ;

    /**
     *
     */
    private final java.lang.String name;

    /**
     *
     */
    private final java.util.List<CrashReportCategory.Entry> children = new ArrayList<>();

    /**
     *
     */
    private java.lang.StackTraceElement[] stackTrace;

    /**
     *
     */
    public CrashReportCategory(CrashReport report,
                               String name) {
        this.crashReport = report;
        this.name = name;
    }

    /**
     *
     */
    public static String getCoordinateInfo(double x,
                                                     double y,
                                                     double z) {
        return null;
    }

    /**
     *
     */
    public static String getCoordinateInfo(BlockPos pos) {
        return null;
    }

    /**
     * Adds a Crashreport section with the given name with the value set to the result of the given Callable;
     */
    public void addCrashSectionCallable(String sectionName,
                                        java.util.concurrent.Callable<String> callable) {
        return;
    }

    /**
     * Adds a Crashreport section with the given name with the given value (convered .toString())
     */
    public void addCrashSection(String sectionName,
                                Object value) {
        return;
    }

    /**
     * Adds a Crashreport section with the given name with the given Throwable
     */
    public void addCrashSectionThrowable(String sectionName,
                                         Throwable throwable) {
        return;
    }

    /**
     * Resets our stack trace according to the current trace, pruning the deepest 3 entries.  The parameter indicates
     * how many additional deepest entries to prune.  Returns the number of entries in the resulting pruned stack trace.
     */
    public int getPrunedStackTrace(int size) {
        return 0;
    }

    /**
     * Do the deepest two elements of our saved stack trace match the given elements, in order from the deepest?
     */
    public boolean firstTwoElementsOfStackTraceMatch(StackTraceElement s1,
                                                     StackTraceElement s2) {
        return true;
    }

    /**
     * Removes the given number entries from the bottom of the stack trace.
     */
    public void trimStackTraceEntriesFromBottom(int amount) {
        return;
    }

    /**
     *
     */
    public void appendToStringBuilder(StringBuilder builder) {
        return;
    }

    /**
     *
     */
    public StackTraceElement[] getStackTrace() {
        return null;
    }

    /**
     *
     */
    public static void addBlockInfo(CrashReportCategory category,
                                    BlockPos pos,
                                    Block blockIn,
                                    int blockData) {
        return;
    }

    /**
     *
     */
    public static void addBlockInfo(CrashReportCategory category,
                                    BlockPos pos,
                                    IBlockState state) {
        return;
    }

    public class Entry {
    }
}