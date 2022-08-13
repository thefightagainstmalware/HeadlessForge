package net.minecraft.client.gui.inventory;

import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.inventory.ContainerHorseInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiScreenHorseInventory extends GuiContainer
{
    private static final ResourceLocation horseGuiTextures = new ResourceLocation("textures/gui/container/horse.png");

    /** The player inventory bound to this GUI. */
    private IInventory playerInventory;

    /** The horse inventory bound to this GUI. */
    private IInventory horseInventory;

    /** The EntityHorse whose inventory is currently being accessed. */
    private EntityHorse horseEntity;

    /** The mouse x-position recorded during the last rendered frame. */
    private float mousePosx;

    /** The mouse y-position recorded during the last renderered frame. */
    private float mousePosY;

    public GuiScreenHorseInventory(IInventory playerInv, IInventory horseInv, EntityHorse horse)
    {
        super(new ContainerHorseInventory(playerInv, horseInv, horse, null));
        this.playerInventory = playerInv;
        this.horseInventory = horseInv;
        this.horseEntity = horse;
        this.allowUserInput = false;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items). Args : mouseX, mouseY
     */
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        this.fontRendererObj.drawString(this.horseInventory.getDisplayName().func_150260_c(), 8, 6, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().func_150260_c(), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Args : renderPartialTicks, mouseX, mouseY
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {}

    /**
     * Draws the screen and all the components in it. Args : mouseX, mouseY, renderPartialTicks
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.mousePosx = (float)mouseX;
        this.mousePosY = (float)mouseY;
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
