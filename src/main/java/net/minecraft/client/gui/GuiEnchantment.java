package net.minecraft.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.model.ModelBook;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerEnchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IWorldNameable;
import net.minecraft.world.World;

/**
 *
 */
public class GuiEnchantment extends GuiContainer {

    /**
     * The ResourceLocation containing the Enchantment GUI texture location
     */
    private static final ResourceLocation ENCHANTMENT_TABLE_GUI_TEXTURE = new ResourceLocation("textures/gui/container/enchanting_table.png");

    /**
     * The ResourceLocation containing the texture for the Book rendered above the enchantment table
     */
    private static final ResourceLocation ENCHANTMENT_TABLE_BOOK_TEXTURE = new ResourceLocation("textures/entity/enchanting_table_book.png");

    /**
     * The ModelBook instance used for rendering the book on the Enchantment table
     */
    private static final ModelBook MODEL_BOOK = new ModelBook();

    /**
     * The player inventory currently bound to this GuiEnchantment instance.
     */
    private final InventoryPlayer playerInventory;

    /**
     * A Random instance for use with the enchantment gui
     */
    private java.util.Random random;

    /**
     *
     */
    private ContainerEnchantment container;

    /**
     *
     */
    public int field_147073_u;

    /**
     *
     */
    public float field_147071_v;

    /**
     *
     */
    public float field_147069_w;

    /**
     *
     */
    public float field_147082_x;

    /**
     *
     */
    public float field_147081_y;

    /**
     *
     */
    public float field_147080_z;

    /**
     *
     */
    public float field_147076_A;

    /**
     *
     */
    ItemStack field_147077_B;

    /**
     *
     */
    private final IWorldNameable field_175380_I;

    /**
     *
     */
    public GuiEnchantment(InventoryPlayer inventory,
                          World worldIn,
                          IWorldNameable p_i45502_3_) {
        super(new ContainerEnchantment(inventory, worldIn));
        this.field_175380_I = p_i45502_3_;
        this.playerInventory = inventory;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items). Args : mouseX, mouseY
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX,
                                                   int mouseY) {
        return;
    }

    /**
     * Called from the main game loop to update the screen.
     */
    @Override
    public void updateScreen() {
        return;
    }

    /**
     * Called when the mouse is clicked. Args : mouseX, mouseY, clickedButton
     * @throws java.io.IOException
     */
    @Override
    protected void mouseClicked(int mouseX,
                                int mouseY,
                                int mouseButton)
                         throws java.io.IOException {
        return;
    }

    /**
     * Args : renderPartialTicks, mouseX, mouseY
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks,
                                                   int mouseX,
                                                   int mouseY) {
        return;
    }

    /**
     * Draws the screen and all the components in it. Args : mouseX, mouseY, renderPartialTicks
     */
    @Override
    public void drawScreen(int mouseX,
                           int mouseY,
                           float partialTicks) {
        return;
    }

    /**
     *
     */
    public void func_147068_g() {
        return;
    }

}