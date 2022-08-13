package net.minecraft.entity.player;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.server.CommandBlockLogic;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.event.ClickEvent;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.potion.Potion;
import net.minecraft.scoreboard.IScoreObjectiveCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.FoodStats;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.LockCode;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;

@SuppressWarnings("incomplete-switch")
public abstract class EntityPlayer extends EntityLivingBase
{
    /** Inventory of the player */
    public InventoryPlayer field_71071_by = new InventoryPlayer(this);
    private InventoryEnderChest theInventoryEnderChest = new InventoryEnderChest();

    /**
     * The Container for the player's inventory (which opens when they press E)
     */
    public Container field_71069_bz;

    /** The Container the player has open. */
    public Container openContainer;

    /** The food object of the player, the general hunger logic. */
    protected FoodStats foodStats = new FoodStats();

    /**
     * Used to tell if the player pressed jump twice. If this is at 0 and it's pressed (And they are allowed to fly, as
     * defined in the player's movementInput) it sets this to 7. If it's pressed and it's greater than 0 enable fly.
     */
    protected int flyToggleTimer;
    public float prevCameraYaw;
    public float cameraYaw;

    /**
     * Used by EntityPlayer to prevent too many xp orbs from getting absorbed at once.
     */
    public int xpCooldown;
    public double prevChasingPosX;
    public double prevChasingPosY;
    public double prevChasingPosZ;
    public double chasingPosX;
    public double chasingPosY;
    public double chasingPosZ;

    /** Boolean value indicating weather a player is sleeping or not */
    protected boolean sleeping;

    /** the current location of the player */
    public BlockPos playerLocation;
    private int sleepTimer;
    public float renderOffsetX;
    public float renderOffsetY;
    public float renderOffsetZ;

    /** holds the spawn chunk of the player */
    private BlockPos spawnChunk;

    /**
     * Whether this player's spawn point is forced, preventing execution of bed checks.
     */
    private boolean spawnForced;

    /** Holds the coordinate of the player when enter a minecraft to ride. */
    private BlockPos startMinecartRidingCoordinate;

    /** The player's capabilities. (See class PlayerCapabilities) */
    public PlayerCapabilities field_71075_bZ = new PlayerCapabilities();

    /** The current experience level the player is on. */
    public int field_71068_ca;

    /**
     * The total amount of experience the player has. This also includes the amount of experience within their
     * Experience Bar.
     */
    public int field_71067_cb;

    /**
     * The current amount of experience the player has within their Experience Bar.
     */
    public float experience;
    private int xpSeed;

    /**
     * This is the item that is in use when the player is holding down the useItemButton (e.g., bow, food, sword)
     */
    private ItemStack itemInUse;

    /**
     * This field starts off equal to getMaxItemUseDuration and is decremented on each tick
     */
    private int itemInUseCount;
    protected float speedOnGround = 0.1F;
    protected float speedInAir = 0.02F;
    private int lastXPSound;

    /** The player's unique game profile */
    private final GameProfile gameProfile;
    private boolean hasReducedDebug = false;

    /**
     * An instance of a fishing rod's hook. If this isn't null, the icon image of the fishing rod is slightly different
     */
    public EntityFishHook fishEntity;

    public EntityPlayer(World worldIn, GameProfile gameProfileIn)
    {
        super(worldIn);
        this.entityUniqueID = getUUID(gameProfileIn);
        this.gameProfile = gameProfileIn;
        this.field_71069_bz = new ContainerPlayer(this.field_71071_by, !worldIn.isRemote, this);
        this.openContainer = this.field_71069_bz;
        BlockPos blockpos = worldIn.getSpawnPoint();
        this.func_70012_b((double)blockpos.func_177958_n() + 0.5D, (double)(blockpos.func_177956_o() + 1), (double)blockpos.func_177952_p() + 0.5D, 0.0F, 0.0F);
        this.field_70741_aB = 180.0F;
        this.fireResistance = 20;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.10000000149011612D);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
        this.dataWatcher.addObject(17, Float.valueOf(0.0F));
        this.dataWatcher.addObject(18, Integer.valueOf(0));
        this.dataWatcher.addObject(10, Byte.valueOf((byte)0));
    }

    /**
     * returns the ItemStack containing the itemInUse
     */
    public ItemStack getItemInUse()
    {
        return this.itemInUse;
    }

    /**
     * Returns the item in use count
     */
    public int getItemInUseCount()
    {
        return this.itemInUseCount;
    }

    /**
     * Checks if the entity is currently using an item (e.g., bow, food, sword) by holding down the useItemButton
     */
    public boolean isUsingItem()
    {
        return this.itemInUse != null;
    }

    /**
     * gets the duration for how long the current itemInUse has been in use
     */
    public int getItemInUseDuration()
    {
        return this.isUsingItem() ? this.itemInUse.getMaxItemUseDuration() - this.itemInUseCount : 0;
    }

    public void stopUsingItem()
    {
        if (this.itemInUse != null)
        {
            this.itemInUse.onPlayerStoppedUsing(this.field_70170_p, this, this.itemInUseCount);
        }

        this.clearItemInUse();
    }

    public void clearItemInUse()
    {
        this.itemInUse = null;
        this.itemInUseCount = 0;

        if (!this.field_70170_p.isRemote)
        {
            this.setEating(false);
        }
    }

    public boolean isBlocking()
    {
        return this.isUsingItem() && this.itemInUse.func_77973_b().getItemUseAction(this.itemInUse) == EnumAction.BLOCK;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        this.noClip = this.isSpectator();

        if (this.isSpectator())
        {
            this.onGround = false;
        }

        if (this.itemInUse != null)
        {
            ItemStack itemstack = this.field_71071_by.getCurrentItem();

            if (itemstack == this.itemInUse)
            {
                if (this.itemInUseCount <= 25 && this.itemInUseCount % 4 == 0)
                {
                    this.updateItemUse(itemstack, 5);
                }

                if (--this.itemInUseCount == 0 && !this.field_70170_p.isRemote)
                {
                    this.onItemUseFinish();
                }
            }
            else
            {
                this.clearItemInUse();
            }
        }

        if (this.xpCooldown > 0)
        {
            --this.xpCooldown;
        }

        if (this.isPlayerSleeping())
        {
            ++this.sleepTimer;

            if (this.sleepTimer > 100)
            {
                this.sleepTimer = 100;
            }

            if (!this.field_70170_p.isRemote)
            {
                if (!this.isInBed())
                {
                    this.wakeUpPlayer(true, true, false);
                }
                else if (this.field_70170_p.isDaytime())
                {
                    this.wakeUpPlayer(false, true, true);
                }
            }
        }
        else if (this.sleepTimer > 0)
        {
            ++this.sleepTimer;

            if (this.sleepTimer >= 110)
            {
                this.sleepTimer = 0;
            }
        }

        super.onUpdate();

        if (!this.field_70170_p.isRemote && this.openContainer != null && !this.openContainer.canInteractWith(this))
        {
            this.closeScreen();
            this.openContainer = this.field_71069_bz;
        }

        if (this.isBurning() && this.field_71075_bZ.disableDamage)
        {
            this.extinguish();
        }

        this.prevChasingPosX = this.chasingPosX;
        this.prevChasingPosY = this.chasingPosY;
        this.prevChasingPosZ = this.chasingPosZ;
        double d5 = this.field_70165_t - this.chasingPosX;
        double d0 = this.field_70163_u - this.chasingPosY;
        double d1 = this.field_70161_v - this.chasingPosZ;
        double d2 = 10.0D;

        if (d5 > d2)
        {
            this.prevChasingPosX = this.chasingPosX = this.field_70165_t;
        }

        if (d1 > d2)
        {
            this.prevChasingPosZ = this.chasingPosZ = this.field_70161_v;
        }

        if (d0 > d2)
        {
            this.prevChasingPosY = this.chasingPosY = this.field_70163_u;
        }

        if (d5 < -d2)
        {
            this.prevChasingPosX = this.chasingPosX = this.field_70165_t;
        }

        if (d1 < -d2)
        {
            this.prevChasingPosZ = this.chasingPosZ = this.field_70161_v;
        }

        if (d0 < -d2)
        {
            this.prevChasingPosY = this.chasingPosY = this.field_70163_u;
        }

        this.chasingPosX += d5 * 0.25D;
        this.chasingPosZ += d1 * 0.25D;
        this.chasingPosY += d0 * 0.25D;

        if (this.ridingEntity == null)
        {
            this.startMinecartRidingCoordinate = null;
        }

        if (!this.field_70170_p.isRemote)
        {
            this.foodStats.onUpdate(this);
            this.func_71029_a(StatList.minutesPlayedStat);

            if (this.isEntityAlive())
            {
                this.func_71029_a(StatList.timeSinceDeathStat);
            }
        }

        int i = 29999999;
        double d3 = MathHelper.clamp_double(this.field_70165_t, -2.9999999E7D, 2.9999999E7D);
        double d4 = MathHelper.clamp_double(this.field_70161_v, -2.9999999E7D, 2.9999999E7D);

        if (d3 != this.field_70165_t || d4 != this.field_70161_v)
        {
            this.setPosition(d3, this.field_70163_u, d4);
        }
    }

    /**
     * Return the amount of time this entity should stay in a portal before being transported.
     */
    public int getMaxInPortalTime()
    {
        return this.field_71075_bZ.disableDamage ? 0 : 80;
    }

    protected String getSwimSound()
    {
        return "game.player.swim";
    }

    protected String getSplashSound()
    {
        return "game.player.swim.splash";
    }

    /**
     * Return the amount of cooldown before this entity can use a portal again.
     */
    public int getPortalCooldown()
    {
        return 10;
    }

    public void playSound(String name, float volume, float pitch)
    {
        this.field_70170_p.playSoundToNearExcept(this, name, volume, pitch);
    }

    /**
     * Plays sounds and makes particles for item in use state
     */
    protected void updateItemUse(ItemStack itemStackIn, int p_71010_2_)
    {
        if (itemStackIn.getItemUseAction() == EnumAction.DRINK)
        {
            this.playSound("random.drink", 0.5F, this.field_70170_p.rand.nextFloat() * 0.1F + 0.9F);
        }

        if (itemStackIn.getItemUseAction() == EnumAction.EAT)
        {
            for (int i = 0; i < p_71010_2_; ++i)
            {
                Vec3 vec3 = new Vec3(((double)this.rand.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D);
                vec3 = vec3.rotatePitch(-this.field_70125_A * (float)Math.PI / 180.0F);
                vec3 = vec3.rotateYaw(-this.field_70177_z * (float)Math.PI / 180.0F);
                double d0 = (double)(-this.rand.nextFloat()) * 0.6D - 0.3D;
                Vec3 vec31 = new Vec3(((double)this.rand.nextFloat() - 0.5D) * 0.3D, d0, 0.6D);
                vec31 = vec31.rotatePitch(-this.field_70125_A * (float)Math.PI / 180.0F);
                vec31 = vec31.rotateYaw(-this.field_70177_z * (float)Math.PI / 180.0F);
                vec31 = vec31.addVector(this.field_70165_t, this.field_70163_u + (double)this.getEyeHeight(), this.field_70161_v);

                if (itemStackIn.getHasSubtypes())
                {
                    this.field_70170_p.spawnParticle(EnumParticleTypes.ITEM_CRACK, vec31.field_72450_a, vec31.field_72448_b, vec31.field_72449_c, vec3.field_72450_a, vec3.field_72448_b + 0.05D, vec3.field_72449_c, new int[] {Item.getIdFromItem(itemStackIn.func_77973_b()), itemStackIn.getMetadata()});
                }
                else
                {
                    this.field_70170_p.spawnParticle(EnumParticleTypes.ITEM_CRACK, vec31.field_72450_a, vec31.field_72448_b, vec31.field_72449_c, vec3.field_72450_a, vec3.field_72448_b + 0.05D, vec3.field_72449_c, new int[] {Item.getIdFromItem(itemStackIn.func_77973_b())});
                }
            }

            this.playSound("random.eat", 0.5F + 0.5F * (float)this.rand.nextInt(2), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
        }
    }

    /**
     * Used for when item use count runs out, ie: eating completed
     */
    protected void onItemUseFinish()
    {
        if (this.itemInUse != null)
        {
            this.updateItemUse(this.itemInUse, 16);
            int i = this.itemInUse.field_77994_a;
            ItemStack itemstack = this.itemInUse.onItemUseFinish(this.field_70170_p, this);

            if (itemstack != this.itemInUse || itemstack != null && itemstack.field_77994_a != i)
            {
                this.field_71071_by.mainInventory[this.field_71071_by.currentItem] = itemstack;

                if (itemstack.field_77994_a == 0)
                {
                    this.field_71071_by.mainInventory[this.field_71071_by.currentItem] = null;
                }
            }

            this.clearItemInUse();
        }
    }

    public void handleStatusUpdate(byte id)
    {
        if (id == 9)
        {
            this.onItemUseFinish();
        }
        else if (id == 23)
        {
            this.hasReducedDebug = false;
        }
        else if (id == 22)
        {
            this.hasReducedDebug = true;
        }
        else
        {
            super.handleStatusUpdate(id);
        }
    }

    /**
     * Dead and sleeping entities cannot move
     */
    protected boolean isMovementBlocked()
    {
        return this.getHealth() <= 0.0F || this.isPlayerSleeping();
    }

    /**
     * set current crafting inventory back to the 2x2 square
     */
    protected void closeScreen()
    {
        this.openContainer = this.field_71069_bz;
    }

    /**
     * Handles updating while being ridden by an entity
     */
    public void updateRidden()
    {
        if (!this.field_70170_p.isRemote && this.isSneaking())
        {
            this.func_70078_a((Entity)null);
            this.setSneaking(false);
        }
        else
        {
            double d0 = this.field_70165_t;
            double d1 = this.field_70163_u;
            double d2 = this.field_70161_v;
            float f = this.field_70177_z;
            float f1 = this.field_70125_A;
            super.updateRidden();
            this.prevCameraYaw = this.cameraYaw;
            this.cameraYaw = 0.0F;
            this.addMountedMovementStat(this.field_70165_t - d0, this.field_70163_u - d1, this.field_70161_v - d2);

            if (this.ridingEntity instanceof EntityPig)
            {
                this.field_70125_A = f1;
                this.field_70177_z = f;
                this.renderYawOffset = ((EntityPig)this.ridingEntity).renderYawOffset;
            }
        }
    }

    /**
     * Keeps moving the entity up so it isn't colliding with blocks and other requirements for this entity to be spawned
     * (only actually used on players though its also on Entity)
     */
    public void preparePlayerToSpawn()
    {
        this.setSize(0.6F, 1.8F);
        super.preparePlayerToSpawn();
        this.setHealth(this.getMaxHealth());
        this.deathTime = 0;
    }

    protected void updateEntityActionState()
    {
        super.updateEntityActionState();
        this.updateArmSwingProgress();
        this.rotationYawHead = this.field_70177_z;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        if (this.flyToggleTimer > 0)
        {
            --this.flyToggleTimer;
        }

        if (this.field_70170_p.getDifficulty() == EnumDifficulty.PEACEFUL && this.field_70170_p.func_82736_K().func_82766_b("naturalRegeneration"))
        {
            if (this.getHealth() < this.getMaxHealth() && this.ticksExisted % 20 == 0)
            {
                this.heal(1.0F);
            }

            if (this.foodStats.needFood() && this.ticksExisted % 10 == 0)
            {
                this.foodStats.setFoodLevel(this.foodStats.getFoodLevel() + 1);
            }
        }

        this.field_71071_by.decrementAnimations();
        this.prevCameraYaw = this.cameraYaw;
        super.onLivingUpdate();
        IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);

        if (!this.field_70170_p.isRemote)
        {
            iattributeinstance.setBaseValue((double)this.field_71075_bZ.getWalkSpeed());
        }

        this.jumpMovementFactor = this.speedInAir;

        if (this.isSprinting())
        {
            this.jumpMovementFactor = (float)((double)this.jumpMovementFactor + (double)this.speedInAir * 0.3D);
        }

        this.setAIMoveSpeed((float)iattributeinstance.getAttributeValue());
        float f = MathHelper.func_76133_a(this.motionX * this.motionX + this.motionZ * this.motionZ);
        float f1 = (float)(Math.atan(-this.motionY * 0.20000000298023224D) * 15.0D);

        if (f > 0.1F)
        {
            f = 0.1F;
        }

        if (!this.onGround || this.getHealth() <= 0.0F)
        {
            f = 0.0F;
        }

        if (this.onGround || this.getHealth() <= 0.0F)
        {
            f1 = 0.0F;
        }

        this.cameraYaw += (f - this.cameraYaw) * 0.4F;
        this.cameraPitch += (f1 - this.cameraPitch) * 0.8F;

        if (this.getHealth() > 0.0F && !this.isSpectator())
        {
            AxisAlignedBB axisalignedbb = null;

            if (this.ridingEntity != null && !this.ridingEntity.isDead)
            {
                axisalignedbb = this.getEntityBoundingBox().union(this.ridingEntity.getEntityBoundingBox()).expand(1.0D, 0.0D, 1.0D);
            }
            else
            {
                axisalignedbb = this.getEntityBoundingBox().expand(1.0D, 0.5D, 1.0D);
            }

            List<Entity> list = this.field_70170_p.getEntitiesWithinAABBExcludingEntity(this, axisalignedbb);

            for (int i = 0; i < list.size(); ++i)
            {
                Entity entity = (Entity)list.get(i);

                if (!entity.isDead)
                {
                    this.collideWithPlayer(entity);
                }
            }
        }
    }

    private void collideWithPlayer(Entity p_71044_1_)
    {
        p_71044_1_.onCollideWithPlayer(this);
    }

    public int getScore()
    {
        return this.dataWatcher.getWatchableObjectInt(18);
    }

    /**
     * Set player's score
     */
    public void setScore(int p_85040_1_)
    {
        this.dataWatcher.updateObject(18, Integer.valueOf(p_85040_1_));
    }

    /**
     * Add to player's score
     */
    public void addScore(int p_85039_1_)
    {
        int i = this.getScore();
        this.dataWatcher.updateObject(18, Integer.valueOf(i + p_85039_1_));
    }

    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource cause)
    {
        super.onDeath(cause);
        this.setSize(0.2F, 0.2F);
        this.setPosition(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.motionY = 0.10000000149011612D;

        if (this.func_70005_c_().equals("Notch"))
        {
            this.dropItem(new ItemStack(Items.apple, 1), true, false);
        }

        if (!this.field_70170_p.func_82736_K().func_82766_b("keepInventory"))
        {
            this.field_71071_by.dropAllItems();
        }

        if (cause != null)
        {
            this.motionX = (double)(-MathHelper.cos((this.attackedAtYaw + this.field_70177_z) * (float)Math.PI / 180.0F) * 0.1F);
            this.motionZ = (double)(-MathHelper.sin((this.attackedAtYaw + this.field_70177_z) * (float)Math.PI / 180.0F) * 0.1F);
        }
        else
        {
            this.motionX = this.motionZ = 0.0D;
        }

        this.func_71029_a(StatList.deathsStat);
        this.func_175145_a(StatList.timeSinceDeathStat);
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "game.player.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "game.player.die";
    }

    /**
     * Adds a value to the player score. Currently not actually used and the entity passed in does nothing. Args:
     * entity, scoreToAdd
     */
    public void addToPlayerScore(Entity entityIn, int amount)
    {
        this.addScore(amount);
        Collection<ScoreObjective> collection = this.getWorldScoreboard().getObjectivesFromCriteria(IScoreObjectiveCriteria.totalKillCount);

        if (entityIn instanceof EntityPlayer)
        {
            this.func_71029_a(StatList.playerKillsStat);
            collection.addAll(this.getWorldScoreboard().getObjectivesFromCriteria(IScoreObjectiveCriteria.playerKillCount));
            collection.addAll(this.func_175137_e(entityIn));
        }
        else
        {
            this.func_71029_a(StatList.mobKillsStat);
        }

        for (ScoreObjective scoreobjective : collection)
        {
            Score score = this.getWorldScoreboard().func_96529_a(this.func_70005_c_(), scoreobjective);
            score.func_96648_a();
        }
    }

    private Collection<ScoreObjective> func_175137_e(Entity p_175137_1_)
    {
        ScorePlayerTeam scoreplayerteam = this.getWorldScoreboard().getPlayersTeam(this.func_70005_c_());

        if (scoreplayerteam != null)
        {
            int i = scoreplayerteam.getChatFormat().getColorIndex();

            if (i >= 0 && i < IScoreObjectiveCriteria.field_178793_i.length)
            {
                for (ScoreObjective scoreobjective : this.getWorldScoreboard().getObjectivesFromCriteria(IScoreObjectiveCriteria.field_178793_i[i]))
                {
                    Score score = this.getWorldScoreboard().func_96529_a(p_175137_1_.func_70005_c_(), scoreobjective);
                    score.func_96648_a();
                }
            }
        }

        ScorePlayerTeam scoreplayerteam1 = this.getWorldScoreboard().getPlayersTeam(p_175137_1_.func_70005_c_());

        if (scoreplayerteam1 != null)
        {
            int j = scoreplayerteam1.getChatFormat().getColorIndex();

            if (j >= 0 && j < IScoreObjectiveCriteria.field_178792_h.length)
            {
                return this.getWorldScoreboard().getObjectivesFromCriteria(IScoreObjectiveCriteria.field_178792_h[j]);
            }
        }

        return Lists.<ScoreObjective>newArrayList();
    }

    /**
     * Called when player presses the drop item key
     */
    public EntityItem dropOneItem(boolean dropAll)
    {
        return this.dropItem(this.field_71071_by.decrStackSize(this.field_71071_by.currentItem, dropAll && this.field_71071_by.getCurrentItem() != null ? this.field_71071_by.getCurrentItem().field_77994_a : 1), false, true);
    }

    /**
     * Args: itemstack, flag
     */
    public EntityItem func_71019_a(ItemStack itemStackIn, boolean unused)
    {
        return this.dropItem(itemStackIn, false, false);
    }

    public EntityItem dropItem(ItemStack droppedItem, boolean dropAround, boolean traceItem)
    {
        if (droppedItem == null)
        {
            return null;
        }
        else if (droppedItem.field_77994_a == 0)
        {
            return null;
        }
        else
        {
            double d0 = this.field_70163_u - 0.30000001192092896D + (double)this.getEyeHeight();
            EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t, d0, this.field_70161_v, droppedItem);
            entityitem.setPickupDelay(40);

            if (traceItem)
            {
                entityitem.setThrower(this.func_70005_c_());
            }

            if (dropAround)
            {
                float f = this.rand.nextFloat() * 0.5F;
                float f1 = this.rand.nextFloat() * (float)Math.PI * 2.0F;
                entityitem.motionX = (double)(-MathHelper.sin(f1) * f);
                entityitem.motionZ = (double)(MathHelper.cos(f1) * f);
                entityitem.motionY = 0.20000000298023224D;
            }
            else
            {
                float f2 = 0.3F;
                entityitem.motionX = (double)(-MathHelper.sin(this.field_70177_z / 180.0F * (float)Math.PI) * MathHelper.cos(this.field_70125_A / 180.0F * (float)Math.PI) * f2);
                entityitem.motionZ = (double)(MathHelper.cos(this.field_70177_z / 180.0F * (float)Math.PI) * MathHelper.cos(this.field_70125_A / 180.0F * (float)Math.PI) * f2);
                entityitem.motionY = (double)(-MathHelper.sin(this.field_70125_A / 180.0F * (float)Math.PI) * f2 + 0.1F);
                float f3 = this.rand.nextFloat() * (float)Math.PI * 2.0F;
                f2 = 0.02F * this.rand.nextFloat();
                entityitem.motionX += Math.cos((double)f3) * (double)f2;
                entityitem.motionY += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F);
                entityitem.motionZ += Math.sin((double)f3) * (double)f2;
            }

            this.joinEntityItemWithWorld(entityitem);

            if (traceItem)
            {
                this.func_71029_a(StatList.dropStat);
            }

            return entityitem;
        }
    }

    /**
     * Joins the passed in entity item with the world. Args: entityItem
     */
    protected void joinEntityItemWithWorld(EntityItem itemIn)
    {
        this.field_70170_p.func_72838_d(itemIn);
    }

    /**
     * Block hardness will be further counted in net/minecraft/block/Block.getPlayerRelativeBlockHardness
     */
    public float getToolDigEfficiency(Block p_180471_1_)
    {
        float f = this.field_71071_by.getStrVsBlock(p_180471_1_);

        if (f > 1.0F)
        {
            int i = EnchantmentHelper.getEfficiencyModifier(this);
            ItemStack itemstack = this.field_71071_by.getCurrentItem();

            if (i > 0 && itemstack != null)
            {
                f += (float)(i * i + 1);
            }
        }

        if (this.isPotionActive(Potion.digSpeed))
        {
            f *= 1.0F + (float)(this.getActivePotionEffect(Potion.digSpeed).getAmplifier() + 1) * 0.2F;
        }

        if (this.isPotionActive(Potion.digSlowdown))
        {
            float f1 = 1.0F;

            switch (this.getActivePotionEffect(Potion.digSlowdown).getAmplifier())
            {
                case 0:
                    f1 = 0.3F;
                    break;

                case 1:
                    f1 = 0.09F;
                    break;

                case 2:
                    f1 = 0.0027F;
                    break;

                case 3:
                default:
                    f1 = 8.1E-4F;
            }

            f *= f1;
        }

        if (this.isInsideOfMaterial(Material.water) && !EnchantmentHelper.getAquaAffinityModifier(this))
        {
            f /= 5.0F;
        }

        if (!this.onGround)
        {
            f /= 5.0F;
        }

        return f;
    }

    /**
     * Checks if the player has the ability to harvest a block (checks current inventory item for a tool if necessary)
     */
    public boolean canHarvestBlock(Block blockToHarvest)
    {
        return this.field_71071_by.canHeldItemHarvest(blockToHarvest);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        super.readEntityFromNBT(tagCompund);
        this.entityUniqueID = getUUID(this.gameProfile);
        NBTTagList nbttaglist = tagCompund.getTagList("Inventory", 10);
        this.field_71071_by.readFromNBT(nbttaglist);
        this.field_71071_by.currentItem = tagCompund.getInteger("SelectedItemSlot");
        this.sleeping = tagCompund.getBoolean("Sleeping");
        this.sleepTimer = tagCompund.func_74765_d("SleepTimer");
        this.experience = tagCompund.getFloat("XpP");
        this.field_71068_ca = tagCompund.getInteger("XpLevel");
        this.field_71067_cb = tagCompund.getInteger("XpTotal");
        this.xpSeed = tagCompund.getInteger("XpSeed");

        if (this.xpSeed == 0)
        {
            this.xpSeed = this.rand.nextInt();
        }

        this.setScore(tagCompund.getInteger("Score"));

        if (this.sleeping)
        {
            this.playerLocation = new BlockPos(this);
            this.wakeUpPlayer(true, true, false);
        }

        if (tagCompund.func_150297_b("SpawnX", 99) && tagCompund.func_150297_b("SpawnY", 99) && tagCompund.func_150297_b("SpawnZ", 99))
        {
            this.spawnChunk = new BlockPos(tagCompund.getInteger("SpawnX"), tagCompund.getInteger("SpawnY"), tagCompund.getInteger("SpawnZ"));
            this.spawnForced = tagCompund.getBoolean("SpawnForced");
        }

        this.foodStats.readNBT(tagCompund);
        this.field_71075_bZ.readCapabilitiesFromNBT(tagCompund);

        if (tagCompund.func_150297_b("EnderItems", 9))
        {
            NBTTagList nbttaglist1 = tagCompund.getTagList("EnderItems", 10);
            this.theInventoryEnderChest.loadInventoryFromNBT(nbttaglist1);
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        super.writeEntityToNBT(tagCompound);
        tagCompound.func_74782_a("Inventory", this.field_71071_by.writeToNBT(new NBTTagList()));
        tagCompound.func_74768_a("SelectedItemSlot", this.field_71071_by.currentItem);
        tagCompound.setBoolean("Sleeping", this.sleeping);
        tagCompound.setShort("SleepTimer", (short)this.sleepTimer);
        tagCompound.setFloat("XpP", this.experience);
        tagCompound.func_74768_a("XpLevel", this.field_71068_ca);
        tagCompound.func_74768_a("XpTotal", this.field_71067_cb);
        tagCompound.func_74768_a("XpSeed", this.xpSeed);
        tagCompound.func_74768_a("Score", this.getScore());

        if (this.spawnChunk != null)
        {
            tagCompound.func_74768_a("SpawnX", this.spawnChunk.func_177958_n());
            tagCompound.func_74768_a("SpawnY", this.spawnChunk.func_177956_o());
            tagCompound.func_74768_a("SpawnZ", this.spawnChunk.func_177952_p());
            tagCompound.setBoolean("SpawnForced", this.spawnForced);
        }

        this.foodStats.writeNBT(tagCompound);
        this.field_71075_bZ.writeCapabilitiesToNBT(tagCompound);
        tagCompound.func_74782_a("EnderItems", this.theInventoryEnderChest.saveInventoryToNBT());
        ItemStack itemstack = this.field_71071_by.getCurrentItem();

        if (itemstack != null && itemstack.func_77973_b() != null)
        {
            tagCompound.func_74782_a("SelectedItem", itemstack.writeToNBT(new NBTTagCompound()));
        }
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (this.isEntityInvulnerable(source))
        {
            return false;
        }
        else if (this.field_71075_bZ.disableDamage && !source.canHarmInCreative())
        {
            return false;
        }
        else
        {
            this.entityAge = 0;

            if (this.getHealth() <= 0.0F)
            {
                return false;
            }
            else
            {
                if (this.isPlayerSleeping() && !this.field_70170_p.isRemote)
                {
                    this.wakeUpPlayer(true, true, false);
                }

                if (source.isDifficultyScaled())
                {
                    if (this.field_70170_p.getDifficulty() == EnumDifficulty.PEACEFUL)
                    {
                        amount = 0.0F;
                    }

                    if (this.field_70170_p.getDifficulty() == EnumDifficulty.EASY)
                    {
                        amount = amount / 2.0F + 1.0F;
                    }

                    if (this.field_70170_p.getDifficulty() == EnumDifficulty.HARD)
                    {
                        amount = amount * 3.0F / 2.0F;
                    }
                }

                if (amount == 0.0F)
                {
                    return false;
                }
                else
                {
                    Entity entity = source.getEntity();

                    if (entity instanceof EntityArrow && ((EntityArrow)entity).shootingEntity != null)
                    {
                        entity = ((EntityArrow)entity).shootingEntity;
                    }

                    return super.attackEntityFrom(source, amount);
                }
            }
        }
    }

    public boolean canAttackPlayer(EntityPlayer other)
    {
        Team team = this.func_96124_cp();
        Team team1 = other.func_96124_cp();
        return team == null ? true : (!team.isSameTeam(team1) ? true : team.getAllowFriendlyFire());
    }

    protected void damageArmor(float p_70675_1_)
    {
        this.field_71071_by.damageArmor(p_70675_1_);
    }

    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    public int getTotalArmorValue()
    {
        return this.field_71071_by.getTotalArmorValue();
    }

    /**
     * When searching for vulnerable players, if a player is invisible, the return value of this is the chance of seeing
     * them anyway.
     */
    public float getArmorVisibility()
    {
        int i = 0;

        for (ItemStack itemstack : this.field_71071_by.armorInventory)
        {
            if (itemstack != null)
            {
                ++i;
            }
        }

        return (float)i / (float)this.field_71071_by.armorInventory.length;
    }

    /**
     * Deals damage to the entity. If its a EntityPlayer then will take damage from the armor first and then health
     * second with the reduced value. Args: damageAmount
     */
    protected void damageEntity(DamageSource damageSrc, float damageAmount)
    {
        if (!this.isEntityInvulnerable(damageSrc))
        {
            if (!damageSrc.isUnblockable() && this.isBlocking() && damageAmount > 0.0F)
            {
                damageAmount = (1.0F + damageAmount) * 0.5F;
            }

            damageAmount = this.applyArmorCalculations(damageSrc, damageAmount);
            damageAmount = this.applyPotionDamageCalculations(damageSrc, damageAmount);
            float f = damageAmount;
            damageAmount = Math.max(damageAmount - this.getAbsorptionAmount(), 0.0F);
            this.setAbsorptionAmount(this.getAbsorptionAmount() - (f - damageAmount));

            if (damageAmount != 0.0F)
            {
                this.addExhaustion(damageSrc.getHungerDamage());
                float f1 = this.getHealth();
                this.setHealth(this.getHealth() - damageAmount);
                this.getCombatTracker().trackDamage(damageSrc, f1, damageAmount);

                if (damageAmount < 3.4028235E37F)
                {
                    this.addStat(StatList.damageTakenStat, Math.round(damageAmount * 10.0F));
                }
            }
        }
    }

    public void openEditSign(TileEntitySign signTile)
    {
    }

    public void openEditCommandBlock(CommandBlockLogic cmdBlockLogic)
    {
    }

    public void displayVillagerTradeGui(IMerchant villager)
    {
    }

    /**
     * Displays the GUI for interacting with a chest inventory. Args: chestInventory
     */
    public void displayGUIChest(IInventory chestInventory)
    {
    }

    public void displayGUIHorse(EntityHorse horse, IInventory horseInventory)
    {
    }

    public void displayGui(IInteractionObject guiOwner)
    {
    }

    /**
     * Displays the GUI for interacting with a book.
     */
    public void displayGUIBook(ItemStack bookStack)
    {
    }

    public boolean interactWith(Entity p_70998_1_)
    {
        if (this.isSpectator())
        {
            if (p_70998_1_ instanceof IInventory)
            {
                this.displayGUIChest((IInventory)p_70998_1_);
            }

            return false;
        }
        else
        {
            ItemStack itemstack = this.func_71045_bC();
            ItemStack itemstack1 = itemstack != null ? itemstack.copy() : null;

            if (!p_70998_1_.interactFirst(this))
            {
                if (itemstack != null && p_70998_1_ instanceof EntityLivingBase)
                {
                    if (this.field_71075_bZ.field_75098_d)
                    {
                        itemstack = itemstack1;
                    }

                    if (itemstack.interactWithEntity(this, (EntityLivingBase)p_70998_1_))
                    {
                        if (itemstack.field_77994_a <= 0 && !this.field_71075_bZ.field_75098_d)
                        {
                            this.destroyCurrentEquippedItem();
                        }

                        return true;
                    }
                }

                return false;
            }
            else
            {
                if (itemstack != null && itemstack == this.func_71045_bC())
                {
                    if (itemstack.field_77994_a <= 0 && !this.field_71075_bZ.field_75098_d)
                    {
                        this.destroyCurrentEquippedItem();
                    }
                    else if (itemstack.field_77994_a < itemstack1.field_77994_a && this.field_71075_bZ.field_75098_d)
                    {
                        itemstack.field_77994_a = itemstack1.field_77994_a;
                    }
                }

                return true;
            }
        }
    }

    /**
     * Returns the currently being used item by the player.
     */
    public ItemStack func_71045_bC()
    {
        return this.field_71071_by.getCurrentItem();
    }

    /**
     * Destroys the currently equipped item from the player's inventory.
     */
    public void destroyCurrentEquippedItem()
    {
        this.field_71071_by.func_70299_a(this.field_71071_by.currentItem, (ItemStack)null);
    }

    /**
     * Returns the Y Offset of this entity.
     */
    public double getYOffset()
    {
        return -0.35D;
    }

    /**
     * Attacks for the player the targeted entity with the currently equipped item.  The equipped item has hitEntity
     * called on it. Args: targetEntity
     */
    public void attackTargetEntityWithCurrentItem(Entity targetEntity)
    {
        if (targetEntity.canAttackWithItem())
        {
            if (!targetEntity.hitByEntity(this))
            {
                float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                int i = 0;
                float f1 = 0.0F;

                if (targetEntity instanceof EntityLivingBase)
                {
                    f1 = EnchantmentHelper.func_152377_a(this.getHeldItem(), ((EntityLivingBase)targetEntity).getCreatureAttribute());
                }
                else
                {
                    f1 = EnchantmentHelper.func_152377_a(this.getHeldItem(), EnumCreatureAttribute.UNDEFINED);
                }

                i = i + EnchantmentHelper.getKnockbackModifier(this);

                if (this.isSprinting())
                {
                    ++i;
                }

                if (f > 0.0F || f1 > 0.0F)
                {
                    boolean flag = this.field_70143_R > 0.0F && !this.onGround && !this.isOnLadder() && !this.isInWater() && !this.isPotionActive(Potion.blindness) && this.ridingEntity == null && targetEntity instanceof EntityLivingBase;

                    if (flag && f > 0.0F)
                    {
                        f *= 1.5F;
                    }

                    f = f + f1;
                    boolean flag1 = false;
                    int j = EnchantmentHelper.getFireAspectModifier(this);

                    if (targetEntity instanceof EntityLivingBase && j > 0 && !targetEntity.isBurning())
                    {
                        flag1 = true;
                        targetEntity.setFire(1);
                    }

                    double d0 = targetEntity.motionX;
                    double d1 = targetEntity.motionY;
                    double d2 = targetEntity.motionZ;
                    boolean flag2 = targetEntity.attackEntityFrom(DamageSource.causePlayerDamage(this), f);

                    if (flag2)
                    {
                        if (i > 0)
                        {
                            targetEntity.addVelocity((double)(-MathHelper.sin(this.field_70177_z * (float)Math.PI / 180.0F) * (float)i * 0.5F), 0.1D, (double)(MathHelper.cos(this.field_70177_z * (float)Math.PI / 180.0F) * (float)i * 0.5F));
                            this.motionX *= 0.6D;
                            this.motionZ *= 0.6D;
                            this.setSprinting(false);
                        }

                        if (targetEntity instanceof EntityPlayerMP && targetEntity.velocityChanged)
                        {
                            ((EntityPlayerMP)targetEntity).field_71135_a.func_147359_a(new S12PacketEntityVelocity(targetEntity));
                            targetEntity.velocityChanged = false;
                            targetEntity.motionX = d0;
                            targetEntity.motionY = d1;
                            targetEntity.motionZ = d2;
                        }

                        if (flag)
                        {
                            this.onCriticalHit(targetEntity);
                        }

                        if (f1 > 0.0F)
                        {
                            this.onEnchantmentCritical(targetEntity);
                        }

                        if (f >= 18.0F)
                        {
                            this.func_71029_a(AchievementList.overkill);
                        }

                        this.setLastAttacker(targetEntity);

                        if (targetEntity instanceof EntityLivingBase)
                        {
                            EnchantmentHelper.applyThornEnchantments((EntityLivingBase)targetEntity, this);
                        }

                        EnchantmentHelper.applyArthropodEnchantments(this, targetEntity);
                        ItemStack itemstack = this.func_71045_bC();
                        Entity entity = targetEntity;

                        if (targetEntity instanceof EntityDragonPart)
                        {
                            IEntityMultiPart ientitymultipart = ((EntityDragonPart)targetEntity).entityDragonObj;

                            if (ientitymultipart instanceof EntityLivingBase)
                            {
                                entity = (EntityLivingBase)ientitymultipart;
                            }
                        }

                        if (itemstack != null && entity instanceof EntityLivingBase)
                        {
                            itemstack.hitEntity((EntityLivingBase)entity, this);

                            if (itemstack.field_77994_a <= 0)
                            {
                                this.destroyCurrentEquippedItem();
                            }
                        }

                        if (targetEntity instanceof EntityLivingBase)
                        {
                            this.addStat(StatList.damageDealtStat, Math.round(f * 10.0F));

                            if (j > 0)
                            {
                                targetEntity.setFire(j * 4);
                            }
                        }

                        this.addExhaustion(0.3F);
                    }
                    else if (flag1)
                    {
                        targetEntity.extinguish();
                    }
                }
            }
        }
    }

    /**
     * Called when the player performs a critical hit on the Entity. Args: entity that was hit critically
     */
    public void onCriticalHit(Entity entityHit)
    {
    }

    public void onEnchantmentCritical(Entity entityHit)
    {
    }

    public void respawnPlayer()
    {
    }

    /**
     * Will get destroyed next tick.
     */
    public void setDead()
    {
        super.setDead();
        this.field_71069_bz.onContainerClosed(this);

        if (this.openContainer != null)
        {
            this.openContainer.onContainerClosed(this);
        }
    }

    /**
     * Checks if this entity is inside of an opaque block
     */
    public boolean isEntityInsideOpaqueBlock()
    {
        return !this.sleeping && super.isEntityInsideOpaqueBlock();
    }

    /**
     * returns true if this is an EntityPlayerSP, or the logged in player.
     */
    public boolean isUser()
    {
        return false;
    }

    /**
     * Returns the GameProfile for this player
     */
    public GameProfile getGameProfile()
    {
        return this.gameProfile;
    }

    public EntityPlayer.EnumStatus trySleep(BlockPos bedLocation)
    {
        if (!this.field_70170_p.isRemote)
        {
            if (this.isPlayerSleeping() || !this.isEntityAlive())
            {
                return EntityPlayer.EnumStatus.OTHER_PROBLEM;
            }

            if (!this.field_70170_p.provider.isSurfaceWorld())
            {
                return EntityPlayer.EnumStatus.NOT_POSSIBLE_HERE;
            }

            if (this.field_70170_p.isDaytime())
            {
                return EntityPlayer.EnumStatus.NOT_POSSIBLE_NOW;
            }

            if (Math.abs(this.field_70165_t - (double)bedLocation.func_177958_n()) > 3.0D || Math.abs(this.field_70163_u - (double)bedLocation.func_177956_o()) > 2.0D || Math.abs(this.field_70161_v - (double)bedLocation.func_177952_p()) > 3.0D)
            {
                return EntityPlayer.EnumStatus.TOO_FAR_AWAY;
            }

            double d0 = 8.0D;
            double d1 = 5.0D;
            List<EntityMob> list = this.field_70170_p.<EntityMob>getEntitiesWithinAABB(EntityMob.class, new AxisAlignedBB((double)bedLocation.func_177958_n() - d0, (double)bedLocation.func_177956_o() - d1, (double)bedLocation.func_177952_p() - d0, (double)bedLocation.func_177958_n() + d0, (double)bedLocation.func_177956_o() + d1, (double)bedLocation.func_177952_p() + d0));

            if (!list.isEmpty())
            {
                return EntityPlayer.EnumStatus.NOT_SAFE;
            }
        }

        if (this.isRiding())
        {
            this.func_70078_a((Entity)null);
        }

        this.setSize(0.2F, 0.2F);

        if (this.field_70170_p.func_175667_e(bedLocation))
        {
            EnumFacing enumfacing = (EnumFacing)this.field_70170_p.func_180495_p(bedLocation).getValue(BlockDirectional.FACING);
            float f = 0.5F;
            float f1 = 0.5F;

            switch (enumfacing)
            {
                case SOUTH:
                    f1 = 0.9F;
                    break;

                case NORTH:
                    f1 = 0.1F;
                    break;

                case WEST:
                    f = 0.1F;
                    break;

                case EAST:
                    f = 0.9F;
            }

            this.func_175139_a(enumfacing);
            this.setPosition((double)((float)bedLocation.func_177958_n() + f), (double)((float)bedLocation.func_177956_o() + 0.6875F), (double)((float)bedLocation.func_177952_p() + f1));
        }
        else
        {
            this.setPosition((double)((float)bedLocation.func_177958_n() + 0.5F), (double)((float)bedLocation.func_177956_o() + 0.6875F), (double)((float)bedLocation.func_177952_p() + 0.5F));
        }

        this.sleeping = true;
        this.sleepTimer = 0;
        this.playerLocation = bedLocation;
        this.motionX = this.motionZ = this.motionY = 0.0D;

        if (!this.field_70170_p.isRemote)
        {
            this.field_70170_p.updateAllPlayersSleepingFlag();
        }

        return EntityPlayer.EnumStatus.OK;
    }

    private void func_175139_a(EnumFacing p_175139_1_)
    {
        this.renderOffsetX = 0.0F;
        this.renderOffsetZ = 0.0F;

        switch (p_175139_1_)
        {
            case SOUTH:
                this.renderOffsetZ = -1.8F;
                break;

            case NORTH:
                this.renderOffsetZ = 1.8F;
                break;

            case WEST:
                this.renderOffsetX = 1.8F;
                break;

            case EAST:
                this.renderOffsetX = -1.8F;
        }
    }

    /**
     * Wake up the player if they're sleeping.
     */
    public void wakeUpPlayer(boolean p_70999_1_, boolean updateWorldFlag, boolean setSpawn)
    {
        this.setSize(0.6F, 1.8F);
        IBlockState iblockstate = this.field_70170_p.func_180495_p(this.playerLocation);

        if (this.playerLocation != null && iblockstate.func_177230_c() == Blocks.bed)
        {
            this.field_70170_p.func_180501_a(this.playerLocation, iblockstate.withProperty(BlockBed.OCCUPIED, Boolean.valueOf(false)), 4);
            BlockPos blockpos = BlockBed.getSafeExitLocation(this.field_70170_p, this.playerLocation, 0);

            if (blockpos == null)
            {
                blockpos = this.playerLocation.up();
            }

            this.setPosition((double)((float)blockpos.func_177958_n() + 0.5F), (double)((float)blockpos.func_177956_o() + 0.1F), (double)((float)blockpos.func_177952_p() + 0.5F));
        }

        this.sleeping = false;

        if (!this.field_70170_p.isRemote && updateWorldFlag)
        {
            this.field_70170_p.updateAllPlayersSleepingFlag();
        }

        this.sleepTimer = p_70999_1_ ? 0 : 100;

        if (setSpawn)
        {
            this.func_180473_a(this.playerLocation, false);
        }
    }

    private boolean isInBed()
    {
        return this.field_70170_p.func_180495_p(this.playerLocation).func_177230_c() == Blocks.bed;
    }

    /**
     * Return null if bed is invalid
     */
    public static BlockPos getBedSpawnLocation(World worldIn, BlockPos bedLocation, boolean forceSpawn)
    {
        Block block = worldIn.func_180495_p(bedLocation).func_177230_c();

        if (block != Blocks.bed)
        {
            if (!forceSpawn)
            {
                return null;
            }
            else
            {
                boolean flag = block.func_181623_g();
                boolean flag1 = worldIn.func_180495_p(bedLocation.up()).func_177230_c().func_181623_g();
                return flag && flag1 ? bedLocation : null;
            }
        }
        else
        {
            return BlockBed.getSafeExitLocation(worldIn, bedLocation, 0);
        }
    }

    /**
     * Returns the orientation of the bed in degrees.
     */
    public float getBedOrientationInDegrees()
    {
        if (this.playerLocation != null)
        {
            EnumFacing enumfacing = (EnumFacing)this.field_70170_p.func_180495_p(this.playerLocation).getValue(BlockDirectional.FACING);

            switch (enumfacing)
            {
                case SOUTH:
                    return 90.0F;

                case NORTH:
                    return 270.0F;

                case WEST:
                    return 0.0F;

                case EAST:
                    return 180.0F;
            }
        }

        return 0.0F;
    }

    /**
     * Returns whether player is sleeping or not
     */
    public boolean isPlayerSleeping()
    {
        return this.sleeping;
    }

    /**
     * Returns whether or not the player is asleep and the screen has fully faded.
     */
    public boolean isPlayerFullyAsleep()
    {
        return this.sleeping && this.sleepTimer >= 100;
    }

    public int getSleepTimer()
    {
        return this.sleepTimer;
    }

    public void addChatComponentMessage(IChatComponent chatComponent)
    {
    }

    public BlockPos getBedLocation()
    {
        return this.spawnChunk;
    }

    public boolean isSpawnForced()
    {
        return this.spawnForced;
    }

    public void func_180473_a(BlockPos pos, boolean forced)
    {
        if (pos != null)
        {
            this.spawnChunk = pos;
            this.spawnForced = forced;
        }
        else
        {
            this.spawnChunk = null;
            this.spawnForced = false;
        }
    }

    /**
     * Will trigger the specified trigger.
     */
    public void func_71029_a(StatBase achievementIn)
    {
        this.addStat(achievementIn, 1);
    }

    /**
     * Adds a value to a statistic field.
     */
    public void addStat(StatBase stat, int amount)
    {
    }

    public void func_175145_a(StatBase p_175145_1_)
    {
    }

    /**
     * Causes this entity to do an upwards motion (jumping).
     */
    public void jump()
    {
        super.jump();
        this.func_71029_a(StatList.jumpStat);

        if (this.isSprinting())
        {
            this.addExhaustion(0.8F);
        }
        else
        {
            this.addExhaustion(0.2F);
        }
    }

    /**
     * Moves the entity based on the specified heading.  Args: strafe, forward
     */
    public void moveEntityWithHeading(float strafe, float forward)
    {
        double d0 = this.field_70165_t;
        double d1 = this.field_70163_u;
        double d2 = this.field_70161_v;

        if (this.field_71075_bZ.isFlying && this.ridingEntity == null)
        {
            double d3 = this.motionY;
            float f = this.jumpMovementFactor;
            this.jumpMovementFactor = this.field_71075_bZ.getFlySpeed() * (float)(this.isSprinting() ? 2 : 1);
            super.moveEntityWithHeading(strafe, forward);
            this.motionY = d3 * 0.6D;
            this.jumpMovementFactor = f;
        }
        else
        {
            super.moveEntityWithHeading(strafe, forward);
        }

        this.addMovementStat(this.field_70165_t - d0, this.field_70163_u - d1, this.field_70161_v - d2);
    }

    /**
     * the movespeed used for the new AI system
     */
    public float getAIMoveSpeed()
    {
        return (float)this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue();
    }

    /**
     * Adds a value to a movement statistic field - like run, walk, swin or climb.
     */
    public void addMovementStat(double p_71000_1_, double p_71000_3_, double p_71000_5_)
    {
        if (this.ridingEntity == null)
        {
            if (this.isInsideOfMaterial(Material.water))
            {
                int i = Math.round(MathHelper.func_76133_a(p_71000_1_ * p_71000_1_ + p_71000_3_ * p_71000_3_ + p_71000_5_ * p_71000_5_) * 100.0F);

                if (i > 0)
                {
                    this.addStat(StatList.distanceDoveStat, i);
                    this.addExhaustion(0.015F * (float)i * 0.01F);
                }
            }
            else if (this.isInWater())
            {
                int j = Math.round(MathHelper.func_76133_a(p_71000_1_ * p_71000_1_ + p_71000_5_ * p_71000_5_) * 100.0F);

                if (j > 0)
                {
                    this.addStat(StatList.distanceSwumStat, j);
                    this.addExhaustion(0.015F * (float)j * 0.01F);
                }
            }
            else if (this.isOnLadder())
            {
                if (p_71000_3_ > 0.0D)
                {
                    this.addStat(StatList.distanceClimbedStat, (int)Math.round(p_71000_3_ * 100.0D));
                }
            }
            else if (this.onGround)
            {
                int k = Math.round(MathHelper.func_76133_a(p_71000_1_ * p_71000_1_ + p_71000_5_ * p_71000_5_) * 100.0F);

                if (k > 0)
                {
                    this.addStat(StatList.distanceWalkedStat, k);

                    if (this.isSprinting())
                    {
                        this.addStat(StatList.distanceSprintedStat, k);
                        this.addExhaustion(0.099999994F * (float)k * 0.01F);
                    }
                    else
                    {
                        if (this.isSneaking())
                        {
                            this.addStat(StatList.distanceCrouchedStat, k);
                        }

                        this.addExhaustion(0.01F * (float)k * 0.01F);
                    }
                }
            }
            else
            {
                int l = Math.round(MathHelper.func_76133_a(p_71000_1_ * p_71000_1_ + p_71000_5_ * p_71000_5_) * 100.0F);

                if (l > 25)
                {
                    this.addStat(StatList.distanceFlownStat, l);
                }
            }
        }
    }

    /**
     * Adds a value to a mounted movement statistic field - by minecart, boat, or pig.
     */
    private void addMountedMovementStat(double p_71015_1_, double p_71015_3_, double p_71015_5_)
    {
        if (this.ridingEntity != null)
        {
            int i = Math.round(MathHelper.func_76133_a(p_71015_1_ * p_71015_1_ + p_71015_3_ * p_71015_3_ + p_71015_5_ * p_71015_5_) * 100.0F);

            if (i > 0)
            {
                if (this.ridingEntity instanceof EntityMinecart)
                {
                    this.addStat(StatList.distanceByMinecartStat, i);

                    if (this.startMinecartRidingCoordinate == null)
                    {
                        this.startMinecartRidingCoordinate = new BlockPos(this);
                    }
                    else if (this.startMinecartRidingCoordinate.distanceSq((double)MathHelper.func_76128_c(this.field_70165_t), (double)MathHelper.func_76128_c(this.field_70163_u), (double)MathHelper.func_76128_c(this.field_70161_v)) >= 1000000.0D)
                    {
                        this.func_71029_a(AchievementList.onARail);
                    }
                }
                else if (this.ridingEntity instanceof EntityBoat)
                {
                    this.addStat(StatList.distanceByBoatStat, i);
                }
                else if (this.ridingEntity instanceof EntityPig)
                {
                    this.addStat(StatList.distanceByPigStat, i);
                }
                else if (this.ridingEntity instanceof EntityHorse)
                {
                    this.addStat(StatList.distanceByHorseStat, i);
                }
            }
        }
    }

    public void fall(float distance, float damageMultiplier)
    {
        if (!this.field_71075_bZ.allowFlying)
        {
            if (distance >= 2.0F)
            {
                this.addStat(StatList.distanceFallenStat, (int)Math.round((double)distance * 100.0D));
            }

            super.fall(distance, damageMultiplier);
        }
    }

    /**
     * sets the players height back to normal after doing things like sleeping and dieing
     */
    protected void resetHeight()
    {
        if (!this.isSpectator())
        {
            super.resetHeight();
        }
    }

    protected String getFallSoundString(int damageValue)
    {
        return damageValue > 4 ? "game.player.hurt.fall.big" : "game.player.hurt.fall.small";
    }

    /**
     * This method gets called when the entity kills another one.
     */
    public void onKillEntity(EntityLivingBase entityLivingIn) {}

    /**
     * Sets the Entity inside a web block.
     */
    public void setInWeb()
    {
        if (!this.field_71075_bZ.isFlying)
        {
            super.setInWeb();
        }
    }

    public ItemStack getCurrentArmor(int slotIn)
    {
        return this.field_71071_by.armorItemInSlot(slotIn);
    }

    /**
     * Add experience points to player.
     */
    public void func_71023_q(int amount)
    {
        this.addScore(amount);
        int i = Integer.MAX_VALUE - this.field_71067_cb;

        if (amount > i)
        {
            amount = i;
        }

        this.experience += (float)amount / (float)this.xpBarCap();

        for (this.field_71067_cb += amount; this.experience >= 1.0F; this.experience /= (float)this.xpBarCap())
        {
            this.experience = (this.experience - 1.0F) * (float)this.xpBarCap();
            this.func_82242_a(1);
        }
    }

    public int getXPSeed()
    {
        return this.xpSeed;
    }

    public void removeExperienceLevel(int levels)
    {
        this.field_71068_ca -= levels;

        if (this.field_71068_ca < 0)
        {
            this.field_71068_ca = 0;
            this.experience = 0.0F;
            this.field_71067_cb = 0;
        }

        this.xpSeed = this.rand.nextInt();
    }

    /**
     * Add experience levels to this player.
     */
    public void func_82242_a(int levels)
    {
        this.field_71068_ca += levels;

        if (this.field_71068_ca < 0)
        {
            this.field_71068_ca = 0;
            this.experience = 0.0F;
            this.field_71067_cb = 0;
        }

        if (levels > 0 && this.field_71068_ca % 5 == 0 && (float)this.lastXPSound < (float)this.ticksExisted - 100.0F)
        {
            float f = this.field_71068_ca > 30 ? 1.0F : (float)this.field_71068_ca / 30.0F;
            this.field_70170_p.func_72956_a(this, "random.levelup", f * 0.75F, 1.0F);
            this.lastXPSound = this.ticksExisted;
        }
    }

    /**
     * This method returns the cap amount of experience that the experience bar can hold. With each level, the
     * experience cap on the player's experience bar is raised by 10.
     */
    public int xpBarCap()
    {
        return this.field_71068_ca >= 30 ? 112 + (this.field_71068_ca - 30) * 9 : (this.field_71068_ca >= 15 ? 37 + (this.field_71068_ca - 15) * 5 : 7 + this.field_71068_ca * 2);
    }

    /**
     * increases exhaustion level by supplied amount
     */
    public void addExhaustion(float p_71020_1_)
    {
        if (!this.field_71075_bZ.disableDamage)
        {
            if (!this.field_70170_p.isRemote)
            {
                this.foodStats.addExhaustion(p_71020_1_);
            }
        }
    }

    /**
     * Returns the player's FoodStats object.
     */
    public FoodStats getFoodStats()
    {
        return this.foodStats;
    }

    public boolean canEat(boolean ignoreHunger)
    {
        return (ignoreHunger || this.foodStats.needFood()) && !this.field_71075_bZ.disableDamage;
    }

    /**
     * Checks if the player's health is not full and not zero.
     */
    public boolean shouldHeal()
    {
        return this.getHealth() > 0.0F && this.getHealth() < this.getMaxHealth();
    }

    /**
     * sets the itemInUse when the use item button is clicked. Args: itemstack, int maxItemUseDuration
     */
    public void setItemInUse(ItemStack stack, int duration)
    {
        if (stack != this.itemInUse)
        {
            this.itemInUse = stack;
            this.itemInUseCount = duration;

            if (!this.field_70170_p.isRemote)
            {
                this.setEating(true);
            }
        }
    }

    public boolean isAllowEdit()
    {
        return this.field_71075_bZ.allowEdit;
    }

    public boolean canPlayerEdit(BlockPos p_175151_1_, EnumFacing p_175151_2_, ItemStack p_175151_3_)
    {
        if (this.field_71075_bZ.allowEdit)
        {
            return true;
        }
        else if (p_175151_3_ == null)
        {
            return false;
        }
        else
        {
            BlockPos blockpos = p_175151_1_.offset(p_175151_2_.getOpposite());
            Block block = this.field_70170_p.func_180495_p(blockpos).func_177230_c();
            return p_175151_3_.canPlaceOn(block) || p_175151_3_.canEditBlocks();
        }
    }

    /**
     * Get the experience points the entity currently has.
     */
    protected int getExperiencePoints(EntityPlayer player)
    {
        if (this.field_70170_p.func_82736_K().func_82766_b("keepInventory"))
        {
            return 0;
        }
        else
        {
            int i = this.field_71068_ca * 7;
            return i > 100 ? 100 : i;
        }
    }

    /**
     * Only use is to identify if class is an instance of player for experience dropping
     */
    protected boolean isPlayer()
    {
        return true;
    }

    public boolean getAlwaysRenderNameTagForRender()
    {
        return true;
    }

    /**
     * Copies the values from the given player into this player if boolean par2 is true. Always clones Ender Chest
     * Inventory.
     */
    public void clonePlayer(EntityPlayer oldPlayer, boolean respawnFromEnd)
    {
        if (respawnFromEnd)
        {
            this.field_71071_by.copyInventory(oldPlayer.field_71071_by);
            this.setHealth(oldPlayer.getHealth());
            this.foodStats = oldPlayer.foodStats;
            this.field_71068_ca = oldPlayer.field_71068_ca;
            this.field_71067_cb = oldPlayer.field_71067_cb;
            this.experience = oldPlayer.experience;
            this.setScore(oldPlayer.getScore());
            this.field_181016_an = oldPlayer.field_181016_an;
            this.field_181017_ao = oldPlayer.field_181017_ao;
            this.field_181018_ap = oldPlayer.field_181018_ap;
        }
        else if (this.field_70170_p.func_82736_K().func_82766_b("keepInventory"))
        {
            this.field_71071_by.copyInventory(oldPlayer.field_71071_by);
            this.field_71068_ca = oldPlayer.field_71068_ca;
            this.field_71067_cb = oldPlayer.field_71067_cb;
            this.experience = oldPlayer.experience;
            this.setScore(oldPlayer.getScore());
        }

        this.xpSeed = oldPlayer.xpSeed;
        this.theInventoryEnderChest = oldPlayer.theInventoryEnderChest;
        this.getDataWatcher().updateObject(10, Byte.valueOf(oldPlayer.getDataWatcher().getWatchableObjectByte(10)));
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return !this.field_71075_bZ.isFlying;
    }

    /**
     * Sends the player's abilities to the server (if there is one).
     */
    public void sendPlayerAbilities()
    {
    }

    /**
     * Sets the player's game mode and sends it to them.
     */
    public void func_71033_a(WorldSettings.GameType gameType)
    {
    }

    /**
     * Gets the name of this command sender (usually username, but possibly "Rcon")
     */
    public String func_70005_c_()
    {
        return this.gameProfile.getName();
    }

    /**
     * Returns the InventoryEnderChest of this player.
     */
    public InventoryEnderChest getInventoryEnderChest()
    {
        return this.theInventoryEnderChest;
    }

    /**
     * 0: Tool in Hand; 1-4: Armor
     */
    public ItemStack getEquipmentInSlot(int slotIn)
    {
        return slotIn == 0 ? this.field_71071_by.getCurrentItem() : this.field_71071_by.armorInventory[slotIn - 1];
    }

    /**
     * Returns the item that this EntityLiving is holding, if any.
     */
    public ItemStack getHeldItem()
    {
        return this.field_71071_by.getCurrentItem();
    }

    /**
     * Sets the held item, or an armor slot. Slot 0 is held item. Slot 1-4 is armor. Params: Item, slot
     */
    public void setCurrentItemOrArmor(int slotIn, ItemStack stack)
    {
        this.field_71071_by.armorInventory[slotIn] = stack;
    }

    /**
     * Only used by renderer in EntityLivingBase subclasses.
     * Determines if an entity is visible or not to a specfic player, if the entity is normally invisible.
     * For EntityLivingBase subclasses, returning false when invisible will render the entity semitransparent.
     */
    public boolean isInvisibleToPlayer(EntityPlayer player)
    {
        if (!this.isInvisible())
        {
            return false;
        }
        else if (player.isSpectator())
        {
            return false;
        }
        else
        {
            Team team = this.func_96124_cp();
            return team == null || player == null || player.func_96124_cp() != team || !team.getSeeFriendlyInvisiblesEnabled();
        }
    }

    /**
     * Returns true if the player is in spectator mode.
     */
    public abstract boolean isSpectator();

    /**
     * returns the inventory of this entity (only used in EntityPlayerMP it seems)
     */
    public ItemStack[] getInventory()
    {
        return this.field_71071_by.armorInventory;
    }

    public boolean isPushedByWater()
    {
        return !this.field_71075_bZ.isFlying;
    }

    public Scoreboard getWorldScoreboard()
    {
        return this.field_70170_p.func_96441_U();
    }

    public Team func_96124_cp()
    {
        return this.getWorldScoreboard().getPlayersTeam(this.func_70005_c_());
    }

    /**
     * Get the formatted ChatComponent that will be used for the sender's username in chat
     */
    public IChatComponent func_145748_c_()
    {
        IChatComponent ichatcomponent = new ChatComponentText(ScorePlayerTeam.formatPlayerName(this.func_96124_cp(), this.func_70005_c_()));
        ichatcomponent.func_150256_b().func_150241_a(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/msg " + this.func_70005_c_() + " "));
        ichatcomponent.func_150256_b().setChatHoverEvent(this.getHoverEvent());
        ichatcomponent.func_150256_b().setInsertion(this.func_70005_c_());
        return ichatcomponent;
    }

    public float getEyeHeight()
    {
        float f = 1.62F;

        if (this.isPlayerSleeping())
        {
            f = 0.2F;
        }

        if (this.isSneaking())
        {
            f -= 0.08F;
        }

        return f;
    }

    public void setAbsorptionAmount(float amount)
    {
        if (amount < 0.0F)
        {
            amount = 0.0F;
        }

        this.getDataWatcher().updateObject(17, Float.valueOf(amount));
    }

    public float getAbsorptionAmount()
    {
        return this.getDataWatcher().getWatchableObjectFloat(17);
    }

    /**
     * Gets a players UUID given their GameProfie
     */
    public static UUID getUUID(GameProfile profile)
    {
        UUID uuid = profile.getId();

        if (uuid == null)
        {
            uuid = getOfflineUUID(profile.getName());
        }

        return uuid;
    }

    public static UUID getOfflineUUID(String username)
    {
        return UUID.nameUUIDFromBytes(("OfflinePlayer:" + username).getBytes(Charsets.UTF_8));
    }

    /**
     * Check whether this player can open an inventory locked with the given LockCode.
     */
    public boolean canOpen(LockCode code)
    {
        if (code.isEmpty())
        {
            return true;
        }
        else
        {
            ItemStack itemstack = this.func_71045_bC();
            return itemstack != null && itemstack.hasDisplayName() ? itemstack.getDisplayName().equals(code.getLock()) : false;
        }
    }

    public boolean isWearing(EnumPlayerModelParts p_175148_1_)
    {
        return (this.getDataWatcher().getWatchableObjectByte(10) & p_175148_1_.getPartMask()) == p_175148_1_.getPartMask();
    }

    /**
     * Returns true if the command sender should be sent feedback about executed commands
     */
    public boolean func_174792_t_()
    {
        return MinecraftServer.func_71276_C().field_71305_c[0].func_82736_K().func_82766_b("sendCommandFeedback");
    }

    public boolean func_174820_d(int inventorySlot, ItemStack itemStackIn)
    {
        if (inventorySlot >= 0 && inventorySlot < this.field_71071_by.mainInventory.length)
        {
            this.field_71071_by.func_70299_a(inventorySlot, itemStackIn);
            return true;
        }
        else
        {
            int i = inventorySlot - 100;

            if (i >= 0 && i < this.field_71071_by.armorInventory.length)
            {
                int k = i + 1;

                if (itemStackIn != null && itemStackIn.func_77973_b() != null)
                {
                    if (itemStackIn.func_77973_b() instanceof ItemArmor)
                    {
                        if (EntityLiving.getArmorPosition(itemStackIn) != k)
                        {
                            return false;
                        }
                    }
                    else if (k != 4 || itemStackIn.func_77973_b() != Items.field_151144_bL && !(itemStackIn.func_77973_b() instanceof ItemBlock))
                    {
                        return false;
                    }
                }

                this.field_71071_by.func_70299_a(i + this.field_71071_by.mainInventory.length, itemStackIn);
                return true;
            }
            else
            {
                int j = inventorySlot - 200;

                if (j >= 0 && j < this.theInventoryEnderChest.func_70302_i_())
                {
                    this.theInventoryEnderChest.func_70299_a(j, itemStackIn);
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
    }

    /**
     * Whether the "reducedDebugInfo" option is active for this player.
     */
    public boolean hasReducedDebug()
    {
        return this.hasReducedDebug;
    }

    public void setReducedDebug(boolean reducedDebug)
    {
        this.hasReducedDebug = reducedDebug;
    }

    public static enum EnumChatVisibility
    {
        FULL(0, "options.chat.visibility.full"),
        SYSTEM(1, "options.chat.visibility.system"),
        HIDDEN(2, "options.chat.visibility.hidden");

        private static final EntityPlayer.EnumChatVisibility[] ID_LOOKUP = new EntityPlayer.EnumChatVisibility[values().length];
        private final int chatVisibility;
        private final String resourceKey;

        private EnumChatVisibility(int id, String resourceKey)
        {
            this.chatVisibility = id;
            this.resourceKey = resourceKey;
        }

        public int getChatVisibility()
        {
            return this.chatVisibility;
        }

        public static EntityPlayer.EnumChatVisibility getEnumChatVisibility(int id)
        {
            return ID_LOOKUP[id % ID_LOOKUP.length];
        }

        public String getResourceKey()
        {
            return this.resourceKey;
        }

        static {
            for (EntityPlayer.EnumChatVisibility entityplayer$enumchatvisibility : values())
            {
                ID_LOOKUP[entityplayer$enumchatvisibility.chatVisibility] = entityplayer$enumchatvisibility;
            }
        }
    }

    public static enum EnumStatus
    {
        OK,
        NOT_POSSIBLE_HERE,
        NOT_POSSIBLE_NOW,
        TOO_FAR_AWAY,
        OTHER_PROBLEM,
        NOT_SAFE;
    }
}
