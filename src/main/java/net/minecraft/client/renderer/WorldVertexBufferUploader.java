package net.minecraft.client.renderer;

import net.minecraft.client.renderer.vertex.VertexFormatElement;

public class WorldVertexBufferUploader
{
    private static final String __OBFID = "CL_00002567";

    public void func_181679_a(WorldRenderer p_181679_1_)
    {

    }

    static final class WorldVertexBufferUploader$1
    {
        static final int[] field_178958_a = new int[VertexFormatElement.EnumUsage.values().length];
        private static final String __OBFID = "CL_00002566";

        static
        {
            try
            {
                field_178958_a[VertexFormatElement.EnumUsage.POSITION.ordinal()] = 1;
            }
            catch (NoSuchFieldError var4)
            {
                ;
            }

            try
            {
                field_178958_a[VertexFormatElement.EnumUsage.UV.ordinal()] = 2;
            }
            catch (NoSuchFieldError var3)
            {
                ;
            }

            try
            {
                field_178958_a[VertexFormatElement.EnumUsage.COLOR.ordinal()] = 3;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                field_178958_a[VertexFormatElement.EnumUsage.NORMAL.ordinal()] = 4;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }
}
