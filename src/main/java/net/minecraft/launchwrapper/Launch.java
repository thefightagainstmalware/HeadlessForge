/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  joptsimple.ArgumentAcceptingOptionSpec
 *  joptsimple.NonOptionArgumentSpec
 *  joptsimple.OptionParser
 *  joptsimple.OptionSet
 *  joptsimple.OptionSpec
 *  org.apache.logging.log4j.Level
 */
package net.minecraft.launchwrapper;

import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;

import java.io.File;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Launch {
    private static final String DEFAULT_TWEAK = "net.minecraft.launchwrapper.VanillaTweaker";
    public static File minecraftHome;
    public static File assetsDir;
    public static Map<String, Object> blackboard;
    public static LaunchClassLoader classLoader;

    public static void main(String[] args) {
        new Launch();
    }

    private Launch() {
        Minecraft mc = Minecraft.func_71410_x();
        URLClassLoader ucl = (URLClassLoader)this.getClass().getClassLoader();
        classLoader = new LaunchClassLoader(ucl.getURLs());
        blackboard = new HashMap<String, Object>();
        ArrayList<String> argumentList = Lists.newArrayList();
        argumentList.add("--uuid");
        argumentList.add(mc.func_110432_I().func_148255_b());
        argumentList.add("--userproperties");
        argumentList.add("{}");
        argumentList.add("--height");
        argumentList.add("480");
        argumentList.add("--assetIndex");
        argumentList.add("1.8");
        argumentList.add("--accessToken");
        argumentList.add(mc.func_110432_I().func_148254_d());
        blackboard.put("ArgumentList", argumentList);
        blackboard.put("fml.deobfuscatedEnvironment", Boolean.FALSE);
        Thread.currentThread().setContextClassLoader(classLoader);
    }

    private void launch(String[] args) {

    }
}

