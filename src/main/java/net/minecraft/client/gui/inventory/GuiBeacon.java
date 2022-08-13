package net.minecraft.client.gui.inventory;

import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerBeacon;
import net.minecraft.inventory.IInventory;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GuiBeacon extends GuiContainer
{
    private static final Logger logger = LogManager.getLogger();
    private static final ResourceLocation beaconGuiTextures = new ResourceLocation("textures/gui/container/beacon.png");
    private IInventory tileBeacon;
    private GuiBeacon.ConfirmButton beaconConfirmButton;
    private boolean buttonsNotDrawn;

    public GuiBeacon(InventoryPlayer playerInventory, IInventory tileBeaconIn)
    {
        super(new ContainerBeacon(playerInventory, tileBeaconIn));
        this.tileBeacon = tileBeaconIn;
        this.xSize = 230;
        this.ySize = 219;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    public void initGui()
    {
        super.initGui();
        this.buttonList.add(this.beaconConfirmButton = new GuiBeacon.ConfirmButton(-1, this.guiLeft + 164, this.guiTop + 107));
        this.buttonList.add(new GuiBeacon.CancelButton(-2, this.guiLeft + 190, this.guiTop + 107));
        this.buttonsNotDrawn = true;
        this.beaconConfirmButton.enabled = false;
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        super.updateScreen();
        int i = this.tileBeacon.getField(0);
        int j = this.tileBeacon.getField(1);
        int k = this.tileBeacon.getField(2);

        if (this.buttonsNotDrawn && i >= 0)
        {
            this.buttonsNotDrawn = false;

            for (int l = 0; l <= 2; ++l)
            {
                int i1 = TileEntityBeacon.effectsList[l].length;
                int j1 = i1 * 22 + (i1 - 1) * 2;

                for (int k1 = 0; k1 < i1; ++k1)
                {
                    int l1 = TileEntityBeacon.effectsList[l][k1].field_76415_H;
                    GuiBeacon.PowerButton guibeacon$powerbutton = new GuiBeacon.PowerButton(l << 8 | l1, this.guiLeft + 76 + k1 * 24 - j1 / 2, this.guiTop + 22 + l * 25, l1, l);
                    this.buttonList.add(guibeacon$powerbutton);

                    if (l >= i)
                    {
                        guibeacon$powerbutton.enabled = false;
                    }
                    else if (l1 == j)
                    {
                        guibeacon$powerbutton.func_146140_b(true);
                    }
                }
            }

            int i2 = 3;
            int j2 = TileEntityBeacon.effectsList[i2].length + 1;
            int k2 = j2 * 22 + (j2 - 1) * 2;

            for (int l2 = 0; l2 < j2 - 1; ++l2)
            {
                int i3 = TileEntityBeacon.effectsList[i2][l2].field_76415_H;
                GuiBeacon.PowerButton guibeacon$powerbutton2 = new GuiBeacon.PowerButton(i2 << 8 | i3, this.guiLeft + 167 + l2 * 24 - k2 / 2, this.guiTop + 47, i3, i2);
                this.buttonList.add(guibeacon$powerbutton2);

                if (i2 >= i)
                {
                    guibeacon$powerbutton2.enabled = false;
                }
                else if (i3 == k)
                {
                    guibeacon$powerbutton2.func_146140_b(true);
                }
            }

            if (j > 0)
            {
                GuiBeacon.PowerButton guibeacon$powerbutton1 = new GuiBeacon.PowerButton(i2 << 8 | j, this.guiLeft + 167 + (j2 - 1) * 24 - k2 / 2, this.guiTop + 47, j, i2);
                this.buttonList.add(guibeacon$powerbutton1);

                if (i2 >= i)
                {
                    guibeacon$powerbutton1.enabled = false;
                }
                else if (j == k)
                {
                    guibeacon$powerbutton1.func_146140_b(true);
                }
            }
        }

        this.beaconConfirmButton.enabled = this.tileBeacon.getStackInSlot(0) != null && j > 0;
    }

    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
    protected void actionPerformed(GuiButton button) throws IOException {}

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items). Args : mouseX, mouseY
     */
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        RenderHelper.disableStandardItemLighting();
        this.drawCenteredString(this.fontRendererObj, I18n.format("tile.beacon.primary", new Object[0]), 62, 10, 14737632);
        this.drawCenteredString(this.fontRendererObj, I18n.format("tile.beacon.secondary", new Object[0]), 169, 10, 14737632);

        for (GuiButton guibutton : this.buttonList)
        {
            if (guibutton.isMouseOver())
            {
                guibutton.drawButtonForegroundLayer(mouseX - this.guiLeft, mouseY - this.guiTop);
                break;
            }
        }

        RenderHelper.enableGUIStandardItemLighting();
    }

    /**
     * Args : renderPartialTicks, mouseX, mouseY
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {}

    static class Button extends GuiButton
    {
        private final ResourceLocation field_146145_o;
        private final int field_146144_p;
        private final int field_146143_q;
        private boolean field_146142_r;

        protected Button(int p_i1077_1_, int p_i1077_2_, int p_i1077_3_, ResourceLocation p_i1077_4_, int p_i1077_5_, int p_i1077_6_)
        {
            super(p_i1077_1_, p_i1077_2_, p_i1077_3_, 22, 22, "");
            this.field_146145_o = p_i1077_4_;
            this.field_146144_p = p_i1077_5_;
            this.field_146143_q = p_i1077_6_;
        }

        public void drawButton(Minecraft mc, int mouseX, int mouseY) {}

        public boolean func_146141_c()
        {
            return this.field_146142_r;
        }

        public void func_146140_b(boolean p_146140_1_)
        {
            this.field_146142_r = p_146140_1_;
        }
    }

    class CancelButton extends GuiBeacon.Button
    {
        public CancelButton(int p_i1074_2_, int p_i1074_3_, int p_i1074_4_)
        {
            super(p_i1074_2_, p_i1074_3_, p_i1074_4_, GuiBeacon.beaconGuiTextures, 112, 220);
        }

        public void drawButtonForegroundLayer(int mouseX, int mouseY)
        {
            GuiBeacon.this.drawCreativeTabHoveringText(I18n.format("gui.cancel", new Object[0]), mouseX, mouseY);
        }
    }

    class ConfirmButton extends GuiBeacon.Button
    {
        public ConfirmButton(int p_i1075_2_, int p_i1075_3_, int p_i1075_4_)
        {
            super(p_i1075_2_, p_i1075_3_, p_i1075_4_, GuiBeacon.beaconGuiTextures, 90, 220);
        }

        public void drawButtonForegroundLayer(int mouseX, int mouseY)
        {
            GuiBeacon.this.drawCreativeTabHoveringText(I18n.format("gui.done", new Object[0]), mouseX, mouseY);
        }
    }

    class PowerButton extends GuiBeacon.Button
    {
        private final int field_146149_p;
        private final int field_146148_q;

        public PowerButton(int p_i1076_2_, int p_i1076_3_, int p_i1076_4_, int p_i1076_5_, int p_i1076_6_)
        {
            super(p_i1076_2_, p_i1076_3_, p_i1076_4_, GuiContainer.inventoryBackground, 0 + Potion.field_76425_a[p_i1076_5_].getStatusIconIndex() % 8 * 18, 198 + Potion.field_76425_a[p_i1076_5_].getStatusIconIndex() / 8 * 18);
            this.field_146149_p = p_i1076_5_;
            this.field_146148_q = p_i1076_6_;
        }

        public void drawButtonForegroundLayer(int mouseX, int mouseY)
        {
            String s = I18n.format(Potion.field_76425_a[this.field_146149_p].func_76393_a(), new Object[0]);

            if (this.field_146148_q >= 3 && this.field_146149_p != Potion.regeneration.field_76415_H)
            {
                s = s + " II";
            }

            GuiBeacon.this.drawCreativeTabHoveringText(s, mouseX, mouseY);
        }
    }
}
