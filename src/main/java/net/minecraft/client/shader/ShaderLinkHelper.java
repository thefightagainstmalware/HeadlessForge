package net.minecraft.client.shader;

import net.minecraft.client.util.JsonException;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class ShaderLinkHelper extends Object {

    /**
     *
     */
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     *
     */
    private static ShaderLinkHelper staticShaderLinkHelper;

    /**
     *
     */
    public ShaderLinkHelper() {
        
    }

    /**
     *
     */
    public static void setNewStaticShaderLinkHelper() {
        return;
    }

    /**
     *
     */
    public static ShaderLinkHelper getStaticShaderLinkHelper() {
        return null;
    }

    /**
     *
     */
    public void deleteShader(ShaderManager p_148077_1_) {
        return;
    }

    /**
     * 
     * @throws JsonException
     */
    public int createProgram()
                      throws JsonException {
        return 0;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    public void linkProgram(ShaderManager manager)
                     throws java.io.IOException {
        return;
    }

}