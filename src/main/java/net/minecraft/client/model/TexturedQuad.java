package net.minecraft.client.model;

import net.minecraft.client.renderer.WorldRenderer;

/**
 *
 */
public class TexturedQuad extends Object {

    /**
     *
     */
    public PositionTextureVertex[] vertexPositions;

    /**
     *
     */
    public int nVertices;

    /**
     *
     */
    private boolean invertNormal;

    /**
     *
     */
    public TexturedQuad(PositionTextureVertex[] vertices) {
        
    }

    /**
     *
     */
    public TexturedQuad(PositionTextureVertex[] vertices,
                        int texcoordU1,
                        int texcoordV1,
                        int texcoordU2,
                        int texcoordV2,
                        float textureWidth,
                        float textureHeight) {
        
    }

    /**
     *
     */
    public void flipFace() {
        return;
    }

    /**
     * Draw this primitve. This is typically called only once as the generated drawing instructions are saved by the
     * renderer and reused later.
     */
    public void draw(WorldRenderer renderer,
                     float scale) {
        return;
    }

}