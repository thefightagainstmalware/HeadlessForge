package net.minecraft.entity.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityFireworkRocket extends Entity
{
    /** The age of the firework in ticks. */
    private int fireworkAge;

    /**
     * The lifetime of the firework in ticks. When the age reaches the lifetime the firework explodes.
     */
    private int lifetime;

    public EntityFireworkRocket(World worldIn)
    {
        super(worldIn);
        this.setSize(0.25F, 0.25F);
    }

    protected void entityInit()
    {
        this.dataWatcher.addObjectByDataType(8, 5);
    }

    /**
     * Checks if the entity is in range to render by using the past in distance and comparing it to its average edge
     * length * 64 * renderDistanceWeight Args: distance
     */
    public boolean isInRangeToRenderDist(double distance)
    {
        return distance < 4096.0D;
    }

    public EntityFireworkRocket(World worldIn, double x, double y, double z, ItemStack givenItem)
    {
        super(worldIn);
        this.fireworkAge = 0;
        this.setSize(0.25F, 0.25F);
        this.setPosition(x, y, z);
        int i = 1;

        if (givenItem != null && givenItem.func_77942_o())
        {
            this.dataWatcher.updateObject(8, givenItem);
            NBTTagCompound nbttagcompound = givenItem.func_77978_p();
            NBTTagCompound nbttagcompound1 = nbttagcompound.func_74775_l("Fireworks");

            if (nbttagcompound1 != null)
            {
                i += nbttagcompound1.getByte("Flight");
            }
        }

        this.motionX = this.rand.nextGaussian() * 0.001D;
        this.motionZ = this.rand.nextGaussian() * 0.001D;
        this.motionY = 0.05D;
        this.lifetime = 10 * i + this.rand.nextInt(6) + this.rand.nextInt(7);
    }

    /**
     * Sets the velocity to the args. Args: x, y, z
     */
    public void setVelocity(double x, double y, double z)
    {
        this.motionX = x;
        this.motionY = y;
        this.motionZ = z;

        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
        {
            float f = MathHelper.func_76133_a(x * x + z * z);
            this.prevRotationYaw = this.field_70177_z = (float)(MathHelper.func_181159_b(x, z) * 180.0D / Math.PI);
            this.prevRotationPitch = this.field_70125_A = (float)(MathHelper.func_181159_b(y, (double)f) * 180.0D / Math.PI);
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        this.lastTickPosX = this.field_70165_t;
        this.lastTickPosY = this.field_70163_u;
        this.lastTickPosZ = this.field_70161_v;
        super.onUpdate();
        this.motionX *= 1.15D;
        this.motionZ *= 1.15D;
        this.motionY += 0.04D;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        float f = MathHelper.func_76133_a(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.field_70177_z = (float)(MathHelper.func_181159_b(this.motionX, this.motionZ) * 180.0D / Math.PI);

        for (this.field_70125_A = (float)(MathHelper.func_181159_b(this.motionY, (double)f) * 180.0D / Math.PI); this.field_70125_A - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
        {
            ;
        }

        while (this.field_70125_A - this.prevRotationPitch >= 180.0F)
        {
            this.prevRotationPitch += 360.0F;
        }

        while (this.field_70177_z - this.prevRotationYaw < -180.0F)
        {
            this.prevRotationYaw -= 360.0F;
        }

        while (this.field_70177_z - this.prevRotationYaw >= 180.0F)
        {
            this.prevRotationYaw += 360.0F;
        }

        this.field_70125_A = this.prevRotationPitch + (this.field_70125_A - this.prevRotationPitch) * 0.2F;
        this.field_70177_z = this.prevRotationYaw + (this.field_70177_z - this.prevRotationYaw) * 0.2F;

        if (this.fireworkAge == 0 && !this.isSilent())
        {
            this.field_70170_p.func_72956_a(this, "fireworks.launch", 3.0F, 1.0F);
        }

        ++this.fireworkAge;

        if (this.field_70170_p.isRemote && this.fireworkAge % 2 < 2)
        {
            this.field_70170_p.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, this.field_70165_t, this.field_70163_u - 0.3D, this.field_70161_v, this.rand.nextGaussian() * 0.05D, -this.motionY * 0.5D, this.rand.nextGaussian() * 0.05D, new int[0]);
        }

        if (!this.field_70170_p.isRemote && this.fireworkAge > this.lifetime)
        {
            this.field_70170_p.setEntityState(this, (byte)17);
            this.setDead();
        }
    }

    public void handleStatusUpdate(byte id)
    {
        if (id == 17 && this.field_70170_p.isRemote)
        {
            ItemStack itemstack = this.dataWatcher.getWatchableObjectItemStack(8);
            NBTTagCompound nbttagcompound = null;

            if (itemstack != null && itemstack.func_77942_o())
            {
                nbttagcompound = itemstack.func_77978_p().func_74775_l("Fireworks");
            }

            this.field_70170_p.makeFireworks(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.motionX, this.motionY, this.motionZ, nbttagcompound);
        }

        super.handleStatusUpdate(id);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        tagCompound.func_74768_a("Life", this.fireworkAge);
        tagCompound.func_74768_a("LifeTime", this.lifetime);
        ItemStack itemstack = this.dataWatcher.getWatchableObjectItemStack(8);

        if (itemstack != null)
        {
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            itemstack.writeToNBT(nbttagcompound);
            tagCompound.func_74782_a("FireworksItem", nbttagcompound);
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        this.fireworkAge = tagCompund.getInteger("Life");
        this.lifetime = tagCompund.getInteger("LifeTime");
        NBTTagCompound nbttagcompound = tagCompund.func_74775_l("FireworksItem");

        if (nbttagcompound != null)
        {
            ItemStack itemstack = ItemStack.loadItemStackFromNBT(nbttagcompound);

            if (itemstack != null)
            {
                this.dataWatcher.updateObject(8, itemstack);
            }
        }
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness(float partialTicks)
    {
        return super.getBrightness(partialTicks);
    }

    public int getBrightnessForRender(float partialTicks)
    {
        return super.getBrightnessForRender(partialTicks);
    }

    /**
     * If returns false, the item will not inflict any damage against entities.
     */
    public boolean canAttackWithItem()
    {
        return false;
    }
}
