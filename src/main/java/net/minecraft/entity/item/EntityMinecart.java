package net.minecraft.entity.item;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.BlockRailPowered;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityMinecartCommandBlock;
import net.minecraft.entity.ai.EntityMinecartMobSpawner;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.IWorldNameable;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public abstract class EntityMinecart extends Entity implements IWorldNameable
{
    private boolean isInReverse;
    private String entityName;

    /** Minecart rotational logic matrix */
    private static final int[][][] matrix = new int[][][] {{{0, 0, -1}, {0, 0, 1}}, {{ -1, 0, 0}, {1, 0, 0}}, {{ -1, -1, 0}, {1, 0, 0}}, {{ -1, 0, 0}, {1, -1, 0}}, {{0, 0, -1}, {0, -1, 1}}, {{0, -1, -1}, {0, 0, 1}}, {{0, 0, 1}, {1, 0, 0}}, {{0, 0, 1}, { -1, 0, 0}}, {{0, 0, -1}, { -1, 0, 0}}, {{0, 0, -1}, {1, 0, 0}}};

    /** appears to be the progress of the turn */
    private int turnProgress;
    private double minecartX;
    private double minecartY;
    private double minecartZ;
    private double minecartYaw;
    private double minecartPitch;
    private double velocityX;
    private double velocityY;
    private double velocityZ;

    public EntityMinecart(World worldIn)
    {
        super(worldIn);
        this.preventEntitySpawning = true;
        this.setSize(0.98F, 0.7F);
    }

    public static EntityMinecart func_180458_a(World worldIn, double p_180458_1_, double p_180458_3_, double p_180458_5_, EntityMinecart.EnumMinecartType p_180458_7_)
    {
        switch (p_180458_7_)
        {
            case CHEST:
                return new EntityMinecartChest(worldIn, p_180458_1_, p_180458_3_, p_180458_5_);

            case FURNACE:
                return new EntityMinecartFurnace(worldIn, p_180458_1_, p_180458_3_, p_180458_5_);

            case TNT:
                return new EntityMinecartTNT(worldIn, p_180458_1_, p_180458_3_, p_180458_5_);

            case SPAWNER:
                return new EntityMinecartMobSpawner(worldIn, p_180458_1_, p_180458_3_, p_180458_5_);

            case HOPPER:
                return new EntityMinecartHopper(worldIn, p_180458_1_, p_180458_3_, p_180458_5_);

            case COMMAND_BLOCK:
                return new EntityMinecartCommandBlock(worldIn, p_180458_1_, p_180458_3_, p_180458_5_);

            default:
                return new EntityMinecartEmpty(worldIn, p_180458_1_, p_180458_3_, p_180458_5_);
        }
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return false;
    }

    protected void entityInit()
    {
        this.dataWatcher.addObject(17, new Integer(0));
        this.dataWatcher.addObject(18, new Integer(1));
        this.dataWatcher.addObject(19, new Float(0.0F));
        this.dataWatcher.addObject(20, new Integer(0));
        this.dataWatcher.addObject(21, new Integer(6));
        this.dataWatcher.addObject(22, Byte.valueOf((byte)0));
    }

    /**
     * Returns a boundingBox used to collide the entity with other entities and blocks. This enables the entity to be
     * pushable on contact, like boats or minecarts.
     */
    public AxisAlignedBB getCollisionBox(Entity entityIn)
    {
        return entityIn.canBePushed() ? entityIn.getEntityBoundingBox() : null;
    }

    /**
     * Returns the collision bounding box for this entity
     */
    public AxisAlignedBB getCollisionBoundingBox()
    {
        return null;
    }

    /**
     * Returns true if this entity should push and be pushed by other entities when colliding.
     */
    public boolean canBePushed()
    {
        return true;
    }

    public EntityMinecart(World worldIn, double x, double y, double z)
    {
        this(worldIn);
        this.setPosition(x, y, z);
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
    }

    /**
     * Returns the Y offset from the entity's position for any entity riding this one.
     */
    public double getMountedYOffset()
    {
        return 0.0D;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (!this.field_70170_p.isRemote && !this.isDead)
        {
            if (this.isEntityInvulnerable(source))
            {
                return false;
            }
            else
            {
                this.setRollingDirection(-this.getRollingDirection());
                this.setRollingAmplitude(10);
                this.setBeenAttacked();
                this.setDamage(this.getDamage() + amount * 10.0F);
                boolean flag = source.getEntity() instanceof EntityPlayer && ((EntityPlayer)source.getEntity()).field_71075_bZ.field_75098_d;

                if (flag || this.getDamage() > 40.0F)
                {
                    if (this.riddenByEntity != null)
                    {
                        this.riddenByEntity.func_70078_a((Entity)null);
                    }

                    if (flag && !this.hasCustomName())
                    {
                        this.setDead();
                    }
                    else
                    {
                        this.killMinecart(source);
                    }
                }

                return true;
            }
        }
        else
        {
            return true;
        }
    }

    public void killMinecart(DamageSource p_94095_1_)
    {
        this.setDead();

        if (this.field_70170_p.func_82736_K().func_82766_b("doEntityDrops"))
        {
            ItemStack itemstack = new ItemStack(Items.minecart, 1);

            if (this.entityName != null)
            {
                itemstack.func_151001_c(this.entityName);
            }

            this.entityDropItem(itemstack, 0.0F);
        }
    }

    /**
     * Setups the entity to do the hurt animation. Only used by packets in multiplayer.
     */
    public void performHurtAnimation()
    {
        this.setRollingDirection(-this.getRollingDirection());
        this.setRollingAmplitude(10);
        this.setDamage(this.getDamage() + this.getDamage() * 10.0F);
    }

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    public boolean canBeCollidedWith()
    {
        return !this.isDead;
    }

    /**
     * Will get destroyed next tick.
     */
    public void setDead()
    {
        super.setDead();
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        if (this.getRollingAmplitude() > 0)
        {
            this.setRollingAmplitude(this.getRollingAmplitude() - 1);
        }

        if (this.getDamage() > 0.0F)
        {
            this.setDamage(this.getDamage() - 1.0F);
        }

        if (this.field_70163_u < -64.0D)
        {
            this.kill();
        }

        if (!this.field_70170_p.isRemote && this.field_70170_p instanceof WorldServer)
        {
            this.field_70170_p.theProfiler.startSection("portal");
            MinecraftServer minecraftserver = ((WorldServer)this.field_70170_p).getMinecraftServer();
            int i = this.getMaxInPortalTime();

            if (this.inPortal)
            {
                if (minecraftserver.getAllowNether())
                {
                    if (this.ridingEntity == null && this.portalCounter++ >= i)
                    {
                        this.portalCounter = i;
                        this.timeUntilPortal = this.getPortalCooldown();
                        int j;

                        if (this.field_70170_p.provider.getDimensionId() == -1)
                        {
                            j = 0;
                        }
                        else
                        {
                            j = -1;
                        }

                        this.travelToDimension(j);
                    }

                    this.inPortal = false;
                }
            }
            else
            {
                if (this.portalCounter > 0)
                {
                    this.portalCounter -= 4;
                }

                if (this.portalCounter < 0)
                {
                    this.portalCounter = 0;
                }
            }

            if (this.timeUntilPortal > 0)
            {
                --this.timeUntilPortal;
            }

            this.field_70170_p.theProfiler.endSection();
        }

        if (this.field_70170_p.isRemote)
        {
            if (this.turnProgress > 0)
            {
                double d4 = this.field_70165_t + (this.minecartX - this.field_70165_t) / (double)this.turnProgress;
                double d5 = this.field_70163_u + (this.minecartY - this.field_70163_u) / (double)this.turnProgress;
                double d6 = this.field_70161_v + (this.minecartZ - this.field_70161_v) / (double)this.turnProgress;
                double d1 = MathHelper.func_76138_g(this.minecartYaw - (double)this.field_70177_z);
                this.field_70177_z = (float)((double)this.field_70177_z + d1 / (double)this.turnProgress);
                this.field_70125_A = (float)((double)this.field_70125_A + (this.minecartPitch - (double)this.field_70125_A) / (double)this.turnProgress);
                --this.turnProgress;
                this.setPosition(d4, d5, d6);
                this.setRotation(this.field_70177_z, this.field_70125_A);
            }
            else
            {
                this.setPosition(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                this.setRotation(this.field_70177_z, this.field_70125_A);
            }
        }
        else
        {
            this.prevPosX = this.field_70165_t;
            this.prevPosY = this.field_70163_u;
            this.prevPosZ = this.field_70161_v;
            this.motionY -= 0.03999999910593033D;
            int k = MathHelper.func_76128_c(this.field_70165_t);
            int l = MathHelper.func_76128_c(this.field_70163_u);
            int i1 = MathHelper.func_76128_c(this.field_70161_v);

            if (BlockRailBase.isRailBlock(this.field_70170_p, new BlockPos(k, l - 1, i1)))
            {
                --l;
            }

            BlockPos blockpos = new BlockPos(k, l, i1);
            IBlockState iblockstate = this.field_70170_p.func_180495_p(blockpos);

            if (BlockRailBase.isRailBlock(iblockstate))
            {
                this.func_180460_a(blockpos, iblockstate);

                if (iblockstate.func_177230_c() == Blocks.activator_rail)
                {
                    this.onActivatorRailPass(k, l, i1, ((Boolean)iblockstate.getValue(BlockRailPowered.POWERED)).booleanValue());
                }
            }
            else
            {
                this.moveDerailedMinecart();
            }

            this.doBlockCollisions();
            this.field_70125_A = 0.0F;
            double d0 = this.prevPosX - this.field_70165_t;
            double d2 = this.prevPosZ - this.field_70161_v;

            if (d0 * d0 + d2 * d2 > 0.001D)
            {
                this.field_70177_z = (float)(MathHelper.func_181159_b(d2, d0) * 180.0D / Math.PI);

                if (this.isInReverse)
                {
                    this.field_70177_z += 180.0F;
                }
            }

            double d3 = (double)MathHelper.func_76142_g(this.field_70177_z - this.prevRotationYaw);

            if (d3 < -170.0D || d3 >= 170.0D)
            {
                this.field_70177_z += 180.0F;
                this.isInReverse = !this.isInReverse;
            }

            this.setRotation(this.field_70177_z, this.field_70125_A);

            for (Entity entity : this.field_70170_p.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(0.20000000298023224D, 0.0D, 0.20000000298023224D)))
            {
                if (entity != this.riddenByEntity && entity.canBePushed() && entity instanceof EntityMinecart)
                {
                    entity.applyEntityCollision(this);
                }
            }

            if (this.riddenByEntity != null && this.riddenByEntity.isDead)
            {
                if (this.riddenByEntity.ridingEntity == this)
                {
                    this.riddenByEntity.ridingEntity = null;
                }

                this.riddenByEntity = null;
            }

            this.handleWaterMovement();
        }
    }

    /**
     * Get's the maximum speed for a minecart
     */
    protected double getMaximumSpeed()
    {
        return 0.4D;
    }

    /**
     * Called every tick the minecart is on an activator rail. Args: x, y, z, is the rail receiving power
     */
    public void onActivatorRailPass(int x, int y, int z, boolean receivingPower)
    {
    }

    /**
     * Moves a minecart that is not attached to a rail
     */
    protected void moveDerailedMinecart()
    {
        double d0 = this.getMaximumSpeed();
        this.motionX = MathHelper.clamp_double(this.motionX, -d0, d0);
        this.motionZ = MathHelper.clamp_double(this.motionZ, -d0, d0);

        if (this.onGround)
        {
            this.motionX *= 0.5D;
            this.motionY *= 0.5D;
            this.motionZ *= 0.5D;
        }

        this.moveEntity(this.motionX, this.motionY, this.motionZ);

        if (!this.onGround)
        {
            this.motionX *= 0.949999988079071D;
            this.motionY *= 0.949999988079071D;
            this.motionZ *= 0.949999988079071D;
        }
    }

    @SuppressWarnings("incomplete-switch")
    protected void func_180460_a(BlockPos p_180460_1_, IBlockState p_180460_2_)
    {
        this.field_70143_R = 0.0F;
        Vec3 vec3 = this.func_70489_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.field_70163_u = (double)p_180460_1_.func_177956_o();
        boolean flag = false;
        boolean flag1 = false;
        BlockRailBase blockrailbase = (BlockRailBase)p_180460_2_.func_177230_c();

        if (blockrailbase == Blocks.golden_rail)
        {
            flag = ((Boolean)p_180460_2_.getValue(BlockRailPowered.POWERED)).booleanValue();
            flag1 = !flag;
        }

        double d0 = 0.0078125D;
        BlockRailBase.EnumRailDirection blockrailbase$enumraildirection = (BlockRailBase.EnumRailDirection)p_180460_2_.getValue(blockrailbase.getShapeProperty());

        switch (blockrailbase$enumraildirection)
        {
            case ASCENDING_EAST:
                this.motionX -= 0.0078125D;
                ++this.field_70163_u;
                break;

            case ASCENDING_WEST:
                this.motionX += 0.0078125D;
                ++this.field_70163_u;
                break;

            case ASCENDING_NORTH:
                this.motionZ += 0.0078125D;
                ++this.field_70163_u;
                break;

            case ASCENDING_SOUTH:
                this.motionZ -= 0.0078125D;
                ++this.field_70163_u;
        }

        int[][] aint = matrix[blockrailbase$enumraildirection.getMetadata()];
        double d1 = (double)(aint[1][0] - aint[0][0]);
        double d2 = (double)(aint[1][2] - aint[0][2]);
        double d3 = Math.sqrt(d1 * d1 + d2 * d2);
        double d4 = this.motionX * d1 + this.motionZ * d2;

        if (d4 < 0.0D)
        {
            d1 = -d1;
            d2 = -d2;
        }

        double d5 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);

        if (d5 > 2.0D)
        {
            d5 = 2.0D;
        }

        this.motionX = d5 * d1 / d3;
        this.motionZ = d5 * d2 / d3;

        if (this.riddenByEntity instanceof EntityLivingBase)
        {
            double d6 = (double)((EntityLivingBase)this.riddenByEntity).moveForward;

            if (d6 > 0.0D)
            {
                double d7 = -Math.sin((double)(this.riddenByEntity.field_70177_z * (float)Math.PI / 180.0F));
                double d8 = Math.cos((double)(this.riddenByEntity.field_70177_z * (float)Math.PI / 180.0F));
                double d9 = this.motionX * this.motionX + this.motionZ * this.motionZ;

                if (d9 < 0.01D)
                {
                    this.motionX += d7 * 0.1D;
                    this.motionZ += d8 * 0.1D;
                    flag1 = false;
                }
            }
        }

        if (flag1)
        {
            double d17 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);

            if (d17 < 0.03D)
            {
                this.motionX *= 0.0D;
                this.motionY *= 0.0D;
                this.motionZ *= 0.0D;
            }
            else
            {
                this.motionX *= 0.5D;
                this.motionY *= 0.0D;
                this.motionZ *= 0.5D;
            }
        }

        double d18 = 0.0D;
        double d19 = (double)p_180460_1_.func_177958_n() + 0.5D + (double)aint[0][0] * 0.5D;
        double d20 = (double)p_180460_1_.func_177952_p() + 0.5D + (double)aint[0][2] * 0.5D;
        double d21 = (double)p_180460_1_.func_177958_n() + 0.5D + (double)aint[1][0] * 0.5D;
        double d10 = (double)p_180460_1_.func_177952_p() + 0.5D + (double)aint[1][2] * 0.5D;
        d1 = d21 - d19;
        d2 = d10 - d20;

        if (d1 == 0.0D)
        {
            this.field_70165_t = (double)p_180460_1_.func_177958_n() + 0.5D;
            d18 = this.field_70161_v - (double)p_180460_1_.func_177952_p();
        }
        else if (d2 == 0.0D)
        {
            this.field_70161_v = (double)p_180460_1_.func_177952_p() + 0.5D;
            d18 = this.field_70165_t - (double)p_180460_1_.func_177958_n();
        }
        else
        {
            double d11 = this.field_70165_t - d19;
            double d12 = this.field_70161_v - d20;
            d18 = (d11 * d1 + d12 * d2) * 2.0D;
        }

        this.field_70165_t = d19 + d1 * d18;
        this.field_70161_v = d20 + d2 * d18;
        this.setPosition(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        double d22 = this.motionX;
        double d23 = this.motionZ;

        if (this.riddenByEntity != null)
        {
            d22 *= 0.75D;
            d23 *= 0.75D;
        }

        double d13 = this.getMaximumSpeed();
        d22 = MathHelper.clamp_double(d22, -d13, d13);
        d23 = MathHelper.clamp_double(d23, -d13, d13);
        this.moveEntity(d22, 0.0D, d23);

        if (aint[0][1] != 0 && MathHelper.func_76128_c(this.field_70165_t) - p_180460_1_.func_177958_n() == aint[0][0] && MathHelper.func_76128_c(this.field_70161_v) - p_180460_1_.func_177952_p() == aint[0][2])
        {
            this.setPosition(this.field_70165_t, this.field_70163_u + (double)aint[0][1], this.field_70161_v);
        }
        else if (aint[1][1] != 0 && MathHelper.func_76128_c(this.field_70165_t) - p_180460_1_.func_177958_n() == aint[1][0] && MathHelper.func_76128_c(this.field_70161_v) - p_180460_1_.func_177952_p() == aint[1][2])
        {
            this.setPosition(this.field_70165_t, this.field_70163_u + (double)aint[1][1], this.field_70161_v);
        }

        this.applyDrag();
        Vec3 vec31 = this.func_70489_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);

        if (vec31 != null && vec3 != null)
        {
            double d14 = (vec3.field_72448_b - vec31.field_72448_b) * 0.05D;
            d5 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);

            if (d5 > 0.0D)
            {
                this.motionX = this.motionX / d5 * (d5 + d14);
                this.motionZ = this.motionZ / d5 * (d5 + d14);
            }

            this.setPosition(this.field_70165_t, vec31.field_72448_b, this.field_70161_v);
        }

        int j = MathHelper.func_76128_c(this.field_70165_t);
        int i = MathHelper.func_76128_c(this.field_70161_v);

        if (j != p_180460_1_.func_177958_n() || i != p_180460_1_.func_177952_p())
        {
            d5 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.motionX = d5 * (double)(j - p_180460_1_.func_177958_n());
            this.motionZ = d5 * (double)(i - p_180460_1_.func_177952_p());
        }

        if (flag)
        {
            double d15 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);

            if (d15 > 0.01D)
            {
                double d16 = 0.06D;
                this.motionX += this.motionX / d15 * d16;
                this.motionZ += this.motionZ / d15 * d16;
            }
            else if (blockrailbase$enumraildirection == BlockRailBase.EnumRailDirection.EAST_WEST)
            {
                if (this.field_70170_p.func_180495_p(p_180460_1_.west()).func_177230_c().isNormalCube())
                {
                    this.motionX = 0.02D;
                }
                else if (this.field_70170_p.func_180495_p(p_180460_1_.east()).func_177230_c().isNormalCube())
                {
                    this.motionX = -0.02D;
                }
            }
            else if (blockrailbase$enumraildirection == BlockRailBase.EnumRailDirection.NORTH_SOUTH)
            {
                if (this.field_70170_p.func_180495_p(p_180460_1_.north()).func_177230_c().isNormalCube())
                {
                    this.motionZ = 0.02D;
                }
                else if (this.field_70170_p.func_180495_p(p_180460_1_.south()).func_177230_c().isNormalCube())
                {
                    this.motionZ = -0.02D;
                }
            }
        }
    }

    protected void applyDrag()
    {
        if (this.riddenByEntity != null)
        {
            this.motionX *= 0.996999979019165D;
            this.motionY *= 0.0D;
            this.motionZ *= 0.996999979019165D;
        }
        else
        {
            this.motionX *= 0.9599999785423279D;
            this.motionY *= 0.0D;
            this.motionZ *= 0.9599999785423279D;
        }
    }

    /**
     * Sets the x,y,z of the entity from the given parameters. Also seems to set up a bounding box.
     */
    public void setPosition(double x, double y, double z)
    {
        this.field_70165_t = x;
        this.field_70163_u = y;
        this.field_70161_v = z;
        float f = this.width / 2.0F;
        float f1 = this.height;
        this.setEntityBoundingBox(new AxisAlignedBB(x - (double)f, y, z - (double)f, x + (double)f, y + (double)f1, z + (double)f));
    }

    public Vec3 func_70495_a(double p_70495_1_, double p_70495_3_, double p_70495_5_, double p_70495_7_)
    {
        int i = MathHelper.func_76128_c(p_70495_1_);
        int j = MathHelper.func_76128_c(p_70495_3_);
        int k = MathHelper.func_76128_c(p_70495_5_);

        if (BlockRailBase.isRailBlock(this.field_70170_p, new BlockPos(i, j - 1, k)))
        {
            --j;
        }

        IBlockState iblockstate = this.field_70170_p.func_180495_p(new BlockPos(i, j, k));

        if (BlockRailBase.isRailBlock(iblockstate))
        {
            BlockRailBase.EnumRailDirection blockrailbase$enumraildirection = (BlockRailBase.EnumRailDirection)iblockstate.getValue(((BlockRailBase)iblockstate.func_177230_c()).getShapeProperty());
            p_70495_3_ = (double)j;

            if (blockrailbase$enumraildirection.isAscending())
            {
                p_70495_3_ = (double)(j + 1);
            }

            int[][] aint = matrix[blockrailbase$enumraildirection.getMetadata()];
            double d0 = (double)(aint[1][0] - aint[0][0]);
            double d1 = (double)(aint[1][2] - aint[0][2]);
            double d2 = Math.sqrt(d0 * d0 + d1 * d1);
            d0 = d0 / d2;
            d1 = d1 / d2;
            p_70495_1_ = p_70495_1_ + d0 * p_70495_7_;
            p_70495_5_ = p_70495_5_ + d1 * p_70495_7_;

            if (aint[0][1] != 0 && MathHelper.func_76128_c(p_70495_1_) - i == aint[0][0] && MathHelper.func_76128_c(p_70495_5_) - k == aint[0][2])
            {
                p_70495_3_ += (double)aint[0][1];
            }
            else if (aint[1][1] != 0 && MathHelper.func_76128_c(p_70495_1_) - i == aint[1][0] && MathHelper.func_76128_c(p_70495_5_) - k == aint[1][2])
            {
                p_70495_3_ += (double)aint[1][1];
            }

            return this.func_70489_a(p_70495_1_, p_70495_3_, p_70495_5_);
        }
        else
        {
            return null;
        }
    }

    public Vec3 func_70489_a(double p_70489_1_, double p_70489_3_, double p_70489_5_)
    {
        int i = MathHelper.func_76128_c(p_70489_1_);
        int j = MathHelper.func_76128_c(p_70489_3_);
        int k = MathHelper.func_76128_c(p_70489_5_);

        if (BlockRailBase.isRailBlock(this.field_70170_p, new BlockPos(i, j - 1, k)))
        {
            --j;
        }

        IBlockState iblockstate = this.field_70170_p.func_180495_p(new BlockPos(i, j, k));

        if (BlockRailBase.isRailBlock(iblockstate))
        {
            BlockRailBase.EnumRailDirection blockrailbase$enumraildirection = (BlockRailBase.EnumRailDirection)iblockstate.getValue(((BlockRailBase)iblockstate.func_177230_c()).getShapeProperty());
            int[][] aint = matrix[blockrailbase$enumraildirection.getMetadata()];
            double d0 = 0.0D;
            double d1 = (double)i + 0.5D + (double)aint[0][0] * 0.5D;
            double d2 = (double)j + 0.0625D + (double)aint[0][1] * 0.5D;
            double d3 = (double)k + 0.5D + (double)aint[0][2] * 0.5D;
            double d4 = (double)i + 0.5D + (double)aint[1][0] * 0.5D;
            double d5 = (double)j + 0.0625D + (double)aint[1][1] * 0.5D;
            double d6 = (double)k + 0.5D + (double)aint[1][2] * 0.5D;
            double d7 = d4 - d1;
            double d8 = (d5 - d2) * 2.0D;
            double d9 = d6 - d3;

            if (d7 == 0.0D)
            {
                p_70489_1_ = (double)i + 0.5D;
                d0 = p_70489_5_ - (double)k;
            }
            else if (d9 == 0.0D)
            {
                p_70489_5_ = (double)k + 0.5D;
                d0 = p_70489_1_ - (double)i;
            }
            else
            {
                double d10 = p_70489_1_ - d1;
                double d11 = p_70489_5_ - d3;
                d0 = (d10 * d7 + d11 * d9) * 2.0D;
            }

            p_70489_1_ = d1 + d7 * d0;
            p_70489_3_ = d2 + d8 * d0;
            p_70489_5_ = d3 + d9 * d0;

            if (d8 < 0.0D)
            {
                ++p_70489_3_;
            }

            if (d8 > 0.0D)
            {
                p_70489_3_ += 0.5D;
            }

            return new Vec3(p_70489_1_, p_70489_3_, p_70489_5_);
        }
        else
        {
            return null;
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        if (tagCompund.getBoolean("CustomDisplayTile"))
        {
            int i = tagCompund.getInteger("DisplayData");

            if (tagCompund.func_150297_b("DisplayTile", 8))
            {
                Block block = Block.func_149684_b(tagCompund.getString("DisplayTile"));

                if (block == null)
                {
                    this.func_174899_a(Blocks.field_150350_a.func_176223_P());
                }
                else
                {
                    this.func_174899_a(block.func_176203_a(i));
                }
            }
            else
            {
                Block block1 = Block.getBlockById(tagCompund.getInteger("DisplayTile"));

                if (block1 == null)
                {
                    this.func_174899_a(Blocks.field_150350_a.func_176223_P());
                }
                else
                {
                    this.func_174899_a(block1.func_176203_a(i));
                }
            }

            this.setDisplayTileOffset(tagCompund.getInteger("DisplayOffset"));
        }

        if (tagCompund.func_150297_b("CustomName", 8) && tagCompund.getString("CustomName").length() > 0)
        {
            this.entityName = tagCompund.getString("CustomName");
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    protected void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        if (this.hasDisplayTile())
        {
            tagCompound.setBoolean("CustomDisplayTile", true);
            IBlockState iblockstate = this.getDisplayTile();
            ResourceLocation resourcelocation = (ResourceLocation)Block.field_149771_c.getNameForObject(iblockstate.func_177230_c());
            tagCompound.func_74778_a("DisplayTile", resourcelocation == null ? "" : resourcelocation.toString());
            tagCompound.func_74768_a("DisplayData", iblockstate.func_177230_c().func_176201_c(iblockstate));
            tagCompound.func_74768_a("DisplayOffset", this.getDisplayTileOffset());
        }

        if (this.entityName != null && this.entityName.length() > 0)
        {
            tagCompound.func_74778_a("CustomName", this.entityName);
        }
    }

    /**
     * Applies a velocity to each of the entities pushing them away from each other. Args: entity
     */
    public void applyEntityCollision(Entity entityIn)
    {
        if (!this.field_70170_p.isRemote)
        {
            if (!entityIn.noClip && !this.noClip)
            {
                if (entityIn != this.riddenByEntity)
                {
                    if (entityIn instanceof EntityLivingBase && !(entityIn instanceof EntityPlayer) && !(entityIn instanceof EntityIronGolem) && this.getMinecartType() == EntityMinecart.EnumMinecartType.RIDEABLE && this.motionX * this.motionX + this.motionZ * this.motionZ > 0.01D && this.riddenByEntity == null && entityIn.ridingEntity == null)
                    {
                        entityIn.func_70078_a(this);
                    }

                    double d0 = entityIn.field_70165_t - this.field_70165_t;
                    double d1 = entityIn.field_70161_v - this.field_70161_v;
                    double d2 = d0 * d0 + d1 * d1;

                    if (d2 >= 9.999999747378752E-5D)
                    {
                        d2 = (double)MathHelper.func_76133_a(d2);
                        d0 = d0 / d2;
                        d1 = d1 / d2;
                        double d3 = 1.0D / d2;

                        if (d3 > 1.0D)
                        {
                            d3 = 1.0D;
                        }

                        d0 = d0 * d3;
                        d1 = d1 * d3;
                        d0 = d0 * 0.10000000149011612D;
                        d1 = d1 * 0.10000000149011612D;
                        d0 = d0 * (double)(1.0F - this.entityCollisionReduction);
                        d1 = d1 * (double)(1.0F - this.entityCollisionReduction);
                        d0 = d0 * 0.5D;
                        d1 = d1 * 0.5D;

                        if (entityIn instanceof EntityMinecart)
                        {
                            double d4 = entityIn.field_70165_t - this.field_70165_t;
                            double d5 = entityIn.field_70161_v - this.field_70161_v;
                            Vec3 vec3 = (new Vec3(d4, 0.0D, d5)).normalize();
                            Vec3 vec31 = (new Vec3((double)MathHelper.cos(this.field_70177_z * (float)Math.PI / 180.0F), 0.0D, (double)MathHelper.sin(this.field_70177_z * (float)Math.PI / 180.0F))).normalize();
                            double d6 = Math.abs(vec3.dotProduct(vec31));

                            if (d6 < 0.800000011920929D)
                            {
                                return;
                            }

                            double d7 = entityIn.motionX + this.motionX;
                            double d8 = entityIn.motionZ + this.motionZ;

                            if (((EntityMinecart)entityIn).getMinecartType() == EntityMinecart.EnumMinecartType.FURNACE && this.getMinecartType() != EntityMinecart.EnumMinecartType.FURNACE)
                            {
                                this.motionX *= 0.20000000298023224D;
                                this.motionZ *= 0.20000000298023224D;
                                this.addVelocity(entityIn.motionX - d0, 0.0D, entityIn.motionZ - d1);
                                entityIn.motionX *= 0.949999988079071D;
                                entityIn.motionZ *= 0.949999988079071D;
                            }
                            else if (((EntityMinecart)entityIn).getMinecartType() != EntityMinecart.EnumMinecartType.FURNACE && this.getMinecartType() == EntityMinecart.EnumMinecartType.FURNACE)
                            {
                                entityIn.motionX *= 0.20000000298023224D;
                                entityIn.motionZ *= 0.20000000298023224D;
                                entityIn.addVelocity(this.motionX + d0, 0.0D, this.motionZ + d1);
                                this.motionX *= 0.949999988079071D;
                                this.motionZ *= 0.949999988079071D;
                            }
                            else
                            {
                                d7 = d7 / 2.0D;
                                d8 = d8 / 2.0D;
                                this.motionX *= 0.20000000298023224D;
                                this.motionZ *= 0.20000000298023224D;
                                this.addVelocity(d7 - d0, 0.0D, d8 - d1);
                                entityIn.motionX *= 0.20000000298023224D;
                                entityIn.motionZ *= 0.20000000298023224D;
                                entityIn.addVelocity(d7 + d0, 0.0D, d8 + d1);
                            }
                        }
                        else
                        {
                            this.addVelocity(-d0, 0.0D, -d1);
                            entityIn.addVelocity(d0 / 4.0D, 0.0D, d1 / 4.0D);
                        }
                    }
                }
            }
        }
    }

    public void setPositionAndRotation2(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean p_180426_10_)
    {
        this.minecartX = x;
        this.minecartY = y;
        this.minecartZ = z;
        this.minecartYaw = (double)yaw;
        this.minecartPitch = (double)pitch;
        this.turnProgress = posRotationIncrements + 2;
        this.motionX = this.velocityX;
        this.motionY = this.velocityY;
        this.motionZ = this.velocityZ;
    }

    /**
     * Sets the velocity to the args. Args: x, y, z
     */
    public void setVelocity(double x, double y, double z)
    {
        this.velocityX = this.motionX = x;
        this.velocityY = this.motionY = y;
        this.velocityZ = this.motionZ = z;
    }

    /**
     * Sets the current amount of damage the minecart has taken. Decreases over time. The cart breaks when this is over
     * 40.
     */
    public void setDamage(float p_70492_1_)
    {
        this.dataWatcher.updateObject(19, Float.valueOf(p_70492_1_));
    }

    /**
     * Gets the current amount of damage the minecart has taken. Decreases over time. The cart breaks when this is over
     * 40.
     */
    public float getDamage()
    {
        return this.dataWatcher.getWatchableObjectFloat(19);
    }

    /**
     * Sets the rolling amplitude the cart rolls while being attacked.
     */
    public void setRollingAmplitude(int p_70497_1_)
    {
        this.dataWatcher.updateObject(17, Integer.valueOf(p_70497_1_));
    }

    /**
     * Gets the rolling amplitude the cart rolls while being attacked.
     */
    public int getRollingAmplitude()
    {
        return this.dataWatcher.getWatchableObjectInt(17);
    }

    /**
     * Sets the rolling direction the cart rolls while being attacked. Can be 1 or -1.
     */
    public void setRollingDirection(int p_70494_1_)
    {
        this.dataWatcher.updateObject(18, Integer.valueOf(p_70494_1_));
    }

    /**
     * Gets the rolling direction the cart rolls while being attacked. Can be 1 or -1.
     */
    public int getRollingDirection()
    {
        return this.dataWatcher.getWatchableObjectInt(18);
    }

    public abstract EntityMinecart.EnumMinecartType getMinecartType();

    public IBlockState getDisplayTile()
    {
        return !this.hasDisplayTile() ? this.getDefaultDisplayTile() : Block.getStateById(this.getDataWatcher().getWatchableObjectInt(20));
    }

    public IBlockState getDefaultDisplayTile()
    {
        return Blocks.field_150350_a.func_176223_P();
    }

    public int getDisplayTileOffset()
    {
        return !this.hasDisplayTile() ? this.getDefaultDisplayTileOffset() : this.getDataWatcher().getWatchableObjectInt(21);
    }

    public int getDefaultDisplayTileOffset()
    {
        return 6;
    }

    public void func_174899_a(IBlockState p_174899_1_)
    {
        this.getDataWatcher().updateObject(20, Integer.valueOf(Block.func_176210_f(p_174899_1_)));
        this.setHasDisplayTile(true);
    }

    public void setDisplayTileOffset(int p_94086_1_)
    {
        this.getDataWatcher().updateObject(21, Integer.valueOf(p_94086_1_));
        this.setHasDisplayTile(true);
    }

    public boolean hasDisplayTile()
    {
        return this.getDataWatcher().getWatchableObjectByte(22) == 1;
    }

    public void setHasDisplayTile(boolean p_94096_1_)
    {
        this.getDataWatcher().updateObject(22, Byte.valueOf((byte)(p_94096_1_ ? 1 : 0)));
    }

    /**
     * Sets the custom name tag for this entity
     */
    public void setCustomNameTag(String name)
    {
        this.entityName = name;
    }

    /**
     * Gets the name of this command sender (usually username, but possibly "Rcon")
     */
    public String func_70005_c_()
    {
        return this.entityName != null ? this.entityName : super.func_70005_c_();
    }

    /**
     * Returns true if this thing is named
     */
    public boolean hasCustomName()
    {
        return this.entityName != null;
    }

    public String getCustomNameTag()
    {
        return this.entityName;
    }

    /**
     * Get the formatted ChatComponent that will be used for the sender's username in chat
     */
    public IChatComponent func_145748_c_()
    {
        if (this.hasCustomName())
        {
            ChatComponentText chatcomponenttext = new ChatComponentText(this.entityName);
            chatcomponenttext.func_150256_b().setChatHoverEvent(this.getHoverEvent());
            chatcomponenttext.func_150256_b().setInsertion(this.func_110124_au().toString());
            return chatcomponenttext;
        }
        else
        {
            ChatComponentTranslation chatcomponenttranslation = new ChatComponentTranslation(this.func_70005_c_(), new Object[0]);
            chatcomponenttranslation.func_150256_b().setChatHoverEvent(this.getHoverEvent());
            chatcomponenttranslation.func_150256_b().setInsertion(this.func_110124_au().toString());
            return chatcomponenttranslation;
        }
    }

    public static enum EnumMinecartType
    {
        RIDEABLE(0, "MinecartRideable"),
        CHEST(1, "MinecartChest"),
        FURNACE(2, "MinecartFurnace"),
        TNT(3, "MinecartTNT"),
        SPAWNER(4, "MinecartSpawner"),
        HOPPER(5, "MinecartHopper"),
        COMMAND_BLOCK(6, "MinecartCommandBlock");

        private static final Map<Integer, EntityMinecart.EnumMinecartType> ID_LOOKUP = Maps.<Integer, EntityMinecart.EnumMinecartType>newHashMap();
        private final int networkID;
        private final String name;

        private EnumMinecartType(int networkID, String name)
        {
            this.networkID = networkID;
            this.name = name;
        }

        public int getNetworkID()
        {
            return this.networkID;
        }

        public String getName()
        {
            return this.name;
        }

        public static EntityMinecart.EnumMinecartType byNetworkID(int id)
        {
            EntityMinecart.EnumMinecartType entityminecart$enumminecarttype = (EntityMinecart.EnumMinecartType)ID_LOOKUP.get(Integer.valueOf(id));
            return entityminecart$enumminecarttype == null ? RIDEABLE : entityminecart$enumminecarttype;
        }

        static {
            for (EntityMinecart.EnumMinecartType entityminecart$enumminecarttype : values())
            {
                ID_LOOKUP.put(Integer.valueOf(entityminecart$enumminecarttype.getNetworkID()), entityminecart$enumminecarttype);
            }
        }
    }
}
