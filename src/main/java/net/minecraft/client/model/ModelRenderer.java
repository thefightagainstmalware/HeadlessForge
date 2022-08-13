package net.minecraft.client.model;

/**
 *
 */
public class ModelRenderer extends Object {

    /**
     * The size of the texture file's width in pixels.
     */
    public float textureWidth;

    /**
     * The size of the texture file's height in pixels.
     */
    public float textureHeight;

    /**
     * The X offset into the texture used for displaying this model
     */
    private int textureOffsetX;

    /**
     * The Y offset into the texture used for displaying this model
     */
    private int textureOffsetY;

    /**
     *
     */
    public float rotationPointX;

    /**
     *
     */
    public float rotationPointY;

    /**
     *
     */
    public float rotationPointZ;

    /**
     *
     */
    public float rotateAngleX;

    /**
     *
     */
    public float rotateAngleY;

    /**
     *
     */
    public float rotateAngleZ;

    /**
     *
     */
    private boolean compiled;

    /**
     * The GL display list rendered by the Tessellator for this model
     */
    private int displayList;

    /**
     *
     */
    public boolean mirror;

    /**
     *
     */
    public boolean showModel;

    /**
     * Hides the model.
     */
    public boolean isHidden;

    /**
     *
     */
    public java.util.List<ModelBox> cubeList;

    /**
     *
     */
    public java.util.List<ModelRenderer> childModels;

    /**
     *
     */
    public final java.lang.String boxName;

    /**
     *
     */
    private ModelBase baseModel;

    /**
     *
     */
    public float offsetX;

    /**
     *
     */
    public float offsetY;

    /**
     *
     */
    public float offsetZ;

    /**
     *
     */
    public ModelRenderer(ModelBase model,
                         String boxNameIn) {
        this.boxName = boxNameIn;
        this.baseModel = model;
    }

    /**
     *
     */
    public ModelRenderer(ModelBase model) {
        this(model, "");
    }

    /**
     *
     */
    public ModelRenderer(ModelBase model,
                         int texOffX,
                         int texOffY) {
        this(model, "");
    }

    /**
     * Sets the current box's rotation points and rotation angles to another box.
     */
    public void addChild(ModelRenderer renderer) {
        return;
    }

    /**
     *
     */
    public ModelRenderer setTextureOffset(int x,
                                          int y) {
        return null;
    }

    /**
     *
     */
    public ModelRenderer addBox(String partName,
                                float offX,
                                float offY,
                                float offZ,
                                int width,
                                int height,
                                int depth) {
        return null;
    }

    /**
     *
     */
    public ModelRenderer addBox(float offX,
                                float offY,
                                float offZ,
                                int width,
                                int height,
                                int depth) {
        return null;
    }

    /**
     *
     */
    public ModelRenderer addBox(float p_178769_1_,
                                float p_178769_2_,
                                float p_178769_3_,
                                int p_178769_4_,
                                int p_178769_5_,
                                int p_178769_6_,
                                boolean p_178769_7_) {
        return null;
    }

    /**
     * Creates a textured box. Args: originX, originY, originZ, width, height, depth, scaleFactor.
     */
    public void addBox(float p_78790_1_,
                       float p_78790_2_,
                       float p_78790_3_,
                       int width,
                       int height,
                       int depth,
                       float scaleFactor) {
        return;
    }

    /**
     *
     */
    public void setRotationPoint(float rotationPointXIn,
                                 float rotationPointYIn,
                                 float rotationPointZIn) {
        return;
    }

    /**
     *
     */
    public void render(float p_78785_1_) {
        return;
    }

    /**
     *
     */
    public void renderWithRotation(float p_78791_1_) {
        return;
    }

    /**
     * Allows the changing of Angles after a box has been rendered
     */
    public void postRender(float scale) {
        return;
    }

    /**
     * Compiles a GL display list for this model
     */
    private void compileDisplayList(float scale) {
        return;
    }

    /**
     * Returns the model renderer with the new texture parameters.
     */
    public ModelRenderer setTextureSize(int textureWidthIn,
                                        int textureHeightIn) {
        return null;
    }

}