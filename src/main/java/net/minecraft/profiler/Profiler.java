package net.minecraft.profiler;

import java.util.List;
import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.google.common.collect.Lists;
import java.util.Collections;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 */
public class Profiler extends Object {

    /**
     *
     */
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     *
     */
    private final java.util.List<java.lang.String> sectionList = Lists.newArrayList();

    /**
     *
     */
    private final java.util.List<java.lang.Long> timestampList = Lists.newArrayList();

    /**
     * Flag profiling enabled
     */
    public boolean field_76327_a;

    /**
     * Current profiling section
     */
    private java.lang.String profilingSection;

    /**
     *
     */
    private final java.util.Map<java.lang.String,java.lang.Long> profilingMap = Maps.newHashMap();

    /**
     *
     */
    public Profiler() {
        
    }

    /**
     * Clear profiling.
     */
    public void clearProfiling() {
        return;
    }

    /**
     * Start section
     */
    public void startSection(String name) {
        return;
    }

    /**
     * End section
     */
    public void endSection() {
        return;
    }

    /**
     *
     */
    public java.util.List<Profiler.Result> func_76321_b(String p_76321_1_) {
        return null;
    }

    /**
     * End current section and start a new section
     */
    public void endStartSection(String name) {
        return;
    }

    /**
     *
     */
    public String getNameOfLastSection() {
        return null;
    }

    public static final class Result implements Comparable
    {
        public double field_76332_a;
        public double field_76330_b;
        public String field_76331_c;
        private static final String __OBFID = "CL_00001498";

        public Result(String p_i1554_1_, double p_i1554_2_, double p_i1554_4_)
        {
            this.field_76331_c = p_i1554_1_;
            this.field_76332_a = p_i1554_2_;
            this.field_76330_b = p_i1554_4_;
        }

        public int compareTo(Profiler.Result p_compareTo_1_)
        {
            return p_compareTo_1_.field_76332_a < this.field_76332_a ? -1 : (p_compareTo_1_.field_76332_a > this.field_76332_a ? 1 : p_compareTo_1_.field_76331_c.compareTo(this.field_76331_c));
        }

        public int func_76329_a()
        {
            return (this.field_76331_c.hashCode() & 11184810) + 4473924;
        }

        public int compareTo(Object p_compareTo_1_)
        {
            return this.compareTo((Profiler.Result)p_compareTo_1_);
        }
    }
}