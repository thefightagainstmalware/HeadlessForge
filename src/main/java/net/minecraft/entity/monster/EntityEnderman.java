package net.minecraft.entity.monster;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityEnderman extends EntityMob
{
    private static final UUID attackingSpeedBoostModifierUUID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
    private static final AttributeModifier attackingSpeedBoostModifier = (new AttributeModifier(attackingSpeedBoostModifierUUID, "Attacking speed boost", 0.15000000596046448D, 0)).setSaved(false);
    private static final Set<Block> carriableBlocks = Sets.<Block>newIdentityHashSet();
    private boolean isAggressive;

    public EntityEnderman(World worldIn)
    {
        super(worldIn);
        this.setSize(0.6F, 2.9F);
        this.stepHeight = 1.0F;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, 1.0D, false));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(10, new EntityEnderman.AIPlaceBlock(this));
        this.tasks.addTask(11, new EntityEnderman.AITakeBlock(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityEnderman.AIFindPlayer(this));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityEndermite.class, 10, true, false, new Predicate<EntityEndermite>()
        {
            public boolean apply(EntityEndermite p_apply_1_)
            {
                return p_apply_1_.isSpawnedByPlayer();
            }
        }));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(64.0D);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Short((short)0));
        this.dataWatcher.addObject(17, new Byte((byte)0));
        this.dataWatcher.addObject(18, new Byte((byte)0));
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        super.writeEntityToNBT(tagCompound);
        IBlockState iblockstate = this.getHeldBlockState();
        tagCompound.setShort("carried", (short)Block.func_149682_b(iblockstate.func_177230_c()));
        tagCompound.setShort("carriedData", (short)iblockstate.func_177230_c().func_176201_c(iblockstate));
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        super.readEntityFromNBT(tagCompund);
        IBlockState iblockstate;

        if (tagCompund.func_150297_b("carried", 8))
        {
            iblockstate = Block.func_149684_b(tagCompund.getString("carried")).func_176203_a(tagCompund.func_74765_d("carriedData") & 65535);
        }
        else
        {
            iblockstate = Block.getBlockById(tagCompund.func_74765_d("carried")).func_176203_a(tagCompund.func_74765_d("carriedData") & 65535);
        }

        this.setHeldBlockState(iblockstate);
    }

    /**
     * Checks to see if this enderman should be attacking this player
     */
    private boolean shouldAttackPlayer(EntityPlayer player)
    {
        ItemStack itemstack = player.field_71071_by.armorInventory[3];

        if (itemstack != null && itemstack.func_77973_b() == Item.func_150898_a(Blocks.field_150423_aK))
        {
            return false;
        }
        else
        {
            Vec3 vec3 = player.getLook(1.0F).normalize();
            Vec3 vec31 = new Vec3(this.field_70165_t - player.field_70165_t, this.getEntityBoundingBox().minY + (double)(this.height / 2.0F) - (player.field_70163_u + (double)player.getEyeHeight()), this.field_70161_v - player.field_70161_v);
            double d0 = vec31.lengthVector();
            vec31 = vec31.normalize();
            double d1 = vec3.dotProduct(vec31);
            return d1 > 1.0D - 0.025D / d0 ? player.canEntityBeSeen(this) : false;
        }
    }

    public float getEyeHeight()
    {
        return 2.55F;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        if (this.field_70170_p.isRemote)
        {
            for (int i = 0; i < 2; ++i)
            {
                this.field_70170_p.spawnParticle(EnumParticleTypes.PORTAL, this.field_70165_t + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.field_70163_u + this.rand.nextDouble() * (double)this.height - 0.25D, this.field_70161_v + (this.rand.nextDouble() - 0.5D) * (double)this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D, new int[0]);
            }
        }

        this.isJumping = false;
        super.onLivingUpdate();
    }

    protected void updateAITasks()
    {
        if (this.isWet())
        {
            this.attackEntityFrom(DamageSource.drown, 1.0F);
        }

        if (this.isScreaming() && !this.isAggressive && this.rand.nextInt(100) == 0)
        {
            this.setScreaming(false);
        }

        if (this.field_70170_p.isDaytime())
        {
            float f = this.getBrightness(1.0F);

            if (f > 0.5F && this.field_70170_p.canSeeSky(new BlockPos(this)) && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F)
            {
                this.setAttackTarget((EntityLivingBase)null);
                this.setScreaming(false);
                this.isAggressive = false;
                this.teleportRandomly();
            }
        }

        super.updateAITasks();
    }

    /**
     * Teleport the enderman to a random nearby position
     */
    protected boolean teleportRandomly()
    {
        double d0 = this.field_70165_t + (this.rand.nextDouble() - 0.5D) * 64.0D;
        double d1 = this.field_70163_u + (double)(this.rand.nextInt(64) - 32);
        double d2 = this.field_70161_v + (this.rand.nextDouble() - 0.5D) * 64.0D;
        return this.teleportTo(d0, d1, d2);
    }

    /**
     * Teleport the enderman to another entity
     */
    protected boolean teleportToEntity(Entity p_70816_1_)
    {
        Vec3 vec3 = new Vec3(this.field_70165_t - p_70816_1_.field_70165_t, this.getEntityBoundingBox().minY + (double)(this.height / 2.0F) - p_70816_1_.field_70163_u + (double)p_70816_1_.getEyeHeight(), this.field_70161_v - p_70816_1_.field_70161_v);
        vec3 = vec3.normalize();
        double d0 = 16.0D;
        double d1 = this.field_70165_t + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.field_72450_a * d0;
        double d2 = this.field_70163_u + (double)(this.rand.nextInt(16) - 8) - vec3.field_72448_b * d0;
        double d3 = this.field_70161_v + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.field_72449_c * d0;
        return this.teleportTo(d1, d2, d3);
    }

    /**
     * Teleport the enderman
     */
    protected boolean teleportTo(double x, double y, double z)
    {
        double d0 = this.field_70165_t;
        double d1 = this.field_70163_u;
        double d2 = this.field_70161_v;
        this.field_70165_t = x;
        this.field_70163_u = y;
        this.field_70161_v = z;
        boolean flag = false;
        BlockPos blockpos = new BlockPos(this.field_70165_t, this.field_70163_u, this.field_70161_v);

        if (this.field_70170_p.func_175667_e(blockpos))
        {
            boolean flag1 = false;

            while (!flag1 && blockpos.func_177956_o() > 0)
            {
                BlockPos blockpos1 = blockpos.func_177977_b();
                Block block = this.field_70170_p.func_180495_p(blockpos1).func_177230_c();

                if (block.func_149688_o().blocksMovement())
                {
                    flag1 = true;
                }
                else
                {
                    --this.field_70163_u;
                    blockpos = blockpos1;
                }
            }

            if (flag1)
            {
                super.func_70634_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);

                if (this.field_70170_p.getCollidingBoundingBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.field_70170_p.isAnyLiquid(this.getEntityBoundingBox()))
                {
                    flag = true;
                }
            }
        }

        if (!flag)
        {
            this.setPosition(d0, d1, d2);
            return false;
        }
        else
        {
            int i = 128;

            for (int j = 0; j < i; ++j)
            {
                double d6 = (double)j / ((double)i - 1.0D);
                float f = (this.rand.nextFloat() - 0.5F) * 0.2F;
                float f1 = (this.rand.nextFloat() - 0.5F) * 0.2F;
                float f2 = (this.rand.nextFloat() - 0.5F) * 0.2F;
                double d3 = d0 + (this.field_70165_t - d0) * d6 + (this.rand.nextDouble() - 0.5D) * (double)this.width * 2.0D;
                double d4 = d1 + (this.field_70163_u - d1) * d6 + this.rand.nextDouble() * (double)this.height;
                double d5 = d2 + (this.field_70161_v - d2) * d6 + (this.rand.nextDouble() - 0.5D) * (double)this.width * 2.0D;
                this.field_70170_p.spawnParticle(EnumParticleTypes.PORTAL, d3, d4, d5, (double)f, (double)f1, (double)f2, new int[0]);
            }

            this.field_70170_p.playSoundEffect(d0, d1, d2, "mob.endermen.portal", 1.0F, 1.0F);
            this.playSound("mob.endermen.portal", 1.0F, 1.0F);
            return true;
        }
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return this.isScreaming() ? "mob.endermen.scream" : "mob.endermen.idle";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.endermen.hit";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.endermen.death";
    }

    protected Item getDropItem()
    {
        return Items.field_151079_bi;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        Item item = this.getDropItem();

        if (item != null)
        {
            int i = this.rand.nextInt(2 + p_70628_2_);

            for (int j = 0; j < i; ++j)
            {
                this.dropItem(item, 1);
            }
        }
    }

    /**
     * Sets this enderman's held block state
     */
    public void setHeldBlockState(IBlockState state)
    {
        this.dataWatcher.updateObject(16, Short.valueOf((short)(Block.func_176210_f(state) & 65535)));
    }

    /**
     * Gets this enderman's held block state
     */
    public IBlockState getHeldBlockState()
    {
        return Block.getStateById(this.dataWatcher.getWatchableObjectShort(16) & 65535);
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
        else
        {
            if (source.getEntity() == null || !(source.getEntity() instanceof EntityEndermite))
            {
                if (!this.field_70170_p.isRemote)
                {
                    this.setScreaming(true);
                }

                if (source instanceof EntityDamageSource && source.getEntity() instanceof EntityPlayer)
                {
                    if (source.getEntity() instanceof EntityPlayerMP && ((EntityPlayerMP)source.getEntity()).field_71134_c.func_73083_d())
                    {
                        this.setScreaming(false);
                    }
                    else
                    {
                        this.isAggressive = true;
                    }
                }

                if (source instanceof EntityDamageSourceIndirect)
                {
                    this.isAggressive = false;

                    for (int i = 0; i < 64; ++i)
                    {
                        if (this.teleportRandomly())
                        {
                            return true;
                        }
                    }

                    return false;
                }
            }

            boolean flag = super.attackEntityFrom(source, amount);

            if (source.isUnblockable() && this.rand.nextInt(10) != 0)
            {
                this.teleportRandomly();
            }

            return flag;
        }
    }

    public boolean isScreaming()
    {
        return this.dataWatcher.getWatchableObjectByte(18) > 0;
    }

    public void setScreaming(boolean screaming)
    {
        this.dataWatcher.updateObject(18, Byte.valueOf((byte)(screaming ? 1 : 0)));
    }

    static
    {
        carriableBlocks.add(Blocks.field_150349_c);
        carriableBlocks.add(Blocks.field_150346_d);
        carriableBlocks.add(Blocks.sand);
        carriableBlocks.add(Blocks.field_150351_n);
        carriableBlocks.add(Blocks.yellow_flower);
        carriableBlocks.add(Blocks.red_flower);
        carriableBlocks.add(Blocks.brown_mushroom);
        carriableBlocks.add(Blocks.red_mushroom);
        carriableBlocks.add(Blocks.field_150335_W);
        carriableBlocks.add(Blocks.cactus);
        carriableBlocks.add(Blocks.clay);
        carriableBlocks.add(Blocks.field_150423_aK);
        carriableBlocks.add(Blocks.melon_block);
        carriableBlocks.add(Blocks.mycelium);
    }

    static class AIFindPlayer extends EntityAINearestAttackableTarget
    {
        private EntityPlayer player;
        private int field_179450_h;
        private int field_179451_i;
        private EntityEnderman enderman;

        public AIFindPlayer(EntityEnderman p_i45842_1_)
        {
            super(p_i45842_1_, EntityPlayer.class, true);
            this.enderman = p_i45842_1_;
        }

        public boolean shouldExecute()
        {
            double d0 = this.getTargetDistance();
            List<EntityPlayer> list = this.taskOwner.field_70170_p.<EntityPlayer>getEntitiesWithinAABB(EntityPlayer.class, this.taskOwner.getEntityBoundingBox().expand(d0, 4.0D, d0), this.targetEntitySelector);
            Collections.sort(list, this.theNearestAttackableTargetSorter);

            if (list.isEmpty())
            {
                return false;
            }
            else
            {
                this.player = (EntityPlayer)list.get(0);
                return true;
            }
        }

        public void startExecuting()
        {
            this.field_179450_h = 5;
            this.field_179451_i = 0;
        }

        public void resetTask()
        {
            this.player = null;
            this.enderman.setScreaming(false);
            IAttributeInstance iattributeinstance = this.enderman.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
            iattributeinstance.removeModifier(EntityEnderman.attackingSpeedBoostModifier);
            super.resetTask();
        }

        public boolean continueExecuting()
        {
            if (this.player != null)
            {
                if (!this.enderman.shouldAttackPlayer(this.player))
                {
                    return false;
                }
                else
                {
                    this.enderman.isAggressive = true;
                    this.enderman.faceEntity(this.player, 10.0F, 10.0F);
                    return true;
                }
            }
            else
            {
                return super.continueExecuting();
            }
        }

        public void updateTask()
        {
            if (this.player != null)
            {
                if (--this.field_179450_h <= 0)
                {
                    this.targetEntity = this.player;
                    this.player = null;
                    super.startExecuting();
                    this.enderman.playSound("mob.endermen.stare", 1.0F, 1.0F);
                    this.enderman.setScreaming(true);
                    IAttributeInstance iattributeinstance = this.enderman.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
                    iattributeinstance.applyModifier(EntityEnderman.attackingSpeedBoostModifier);
                }
            }
            else
            {
                if (this.targetEntity != null)
                {
                    if (this.targetEntity instanceof EntityPlayer && this.enderman.shouldAttackPlayer((EntityPlayer)this.targetEntity))
                    {
                        if (this.targetEntity.getDistanceSqToEntity(this.enderman) < 16.0D)
                        {
                            this.enderman.teleportRandomly();
                        }

                        this.field_179451_i = 0;
                    }
                    else if (this.targetEntity.getDistanceSqToEntity(this.enderman) > 256.0D && this.field_179451_i++ >= 30 && this.enderman.teleportToEntity(this.targetEntity))
                    {
                        this.field_179451_i = 0;
                    }
                }

                super.updateTask();
            }
        }
    }

    static class AIPlaceBlock extends EntityAIBase
    {
        private EntityEnderman enderman;

        public AIPlaceBlock(EntityEnderman p_i45843_1_)
        {
            this.enderman = p_i45843_1_;
        }

        public boolean shouldExecute()
        {
            return !this.enderman.field_70170_p.func_82736_K().func_82766_b("mobGriefing") ? false : (this.enderman.getHeldBlockState().func_177230_c().func_149688_o() == Material.field_151579_a ? false : this.enderman.func_70681_au().nextInt(2000) == 0);
        }

        public void updateTask()
        {
            Random random = this.enderman.func_70681_au();
            World world = this.enderman.field_70170_p;
            int i = MathHelper.func_76128_c(this.enderman.field_70165_t - 1.0D + random.nextDouble() * 2.0D);
            int j = MathHelper.func_76128_c(this.enderman.field_70163_u + random.nextDouble() * 2.0D);
            int k = MathHelper.func_76128_c(this.enderman.field_70161_v - 1.0D + random.nextDouble() * 2.0D);
            BlockPos blockpos = new BlockPos(i, j, k);
            Block block = world.func_180495_p(blockpos).func_177230_c();
            Block block1 = world.func_180495_p(blockpos.func_177977_b()).func_177230_c();

            if (this.func_179474_a(world, blockpos, this.enderman.getHeldBlockState().func_177230_c(), block, block1))
            {
                world.func_180501_a(blockpos, this.enderman.getHeldBlockState(), 3);
                this.enderman.setHeldBlockState(Blocks.field_150350_a.func_176223_P());
            }
        }

        private boolean func_179474_a(World worldIn, BlockPos p_179474_2_, Block p_179474_3_, Block p_179474_4_, Block p_179474_5_)
        {
            return !p_179474_3_.canPlaceBlockAt(worldIn, p_179474_2_) ? false : (p_179474_4_.func_149688_o() != Material.field_151579_a ? false : (p_179474_5_.func_149688_o() == Material.field_151579_a ? false : p_179474_5_.func_149686_d()));
        }
    }

    static class AITakeBlock extends EntityAIBase
    {
        private EntityEnderman enderman;

        public AITakeBlock(EntityEnderman p_i45841_1_)
        {
            this.enderman = p_i45841_1_;
        }

        public boolean shouldExecute()
        {
            return !this.enderman.field_70170_p.func_82736_K().func_82766_b("mobGriefing") ? false : (this.enderman.getHeldBlockState().func_177230_c().func_149688_o() != Material.field_151579_a ? false : this.enderman.func_70681_au().nextInt(20) == 0);
        }

        public void updateTask()
        {
            Random random = this.enderman.func_70681_au();
            World world = this.enderman.field_70170_p;
            int i = MathHelper.func_76128_c(this.enderman.field_70165_t - 2.0D + random.nextDouble() * 4.0D);
            int j = MathHelper.func_76128_c(this.enderman.field_70163_u + random.nextDouble() * 3.0D);
            int k = MathHelper.func_76128_c(this.enderman.field_70161_v - 2.0D + random.nextDouble() * 4.0D);
            BlockPos blockpos = new BlockPos(i, j, k);
            IBlockState iblockstate = world.func_180495_p(blockpos);
            Block block = iblockstate.func_177230_c();

            if (EntityEnderman.carriableBlocks.contains(block))
            {
                this.enderman.setHeldBlockState(iblockstate);
                world.setBlockState(blockpos, Blocks.field_150350_a.func_176223_P());
            }
        }
    }
}
