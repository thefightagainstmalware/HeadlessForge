package net.minecraft.entity;

import java.util.UUID;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityJumpHelper;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.play.server.S1BPacketEntityAttach;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.profiler.Profiler;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public abstract class EntityLiving extends EntityLivingBase
{
    /** Number of ticks since this EntityLiving last produced its sound */
    public int livingSoundTime;
    /** The experience points the Entity gives. */
    protected int experienceValue;
    private EntityLookHelper lookHelper;
    protected EntityMoveHelper moveHelper;
    /** Entity jumping helper */
    protected EntityJumpHelper jumpHelper;
    private EntityBodyHelper bodyHelper;
    protected PathNavigate navigator;
    /** Passive tasks (wandering, look, idle, ...) */
    public final EntityAITasks tasks;
    /** Fighting tasks (used by monsters, wolves, ocelots) */
    public final EntityAITasks targetTasks;
    /** The active target the Task system uses for tracking */
    private EntityLivingBase attackTarget;
    private EntitySenses senses;
    /** Equipment (armor and held item) for this entity. */
    private ItemStack[] equipment = new ItemStack[5];
    /** Chances for each equipment piece from dropping when this entity dies. */
    protected float[] equipmentDropChances = new float[5];
    /** Whether this entity can pick up items from the ground. */
    private boolean canPickUpLoot;
    /** Whether this entity should NOT despawn. */
    private boolean persistenceRequired;
    private boolean isLeashed;
    private Entity leashedToEntity;
    private NBTTagCompound leashNBTTag;

    public EntityLiving(World worldIn)
    {
        super(worldIn);
        Profiler profilerIn = worldIn != null && worldIn.theProfiler != null ? worldIn.theProfiler : null;
        this.tasks = new EntityAITasks(profilerIn);
        this.targetTasks = new EntityAITasks(profilerIn);
        this.lookHelper = new EntityLookHelper(this);
        this.moveHelper = new EntityMoveHelper(this);
        this.jumpHelper = new EntityJumpHelper(this);
        this.bodyHelper = new EntityBodyHelper(this);
        this.navigator = this.getNewNavigator(worldIn);
        this.senses = new EntitySenses(this);

        for (int i = 0; i < this.equipmentDropChances.length; ++i)
        {
            this.equipmentDropChances[i] = 0.085F;
        }
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.followRange).setBaseValue(16.0D);
    }

    /**
     * Returns new PathNavigateGround instance
     */
    protected PathNavigate getNewNavigator(World worldIn)
    {
        return new PathNavigateGround(this, worldIn);
    }

    public EntityLookHelper getLookHelper()
    {
        return this.lookHelper;
    }

    public EntityMoveHelper getMoveHelper()
    {
        return this.moveHelper;
    }

    public EntityJumpHelper getJumpHelper()
    {
        return this.jumpHelper;
    }

    public PathNavigate getNavigator()
    {
        return this.navigator;
    }

    /**
     * returns the EntitySenses Object for the EntityLiving
     */
    public EntitySenses getEntitySenses()
    {
        return this.senses;
    }

    /**
     * Gets the active target the Task system uses for tracking
     */
    public EntityLivingBase getAttackTarget()
    {
        return this.attackTarget;
    }

    /**
     * Sets the active target the Task system uses for tracking
     */
    public void setAttackTarget(EntityLivingBase entitylivingbaseIn)
    {
        this.attackTarget = entitylivingbaseIn;
    }

    /**
     * Returns true if this entity can attack entities of the specified class.
     */
    public boolean canAttackClass(Class <? extends EntityLivingBase > cls)
    {
        return cls != EntityGhast.class;
    }

    /**
     * This function applies the benefits of growing back wool and faster growing up to the acting entity. (This
     * function is used in the AIEatGrass)
     */
    public void eatGrassBonus()
    {
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(15, Byte.valueOf((byte)0));
    }

    /**
     * Get number of ticks, at least during which the living entity will be silent.
     */
    public int getTalkInterval()
    {
        return 80;
    }

    /**
     * Plays living's sound at its position
     */
    public void playLivingSound()
    {
        String s = this.getLivingSound();

        if (s != null)
        {
            this.playSound(s, this.getSoundVolume(), this.getSoundPitch());
        }
    }

    /**
     * Gets called every tick from main Entity class
     */
    public void onEntityUpdate()
    {
        super.onEntityUpdate();
        this.field_70170_p.theProfiler.startSection("mobBaseTick");

        if (this.isEntityAlive() && this.rand.nextInt(1000) < this.livingSoundTime++)
        {
            this.livingSoundTime = -this.getTalkInterval();
            this.playLivingSound();
        }

        this.field_70170_p.theProfiler.endSection();
    }

    /**
     * Get the experience points the entity currently has.
     */
    protected int getExperiencePoints(EntityPlayer player)
    {
        if (this.experienceValue > 0)
        {
            int i = this.experienceValue;
            ItemStack[] aitemstack = this.getInventory();

            for (int j = 0; j < aitemstack.length; ++j)
            {
                if (aitemstack[j] != null && this.equipmentDropChances[j] <= 1.0F)
                {
                    i += 1 + this.rand.nextInt(3);
                }
            }

            return i;
        }
        else
        {
            return this.experienceValue;
        }
    }

    /**
     * Spawns an explosion particle around the Entity's location
     */
    public void spawnExplosionParticle()
    {
        if (this.field_70170_p.isRemote)
        {
            for (int i = 0; i < 20; ++i)
            {
                double d0 = this.rand.nextGaussian() * 0.02D;
                double d1 = this.rand.nextGaussian() * 0.02D;
                double d2 = this.rand.nextGaussian() * 0.02D;
                double d3 = 10.0D;
                this.field_70170_p.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.field_70165_t + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width - d0 * d3, this.field_70163_u + (double)(this.rand.nextFloat() * this.height) - d1 * d3, this.field_70161_v + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width - d2 * d3, d0, d1, d2, new int[0]);
            }
        }
        else
        {
            this.field_70170_p.setEntityState(this, (byte)20);
        }
    }

    public void handleStatusUpdate(byte id)
    {
        if (id == 20)
        {
            this.spawnExplosionParticle();
        }
        else
        {
            super.handleStatusUpdate(id);
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.field_70170_p.isRemote)
        {
            this.updateLeashedState();
        }
    }

    protected float func_110146_f(float p_110146_1_, float p_110146_2_)
    {
        this.bodyHelper.updateRenderAngles();
        return p_110146_2_;
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return null;
    }

    protected Item getDropItem()
    {
        return null;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        Item item = this.getDropItem();

        if (item != null)
        {
            int i = this.rand.nextInt(3);

            if (p_70628_2_ > 0)
            {
                i += this.rand.nextInt(p_70628_2_ + 1);
            }

            for (int j = 0; j < i; ++j)
            {
                this.dropItem(item, 1);
            }
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setBoolean("CanPickUpLoot", this.canPickUpLoot());
        tagCompound.setBoolean("PersistenceRequired", this.persistenceRequired);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.equipment.length; ++i)
        {
            NBTTagCompound nbttagcompound = new NBTTagCompound();

            if (this.equipment[i] != null)
            {
                this.equipment[i].writeToNBT(nbttagcompound);
            }

            nbttaglist.func_74742_a(nbttagcompound);
        }

        tagCompound.func_74782_a("Equipment", nbttaglist);
        NBTTagList nbttaglist1 = new NBTTagList();

        for (int j = 0; j < this.equipmentDropChances.length; ++j)
        {
            nbttaglist1.func_74742_a(new NBTTagFloat(this.equipmentDropChances[j]));
        }

        tagCompound.func_74782_a("DropChances", nbttaglist1);
        tagCompound.setBoolean("Leashed", this.isLeashed);

        if (this.leashedToEntity != null)
        {
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();

            if (this.leashedToEntity instanceof EntityLivingBase)
            {
                nbttagcompound1.setLong("UUIDMost", this.leashedToEntity.func_110124_au().getMostSignificantBits());
                nbttagcompound1.setLong("UUIDLeast", this.leashedToEntity.func_110124_au().getLeastSignificantBits());
            }
            else if (this.leashedToEntity instanceof EntityHanging)
            {
                BlockPos blockpos = ((EntityHanging)this.leashedToEntity).getHangingPosition();
                nbttagcompound1.func_74768_a("X", blockpos.func_177958_n());
                nbttagcompound1.func_74768_a("Y", blockpos.func_177956_o());
                nbttagcompound1.func_74768_a("Z", blockpos.func_177952_p());
            }

            tagCompound.func_74782_a("Leash", nbttagcompound1);
        }

        if (this.isAIDisabled())
        {
            tagCompound.setBoolean("NoAI", this.isAIDisabled());
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        super.readEntityFromNBT(tagCompund);

        if (tagCompund.func_150297_b("CanPickUpLoot", 1))
        {
            this.setCanPickUpLoot(tagCompund.getBoolean("CanPickUpLoot"));
        }

        this.persistenceRequired = tagCompund.getBoolean("PersistenceRequired");

        if (tagCompund.func_150297_b("Equipment", 9))
        {
            NBTTagList nbttaglist = tagCompund.getTagList("Equipment", 10);

            for (int i = 0; i < this.equipment.length; ++i)
            {
                this.equipment[i] = ItemStack.loadItemStackFromNBT(nbttaglist.func_150305_b(i));
            }
        }

        if (tagCompund.func_150297_b("DropChances", 9))
        {
            NBTTagList nbttaglist1 = tagCompund.getTagList("DropChances", 5);

            for (int j = 0; j < nbttaglist1.func_74745_c(); ++j)
            {
                this.equipmentDropChances[j] = nbttaglist1.getFloatAt(j);
            }
        }

        this.isLeashed = tagCompund.getBoolean("Leashed");

        if (this.isLeashed && tagCompund.func_150297_b("Leash", 10))
        {
            this.leashNBTTag = tagCompund.func_74775_l("Leash");
        }

        this.setNoAI(tagCompund.getBoolean("NoAI"));
    }

    public void setMoveForward(float p_70657_1_)
    {
        this.moveForward = p_70657_1_;
    }

    /**
     * set the movespeed used for the new AI system
     */
    public void setAIMoveSpeed(float speedIn)
    {
        super.setAIMoveSpeed(speedIn);
        this.setMoveForward(speedIn);
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        this.field_70170_p.theProfiler.startSection("looting");

        if (!this.field_70170_p.isRemote && this.canPickUpLoot() && !this.dead && this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"))
        {
            for (EntityItem entityitem : this.field_70170_p.getEntitiesWithinAABB(EntityItem.class, this.getEntityBoundingBox().expand(1.0D, 0.0D, 1.0D)))
            {
                if (!entityitem.isDead && entityitem.getEntityItem() != null && !entityitem.cannotPickup())
                {
                    this.updateEquipmentIfNeeded(entityitem);
                }
            }
        }

        this.field_70170_p.theProfiler.endSection();
    }

    /**
     * Tests if this entity should pickup a weapon or an armor. Entity drops current weapon or armor if the new one is
     * better.
     */
    protected void updateEquipmentIfNeeded(EntityItem itemEntity)
    {
        ItemStack itemstack = itemEntity.getEntityItem();
        int i = getArmorPosition(itemstack);

        if (i > -1)
        {
            boolean flag = true;
            ItemStack itemstack1 = this.getEquipmentInSlot(i);

            if (itemstack1 != null)
            {
                if (i == 0)
                {
                    if (itemstack.func_77973_b() instanceof ItemSword && !(itemstack1.func_77973_b() instanceof ItemSword))
                    {
                        flag = true;
                    }
                    else if (itemstack.func_77973_b() instanceof ItemSword && itemstack1.func_77973_b() instanceof ItemSword)
                    {
                        ItemSword itemsword = (ItemSword)itemstack.func_77973_b();
                        ItemSword itemsword1 = (ItemSword)itemstack1.func_77973_b();

                        if (itemsword.getDamageVsEntity() != itemsword1.getDamageVsEntity())
                        {
                            flag = itemsword.getDamageVsEntity() > itemsword1.getDamageVsEntity();
                        }
                        else
                        {
                            flag = itemstack.getMetadata() > itemstack1.getMetadata() || itemstack.func_77942_o() && !itemstack1.func_77942_o();
                        }
                    }
                    else if (itemstack.func_77973_b() instanceof ItemBow && itemstack1.func_77973_b() instanceof ItemBow)
                    {
                        flag = itemstack.func_77942_o() && !itemstack1.func_77942_o();
                    }
                    else
                    {
                        flag = false;
                    }
                }
                else if (itemstack.func_77973_b() instanceof ItemArmor && !(itemstack1.func_77973_b() instanceof ItemArmor))
                {
                    flag = true;
                }
                else if (itemstack.func_77973_b() instanceof ItemArmor && itemstack1.func_77973_b() instanceof ItemArmor)
                {
                    ItemArmor itemarmor = (ItemArmor)itemstack.func_77973_b();
                    ItemArmor itemarmor1 = (ItemArmor)itemstack1.func_77973_b();

                    if (itemarmor.damageReduceAmount != itemarmor1.damageReduceAmount)
                    {
                        flag = itemarmor.damageReduceAmount > itemarmor1.damageReduceAmount;
                    }
                    else
                    {
                        flag = itemstack.getMetadata() > itemstack1.getMetadata() || itemstack.func_77942_o() && !itemstack1.func_77942_o();
                    }
                }
                else
                {
                    flag = false;
                }
            }

            if (flag && this.func_175448_a(itemstack))
            {
                if (itemstack1 != null && this.rand.nextFloat() - 0.1F < this.equipmentDropChances[i])
                {
                    this.entityDropItem(itemstack1, 0.0F);
                }

                if (itemstack.func_77973_b() == Items.field_151045_i && itemEntity.getThrower() != null)
                {
                    EntityPlayer entityplayer = this.field_70170_p.getPlayerEntityByName(itemEntity.getThrower());

                    if (entityplayer != null)
                    {
                        entityplayer.func_71029_a(AchievementList.diamondsToYou);
                    }
                }

                this.setCurrentItemOrArmor(i, itemstack);
                this.equipmentDropChances[i] = 2.0F;
                this.persistenceRequired = true;
                this.onItemPickup(itemEntity, 1);
                itemEntity.setDead();
            }
        }
    }

    protected boolean func_175448_a(ItemStack stack)
    {
        return true;
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return true;
    }

    /**
     * Makes the entity despawn if requirements are reached
     */
    protected void despawnEntity()
    {
        net.minecraftforge.fml.common.eventhandler.Event.Result result = null;
        if (this.persistenceRequired)
        {
            this.entityAge = 0;
        }
        else if ((this.entityAge & 0x1F) == 0x1F)
        {
this.setDead();
        }
        else
        {
            Entity entity = this.field_70170_p.getClosestPlayerToEntity(this, -1.0D);

            if (entity != null)
            {
                double d0 = entity.field_70165_t - this.field_70165_t;
                double d1 = entity.field_70163_u - this.field_70163_u;
                double d2 = entity.field_70161_v - this.field_70161_v;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;

                if (this.canDespawn() && d3 > 16384.0D)
                {
                    this.setDead();
                }

                if (this.entityAge > 600 && this.rand.nextInt(800) == 0 && d3 > 1024.0D && this.canDespawn())
                {
                    this.setDead();
                }
                else if (d3 < 1024.0D)
                {
                    this.entityAge = 0;
                }
            }
        }
    }

    protected final void updateEntityActionState()
    {
        ++this.entityAge;
        this.field_70170_p.theProfiler.startSection("checkDespawn");
        this.despawnEntity();
        this.field_70170_p.theProfiler.endSection();
        this.field_70170_p.theProfiler.startSection("sensing");
        this.senses.clearSensingCache();
        this.field_70170_p.theProfiler.endSection();
        this.field_70170_p.theProfiler.startSection("targetSelector");
        this.targetTasks.onUpdateTasks();
        this.field_70170_p.theProfiler.endSection();
        this.field_70170_p.theProfiler.startSection("goalSelector");
        this.tasks.onUpdateTasks();
        this.field_70170_p.theProfiler.endSection();
        this.field_70170_p.theProfiler.startSection("navigation");
        this.navigator.onUpdateNavigation();
        this.field_70170_p.theProfiler.endSection();
        this.field_70170_p.theProfiler.startSection("mob tick");
        this.updateAITasks();
        this.field_70170_p.theProfiler.endSection();
        this.field_70170_p.theProfiler.startSection("controls");
        this.field_70170_p.theProfiler.startSection("move");
        this.moveHelper.onUpdateMoveHelper();
        this.field_70170_p.theProfiler.endStartSection("look");
        this.lookHelper.onUpdateLook();
        this.field_70170_p.theProfiler.endStartSection("jump");
        this.jumpHelper.doJump();
        this.field_70170_p.theProfiler.endSection();
        this.field_70170_p.theProfiler.endSection();
    }

    protected void updateAITasks()
    {
    }

    /**
     * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
     * use in wolves.
     */
    public int getVerticalFaceSpeed()
    {
        return 40;
    }

    /**
     * Changes pitch and yaw so that the entity calling the function is facing the entity provided as an argument.
     */
    public void faceEntity(Entity entityIn, float p_70625_2_, float p_70625_3_)
    {
        double d0 = entityIn.field_70165_t - this.field_70165_t;
        double d2 = entityIn.field_70161_v - this.field_70161_v;
        double d1;

        if (entityIn instanceof EntityLivingBase)
        {
            EntityLivingBase entitylivingbase = (EntityLivingBase)entityIn;
            d1 = entitylivingbase.field_70163_u + (double)entitylivingbase.getEyeHeight() - (this.field_70163_u + (double)this.getEyeHeight());
        }
        else
        {
            d1 = (entityIn.getEntityBoundingBox().minY + entityIn.getEntityBoundingBox().maxY) / 2.0D - (this.field_70163_u + (double)this.getEyeHeight());
        }

        double d3 = (double)MathHelper.func_76133_a(d0 * d0 + d2 * d2);
        float f = (float)(MathHelper.func_181159_b(d2, d0) * 180.0D / Math.PI) - 90.0F;
        float f1 = (float)(-(MathHelper.func_181159_b(d1, d3) * 180.0D / Math.PI));
        this.field_70125_A = this.updateRotation(this.field_70125_A, f1, p_70625_3_);
        this.field_70177_z = this.updateRotation(this.field_70177_z, f, p_70625_2_);
    }

    /**
     * Arguments: current rotation, intended rotation, max increment.
     */
    private float updateRotation(float p_70663_1_, float p_70663_2_, float p_70663_3_)
    {
        float f = MathHelper.func_76142_g(p_70663_2_ - p_70663_1_);

        if (f > p_70663_3_)
        {
            f = p_70663_3_;
        }

        if (f < -p_70663_3_)
        {
            f = -p_70663_3_;
        }

        return p_70663_1_ + f;
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return true;
    }

    /**
     * Checks that the entity is not colliding with any blocks / liquids
     */
    public boolean isNotColliding()
    {
        return this.field_70170_p.checkNoEntityCollision(this.getEntityBoundingBox(), this) && this.field_70170_p.getCollidingBoundingBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.field_70170_p.isAnyLiquid(this.getEntityBoundingBox());
    }

    /**
     * Returns render size modifier
     */
    public float getRenderSizeModifier()
    {
        return 1.0F;
    }

    /**
     * Will return how many at most can spawn in a chunk at once.
     */
    public int getMaxSpawnedInChunk()
    {
        return 4;
    }

    /**
     * The maximum height from where the entity is alowed to jump (used in pathfinder)
     */
    public int getMaxFallHeight()
    {
        if (this.getAttackTarget() == null)
        {
            return 3;
        }
        else
        {
            int i = (int)(this.getHealth() - this.getMaxHealth() * 0.33F);
            i = i - (3 - this.field_70170_p.getDifficulty().getDifficultyId()) * 4;

            if (i < 0)
            {
                i = 0;
            }

            return i + 3;
        }
    }

    /**
     * Returns the item that this EntityLiving is holding, if any.
     */
    public ItemStack getHeldItem()
    {
        return this.equipment[0];
    }

    /**
     * 0: Tool in Hand; 1-4: Armor
     */
    public ItemStack getEquipmentInSlot(int slotIn)
    {
        return this.equipment[slotIn];
    }

    public ItemStack getCurrentArmor(int slotIn)
    {
        return this.equipment[slotIn + 1];
    }

    /**
     * Sets the held item, or an armor slot. Slot 0 is held item. Slot 1-4 is armor. Params: Item, slot
     */
    public void setCurrentItemOrArmor(int slotIn, ItemStack stack)
    {
        this.equipment[slotIn] = stack;
    }

    /**
     * returns the inventory of this entity (only used in EntityPlayerMP it seems)
     */
    public ItemStack[] getInventory()
    {
        return this.equipment;
    }

    /**
     * Drop the equipment for this entity.
     */
    protected void dropEquipment(boolean p_82160_1_, int p_82160_2_)
    {
        for (int i = 0; i < this.getInventory().length; ++i)
        {
            ItemStack itemstack = this.getEquipmentInSlot(i);
            boolean flag = this.equipmentDropChances[i] > 1.0F;

            if (itemstack != null && (p_82160_1_ || flag) && this.rand.nextFloat() - (float)p_82160_2_ * 0.01F < this.equipmentDropChances[i])
            {
                if (!flag && itemstack.isItemStackDamageable())
                {
                    int j = Math.max(itemstack.getMaxDamage() - 25, 1);
                    int k = itemstack.getMaxDamage() - this.rand.nextInt(this.rand.nextInt(j) + 1);

                    if (k > j)
                    {
                        k = j;
                    }

                    if (k < 1)
                    {
                        k = 1;
                    }

                    itemstack.setItemDamage(k);
                }

                this.entityDropItem(itemstack, 0.0F);
            }
        }
    }

    /**
     * Gives armor or weapon for entity based on given DifficultyInstance
     */
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
    {
        if (this.rand.nextFloat() < 0.15F * difficulty.getClampedAdditionalDifficulty())
        {
            int i = this.rand.nextInt(2);
            float f = this.field_70170_p.getDifficulty() == EnumDifficulty.HARD ? 0.1F : 0.25F;

            if (this.rand.nextFloat() < 0.095F)
            {
                ++i;
            }

            if (this.rand.nextFloat() < 0.095F)
            {
                ++i;
            }

            if (this.rand.nextFloat() < 0.095F)
            {
                ++i;
            }

            for (int j = 3; j >= 0; --j)
            {
                ItemStack itemstack = this.getCurrentArmor(j);

                if (j < 3 && this.rand.nextFloat() < f)
                {
                    break;
                }

                if (itemstack == null)
                {
                    Item item = getArmorItemForSlot(j + 1, i);

                    if (item != null)
                    {
                        this.setCurrentItemOrArmor(j + 1, new ItemStack(item));
                    }
                }
            }
        }
    }

    public static int getArmorPosition(ItemStack stack)
    {
        if (stack.func_77973_b() != Item.func_150898_a(Blocks.field_150423_aK) && stack.func_77973_b() != Items.field_151144_bL)
        {
            if (stack.func_77973_b() instanceof ItemArmor)
            {
                switch (((ItemArmor)stack.func_77973_b()).armorType)
                {
                    case 0:
                        return 4;
                    case 1:
                        return 3;
                    case 2:
                        return 2;
                    case 3:
                        return 1;
                }
            }

            return 0;
        }
        else
        {
            return 4;
        }
    }

    /**
     * Gets the vanilla armor Item that can go in the slot specified for the given tier.
     */
    public static Item getArmorItemForSlot(int armorSlot, int itemTier)
    {
        switch (armorSlot)
        {
            case 4:

                if (itemTier == 0)
                {
                    return Items.field_151024_Q;
                }
                else if (itemTier == 1)
                {
                    return Items.golden_helmet;
                }
                else if (itemTier == 2)
                {
                    return Items.chainmail_helmet;
                }
                else if (itemTier == 3)
                {
                    return Items.iron_helmet;
                }
                else if (itemTier == 4)
                {
                    return Items.diamond_helmet;
                }

            case 3:

                if (itemTier == 0)
                {
                    return Items.leather_chestplate;
                }
                else if (itemTier == 1)
                {
                    return Items.golden_chestplate;
                }
                else if (itemTier == 2)
                {
                    return Items.chainmail_chestplate;
                }
                else if (itemTier == 3)
                {
                    return Items.iron_chestplate;
                }
                else if (itemTier == 4)
                {
                    return Items.field_151163_ad;
                }

            case 2:

                if (itemTier == 0)
                {
                    return Items.leather_leggings;
                }
                else if (itemTier == 1)
                {
                    return Items.golden_leggings;
                }
                else if (itemTier == 2)
                {
                    return Items.field_151022_W;
                }
                else if (itemTier == 3)
                {
                    return Items.iron_leggings;
                }
                else if (itemTier == 4)
                {
                    return Items.diamond_leggings;
                }

            case 1:

                if (itemTier == 0)
                {
                    return Items.leather_boots;
                }
                else if (itemTier == 1)
                {
                    return Items.golden_boots;
                }
                else if (itemTier == 2)
                {
                    return Items.chainmail_boots;
                }
                else if (itemTier == 3)
                {
                    return Items.iron_boots;
                }
                else if (itemTier == 4)
                {
                    return Items.field_151175_af;
                }

            default:
                return null;
        }
    }

    /**
     * Enchants Entity's current equipments based on given DifficultyInstance
     */
    protected void setEnchantmentBasedOnDifficulty(DifficultyInstance difficulty)
    {
        float f = difficulty.getClampedAdditionalDifficulty();

        if (this.getHeldItem() != null && this.rand.nextFloat() < 0.25F * f)
        {
            EnchantmentHelper.addRandomEnchantment(this.rand, this.getHeldItem(), (int)(5.0F + f * (float)this.rand.nextInt(18)));
        }

        for (int i = 0; i < 4; ++i)
        {
            ItemStack itemstack = this.getCurrentArmor(i);

            if (itemstack != null && this.rand.nextFloat() < 0.5F * f)
            {
                EnchantmentHelper.addRandomEnchantment(this.rand, itemstack, (int)(5.0F + f * (float)this.rand.nextInt(18)));
            }
        }
    }

    /**
     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
     */
    public IEntityLivingData func_180482_a(DifficultyInstance difficulty, IEntityLivingData livingdata)
    {
        this.getEntityAttribute(SharedMonsterAttributes.followRange).applyModifier(new AttributeModifier("Random spawn bonus", this.rand.nextGaussian() * 0.05D, 1));
        return livingdata;
    }

    /**
     * returns true if all the conditions for steering the entity are met. For pigs, this is true if it is being ridden
     * by a player and the player is holding a carrot-on-a-stick
     */
    public boolean canBeSteered()
    {
        return false;
    }

    /**
     * Enable the Entity persistence
     */
    public void enablePersistence()
    {
        this.persistenceRequired = true;
    }

    public void setEquipmentDropChance(int slotIn, float chance)
    {
        this.equipmentDropChances[slotIn] = chance;
    }

    public boolean canPickUpLoot()
    {
        return this.canPickUpLoot;
    }

    public void setCanPickUpLoot(boolean canPickup)
    {
        this.canPickUpLoot = canPickup;
    }

    public boolean isNoDespawnRequired()
    {
        return this.persistenceRequired;
    }

    /**
     * First layer of player interaction
     */
    public final boolean interactFirst(EntityPlayer playerIn)
    {
        if (this.getLeashed() && this.getLeashedToEntity() == playerIn)
        {
            this.clearLeashed(true, !playerIn.field_71075_bZ.field_75098_d);
            return true;
        }
        else
        {
            ItemStack itemstack = playerIn.field_71071_by.getCurrentItem();

            if (itemstack != null && itemstack.func_77973_b() == Items.lead && this.allowLeashing())
            {
                if (!(this instanceof EntityTameable) || !((EntityTameable)this).isTamed())
                {
                    this.setLeashedToEntity(playerIn, true);
                    --itemstack.field_77994_a;
                    return true;
                }

                if (((EntityTameable)this).isOwner(playerIn))
                {
                    this.setLeashedToEntity(playerIn, true);
                    --itemstack.field_77994_a;
                    return true;
                }
            }

            if (this.interact(playerIn))
            {
                return true;
            }
            else
            {
                return super.interactFirst(playerIn);
            }
        }
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    protected boolean interact(EntityPlayer player)
    {
        return false;
    }

    /**
     * Applies logic related to leashes, for example dragging the entity or breaking the leash.
     */
    protected void updateLeashedState()
    {
        if (this.leashNBTTag != null)
        {
            this.recreateLeash();
        }

        if (this.isLeashed)
        {
            if (!this.isEntityAlive())
            {
                this.clearLeashed(true, true);
            }

            if (this.leashedToEntity == null || this.leashedToEntity.isDead)
            {
                this.clearLeashed(true, true);
            }
        }
    }

    /**
     * Removes the leash from this entity
     */
    public void clearLeashed(boolean sendPacket, boolean dropLead)
    {
        if (this.isLeashed)
        {
            this.isLeashed = false;
            this.leashedToEntity = null;

            if (!this.field_70170_p.isRemote && dropLead)
            {
                this.dropItem(Items.lead, 1);
            }

            if (!this.field_70170_p.isRemote && sendPacket && this.field_70170_p instanceof WorldServer)
            {
                ((WorldServer)this.field_70170_p).getEntityTracker().sendToAllTrackingEntity(this, new S1BPacketEntityAttach(1, this, (Entity)null));
            }
        }
    }

    public boolean allowLeashing()
    {
        return !this.getLeashed() && !(this instanceof IMob);
    }

    public boolean getLeashed()
    {
        return this.isLeashed;
    }

    public Entity getLeashedToEntity()
    {
        return this.leashedToEntity;
    }

    /**
     * Sets the entity to be leashed to.
     */
    public void setLeashedToEntity(Entity entityIn, boolean sendAttachNotification)
    {
        this.isLeashed = true;
        this.leashedToEntity = entityIn;

        if (!this.field_70170_p.isRemote && sendAttachNotification && this.field_70170_p instanceof WorldServer)
        {
            ((WorldServer)this.field_70170_p).getEntityTracker().sendToAllTrackingEntity(this, new S1BPacketEntityAttach(1, this, this.leashedToEntity));
        }
    }

    private void recreateLeash()
    {
        if (this.isLeashed && this.leashNBTTag != null)
        {
            if (this.leashNBTTag.func_150297_b("UUIDMost", 4) && this.leashNBTTag.func_150297_b("UUIDLeast", 4))
            {
                UUID uuid = new UUID(this.leashNBTTag.getLong("UUIDMost"), this.leashNBTTag.getLong("UUIDLeast"));

                for (EntityLivingBase entitylivingbase : this.field_70170_p.getEntitiesWithinAABB(EntityLivingBase.class, this.getEntityBoundingBox().expand(10.0D, 10.0D, 10.0D)))
                {
                    if (entitylivingbase.func_110124_au().equals(uuid))
                    {
                        this.leashedToEntity = entitylivingbase;
                        break;
                    }
                }
            }
            else if (this.leashNBTTag.func_150297_b("X", 99) && this.leashNBTTag.func_150297_b("Y", 99) && this.leashNBTTag.func_150297_b("Z", 99))
            {
                BlockPos blockpos = new BlockPos(this.leashNBTTag.getInteger("X"), this.leashNBTTag.getInteger("Y"), this.leashNBTTag.getInteger("Z"));
                EntityLeashKnot entityleashknot = EntityLeashKnot.getKnotForPosition(this.field_70170_p, blockpos);

                if (entityleashknot == null)
                {
                    entityleashknot = EntityLeashKnot.createKnot(this.field_70170_p, blockpos);
                }

                this.leashedToEntity = entityleashknot;
            }
            else
            {
                this.clearLeashed(false, true);
            }
        }

        this.leashNBTTag = null;
    }

    public boolean func_174820_d(int inventorySlot, ItemStack itemStackIn)
    {
        int i;

        if (inventorySlot == 99)
        {
            i = 0;
        }
        else
        {
            i = inventorySlot - 100 + 1;

            if (i < 0 || i >= this.equipment.length)
            {
                return false;
            }
        }

        if (itemStackIn != null && getArmorPosition(itemStackIn) != i && (i != 4 || !(itemStackIn.func_77973_b() instanceof ItemBlock)))
        {
            return false;
        }
        else
        {
            this.setCurrentItemOrArmor(i, itemStackIn);
            return true;
        }
    }

    /**
     * Returns whether the entity is in a server world
     */
    public boolean isServerWorld()
    {
        return super.isServerWorld() && !this.isAIDisabled();
    }

    /**
     * Set whether this Entity's AI is disabled
     */
    public void setNoAI(boolean disable)
    {
        this.dataWatcher.updateObject(15, Byte.valueOf((byte)(disable ? 1 : 0)));
    }

    /**
     * Get whether this Entity's AI is disabled
     */
    public boolean isAIDisabled()
    {
        return this.dataWatcher.getWatchableObjectByte(15) != 0;
    }

    public static enum SpawnPlacementType
    {
        ON_GROUND,
        IN_AIR,
        IN_WATER;
    }
}