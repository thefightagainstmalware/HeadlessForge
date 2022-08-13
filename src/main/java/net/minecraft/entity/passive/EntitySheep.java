package net.minecraft.entity.passive;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.inventory.Container;
import net.minecraft.util.BlockPos;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.world.World;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.block.Block;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.item.Item;
import com.google.common.collect.Maps;
import net.minecraft.item.ItemStack;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.entity.IEntityLivingData;

/**
 *
 */
public class EntitySheep extends EntityAnimal {

    /**
     * Internal crafting inventory used to check the result of mixing dyes corresponding to the fleece color when
     * breeding sheep.
     */
    private final InventoryCrafting inventoryCrafting = new InventoryCrafting(new Container() {
        public boolean canInteractWith(EntityPlayer var1) {
            return false;
        }
    }, 2, 1);

    /**
     *
     */
    private static final java.util.Map<EnumDyeColor,float[]> DYE_TO_RGB = Maps.newEnumMap(EnumDyeColor.class);

    /**
     * Used to control movement as well as wool regrowth. Set to 40 on handleHealthUpdate and counts down with each
     * tick.
     */
    private int sheepTimer;

    /**
     *
     */
    private EntityAIEatGrass entityAIEatGrass;

    /**
     *
     */
    public EntitySheep(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    public static float[] func_175513_a(EnumDyeColor dyeColor) {
        return null;
    }

    /**
     *
     */
    @Override
    protected void updateAITasks() {
        return;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    @Override
    public void onLivingUpdate() {
        return;
    }

    /**
     *
     */
    @Override
    protected void applyEntityAttributes() {
        return;
    }

    /**
     *
     */
    @Override
    protected void entityInit() {
        return;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    @Override
    protected void dropFewItems(boolean p_70628_1_,
                                int p_70628_2_) {
        return;
    }

    /**
     *
     */
    @Override
    protected Item getDropItem() {
        return null;
    }

    /**
     *
     */
    @Override
    public void handleStatusUpdate(byte id) {
        return;
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    @Override
    public boolean interact(EntityPlayer player) {
        return true;
    }

    /**
     *
     */
    public float getHeadRotationPointY(float p_70894_1_) {
        return 0;
    }

    /**
     *
     */
    public float getHeadRotationAngleX(float p_70890_1_) {
        return 0;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        return;
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        return;
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    @Override
    protected String getLivingSound() {
        return null;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
    protected String getHurtSound() {
        return null;
    }

    /**
     * Returns the sound this mob makes on death.
     */
    @Override
    protected String getDeathSound() {
        return null;
    }

    /**
     *
     */
    @Override
    protected void playStepSound(BlockPos pos,
                                 Block blockIn) {
        return;
    }

    /**
     * Gets the wool color of this sheep.
     */
    public EnumDyeColor getFleeceColor() {
        return null;
    }

    /**
     * Sets the wool color of this sheep
     */
    public void setFleeceColor(EnumDyeColor color) {
        return;
    }

    /**
     * returns true if a sheeps wool has been sheared
     */
    public boolean getSheared() {
        return true;
    }

    /**
     * make a sheep sheared if set to true
     */
    public void setSheared(boolean sheared) {
        return;
    }

    /**
     * Chooses a "vanilla" sheep color based on the provided random.
     */
    public static EnumDyeColor getRandomSheepColor(java.util.Random random) {
        return null;
    }

    /**
     *
     */
    public EntitySheep createChild(EntityAgeable ageable) {
        return null;
    }

    /**
     * This function applies the benefits of growing back wool and faster growing up to the acting entity. (This
     * function is used in the AIEatGrass)
     */
    @Override
    public void eatGrassBonus() {
        return;
    }

    /**
     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
     */
    @Override
    public IEntityLivingData func_180482_a(DifficultyInstance difficulty,
                                           IEntityLivingData livingdata) {
        return null;
    }

    /**
     * Attempts to mix both parent sheep to come up with a mixed dye color.
     */
    private EnumDyeColor getDyeColorMixFromParents(EntityAnimal father,
                                                   EntityAnimal mother) {
        return null;
    }

    /**
     *
     */
    @Override
    public float getEyeHeight() {
        return 0;
    }

    /**
     * Checks if the object is currently shearable
     * Example: Sheep return false when they have no wool
     * @param item The itemstack that is being used, Possible to be null
     * @param world The current world
     * @param pos Block's position in world.
     * @return If this is shearable, and onSheared should be called.
     */
    public boolean isShearable(ItemStack item,
                               IBlockAccess world,
                               BlockPos pos) {
        return true;
    }

    /**
     * Performs the shear function on this object.
     * This is called for both client, and server.
     * The object should perform all actions related to being sheared,
     * except for dropping of the items, and removal of the block.
     * As those are handled by ItemShears itself.
     * 
     * Returns a list of items that resulted from the shearing process.
     * 
     * For entities, they should trust there internal location information
     * over the values passed into this function.
     * @param item The itemstack that is being used, Possible to be null
     * @param world The current world
     * @param pos If this is a block, the block's position in world.
     * @param fortune The fortune level of the shears being used
     * @return A ArrayList containing all items from this shearing. Possible to be null.
     */
    public java.util.List<ItemStack> onSheared(ItemStack item,
                                               IBlockAccess world,
                                               BlockPos pos,
                                               int fortune) {
        return null;
    }

}