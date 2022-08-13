package net.minecraft.client.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

/**
 *
 */
public class ItemRenderer extends Object {

    /**
     *
     */
    private static final ResourceLocation RES_MAP_BACKGROUND = new ResourceLocation("textures/map/background.png");

    /**
     *
     */
    private static final ResourceLocation RES_UNDERWATER_OVERLAY = new ResourceLocation("textures/misc/underwater.png");

    /**
     * A reference to the Minecraft object.
     */
    private final Minecraft mc;

    /**
     *
     */
    private ItemStack itemToRender;

    /**
     * How far the current item has been equipped (0 disequipped and 1 fully up)
     */
    private float equippedProgress;

    /**
     *
     */
    private float prevEquippedProgress;

    /**
     *
     */
    private final RenderManager renderManager = null;

    /**
     *
     */
    private final RenderItem itemRenderer = null;

    /**
     * The index of the currently held item (0-8, or -1 if not yet updated)
     */
    private int equippedItemSlot;

    /**
     *
     */
    public ItemRenderer(Minecraft mcIn) {
        this.mc = mcIn;
    }

    /**
     *
     */
    public void renderItem(EntityLivingBase entityIn,
                           ItemStack heldStack,
                           ItemCameraTransforms.TransformType transform) {
        return;
    }

    /**
     * Returns true if given block is translucent
     */
    private boolean isBlockTranslucent(Block blockIn) {
        return true;
    }

    /**
     *
     */
    private void func_178101_a(float angle,
                               float p_178101_2_) {
        return;
    }

    /**
     *
     */
    private void func_178109_a(AbstractClientPlayer clientPlayer) {
        return;
    }

    /**
     *
     */
    private void func_178110_a(EntityPlayerSP entityplayerspIn,
                               float partialTicks) {
        return;
    }

    /**
     *
     */
    private float func_178100_c(float p_178100_1_) {
        return 0;
    }

    /**
     *
     */
    private void renderRightArm(RenderPlayer renderPlayerIn) {
        return;
    }

    /**
     *
     */
    private void renderLeftArm(RenderPlayer renderPlayerIn) {
        return;
    }

    /**
     *
     */
    private void renderPlayerArms(AbstractClientPlayer clientPlayer) {
        return;
    }

    /**
     *
     */
    private void renderItemMap(AbstractClientPlayer clientPlayer,
                               float p_178097_2_,
                               float p_178097_3_,
                               float p_178097_4_) {
        return;
    }

    /**
     *
     */
    private void func_178095_a(AbstractClientPlayer clientPlayer,
                               float p_178095_2_,
                               float p_178095_3_) {
        return;
    }

    /**
     *
     */
    private void func_178105_d(float p_178105_1_) {
        return;
    }

    /**
     *
     */
    private void func_178104_a(AbstractClientPlayer clientPlayer,
                               float p_178104_2_) {
        return;
    }

    /**
     * Performs transformations prior to the rendering of a held item in first person.
     */
    private void transformFirstPersonItem(float equipProgress,
                                          float swingProgress) {
        return;
    }

    /**
     *
     */
    private void func_178098_a(float p_178098_1_,
                               AbstractClientPlayer clientPlayer) {
        return;
    }

    /**
     *
     */
    private void func_178103_d() {
        return;
    }

    /**
     * Renders the active item in the player's hand when in first person mode. Args: partialTickTime
     */
    public void renderItemInFirstPerson(float partialTicks) {
        return;
    }

    /**
     * Renders all the overlays that are in first person mode. Args: partialTickTime
     */
    public void renderOverlays(float partialTicks) {
        return;
    }

    /**
     *
     */
    private void func_178108_a(float p_178108_1_,
                               TextureAtlasSprite p_178108_2_) {
        return;
    }

    /**
     * Renders a texture that warps around based on the direction the player is looking. Texture needs to be bound
     * before being called. Used for the water overlay. Args: parialTickTime
     */
    private void renderWaterOverlayTexture(float p_78448_1_) {
        return;
    }

    /**
     * Renders the fire on the screen for first person mode. Arg: partialTickTime
     */
    private void renderFireInFirstPerson(float p_78442_1_) {
        return;
    }

    /**
     *
     */
    public void updateEquippedItem() {
        return;
    }

    /**
     * Resets equippedProgress
     */
    public void resetEquippedProgress() {
        return;
    }

    /**
     * Resets equippedProgress
     */
    public void resetEquippedProgress2() {
        return;
    }

}