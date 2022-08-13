package net.minecraft.world.gen.structure;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 */
public class MapGenStructureIO extends Object {

    /**
     *
     */
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     *
     */
    private static java.util.Map<java.lang.String,java.lang.Class<? extends StructureStart>> startNameToClassMap;

    /**
     *
     */
    private static java.util.Map<java.lang.Class<? extends StructureStart>,java.lang.String> startClassToNameMap;

    /**
     *
     */
    private static java.util.Map<java.lang.String,java.lang.Class<? extends StructureComponent>> componentNameToClassMap;

    /**
     *
     */
    private static java.util.Map<java.lang.Class<? extends StructureComponent>,java.lang.String> componentClassToNameMap;

    /**
     *
     */
    public MapGenStructureIO() {
        
    }

    /**
     *
     */
    public static void registerStructure(Class<? extends StructureStart> startClass,
                                         String structureName) {
        return;
    }

    /**
     *
     */
    public static void registerStructureComponent(Class<? extends StructureComponent> componentClass,
                                                  String componentName) {
        return;
    }

    /**
     *
     */
    public static String getStructureStartName(StructureStart start) {
        return null;
    }

    /**
     *
     */
    public static String getStructureComponentName(StructureComponent component) {
        return null;
    }

    /**
     *
     */
    public static StructureStart getStructureStart(NBTTagCompound tagCompound,
                                                   World worldIn) {
        return null;
    }

    /**
     *
     */
    public static StructureComponent getStructureComponent(NBTTagCompound tagCompound,
                                                           World worldIn) {
        return null;
    }

}