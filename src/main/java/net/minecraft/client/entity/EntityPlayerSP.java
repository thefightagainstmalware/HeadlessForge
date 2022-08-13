package net.minecraft.client.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MovementInput;
import net.minecraft.command.server.CommandBlockLogic;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;

/**
 *
 */
public class EntityPlayerSP extends AbstractClientPlayer {

    /**
     *
     */
    public final NetHandlerPlayClient sendQueue;

    /**
     *
     */
    private final StatFileWriter statWriter;

    /**
     * The last X position which was transmitted to the server, used to determine when the X position changes and needs
     * to be re-trasmitted
     */
    private double lastReportedPosX;

    /**
     * The last Y position which was transmitted to the server, used to determine when the Y position changes and needs
     * to be re-transmitted
     */
    private double lastReportedPosY;

    /**
     * The last Z position which was transmitted to the server, used to determine when the Z position changes and needs
     * to be re-transmitted
     */
    private double lastReportedPosZ;

    /**
     * The last yaw value which was transmitted to the server, used to determine when the yaw changes and needs to be
     * re-transmitted
     */
    private float lastReportedYaw;

    /**
     * The last pitch value which was transmitted to the server, used to determine when the pitch changes and needs to
     * be re-transmitted
     */
    private float lastReportedPitch;

    /**
     * the last sneaking state sent to the server
     */
    private boolean serverSneakState;

    /**
     * the last sprinting state sent to the server
     */
    private boolean serverSprintState;

    /**
     * Reset to 0 every time position is sent to the server, used to send periodic updates every 20 ticks even when the
     * player is not moving.
     */
    private int positionUpdateTicks;

    /**
     *
     */
    private boolean hasValidHealth;

    /**
     *
     */
    private java.lang.String clientBrand;

    /**
     *
     */
    public MovementInput movementInput;

    /**
     *
     */
    protected Minecraft mc;

    /**
     * Used to tell if the player pressed forward twice. If this is at 0 and it's pressed (And they are allowed to
     * sprint, aka enough food on the ground etc) it sets this to 7. If it's pressed and it's greater than 0 enable
     * sprinting.
     */
    protected int sprintToggleTimer;

    /**
     * Ticks left before sprinting is disabled.
     */
    public int sprintingTicksLeft;

    /**
     *
     */
    public float renderArmYaw;

    /**
     *
     */
    public float renderArmPitch;

    /**
     *
     */
    public float prevRenderArmYaw;

    /**
     *
     */
    public float prevRenderArmPitch;

    /**
     *
     */
    private int horseJumpPowerCounter;

    /**
     *
     */
    private float horseJumpPower;

    /**
     * The amount of time an entity has been in a Portal
     */
    public float timeInPortal;

    /**
     * The amount of time an entity has been in a Portal the previous tick
     */
    public float prevTimeInPortal;

    /**
     *
     */
    public EntityPlayerSP(Minecraft mcIn,
                          World worldIn,
                          NetHandlerPlayClient netHandler,
                          StatFileWriter statFile) {
        super(worldIn, netHandler.getGameProfile());
        this.sendQueue = netHandler;
        this.statWriter = statFile;
    }

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean attackEntityFrom(DamageSource source,
                                    float amount) {
        return true;
    }

    /**
     * Heal living entity (param: amount of half-hearts)
     */
    @Override
    public void heal(float healAmount) {
        return;
    }

    /**
     * Called when a player mounts an entity. e.g. mounts a pig, mounts a boat.
     */
    @Override
    public void func_70078_a(Entity entityIn) {
        return;
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        return;
    }

    /**
     * called every tick when the player is on foot. Performs all the things that normally happen during movement.
     */
    public void onUpdateWalkingPlayer() {
        return;
    }

    /**
     * Called when player presses the drop item key
     */
    @Override
    public EntityItem dropOneItem(boolean dropAll) {
        return null;
    }

    /**
     * Joins the passed in entity item with the world. Args: entityItem
     */
    @Override
    public void joinEntityItemWithWorld(EntityItem itemIn) {
        return;
    }

    /**
     * Sends a chat message from the player. Args: chatMessage
     */
    public void sendChatMessage(String message) {
        return;
    }

    /**
     * Swings the item the player is holding.
     */
    @Override
    public void swingItem() {
        return;
    }

    /**
     *
     */
    @Override
    public void respawnPlayer() {
        return;
    }

    /**
     * Deals damage to the entity. If its a EntityPlayer then will take damage from the armor first and then health
     * second with the reduced value. Args: damageAmount
     */
    @Override
    protected void damageEntity(DamageSource damageSrc,
                                float damageAmount) {
        return;
    }

    /**
     * set current crafting inventory back to the 2x2 square
     */
    @Override
    public void closeScreen() {
        return;
    }

    /**
     *
     */
    public void closeScreenAndDropStack() {
        return;
    }

    /**
     * Updates health locally.
     */
    public void setPlayerSPHealth(float health) {
        return;
    }

    /**
     * Adds a value to a statistic field.
     */
    @Override
    public void addStat(StatBase stat,
                        int amount) {
        return;
    }

    /**
     * Sends the player's abilities to the server (if there is one).
     */
    @Override
    public void sendPlayerAbilities() {
        return;
    }

    /**
     * returns true if this is an EntityPlayerSP, or the logged in player.
     */
    @Override
    public boolean isUser() {
        return true;
    }

    /**
     *
     */
    protected void sendHorseJump() {
        return;
    }

    /**
     *
     */
    public void sendHorseInventory() {
        return;
    }

    /**
     *
     */
    public void setClientBrand(String brand) {
        return;
    }

    /**
     *
     */
    public String getClientBrand() {
        return null;
    }

    /**
     *
     */
    public StatFileWriter getStatFileWriter() {
        return null;
    }

    /**
     *
     */
    @Override
    public void addChatComponentMessage(IChatComponent chatComponent) {
        return;
    }

    /**
     *
     */
    private boolean isHeadspaceFree(BlockPos pos,
                                    int height) {
        return true;
    }

    /**
     *
     */
    @Override
    protected boolean pushOutOfBlocks(double x,
                                      double y,
                                      double z) {
        return true;
    }

    /**
     * Returns true if the block at the given BlockPos and the block above it are NOT full cubes.
     */
    private boolean isOpenBlockSpace(BlockPos pos) {
        return true;
    }

    /**
     * Set sprinting switch for Entity.
     */
    @Override
    public void setSprinting(boolean sprinting) {
        return;
    }

    /**
     * Sets the current XP, total XP, and level number.
     */
    public void setXPStats(float currentXP,
                           int maxXP,
                           int level) {
        return;
    }

    /**
     * Send a chat message to the CommandSender
     */
    @Override
    public void func_145747_a(IChatComponent component) {
        return;
    }

    /**
     * Returns <code>true</code> if the CommandSender is allowed to execute the command, <code>false</code> if not
     */
    @Override
    public boolean func_70003_b(int permLevel,
                                String commandName) {
        return true;
    }

    /**
     * Get the position in the world. <b><code>null</code> is not allowed!</b> If you are not an entity in the world, return
     * the coordinates 0, 0, 0
     */
    @Override
    public BlockPos func_180425_c() {
        return null;
    }

    /**
     *
     */
    @Override
    public void playSound(String name,
                          float volume,
                          float pitch) {
        return;
    }

    /**
     * Returns whether the entity is in a server world
     */
    @Override
    public boolean isServerWorld() {
        return true;
    }

    /**
     *
     */
    public boolean isRidingHorse() {
        return true;
    }

    /**
     *
     */
    public float getHorseJumpPower() {
        return 0;
    }

    /**
     *
     */
    @Override
    public void openEditSign(TileEntitySign signTile) {
        return;
    }

    /**
     *
     */
    @Override
    public void openEditCommandBlock(CommandBlockLogic cmdBlockLogic) {
        return;
    }

    /**
     * Displays the GUI for interacting with a book.
     */
    @Override
    public void displayGUIBook(ItemStack bookStack) {
        return;
    }

    /**
     * Displays the GUI for interacting with a chest inventory. Args: chestInventory
     */
    @Override
    public void displayGUIChest(IInventory chestInventory) {
        return;
    }

    /**
     *
     */
    @Override
    public void displayGUIHorse(EntityHorse horse,
                                IInventory horseInventory) {
        return;
    }

    /**
     *
     */
    @Override
    public void displayGui(IInteractionObject guiOwner) {
        return;
    }

    /**
     *
     */
    @Override
    public void displayVillagerTradeGui(IMerchant villager) {
        return;
    }

    /**
     * Called when the player performs a critical hit on the Entity. Args: entity that was hit critically
     */
    @Override
    public void onCriticalHit(Entity entityHit) {
        return;
    }

    /**
     *
     */
    @Override
    public void onEnchantmentCritical(Entity entityHit) {
        return;
    }

    /**
     * Returns if this entity is sneaking.
     */
    @Override
    public boolean isSneaking() {
        return true;
    }

    /**
     *
     */
    @Override
    public void updateEntityActionState() {
        return;
    }

    /**
     *
     */
    protected boolean isCurrentViewEntity() {
        return true;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    @Override
    public void onLivingUpdate() {
        return;
    }

}