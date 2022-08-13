package net.minecraft.entity;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.event.HoverEvent;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ReportedException;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public abstract class Entity implements ICommandSender
{
    private static final AxisAlignedBB ZERO_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
    private static int nextEntityID;
    private int entityId;
    public double renderDistanceWeight;

    /**
     * Blocks entities from spawning when they do their AABB check to make sure the spot is clear of entities that can
     * prevent spawning.
     */
    public boolean preventEntitySpawning;

    /** The entity that is riding this entity */
    public Entity riddenByEntity;

    /** The entity we are currently riding */
    public Entity ridingEntity;
    public boolean forceSpawn;

    /** Reference to the World object. */
    public World field_70170_p;
    public double prevPosX;
    public double prevPosY;
    public double prevPosZ;

    /** Entity position X */
    public double field_70165_t;

    /** Entity position Y */
    public double field_70163_u;

    /** Entity position Z */
    public double field_70161_v;

    /** Entity motion X */
    public double motionX;

    /** Entity motion Y */
    public double motionY;

    /** Entity motion Z */
    public double motionZ;

    /** Entity rotation Yaw */
    public float field_70177_z;

    /** Entity rotation Pitch */
    public float field_70125_A;
    public float prevRotationYaw;
    public float prevRotationPitch;

    /** Axis aligned bounding box. */
    private AxisAlignedBB boundingBox;
    public boolean onGround;

    /**
     * True if after a move this entity has collided with something on X- or Z-axis
     */
    public boolean isCollidedHorizontally;

    /**
     * True if after a move this entity has collided with something on Y-axis
     */
    public boolean isCollidedVertically;

    /**
     * True if after a move this entity has collided with something either vertically or horizontally
     */
    public boolean isCollided;
    public boolean velocityChanged;
    protected boolean isInWeb;
    private boolean isOutsideBorder;

    /**
     * gets set by setEntityDead, so this must be the flag whether an Entity is dead (inactive may be better term)
     */
    public boolean isDead;

    /** How wide this entity is considered to be */
    public float width;

    /** How high this entity is considered to be */
    public float height;

    /** The previous ticks distance walked multiplied by 0.6 */
    public float prevDistanceWalkedModified;

    /** The distance walked multiplied by 0.6 */
    public float distanceWalkedModified;
    public float distanceWalkedOnStepModified;
    public float field_70143_R;

    /**
     * The distance that has to be exceeded in order to triger a new step sound and an onEntityWalking event on a block
     */
    private int nextStepDistance;

    /**
     * The entity's X coordinate at the previous tick, used to calculate position during rendering routines
     */
    public double lastTickPosX;

    /**
     * The entity's Y coordinate at the previous tick, used to calculate position during rendering routines
     */
    public double lastTickPosY;

    /**
     * The entity's Z coordinate at the previous tick, used to calculate position during rendering routines
     */
    public double lastTickPosZ;

    /**
     * How high this entity can step up when running into a block to try to get over it (currently make note the entity
     * will always step up this amount and not just the amount needed)
     */
    public float stepHeight;

    /**
     * Whether this entity won't clip with collision or not (make note it won't disable gravity)
     */
    public boolean noClip;

    /**
     * Reduces the velocity applied by entity collisions by the specified percent.
     */
    public float entityCollisionReduction;
    protected Random rand;

    /** How many ticks has this entity had ran since being alive */
    public int ticksExisted;

    /**
     * The amount of ticks you have to stand inside of fire before be set on fire
     */
    public int fireResistance;
    private int fire;

    /**
     * Whether this entity is currently inside of water (if it handles water movement that is)
     */
    protected boolean inWater;

    /**
     * Remaining time an entity will be "immune" to further damage after being hurt.
     */
    public int hurtResistantTime;
    protected boolean firstUpdate;
    protected boolean isImmuneToFire;
    protected DataWatcher dataWatcher;
    private double entityRiderPitchDelta;
    private double entityRiderYawDelta;

    /** Has this entity been added to the chunk its within */
    public boolean addedToChunk;
    public int chunkCoordX;
    public int chunkCoordY;
    public int chunkCoordZ;
    public int serverPosX;
    public int serverPosY;
    public int serverPosZ;

    /**
     * Render entity even if it is outside the camera frustum. Only true in EntityFish for now. Used in RenderGlobal:
     * render if ignoreFrustumCheck or in frustum.
     */
    public boolean ignoreFrustumCheck;
    public boolean isAirBorne;
    public int timeUntilPortal;

    /** Whether the entity is inside a Portal */
    protected boolean inPortal;
    protected int portalCounter;

    /** Which dimension the player is in (-1 = the Nether, 0 = normal world) */
    public int dimension;
    protected BlockPos field_181016_an;
    protected Vec3 field_181017_ao;
    protected EnumFacing field_181018_ap;
    private boolean invulnerable;
    protected UUID entityUniqueID;

    /** The command result statistics for this Entity. */
    private final CommandResultStats cmdResultStats;

    public int getEntityId()
    {
        return this.entityId;
    }

    public void setEntityId(int id)
    {
        this.entityId = id;
    }

    /**
     * Called by the /kill command.
     */
    public void func_174812_G()
    {
        this.setDead();
    }

    public Entity(World worldIn)
    {
        this.entityId = nextEntityID++;
        this.renderDistanceWeight = 1.0D;
        this.boundingBox = ZERO_AABB;
        this.width = 0.6F;
        this.height = 1.8F;
        this.nextStepDistance = 1;
        this.rand = new Random();
        this.fireResistance = 1;
        this.firstUpdate = true;
        this.entityUniqueID = MathHelper.getRandomUuid(this.rand);
        this.cmdResultStats = new CommandResultStats();
        this.field_70170_p = worldIn;
        this.setPosition(0.0D, 0.0D, 0.0D);

        if (worldIn != null)
        {
            this.dimension = worldIn.provider.getDimensionId();
        }

        this.dataWatcher = new DataWatcher(this);
        this.dataWatcher.addObject(0, Byte.valueOf((byte)0));
        this.dataWatcher.addObject(1, Short.valueOf((short)300));
        this.dataWatcher.addObject(3, Byte.valueOf((byte)0));
        this.dataWatcher.addObject(2, "");
        this.dataWatcher.addObject(4, Byte.valueOf((byte)0));
        this.entityInit();
    }

    protected abstract void entityInit();

    public DataWatcher getDataWatcher()
    {
        return this.dataWatcher;
    }

    public boolean equals(Object p_equals_1_)
    {
        return p_equals_1_ instanceof Entity ? ((Entity)p_equals_1_).entityId == this.entityId : false;
    }

    public int hashCode()
    {
        return this.entityId;
    }

    /**
     * Keeps moving the entity up so it isn't colliding with blocks and other requirements for this entity to be spawned
     * (only actually used on players though its also on Entity)
     */
    protected void preparePlayerToSpawn()
    {
        if (this.field_70170_p != null)
        {
            while (this.field_70163_u > 0.0D && this.field_70163_u < 256.0D)
            {
                this.setPosition(this.field_70165_t, this.field_70163_u, this.field_70161_v);

                if (this.field_70170_p.getCollidingBoundingBoxes(this, this.getEntityBoundingBox()).isEmpty())
                {
                    break;
                }

                ++this.field_70163_u;
            }

            this.motionX = this.motionY = this.motionZ = 0.0D;
            this.field_70125_A = 0.0F;
        }
    }

    /**
     * Will get destroyed next tick.
     */
    public void setDead()
    {
        this.isDead = true;
    }

    /**
     * Sets the width and height of the entity. Args: width, height
     */
    protected void setSize(float width, float height)
    {
        if (width != this.width || height != this.height)
        {
            float f = this.width;
            this.width = width;
            this.height = height;
            this.setEntityBoundingBox(new AxisAlignedBB(this.getEntityBoundingBox().minX, this.getEntityBoundingBox().minY, this.getEntityBoundingBox().minZ, this.getEntityBoundingBox().minX + (double)this.width, this.getEntityBoundingBox().minY + (double)this.height, this.getEntityBoundingBox().minZ + (double)this.width));

            if (this.width > f && !this.firstUpdate && !this.field_70170_p.isRemote)
            {
                this.moveEntity((double)(f - this.width), 0.0D, (double)(f - this.width));
            }
        }
    }

    /**
     * Sets the rotation of the entity. Args: yaw, pitch (both in degrees)
     */
    protected void setRotation(float yaw, float pitch)
    {
        this.field_70177_z = yaw % 360.0F;
        this.field_70125_A = pitch % 360.0F;
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

    /**
     * Adds 15% to the entity's yaw and subtracts 15% from the pitch. Clamps pitch from -90 to 90. Both arguments in
     * degrees.
     */
    public void setAngles(float yaw, float pitch)
    {
        float f = this.field_70125_A;
        float f1 = this.field_70177_z;
        this.field_70177_z = (float)((double)this.field_70177_z + (double)yaw * 0.15D);
        this.field_70125_A = (float)((double)this.field_70125_A - (double)pitch * 0.15D);
        this.field_70125_A = MathHelper.func_76131_a(this.field_70125_A, -90.0F, 90.0F);
        this.prevRotationPitch += this.field_70125_A - f;
        this.prevRotationYaw += this.field_70177_z - f1;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        this.onEntityUpdate();
    }

    /**
     * Gets called every tick from main Entity class
     */
    public void onEntityUpdate()
    {
        this.field_70170_p.theProfiler.startSection("entityBaseTick");

        if (this.ridingEntity != null && this.ridingEntity.isDead)
        {
            this.ridingEntity = null;
        }

        this.prevDistanceWalkedModified = this.distanceWalkedModified;
        this.prevPosX = this.field_70165_t;
        this.prevPosY = this.field_70163_u;
        this.prevPosZ = this.field_70161_v;
        this.prevRotationPitch = this.field_70125_A;
        this.prevRotationYaw = this.field_70177_z;

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

        this.spawnRunningParticles();
        this.handleWaterMovement();

        if (this.field_70170_p.isRemote)
        {
            this.fire = 0;
        }
        else if (this.fire > 0)
        {
            if (this.isImmuneToFire)
            {
                this.fire -= 4;

                if (this.fire < 0)
                {
                    this.fire = 0;
                }
            }
            else
            {
                if (this.fire % 20 == 0)
                {
                    this.attackEntityFrom(DamageSource.onFire, 1.0F);
                }

                --this.fire;
            }
        }

        if (this.isInLava())
        {
            this.setOnFireFromLava();
            this.field_70143_R *= 0.5F;
        }

        if (this.field_70163_u < -64.0D)
        {
            this.kill();
        }

        if (!this.field_70170_p.isRemote)
        {
            this.setFlag(0, this.fire > 0);
        }

        this.firstUpdate = false;
        this.field_70170_p.theProfiler.endSection();
    }

    /**
     * Return the amount of time this entity should stay in a portal before being transported.
     */
    public int getMaxInPortalTime()
    {
        return 0;
    }

    /**
     * Called whenever the entity is walking inside of lava.
     */
    protected void setOnFireFromLava()
    {
        if (!this.isImmuneToFire)
        {
            this.attackEntityFrom(DamageSource.lava, 4.0F);
            this.setFire(15);
        }
    }

    /**
     * Sets entity to burn for x amount of seconds, cannot lower amount of existing fire.
     */
    public void setFire(int seconds)
    {
        int i = seconds * 20;
        i = EnchantmentProtection.getFireTimeForEntity(this, i);

        if (this.fire < i)
        {
            this.fire = i;
        }
    }

    /**
     * Removes fire from entity.
     */
    public void extinguish()
    {
        this.fire = 0;
    }

    /**
     * sets the dead flag. Used when you fall off the bottom of the world.
     */
    protected void kill()
    {
        this.setDead();
    }

    /**
     * Checks if the offset position from the entity's current position is inside of liquid. Args: x, y, z
     */
    public boolean isOffsetPositionInLiquid(double x, double y, double z)
    {
        AxisAlignedBB axisalignedbb = this.getEntityBoundingBox().offset(x, y, z);
        return this.isLiquidPresentInAABB(axisalignedbb);
    }

    /**
     * Determines if a liquid is present within the specified AxisAlignedBB.
     */
    private boolean isLiquidPresentInAABB(AxisAlignedBB bb)
    {
        return this.field_70170_p.getCollidingBoundingBoxes(this, bb).isEmpty() && !this.field_70170_p.isAnyLiquid(bb);
    }

    /**
     * Tries to moves the entity by the passed in displacement. Args: x, y, z
     */
    public void moveEntity(double x, double y, double z)
    {
        if (this.noClip)
        {
            this.setEntityBoundingBox(this.getEntityBoundingBox().offset(x, y, z));
            this.resetPositionToBB();
        }
        else
        {
            this.field_70170_p.theProfiler.startSection("move");
            double d0 = this.field_70165_t;
            double d1 = this.field_70163_u;
            double d2 = this.field_70161_v;

            if (this.isInWeb)
            {
                this.isInWeb = false;
                x *= 0.25D;
                y *= 0.05000000074505806D;
                z *= 0.25D;
                this.motionX = 0.0D;
                this.motionY = 0.0D;
                this.motionZ = 0.0D;
            }

            double d3 = x;
            double d4 = y;
            double d5 = z;
            boolean flag = this.onGround && this.isSneaking() && this instanceof EntityPlayer;

            if (flag)
            {
                double d6;

                for (d6 = 0.05D; x != 0.0D && this.field_70170_p.getCollidingBoundingBoxes(this, this.getEntityBoundingBox().offset(x, -1.0D, 0.0D)).isEmpty(); d3 = x)
                {
                    if (x < d6 && x >= -d6)
                    {
                        x = 0.0D;
                    }
                    else if (x > 0.0D)
                    {
                        x -= d6;
                    }
                    else
                    {
                        x += d6;
                    }
                }

                for (; z != 0.0D && this.field_70170_p.getCollidingBoundingBoxes(this, this.getEntityBoundingBox().offset(0.0D, -1.0D, z)).isEmpty(); d5 = z)
                {
                    if (z < d6 && z >= -d6)
                    {
                        z = 0.0D;
                    }
                    else if (z > 0.0D)
                    {
                        z -= d6;
                    }
                    else
                    {
                        z += d6;
                    }
                }

                for (; x != 0.0D && z != 0.0D && this.field_70170_p.getCollidingBoundingBoxes(this, this.getEntityBoundingBox().offset(x, -1.0D, z)).isEmpty(); d5 = z)
                {
                    if (x < d6 && x >= -d6)
                    {
                        x = 0.0D;
                    }
                    else if (x > 0.0D)
                    {
                        x -= d6;
                    }
                    else
                    {
                        x += d6;
                    }

                    d3 = x;

                    if (z < d6 && z >= -d6)
                    {
                        z = 0.0D;
                    }
                    else if (z > 0.0D)
                    {
                        z -= d6;
                    }
                    else
                    {
                        z += d6;
                    }
                }
            }

            List<AxisAlignedBB> list1 = this.field_70170_p.getCollidingBoundingBoxes(this, this.getEntityBoundingBox().addCoord(x, y, z));
            AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();

            for (AxisAlignedBB axisalignedbb1 : list1)
            {
                y = axisalignedbb1.calculateYOffset(this.getEntityBoundingBox(), y);
            }

            this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0.0D, y, 0.0D));
            boolean flag1 = this.onGround || d4 != y && d4 < 0.0D;

            for (AxisAlignedBB axisalignedbb2 : list1)
            {
                x = axisalignedbb2.calculateXOffset(this.getEntityBoundingBox(), x);
            }

            this.setEntityBoundingBox(this.getEntityBoundingBox().offset(x, 0.0D, 0.0D));

            for (AxisAlignedBB axisalignedbb13 : list1)
            {
                z = axisalignedbb13.calculateZOffset(this.getEntityBoundingBox(), z);
            }

            this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0.0D, 0.0D, z));

            if (this.stepHeight > 0.0F && flag1 && (d3 != x || d5 != z))
            {
                double d11 = x;
                double d7 = y;
                double d8 = z;
                AxisAlignedBB axisalignedbb3 = this.getEntityBoundingBox();
                this.setEntityBoundingBox(axisalignedbb);
                y = (double)this.stepHeight;
                List<AxisAlignedBB> list = this.field_70170_p.getCollidingBoundingBoxes(this, this.getEntityBoundingBox().addCoord(d3, y, d5));
                AxisAlignedBB axisalignedbb4 = this.getEntityBoundingBox();
                AxisAlignedBB axisalignedbb5 = axisalignedbb4.addCoord(d3, 0.0D, d5);
                double d9 = y;

                for (AxisAlignedBB axisalignedbb6 : list)
                {
                    d9 = axisalignedbb6.calculateYOffset(axisalignedbb5, d9);
                }

                axisalignedbb4 = axisalignedbb4.offset(0.0D, d9, 0.0D);
                double d15 = d3;

                for (AxisAlignedBB axisalignedbb7 : list)
                {
                    d15 = axisalignedbb7.calculateXOffset(axisalignedbb4, d15);
                }

                axisalignedbb4 = axisalignedbb4.offset(d15, 0.0D, 0.0D);
                double d16 = d5;

                for (AxisAlignedBB axisalignedbb8 : list)
                {
                    d16 = axisalignedbb8.calculateZOffset(axisalignedbb4, d16);
                }

                axisalignedbb4 = axisalignedbb4.offset(0.0D, 0.0D, d16);
                AxisAlignedBB axisalignedbb14 = this.getEntityBoundingBox();
                double d17 = y;

                for (AxisAlignedBB axisalignedbb9 : list)
                {
                    d17 = axisalignedbb9.calculateYOffset(axisalignedbb14, d17);
                }

                axisalignedbb14 = axisalignedbb14.offset(0.0D, d17, 0.0D);
                double d18 = d3;

                for (AxisAlignedBB axisalignedbb10 : list)
                {
                    d18 = axisalignedbb10.calculateXOffset(axisalignedbb14, d18);
                }

                axisalignedbb14 = axisalignedbb14.offset(d18, 0.0D, 0.0D);
                double d19 = d5;

                for (AxisAlignedBB axisalignedbb11 : list)
                {
                    d19 = axisalignedbb11.calculateZOffset(axisalignedbb14, d19);
                }

                axisalignedbb14 = axisalignedbb14.offset(0.0D, 0.0D, d19);
                double d20 = d15 * d15 + d16 * d16;
                double d10 = d18 * d18 + d19 * d19;

                if (d20 > d10)
                {
                    x = d15;
                    z = d16;
                    y = -d9;
                    this.setEntityBoundingBox(axisalignedbb4);
                }
                else
                {
                    x = d18;
                    z = d19;
                    y = -d17;
                    this.setEntityBoundingBox(axisalignedbb14);
                }

                for (AxisAlignedBB axisalignedbb12 : list)
                {
                    y = axisalignedbb12.calculateYOffset(this.getEntityBoundingBox(), y);
                }

                this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0.0D, y, 0.0D));

                if (d11 * d11 + d8 * d8 >= x * x + z * z)
                {
                    x = d11;
                    y = d7;
                    z = d8;
                    this.setEntityBoundingBox(axisalignedbb3);
                }
            }

            this.field_70170_p.theProfiler.endSection();
            this.field_70170_p.theProfiler.startSection("rest");
            this.resetPositionToBB();
            this.isCollidedHorizontally = d3 != x || d5 != z;
            this.isCollidedVertically = d4 != y;
            this.onGround = this.isCollidedVertically && d4 < 0.0D;
            this.isCollided = this.isCollidedHorizontally || this.isCollidedVertically;
            int i = MathHelper.func_76128_c(this.field_70165_t);
            int j = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224D);
            int k = MathHelper.func_76128_c(this.field_70161_v);
            BlockPos blockpos = new BlockPos(i, j, k);
            Block block1 = this.field_70170_p.func_180495_p(blockpos).func_177230_c();

            if (block1.func_149688_o() == Material.field_151579_a)
            {
                Block block = this.field_70170_p.func_180495_p(blockpos.func_177977_b()).func_177230_c();

                if (block instanceof BlockFence || block instanceof BlockWall || block instanceof BlockFenceGate)
                {
                    block1 = block;
                    blockpos = blockpos.func_177977_b();
                }
            }

            this.updateFallState(y, this.onGround, block1, blockpos);

            if (d3 != x)
            {
                this.motionX = 0.0D;
            }

            if (d5 != z)
            {
                this.motionZ = 0.0D;
            }

            if (d4 != y)
            {
                block1.onLanded(this.field_70170_p, this);
            }

            if (this.canTriggerWalking() && !flag && this.ridingEntity == null)
            {
                double d12 = this.field_70165_t - d0;
                double d13 = this.field_70163_u - d1;
                double d14 = this.field_70161_v - d2;

                if (block1 != Blocks.ladder)
                {
                    d13 = 0.0D;
                }

                if (block1 != null && this.onGround)
                {
                    block1.onEntityCollidedWithBlock(this.field_70170_p, blockpos, this);
                }

                this.distanceWalkedModified = (float)((double)this.distanceWalkedModified + (double)MathHelper.func_76133_a(d12 * d12 + d14 * d14) * 0.6D);
                this.distanceWalkedOnStepModified = (float)((double)this.distanceWalkedOnStepModified + (double)MathHelper.func_76133_a(d12 * d12 + d13 * d13 + d14 * d14) * 0.6D);

                if (this.distanceWalkedOnStepModified > (float)this.nextStepDistance && block1.func_149688_o() != Material.field_151579_a)
                {
                    this.nextStepDistance = (int)this.distanceWalkedOnStepModified + 1;

                    if (this.isInWater())
                    {
                        float f = MathHelper.func_76133_a(this.motionX * this.motionX * 0.20000000298023224D + this.motionY * this.motionY + this.motionZ * this.motionZ * 0.20000000298023224D) * 0.35F;

                        if (f > 1.0F)
                        {
                            f = 1.0F;
                        }

                        this.playSound(this.getSwimSound(), f, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4F);
                    }

                    this.playStepSound(blockpos, block1);
                }
            }

            try
            {
                this.doBlockCollisions();
            }
            catch (Throwable throwable)
            {
                CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Checking entity block collision");
                CrashReportCategory crashreportcategory = crashreport.makeCategory("Entity being checked for collision");
                this.addEntityCrashInfo(crashreportcategory);
                throw new ReportedException(crashreport);
            }

            boolean flag2 = this.isWet();

            if (this.field_70170_p.isFlammableWithin(this.getEntityBoundingBox().contract(0.001D, 0.001D, 0.001D)))
            {
                this.dealFireDamage(1);

                if (!flag2)
                {
                    ++this.fire;

                    if (this.fire == 0)
                    {
                        this.setFire(8);
                    }
                }
            }
            else if (this.fire <= 0)
            {
                this.fire = -this.fireResistance;
            }

            if (flag2 && this.fire > 0)
            {
                this.playSound("random.fizz", 0.7F, 1.6F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4F);
                this.fire = -this.fireResistance;
            }

            this.field_70170_p.theProfiler.endSection();
        }
    }

    /**
     * Resets the entity's position to the center (planar) and bottom (vertical) points of its bounding box.
     */
    private void resetPositionToBB()
    {
        this.field_70165_t = (this.getEntityBoundingBox().minX + this.getEntityBoundingBox().maxX) / 2.0D;
        this.field_70163_u = this.getEntityBoundingBox().minY;
        this.field_70161_v = (this.getEntityBoundingBox().minZ + this.getEntityBoundingBox().maxZ) / 2.0D;
    }

    protected String getSwimSound()
    {
        return "game.neutral.swim";
    }

    protected void doBlockCollisions()
    {
        BlockPos blockpos = new BlockPos(this.getEntityBoundingBox().minX + 0.001D, this.getEntityBoundingBox().minY + 0.001D, this.getEntityBoundingBox().minZ + 0.001D);
        BlockPos blockpos1 = new BlockPos(this.getEntityBoundingBox().maxX - 0.001D, this.getEntityBoundingBox().maxY - 0.001D, this.getEntityBoundingBox().maxZ - 0.001D);

        if (this.field_70170_p.isAreaLoaded(blockpos, blockpos1))
        {
            for (int i = blockpos.func_177958_n(); i <= blockpos1.func_177958_n(); ++i)
            {
                for (int j = blockpos.func_177956_o(); j <= blockpos1.func_177956_o(); ++j)
                {
                    for (int k = blockpos.func_177952_p(); k <= blockpos1.func_177952_p(); ++k)
                    {
                        BlockPos blockpos2 = new BlockPos(i, j, k);
                        IBlockState iblockstate = this.field_70170_p.func_180495_p(blockpos2);

                        try
                        {
                            iblockstate.func_177230_c().onEntityCollidedWithBlock(this.field_70170_p, blockpos2, iblockstate, this);
                        }
                        catch (Throwable throwable)
                        {
                            CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Colliding entity with block");
                            CrashReportCategory crashreportcategory = crashreport.makeCategory("Block being collided with");
                            CrashReportCategory.addBlockInfo(crashreportcategory, blockpos2, iblockstate);
                            throw new ReportedException(crashreport);
                        }
                    }
                }
            }
        }
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        Block.SoundType block$soundtype = blockIn.stepSound;

        if (this.field_70170_p.func_180495_p(pos.up()).func_177230_c() == Blocks.snow_layer)
        {
            block$soundtype = Blocks.snow_layer.stepSound;
            this.playSound(block$soundtype.getStepSound(), block$soundtype.getVolume() * 0.15F, block$soundtype.getFrequency());
        }
        else if (!blockIn.func_149688_o().func_76224_d())
        {
            this.playSound(block$soundtype.getStepSound(), block$soundtype.getVolume() * 0.15F, block$soundtype.getFrequency());
        }
    }

    public void playSound(String name, float volume, float pitch)
    {
        if (!this.isSilent())
        {
            this.field_70170_p.func_72956_a(this, name, volume, pitch);
        }
    }

    /**
     * @return True if this entity will not play sounds
     */
    public boolean isSilent()
    {
        return this.dataWatcher.getWatchableObjectByte(4) == 1;
    }

    /**
     * When set to true the entity will not play sounds.
     */
    public void setSilent(boolean isSilent)
    {
        this.dataWatcher.updateObject(4, Byte.valueOf((byte)(isSilent ? 1 : 0)));
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return true;
    }

    protected void updateFallState(double y, boolean onGroundIn, Block blockIn, BlockPos pos)
    {
        if (onGroundIn)
        {
            if (this.field_70143_R > 0.0F)
            {
                if (blockIn != null)
                {
                    blockIn.onFallenUpon(this.field_70170_p, pos, this, this.field_70143_R);
                }
                else
                {
                    this.fall(this.field_70143_R, 1.0F);
                }

                this.field_70143_R = 0.0F;
            }
        }
        else if (y < 0.0D)
        {
            this.field_70143_R = (float)((double)this.field_70143_R - y);
        }
    }

    /**
     * Returns the collision bounding box for this entity
     */
    public AxisAlignedBB getCollisionBoundingBox()
    {
        return null;
    }

    /**
     * Will deal the specified amount of damage to the entity if the entity isn't immune to fire damage. Args:
     * amountDamage
     */
    protected void dealFireDamage(int amount)
    {
        if (!this.isImmuneToFire)
        {
            this.attackEntityFrom(DamageSource.inFire, (float)amount);
        }
    }

    public final boolean isImmuneToFire()
    {
        return this.isImmuneToFire;
    }

    public void fall(float distance, float damageMultiplier)
    {
        if (this.riddenByEntity != null)
        {
            this.riddenByEntity.fall(distance, damageMultiplier);
        }
    }

    /**
     * Checks if this entity is either in water or on an open air block in rain (used in wolves).
     */
    public boolean isWet()
    {
        return this.inWater || this.field_70170_p.canLightningStrike(new BlockPos(this.field_70165_t, this.field_70163_u, this.field_70161_v)) || this.field_70170_p.canLightningStrike(new BlockPos(this.field_70165_t, this.field_70163_u + (double)this.height, this.field_70161_v));
    }

    /**
     * Checks if this entity is inside water (if inWater field is true as a result of handleWaterMovement() returning
     * true)
     */
    public boolean isInWater()
    {
        return this.inWater;
    }

    /**
     * Returns if this entity is in water and will end up adding the waters velocity to the entity
     */
    public boolean handleWaterMovement()
    {
        if (this.field_70170_p.handleMaterialAcceleration(this.getEntityBoundingBox().expand(0.0D, -0.4000000059604645D, 0.0D).contract(0.001D, 0.001D, 0.001D), Material.water, this))
        {
            if (!this.inWater && !this.firstUpdate)
            {
                this.resetHeight();
            }

            this.field_70143_R = 0.0F;
            this.inWater = true;
            this.fire = 0;
        }
        else
        {
            this.inWater = false;
        }

        return this.inWater;
    }

    /**
     * sets the players height back to normal after doing things like sleeping and dieing
     */
    protected void resetHeight()
    {
        float f = MathHelper.func_76133_a(this.motionX * this.motionX * 0.20000000298023224D + this.motionY * this.motionY + this.motionZ * this.motionZ * 0.20000000298023224D) * 0.2F;

        if (f > 1.0F)
        {
            f = 1.0F;
        }

        this.playSound(this.getSplashSound(), f, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4F);
        float f1 = (float)MathHelper.func_76128_c(this.getEntityBoundingBox().minY);

        for (int i = 0; (float)i < 1.0F + this.width * 20.0F; ++i)
        {
            float f2 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width;
            float f3 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width;
            this.field_70170_p.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.field_70165_t + (double)f2, (double)(f1 + 1.0F), this.field_70161_v + (double)f3, this.motionX, this.motionY - (double)(this.rand.nextFloat() * 0.2F), this.motionZ, new int[0]);
        }

        for (int j = 0; (float)j < 1.0F + this.width * 20.0F; ++j)
        {
            float f4 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width;
            float f5 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width;
            this.field_70170_p.spawnParticle(EnumParticleTypes.WATER_SPLASH, this.field_70165_t + (double)f4, (double)(f1 + 1.0F), this.field_70161_v + (double)f5, this.motionX, this.motionY, this.motionZ, new int[0]);
        }
    }

    /**
     * Attempts to create sprinting particles if the entity is sprinting and not in water.
     */
    public void spawnRunningParticles()
    {
        if (this.isSprinting() && !this.isInWater())
        {
            this.createRunningParticles();
        }
    }

    protected void createRunningParticles()
    {
        int i = MathHelper.func_76128_c(this.field_70165_t);
        int j = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224D);
        int k = MathHelper.func_76128_c(this.field_70161_v);
        BlockPos blockpos = new BlockPos(i, j, k);
        IBlockState iblockstate = this.field_70170_p.func_180495_p(blockpos);
        Block block = iblockstate.func_177230_c();

        if (block.getRenderType() != -1)
        {
            this.field_70170_p.spawnParticle(EnumParticleTypes.BLOCK_CRACK, this.field_70165_t + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, this.getEntityBoundingBox().minY + 0.1D, this.field_70161_v + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, -this.motionX * 4.0D, 1.5D, -this.motionZ * 4.0D, new int[] {Block.func_176210_f(iblockstate)});
        }
    }

    protected String getSplashSound()
    {
        return "game.neutral.swim.splash";
    }

    /**
     * Checks if the current block the entity is within of the specified material type
     */
    public boolean isInsideOfMaterial(Material materialIn)
    {
        double d0 = this.field_70163_u + (double)this.getEyeHeight();
        BlockPos blockpos = new BlockPos(this.field_70165_t, d0, this.field_70161_v);
        IBlockState iblockstate = this.field_70170_p.func_180495_p(blockpos);
        Block block = iblockstate.func_177230_c();

        if (block.func_149688_o() == materialIn)
        {
            float f = BlockLiquid.getLiquidHeightPercent(iblockstate.func_177230_c().func_176201_c(iblockstate)) - 0.11111111F;
            float f1 = (float)(blockpos.func_177956_o() + 1) - f;
            boolean flag = d0 < (double)f1;
            return !flag && this instanceof EntityPlayer ? false : flag;
        }
        else
        {
            return false;
        }
    }

    public boolean isInLava()
    {
        return this.field_70170_p.isMaterialInBB(this.getEntityBoundingBox().expand(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.lava);
    }

    /**
     * Used in both water and by flying objects
     */
    public void moveFlying(float strafe, float forward, float friction)
    {
        float f = strafe * strafe + forward * forward;

        if (f >= 1.0E-4F)
        {
            f = MathHelper.sqrt_float(f);

            if (f < 1.0F)
            {
                f = 1.0F;
            }

            f = friction / f;
            strafe = strafe * f;
            forward = forward * f;
            float f1 = MathHelper.sin(this.field_70177_z * (float)Math.PI / 180.0F);
            float f2 = MathHelper.cos(this.field_70177_z * (float)Math.PI / 180.0F);
            this.motionX += (double)(strafe * f2 - forward * f1);
            this.motionZ += (double)(forward * f2 + strafe * f1);
        }
    }

    public int getBrightnessForRender(float partialTicks)
    {
        BlockPos blockpos = new BlockPos(this.field_70165_t, this.field_70163_u + (double)this.getEyeHeight(), this.field_70161_v);
        return this.field_70170_p.func_175667_e(blockpos) ? this.field_70170_p.getCombinedLight(blockpos, 0) : 0;
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness(float partialTicks)
    {
        BlockPos blockpos = new BlockPos(this.field_70165_t, this.field_70163_u + (double)this.getEyeHeight(), this.field_70161_v);
        return this.field_70170_p.func_175667_e(blockpos) ? this.field_70170_p.getLightBrightness(blockpos) : 0.0F;
    }

    /**
     * Sets the reference to the World object.
     */
    public void setWorld(World worldIn)
    {
        this.field_70170_p = worldIn;
    }

    /**
     * Sets the entity's position and rotation.
     */
    public void setPositionAndRotation(double x, double y, double z, float yaw, float pitch)
    {
        this.prevPosX = this.field_70165_t = x;
        this.prevPosY = this.field_70163_u = y;
        this.prevPosZ = this.field_70161_v = z;
        this.prevRotationYaw = this.field_70177_z = yaw;
        this.prevRotationPitch = this.field_70125_A = pitch;
        double d0 = (double)(this.prevRotationYaw - yaw);

        if (d0 < -180.0D)
        {
            this.prevRotationYaw += 360.0F;
        }

        if (d0 >= 180.0D)
        {
            this.prevRotationYaw -= 360.0F;
        }

        this.setPosition(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.setRotation(yaw, pitch);
    }

    public void moveToBlockPosAndAngles(BlockPos pos, float rotationYawIn, float rotationPitchIn)
    {
        this.func_70012_b((double)pos.func_177958_n() + 0.5D, (double)pos.func_177956_o(), (double)pos.func_177952_p() + 0.5D, rotationYawIn, rotationPitchIn);
    }

    /**
     * Sets the location and Yaw/Pitch of an entity in the world
     */
    public void func_70012_b(double x, double y, double z, float yaw, float pitch)
    {
        this.lastTickPosX = this.prevPosX = this.field_70165_t = x;
        this.lastTickPosY = this.prevPosY = this.field_70163_u = y;
        this.lastTickPosZ = this.prevPosZ = this.field_70161_v = z;
        this.field_70177_z = yaw;
        this.field_70125_A = pitch;
        this.setPosition(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    }

    /**
     * Returns the distance to the entity. Args: entity
     */
    public float getDistanceToEntity(Entity entityIn)
    {
        float f = (float)(this.field_70165_t - entityIn.field_70165_t);
        float f1 = (float)(this.field_70163_u - entityIn.field_70163_u);
        float f2 = (float)(this.field_70161_v - entityIn.field_70161_v);
        return MathHelper.sqrt_float(f * f + f1 * f1 + f2 * f2);
    }

    /**
     * Gets the squared distance to the position. Args: x, y, z
     */
    public double getDistanceSq(double x, double y, double z)
    {
        double d0 = this.field_70165_t - x;
        double d1 = this.field_70163_u - y;
        double d2 = this.field_70161_v - z;
        return d0 * d0 + d1 * d1 + d2 * d2;
    }

    public double getDistanceSq(BlockPos pos)
    {
        return pos.distanceSq(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    }

    public double getDistanceSqToCenter(BlockPos pos)
    {
        return pos.distanceSqToCenter(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    }

    /**
     * Gets the distance to the position. Args: x, y, z
     */
    public double func_70011_f(double x, double y, double z)
    {
        double d0 = this.field_70165_t - x;
        double d1 = this.field_70163_u - y;
        double d2 = this.field_70161_v - z;
        return (double)MathHelper.func_76133_a(d0 * d0 + d1 * d1 + d2 * d2);
    }

    /**
     * Returns the squared distance to the entity. Args: entity
     */
    public double getDistanceSqToEntity(Entity entityIn)
    {
        double d0 = this.field_70165_t - entityIn.field_70165_t;
        double d1 = this.field_70163_u - entityIn.field_70163_u;
        double d2 = this.field_70161_v - entityIn.field_70161_v;
        return d0 * d0 + d1 * d1 + d2 * d2;
    }

    /**
     * Called by a player entity when they collide with an entity
     */
    public void onCollideWithPlayer(EntityPlayer entityIn)
    {
    }

    /**
     * Applies a velocity to each of the entities pushing them away from each other. Args: entity
     */
    public void applyEntityCollision(Entity entityIn)
    {
        if (entityIn.riddenByEntity != this && entityIn.ridingEntity != this)
        {
            if (!entityIn.noClip && !this.noClip)
            {
                double d0 = entityIn.field_70165_t - this.field_70165_t;
                double d1 = entityIn.field_70161_v - this.field_70161_v;
                double d2 = MathHelper.abs_max(d0, d1);

                if (d2 >= 0.009999999776482582D)
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
                    d0 = d0 * 0.05000000074505806D;
                    d1 = d1 * 0.05000000074505806D;
                    d0 = d0 * (double)(1.0F - this.entityCollisionReduction);
                    d1 = d1 * (double)(1.0F - this.entityCollisionReduction);

                    if (this.riddenByEntity == null)
                    {
                        this.addVelocity(-d0, 0.0D, -d1);
                    }

                    if (entityIn.riddenByEntity == null)
                    {
                        entityIn.addVelocity(d0, 0.0D, d1);
                    }
                }
            }
        }
    }

    /**
     * Adds to the current velocity of the entity. Args: x, y, z
     */
    public void addVelocity(double x, double y, double z)
    {
        this.motionX += x;
        this.motionY += y;
        this.motionZ += z;
        this.isAirBorne = true;
    }

    /**
     * Sets that this entity has been attacked.
     */
    protected void setBeenAttacked()
    {
        this.velocityChanged = true;
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
            this.setBeenAttacked();
            return false;
        }
    }

    /**
     * interpolated look vector
     */
    public Vec3 getLook(float partialTicks)
    {
        if (partialTicks == 1.0F)
        {
            return this.getVectorForRotation(this.field_70125_A, this.field_70177_z);
        }
        else
        {
            float f = this.prevRotationPitch + (this.field_70125_A - this.prevRotationPitch) * partialTicks;
            float f1 = this.prevRotationYaw + (this.field_70177_z - this.prevRotationYaw) * partialTicks;
            return this.getVectorForRotation(f, f1);
        }
    }

    /**
     * Creates a Vec3 using the pitch and yaw of the entities rotation.
     */
    protected final Vec3 getVectorForRotation(float pitch, float yaw)
    {
        float f = MathHelper.cos(-yaw * 0.017453292F - (float)Math.PI);
        float f1 = MathHelper.sin(-yaw * 0.017453292F - (float)Math.PI);
        float f2 = -MathHelper.cos(-pitch * 0.017453292F);
        float f3 = MathHelper.sin(-pitch * 0.017453292F);
        return new Vec3((double)(f1 * f2), (double)f3, (double)(f * f2));
    }

    public Vec3 getPositionEyes(float partialTicks)
    {
        if (partialTicks == 1.0F)
        {
            return new Vec3(this.field_70165_t, this.field_70163_u + (double)this.getEyeHeight(), this.field_70161_v);
        }
        else
        {
            double d0 = this.prevPosX + (this.field_70165_t - this.prevPosX) * (double)partialTicks;
            double d1 = this.prevPosY + (this.field_70163_u - this.prevPosY) * (double)partialTicks + (double)this.getEyeHeight();
            double d2 = this.prevPosZ + (this.field_70161_v - this.prevPosZ) * (double)partialTicks;
            return new Vec3(d0, d1, d2);
        }
    }

    public MovingObjectPosition rayTrace(double blockReachDistance, float partialTicks)
    {
        Vec3 vec3 = this.getPositionEyes(partialTicks);
        Vec3 vec31 = this.getLook(partialTicks);
        Vec3 vec32 = vec3.addVector(vec31.field_72450_a * blockReachDistance, vec31.field_72448_b * blockReachDistance, vec31.field_72449_c * blockReachDistance);
        return this.field_70170_p.rayTraceBlocks(vec3, vec32, false, false, true);
    }

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    public boolean canBeCollidedWith()
    {
        return false;
    }

    /**
     * Returns true if this entity should push and be pushed by other entities when colliding.
     */
    public boolean canBePushed()
    {
        return false;
    }

    /**
     * Adds a value to the player score. Currently not actually used and the entity passed in does nothing. Args:
     * entity, scoreToAdd
     */
    public void addToPlayerScore(Entity entityIn, int amount)
    {
    }

    public boolean isInRangeToRender3d(double x, double y, double z)
    {
        double d0 = this.field_70165_t - x;
        double d1 = this.field_70163_u - y;
        double d2 = this.field_70161_v - z;
        double d3 = d0 * d0 + d1 * d1 + d2 * d2;
        return this.isInRangeToRenderDist(d3);
    }

    /**
     * Checks if the entity is in range to render by using the past in distance and comparing it to its average edge
     * length * 64 * renderDistanceWeight Args: distance
     */
    public boolean isInRangeToRenderDist(double distance)
    {
        double d0 = this.getEntityBoundingBox().getAverageEdgeLength();

        if (Double.isNaN(d0))
        {
            d0 = 1.0D;
        }

        d0 = d0 * 64.0D * this.renderDistanceWeight;
        return distance < d0 * d0;
    }

    /**
     * Like writeToNBTOptional but does not check if the entity is ridden. Used for saving ridden entities with their
     * riders.
     */
    public boolean writeMountToNBT(NBTTagCompound tagCompund)
    {
        String s = this.getEntityString();

        if (!this.isDead && s != null)
        {
            tagCompund.func_74778_a("id", s);
            this.func_70109_d(tagCompund);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Either write this entity to the NBT tag given and return true, or return false without doing anything. If this
     * returns false the entity is not saved on disk. Ridden entities return false here as they are saved with their
     * rider.
     */
    public boolean writeToNBTOptional(NBTTagCompound tagCompund)
    {
        String s = this.getEntityString();

        if (!this.isDead && s != null && this.riddenByEntity == null)
        {
            tagCompund.func_74778_a("id", s);
            this.func_70109_d(tagCompund);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Save the entity to NBT (calls an abstract helper method to write extra data)
     */
    public void func_70109_d(NBTTagCompound tagCompund)
    {
        try
        {
            tagCompund.func_74782_a("Pos", this.newDoubleNBTList(new double[] {this.field_70165_t, this.field_70163_u, this.field_70161_v}));
            tagCompund.func_74782_a("Motion", this.newDoubleNBTList(new double[] {this.motionX, this.motionY, this.motionZ}));
            tagCompund.func_74782_a("Rotation", this.newFloatNBTList(new float[] {this.field_70177_z, this.field_70125_A}));
            tagCompund.setFloat("FallDistance", this.field_70143_R);
            tagCompund.setShort("Fire", (short)this.fire);
            tagCompund.setShort("Air", (short)this.getAir());
            tagCompund.setBoolean("OnGround", this.onGround);
            tagCompund.func_74768_a("Dimension", this.dimension);
            tagCompund.setBoolean("Invulnerable", this.invulnerable);
            tagCompund.func_74768_a("PortalCooldown", this.timeUntilPortal);
            tagCompund.setLong("UUIDMost", this.func_110124_au().getMostSignificantBits());
            tagCompund.setLong("UUIDLeast", this.func_110124_au().getLeastSignificantBits());

            if (this.getCustomNameTag() != null && this.getCustomNameTag().length() > 0)
            {
                tagCompund.func_74778_a("CustomName", this.getCustomNameTag());
                tagCompund.setBoolean("CustomNameVisible", this.getAlwaysRenderNameTag());
            }

            this.cmdResultStats.writeStatsToNBT(tagCompund);

            if (this.isSilent())
            {
                tagCompund.setBoolean("Silent", this.isSilent());
            }

            this.writeEntityToNBT(tagCompund);

            if (this.ridingEntity != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();

                if (this.ridingEntity.writeMountToNBT(nbttagcompound))
                {
                    tagCompund.func_74782_a("Riding", nbttagcompound);
                }
            }
        }
        catch (Throwable throwable)
        {
            CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Saving entity NBT");
            CrashReportCategory crashreportcategory = crashreport.makeCategory("Entity being saved");
            this.addEntityCrashInfo(crashreportcategory);
            throw new ReportedException(crashreport);
        }
    }

    /**
     * Reads the entity from NBT (calls an abstract helper method to read specialized data)
     */
    public void func_70020_e(NBTTagCompound tagCompund)
    {
        try
        {
            NBTTagList nbttaglist = tagCompund.getTagList("Pos", 6);
            NBTTagList nbttaglist1 = tagCompund.getTagList("Motion", 6);
            NBTTagList nbttaglist2 = tagCompund.getTagList("Rotation", 5);
            this.motionX = nbttaglist1.getDoubleAt(0);
            this.motionY = nbttaglist1.getDoubleAt(1);
            this.motionZ = nbttaglist1.getDoubleAt(2);

            if (Math.abs(this.motionX) > 10.0D)
            {
                this.motionX = 0.0D;
            }

            if (Math.abs(this.motionY) > 10.0D)
            {
                this.motionY = 0.0D;
            }

            if (Math.abs(this.motionZ) > 10.0D)
            {
                this.motionZ = 0.0D;
            }

            this.prevPosX = this.lastTickPosX = this.field_70165_t = nbttaglist.getDoubleAt(0);
            this.prevPosY = this.lastTickPosY = this.field_70163_u = nbttaglist.getDoubleAt(1);
            this.prevPosZ = this.lastTickPosZ = this.field_70161_v = nbttaglist.getDoubleAt(2);
            this.prevRotationYaw = this.field_70177_z = nbttaglist2.getFloatAt(0);
            this.prevRotationPitch = this.field_70125_A = nbttaglist2.getFloatAt(1);
            this.func_70034_d(this.field_70177_z);
            this.func_181013_g(this.field_70177_z);
            this.field_70143_R = tagCompund.getFloat("FallDistance");
            this.fire = tagCompund.func_74765_d("Fire");
            this.setAir(tagCompund.func_74765_d("Air"));
            this.onGround = tagCompund.getBoolean("OnGround");
            this.dimension = tagCompund.getInteger("Dimension");
            this.invulnerable = tagCompund.getBoolean("Invulnerable");
            this.timeUntilPortal = tagCompund.getInteger("PortalCooldown");

            if (tagCompund.func_150297_b("UUIDMost", 4) && tagCompund.func_150297_b("UUIDLeast", 4))
            {
                this.entityUniqueID = new UUID(tagCompund.getLong("UUIDMost"), tagCompund.getLong("UUIDLeast"));
            }
            else if (tagCompund.func_150297_b("UUID", 8))
            {
                this.entityUniqueID = UUID.fromString(tagCompund.getString("UUID"));
            }

            this.setPosition(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.setRotation(this.field_70177_z, this.field_70125_A);

            if (tagCompund.func_150297_b("CustomName", 8) && tagCompund.getString("CustomName").length() > 0)
            {
                this.setCustomNameTag(tagCompund.getString("CustomName"));
            }

            this.setAlwaysRenderNameTag(tagCompund.getBoolean("CustomNameVisible"));
            this.cmdResultStats.readStatsFromNBT(tagCompund);
            this.setSilent(tagCompund.getBoolean("Silent"));
            this.readEntityFromNBT(tagCompund);

            if (this.shouldSetPosAfterLoading())
            {
                this.setPosition(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            }
        }
        catch (Throwable throwable)
        {
            CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Loading entity NBT");
            CrashReportCategory crashreportcategory = crashreport.makeCategory("Entity being loaded");
            this.addEntityCrashInfo(crashreportcategory);
            throw new ReportedException(crashreport);
        }
    }

    protected boolean shouldSetPosAfterLoading()
    {
        return true;
    }

    /**
     * Returns the string that identifies this Entity's class
     */
    protected final String getEntityString()
    {
        return EntityList.getEntityString(this);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected abstract void readEntityFromNBT(NBTTagCompound tagCompund);

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    protected abstract void writeEntityToNBT(NBTTagCompound tagCompound);

    public void onChunkLoad()
    {
    }

    /**
     * creates a NBT list from the array of doubles passed to this function
     */
    protected NBTTagList newDoubleNBTList(double... numbers)
    {
        NBTTagList nbttaglist = new NBTTagList();

        for (double d0 : numbers)
        {
            nbttaglist.func_74742_a(new NBTTagDouble(d0));
        }

        return nbttaglist;
    }

    /**
     * Returns a new NBTTagList filled with the specified floats
     */
    protected NBTTagList newFloatNBTList(float... numbers)
    {
        NBTTagList nbttaglist = new NBTTagList();

        for (float f : numbers)
        {
            nbttaglist.func_74742_a(new NBTTagFloat(f));
        }

        return nbttaglist;
    }

    public EntityItem dropItem(Item itemIn, int size)
    {
        return this.dropItemWithOffset(itemIn, size, 0.0F);
    }

    public EntityItem dropItemWithOffset(Item itemIn, int size, float offsetY)
    {
        return this.entityDropItem(new ItemStack(itemIn, size, 0), offsetY);
    }

    /**
     * Drops an item at the position of the entity.
     */
    public EntityItem entityDropItem(ItemStack itemStackIn, float offsetY)
    {
        if (itemStackIn.field_77994_a != 0 && itemStackIn.func_77973_b() != null)
        {
            EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)offsetY, this.field_70161_v, itemStackIn);
            entityitem.setDefaultPickupDelay();
            this.field_70170_p.func_72838_d(entityitem);
            return entityitem;
        }
        else
        {
            return null;
        }
    }

    /**
     * Checks whether target entity is alive.
     */
    public boolean isEntityAlive()
    {
        return !this.isDead;
    }

    /**
     * Checks if this entity is inside of an opaque block
     */
    public boolean isEntityInsideOpaqueBlock()
    {
        if (this.noClip)
        {
            return false;
        }
        else
        {
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

            for (int i = 0; i < 8; ++i)
            {
                int j = MathHelper.func_76128_c(this.field_70163_u + (double)(((float)((i >> 0) % 2) - 0.5F) * 0.1F) + (double)this.getEyeHeight());
                int k = MathHelper.func_76128_c(this.field_70165_t + (double)(((float)((i >> 1) % 2) - 0.5F) * this.width * 0.8F));
                int l = MathHelper.func_76128_c(this.field_70161_v + (double)(((float)((i >> 2) % 2) - 0.5F) * this.width * 0.8F));

                if (blockpos$mutableblockpos.func_177958_n() != k || blockpos$mutableblockpos.func_177956_o() != j || blockpos$mutableblockpos.func_177952_p() != l)
                {
                    blockpos$mutableblockpos.func_181079_c(k, j, l);

                    if (this.field_70170_p.func_180495_p(blockpos$mutableblockpos).func_177230_c().isVisuallyOpaque())
                    {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    /**
     * First layer of player interaction
     */
    public boolean interactFirst(EntityPlayer playerIn)
    {
        return false;
    }

    /**
     * Returns a boundingBox used to collide the entity with other entities and blocks. This enables the entity to be
     * pushable on contact, like boats or minecarts.
     */
    public AxisAlignedBB getCollisionBox(Entity entityIn)
    {
        return null;
    }

    /**
     * Handles updating while being ridden by an entity
     */
    public void updateRidden()
    {
        if (this.ridingEntity.isDead)
        {
            this.ridingEntity = null;
        }
        else
        {
            this.motionX = 0.0D;
            this.motionY = 0.0D;
            this.motionZ = 0.0D;
            this.onUpdate();

            if (this.ridingEntity != null)
            {
                this.ridingEntity.updateRiderPosition();
                this.entityRiderYawDelta += (double)(this.ridingEntity.field_70177_z - this.ridingEntity.prevRotationYaw);

                for (this.entityRiderPitchDelta += (double)(this.ridingEntity.field_70125_A - this.ridingEntity.prevRotationPitch); this.entityRiderYawDelta >= 180.0D; this.entityRiderYawDelta -= 360.0D)
                {
                    ;
                }

                while (this.entityRiderYawDelta < -180.0D)
                {
                    this.entityRiderYawDelta += 360.0D;
                }

                while (this.entityRiderPitchDelta >= 180.0D)
                {
                    this.entityRiderPitchDelta -= 360.0D;
                }

                while (this.entityRiderPitchDelta < -180.0D)
                {
                    this.entityRiderPitchDelta += 360.0D;
                }

                double d0 = this.entityRiderYawDelta * 0.5D;
                double d1 = this.entityRiderPitchDelta * 0.5D;
                float f = 10.0F;

                if (d0 > (double)f)
                {
                    d0 = (double)f;
                }

                if (d0 < (double)(-f))
                {
                    d0 = (double)(-f);
                }

                if (d1 > (double)f)
                {
                    d1 = (double)f;
                }

                if (d1 < (double)(-f))
                {
                    d1 = (double)(-f);
                }

                this.entityRiderYawDelta -= d0;
                this.entityRiderPitchDelta -= d1;
            }
        }
    }

    public void updateRiderPosition()
    {
        if (this.riddenByEntity != null)
        {
            this.riddenByEntity.setPosition(this.field_70165_t, this.field_70163_u + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), this.field_70161_v);
        }
    }

    /**
     * Returns the Y Offset of this entity.
     */
    public double getYOffset()
    {
        return 0.0D;
    }

    /**
     * Returns the Y offset from the entity's position for any entity riding this one.
     */
    public double getMountedYOffset()
    {
        return (double)this.height * 0.75D;
    }

    /**
     * Called when a player mounts an entity. e.g. mounts a pig, mounts a boat.
     */
    public void func_70078_a(Entity entityIn)
    {
        this.entityRiderPitchDelta = 0.0D;
        this.entityRiderYawDelta = 0.0D;

        if (entityIn == null)
        {
            if (this.ridingEntity != null)
            {
                this.func_70012_b(this.ridingEntity.field_70165_t, this.ridingEntity.getEntityBoundingBox().minY + (double)this.ridingEntity.height, this.ridingEntity.field_70161_v, this.field_70177_z, this.field_70125_A);
                this.ridingEntity.riddenByEntity = null;
            }

            this.ridingEntity = null;
        }
        else
        {
            if (this.ridingEntity != null)
            {
                this.ridingEntity.riddenByEntity = null;
            }

            if (entityIn != null)
            {
                for (Entity entity = entityIn.ridingEntity; entity != null; entity = entity.ridingEntity)
                {
                    if (entity == this)
                    {
                        return;
                    }
                }
            }

            this.ridingEntity = entityIn;
            entityIn.riddenByEntity = this;
        }
    }

    public void setPositionAndRotation2(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean p_180426_10_)
    {
        this.setPosition(x, y, z);
        this.setRotation(yaw, pitch);
        List<AxisAlignedBB> list = this.field_70170_p.getCollidingBoundingBoxes(this, this.getEntityBoundingBox().contract(0.03125D, 0.0D, 0.03125D));

        if (!list.isEmpty())
        {
            double d0 = 0.0D;

            for (AxisAlignedBB axisalignedbb : list)
            {
                if (axisalignedbb.maxY > d0)
                {
                    d0 = axisalignedbb.maxY;
                }
            }

            y = y + (d0 - this.getEntityBoundingBox().minY);
            this.setPosition(x, y, z);
        }
    }

    public float getCollisionBorderSize()
    {
        return 0.1F;
    }

    /**
     * returns a (normalized) vector of where this entity is looking
     */
    public Vec3 getLookVec()
    {
        return null;
    }

    public void func_181015_d(BlockPos p_181015_1_)
    {
        if (this.timeUntilPortal > 0)
        {
            this.timeUntilPortal = this.getPortalCooldown();
        }
        else
        {
            if (!this.field_70170_p.isRemote && !p_181015_1_.equals(this.field_181016_an))
            {
                this.field_181016_an = p_181015_1_;
                BlockPattern.PatternHelper blockpattern$patternhelper = Blocks.portal.func_181089_f(this.field_70170_p, p_181015_1_);
                double d0 = blockpattern$patternhelper.getFinger().getAxis() == EnumFacing.Axis.X ? (double)blockpattern$patternhelper.func_181117_a().func_177952_p() : (double)blockpattern$patternhelper.func_181117_a().func_177958_n();
                double d1 = blockpattern$patternhelper.getFinger().getAxis() == EnumFacing.Axis.X ? this.field_70161_v : this.field_70165_t;
                d1 = Math.abs(MathHelper.func_181160_c(d1 - (double)(blockpattern$patternhelper.getFinger().rotateY().getAxisDirection() == EnumFacing.AxisDirection.NEGATIVE ? 1 : 0), d0, d0 - (double)blockpattern$patternhelper.func_181118_d()));
                double d2 = MathHelper.func_181160_c(this.field_70163_u - 1.0D, (double)blockpattern$patternhelper.func_181117_a().func_177956_o(), (double)(blockpattern$patternhelper.func_181117_a().func_177956_o() - blockpattern$patternhelper.func_181119_e()));
                this.field_181017_ao = new Vec3(d1, d2, 0.0D);
                this.field_181018_ap = blockpattern$patternhelper.getFinger();
            }

            this.inPortal = true;
        }
    }

    /**
     * Return the amount of cooldown before this entity can use a portal again.
     */
    public int getPortalCooldown()
    {
        return 300;
    }

    /**
     * Sets the velocity to the args. Args: x, y, z
     */
    public void setVelocity(double x, double y, double z)
    {
        this.motionX = x;
        this.motionY = y;
        this.motionZ = z;
    }

    public void handleStatusUpdate(byte id)
    {
    }

    /**
     * Setups the entity to do the hurt animation. Only used by packets in multiplayer.
     */
    public void performHurtAnimation()
    {
    }

    /**
     * returns the inventory of this entity (only used in EntityPlayerMP it seems)
     */
    public ItemStack[] getInventory()
    {
        return null;
    }

    /**
     * Sets the held item, or an armor slot. Slot 0 is held item. Slot 1-4 is armor. Params: Item, slot
     */
    public void setCurrentItemOrArmor(int slotIn, ItemStack stack)
    {
    }

    /**
     * Returns true if the entity is on fire. Used by render to add the fire effect on rendering.
     */
    public boolean isBurning()
    {
        boolean flag = this.field_70170_p != null && this.field_70170_p.isRemote;
        return !this.isImmuneToFire && (this.fire > 0 || flag && this.getFlag(0));
    }

    /**
     * Returns true if the entity is riding another entity, used by render to rotate the legs to be in 'sit' position
     * for players.
     */
    public boolean isRiding()
    {
        return this.ridingEntity != null;
    }

    /**
     * Returns if this entity is sneaking.
     */
    public boolean isSneaking()
    {
        return this.getFlag(1);
    }

    /**
     * Sets the sneaking flag.
     */
    public void setSneaking(boolean sneaking)
    {
        this.setFlag(1, sneaking);
    }

    /**
     * Get if the Entity is sprinting.
     */
    public boolean isSprinting()
    {
        return this.getFlag(3);
    }

    /**
     * Set sprinting switch for Entity.
     */
    public void setSprinting(boolean sprinting)
    {
        this.setFlag(3, sprinting);
    }

    public boolean isInvisible()
    {
        return this.getFlag(5);
    }

    /**
     * Only used by renderer in EntityLivingBase subclasses.
     * Determines if an entity is visible or not to a specfic player, if the entity is normally invisible.
     * For EntityLivingBase subclasses, returning false when invisible will render the entity semitransparent.
     */
    public boolean isInvisibleToPlayer(EntityPlayer player)
    {
        return player.isSpectator() ? false : this.isInvisible();
    }

    public void setInvisible(boolean invisible)
    {
        this.setFlag(5, invisible);
    }

    public boolean isEating()
    {
        return this.getFlag(4);
    }

    public void setEating(boolean eating)
    {
        this.setFlag(4, eating);
    }

    /**
     * Returns true if the flag is active for the entity. Known flags: 0) is burning; 1) is sneaking; 2) is riding
     * something; 3) is sprinting; 4) is eating
     */
    protected boolean getFlag(int flag)
    {
        return (this.dataWatcher.getWatchableObjectByte(0) & 1 << flag) != 0;
    }

    /**
     * Enable or disable a entity flag, see getEntityFlag to read the know flags.
     */
    protected void setFlag(int flag, boolean set)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(0);

        if (set)
        {
            this.dataWatcher.updateObject(0, Byte.valueOf((byte)(b0 | 1 << flag)));
        }
        else
        {
            this.dataWatcher.updateObject(0, Byte.valueOf((byte)(b0 & ~(1 << flag))));
        }
    }

    public int getAir()
    {
        return this.dataWatcher.getWatchableObjectShort(1);
    }

    public void setAir(int air)
    {
        this.dataWatcher.updateObject(1, Short.valueOf((short)air));
    }

    /**
     * Called when a lightning bolt hits the entity.
     */
    public void onStruckByLightning(EntityLightningBolt lightningBolt)
    {
        this.attackEntityFrom(DamageSource.lightningBolt, 5.0F);
        ++this.fire;

        if (this.fire == 0)
        {
            this.setFire(8);
        }
    }

    /**
     * This method gets called when the entity kills another one.
     */
    public void onKillEntity(EntityLivingBase entityLivingIn)
    {
    }

    protected boolean pushOutOfBlocks(double x, double y, double z)
    {
        BlockPos blockpos = new BlockPos(x, y, z);
        double d0 = x - (double)blockpos.func_177958_n();
        double d1 = y - (double)blockpos.func_177956_o();
        double d2 = z - (double)blockpos.func_177952_p();
        List<AxisAlignedBB> list = this.field_70170_p.func_147461_a(this.getEntityBoundingBox());

        if (list.isEmpty() && !this.field_70170_p.isBlockFullCube(blockpos))
        {
            return false;
        }
        else
        {
            int i = 3;
            double d3 = 9999.0D;

            if (!this.field_70170_p.isBlockFullCube(blockpos.west()) && d0 < d3)
            {
                d3 = d0;
                i = 0;
            }

            if (!this.field_70170_p.isBlockFullCube(blockpos.east()) && 1.0D - d0 < d3)
            {
                d3 = 1.0D - d0;
                i = 1;
            }

            if (!this.field_70170_p.isBlockFullCube(blockpos.up()) && 1.0D - d1 < d3)
            {
                d3 = 1.0D - d1;
                i = 3;
            }

            if (!this.field_70170_p.isBlockFullCube(blockpos.north()) && d2 < d3)
            {
                d3 = d2;
                i = 4;
            }

            if (!this.field_70170_p.isBlockFullCube(blockpos.south()) && 1.0D - d2 < d3)
            {
                d3 = 1.0D - d2;
                i = 5;
            }

            float f = this.rand.nextFloat() * 0.2F + 0.1F;

            if (i == 0)
            {
                this.motionX = (double)(-f);
            }

            if (i == 1)
            {
                this.motionX = (double)f;
            }

            if (i == 3)
            {
                this.motionY = (double)f;
            }

            if (i == 4)
            {
                this.motionZ = (double)(-f);
            }

            if (i == 5)
            {
                this.motionZ = (double)f;
            }

            return true;
        }
    }

    /**
     * Sets the Entity inside a web block.
     */
    public void setInWeb()
    {
        this.isInWeb = true;
        this.field_70143_R = 0.0F;
    }

    /**
     * Gets the name of this command sender (usually username, but possibly "Rcon")
     */
    public String func_70005_c_()
    {
        if (this.hasCustomName())
        {
            return this.getCustomNameTag();
        }
        else
        {
            String s = EntityList.getEntityString(this);

            if (s == null)
            {
                s = "generic";
            }

            return StatCollector.translateToLocal("entity." + s + ".name");
        }
    }

    /**
     * Return the Entity parts making up this Entity (currently only for dragons)
     */
    public Entity[] getParts()
    {
        return null;
    }

    /**
     * Returns true if Entity argument is equal to this Entity
     */
    public boolean isEntityEqual(Entity entityIn)
    {
        return this == entityIn;
    }

    public float getRotationYawHead()
    {
        return 0.0F;
    }

    /**
     * Sets the head's yaw rotation of the entity.
     */
    public void func_70034_d(float rotation)
    {
    }

    public void func_181013_g(float p_181013_1_)
    {
    }

    /**
     * If returns false, the item will not inflict any damage against entities.
     */
    public boolean canAttackWithItem()
    {
        return true;
    }

    /**
     * Called when a player attacks an entity. If this returns true the attack will not happen.
     */
    public boolean hitByEntity(Entity entityIn)
    {
        return false;
    }

    public String toString()
    {
        return String.format("%s[\'%s\'/%d, l=\'%s\', x=%.2f, y=%.2f, z=%.2f]", new Object[] {this.getClass().getSimpleName(), this.func_70005_c_(), Integer.valueOf(this.entityId), this.field_70170_p == null ? "~NULL~" : this.field_70170_p.func_72912_H().getWorldName(), Double.valueOf(this.field_70165_t), Double.valueOf(this.field_70163_u), Double.valueOf(this.field_70161_v)});
    }

    public boolean isEntityInvulnerable(DamageSource source)
    {
        return this.invulnerable && source != DamageSource.outOfWorld && !source.isCreativePlayer();
    }

    /**
     * Sets this entity's location and angles to the location and angles of the passed in entity.
     */
    public void copyLocationAndAnglesFrom(Entity entityIn)
    {
        this.func_70012_b(entityIn.field_70165_t, entityIn.field_70163_u, entityIn.field_70161_v, entityIn.field_70177_z, entityIn.field_70125_A);
    }

    /**
     * Prepares this entity in new dimension by copying NBT data from entity in old dimension
     */
    public void copyDataFromOld(Entity entityIn)
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        entityIn.func_70109_d(nbttagcompound);
        this.func_70020_e(nbttagcompound);
        this.timeUntilPortal = entityIn.timeUntilPortal;
        this.field_181016_an = entityIn.field_181016_an;
        this.field_181017_ao = entityIn.field_181017_ao;
        this.field_181018_ap = entityIn.field_181018_ap;
    }

    /**
     * Teleports the entity to another dimension. Params: Dimension number to teleport to
     */
    public void travelToDimension(int dimensionId)
    {
        if (!this.field_70170_p.isRemote && !this.isDead)
        {
            this.field_70170_p.theProfiler.startSection("changeDimension");
            MinecraftServer minecraftserver = MinecraftServer.func_71276_C();
            int i = this.dimension;
            WorldServer worldserver = minecraftserver.func_71218_a(i);
            WorldServer worldserver1 = minecraftserver.func_71218_a(dimensionId);
            this.dimension = dimensionId;

            if (i == 1 && dimensionId == 1)
            {
                worldserver1 = minecraftserver.func_71218_a(0);
                this.dimension = 0;
            }

            this.field_70170_p.removeEntity(this);
            this.isDead = false;
            this.field_70170_p.theProfiler.startSection("reposition");
            minecraftserver.func_71203_ab().transferEntityToWorld(this, i, worldserver, worldserver1);
            this.field_70170_p.theProfiler.endStartSection("reloading");
            Entity entity = EntityList.createEntityByName(EntityList.getEntityString(this), worldserver1);

            if (entity != null)
            {
                entity.copyDataFromOld(this);

                if (i == 1 && dimensionId == 1)
                {
                    BlockPos blockpos = this.field_70170_p.getTopSolidOrLiquidBlock(worldserver1.getSpawnPoint());
                    entity.moveToBlockPosAndAngles(blockpos, entity.field_70177_z, entity.field_70125_A);
                }

                worldserver1.func_72838_d(entity);
            }

            this.isDead = true;
            this.field_70170_p.theProfiler.endSection();
            worldserver.resetUpdateEntityTick();
            worldserver1.resetUpdateEntityTick();
            this.field_70170_p.theProfiler.endSection();
        }
    }

    /**
     * Explosion resistance of a block relative to this entity
     */
    public float getExplosionResistance(Explosion explosionIn, World worldIn, BlockPos pos, IBlockState blockStateIn)
    {
        return blockStateIn.func_177230_c().getExplosionResistance(this);
    }

    public boolean verifyExplosion(Explosion explosionIn, World worldIn, BlockPos pos, IBlockState blockStateIn, float p_174816_5_)
    {
        return true;
    }

    /**
     * The maximum height from where the entity is alowed to jump (used in pathfinder)
     */
    public int getMaxFallHeight()
    {
        return 3;
    }

    public Vec3 func_181014_aG()
    {
        return this.field_181017_ao;
    }

    public EnumFacing func_181012_aH()
    {
        return this.field_181018_ap;
    }

    /**
     * Return whether this entity should NOT trigger a pressure plate or a tripwire.
     */
    public boolean doesEntityNotTriggerPressurePlate()
    {
        return false;
    }

    public void addEntityCrashInfo(CrashReportCategory category)
    {
        category.addCrashSectionCallable("Entity Type", new Callable<String>()
        {
            public String call() throws Exception
            {
                return EntityList.getEntityString(Entity.this) + " (" + Entity.this.getClass().getCanonicalName() + ")";
            }
        });
        category.addCrashSection("Entity ID", Integer.valueOf(this.entityId));
        category.addCrashSectionCallable("Entity Name", new Callable<String>()
        {
            public String call() throws Exception
            {
                return Entity.this.func_70005_c_();
            }
        });
        category.addCrashSection("Entity\'s Exact location", String.format("%.2f, %.2f, %.2f", new Object[] {Double.valueOf(this.field_70165_t), Double.valueOf(this.field_70163_u), Double.valueOf(this.field_70161_v)}));
        category.addCrashSection("Entity\'s Block location", CrashReportCategory.getCoordinateInfo((double)MathHelper.func_76128_c(this.field_70165_t), (double)MathHelper.func_76128_c(this.field_70163_u), (double)MathHelper.func_76128_c(this.field_70161_v)));
        category.addCrashSection("Entity\'s Momentum", String.format("%.2f, %.2f, %.2f", new Object[] {Double.valueOf(this.motionX), Double.valueOf(this.motionY), Double.valueOf(this.motionZ)}));
        category.addCrashSectionCallable("Entity\'s Rider", new Callable<String>()
        {
            public String call() throws Exception
            {
                return Entity.this.riddenByEntity.toString();
            }
        });
        category.addCrashSectionCallable("Entity\'s Vehicle", new Callable<String>()
        {
            public String call() throws Exception
            {
                return Entity.this.ridingEntity.toString();
            }
        });
    }

    /**
     * Return whether this entity should be rendered as on fire.
     */
    public boolean canRenderOnFire()
    {
        return this.isBurning();
    }

    public UUID func_110124_au()
    {
        return this.entityUniqueID;
    }

    public boolean isPushedByWater()
    {
        return true;
    }

    /**
     * Get the formatted ChatComponent that will be used for the sender's username in chat
     */
    public IChatComponent func_145748_c_()
    {
        ChatComponentText chatcomponenttext = new ChatComponentText(this.func_70005_c_());
        chatcomponenttext.func_150256_b().setChatHoverEvent(this.getHoverEvent());
        chatcomponenttext.func_150256_b().setInsertion(this.func_110124_au().toString());
        return chatcomponenttext;
    }

    /**
     * Sets the custom name tag for this entity
     */
    public void setCustomNameTag(String name)
    {
        this.dataWatcher.updateObject(2, name);
    }

    public String getCustomNameTag()
    {
        return this.dataWatcher.getWatchableObjectString(2);
    }

    /**
     * Returns true if this thing is named
     */
    public boolean hasCustomName()
    {
        return this.dataWatcher.getWatchableObjectString(2).length() > 0;
    }

    public void setAlwaysRenderNameTag(boolean alwaysRenderNameTag)
    {
        this.dataWatcher.updateObject(3, Byte.valueOf((byte)(alwaysRenderNameTag ? 1 : 0)));
    }

    public boolean getAlwaysRenderNameTag()
    {
        return this.dataWatcher.getWatchableObjectByte(3) == 1;
    }

    /**
     * Sets the position of the entity and updates the 'last' variables
     */
    public void func_70634_a(double x, double y, double z)
    {
        this.func_70012_b(x, y, z, this.field_70177_z, this.field_70125_A);
    }

    public boolean getAlwaysRenderNameTagForRender()
    {
        return this.getAlwaysRenderNameTag();
    }

    public void onDataWatcherUpdate(int dataID)
    {
    }

    public EnumFacing getHorizontalFacing()
    {
        return EnumFacing.getHorizontal(MathHelper.func_76128_c((double)(this.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3);
    }

    protected HoverEvent getHoverEvent()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        String s = EntityList.getEntityString(this);
        nbttagcompound.func_74778_a("id", this.func_110124_au().toString());

        if (s != null)
        {
            nbttagcompound.func_74778_a("type", s);
        }

        nbttagcompound.func_74778_a("name", this.func_70005_c_());
        return new HoverEvent(HoverEvent.Action.SHOW_ENTITY, new ChatComponentText(nbttagcompound.toString()));
    }

    public boolean isSpectatedByPlayer(EntityPlayerMP player)
    {
        return true;
    }

    public AxisAlignedBB getEntityBoundingBox()
    {
        return this.boundingBox;
    }

    public void setEntityBoundingBox(AxisAlignedBB bb)
    {
        this.boundingBox = bb;
    }

    public float getEyeHeight()
    {
        return this.height * 0.85F;
    }

    public boolean isOutsideBorder()
    {
        return this.isOutsideBorder;
    }

    public void setOutsideBorder(boolean outsideBorder)
    {
        this.isOutsideBorder = outsideBorder;
    }

    public boolean func_174820_d(int inventorySlot, ItemStack itemStackIn)
    {
        return false;
    }

    /**
     * Send a chat message to the CommandSender
     */
    public void func_145747_a(IChatComponent component)
    {
    }

    /**
     * Returns {@code true} if the CommandSender is allowed to execute the command, {@code false} if not
     */
    public boolean func_70003_b(int permLevel, String commandName)
    {
        return true;
    }

    /**
     * Get the position in the world. <b>{@code null} is not allowed!</b> If you are not an entity in the world, return
     * the coordinates 0, 0, 0
     */
    public BlockPos func_180425_c()
    {
        return new BlockPos(this.field_70165_t, this.field_70163_u + 0.5D, this.field_70161_v);
    }

    /**
     * Get the position vector. <b>{@code null} is not allowed!</b> If you are not an entity in the world, return 0.0D,
     * 0.0D, 0.0D
     */
    public Vec3 func_174791_d()
    {
        return new Vec3(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    }

    /**
     * Get the world, if available. <b>{@code null} is not allowed!</b> If you are not an entity in the world, return
     * the overworld
     */
    public World func_130014_f_()
    {
        return this.field_70170_p;
    }

    /**
     * Returns the entity associated with the command sender. MAY BE NULL!
     */
    public Entity func_174793_f()
    {
        return this;
    }

    /**
     * Returns true if the command sender should be sent feedback about executed commands
     */
    public boolean func_174792_t_()
    {
        return false;
    }

    public void func_174794_a(CommandResultStats.Type type, int amount)
    {
        this.cmdResultStats.func_179672_a(this, type, amount);
    }

    public CommandResultStats func_174807_aT()
    {
        return this.cmdResultStats;
    }

    public void func_174817_o(Entity entityIn)
    {
        this.cmdResultStats.func_179671_a(entityIn.func_174807_aT());
    }

    public NBTTagCompound getNBTTagCompound()
    {
        return null;
    }

    /**
     * Called when client receives entity's NBTTagCompound from server.
     */
    public void clientUpdateEntityNBT(NBTTagCompound compound)
    {
    }

    /**
     * New version of interactWith that includes vector information on where precisely the player targeted.
     */
    public boolean interactAt(EntityPlayer player, Vec3 targetVec3)
    {
        return false;
    }

    public boolean isImmuneToExplosions()
    {
        return false;
    }

    protected void applyEnchantments(EntityLivingBase entityLivingBaseIn, Entity entityIn)
    {
        if (entityIn instanceof EntityLivingBase)
        {
            EnchantmentHelper.applyThornEnchantments((EntityLivingBase)entityIn, entityLivingBaseIn);
        }

        EnchantmentHelper.applyArthropodEnchantments(entityLivingBaseIn, entityIn);
    }
}
