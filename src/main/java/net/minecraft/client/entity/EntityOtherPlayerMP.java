package net.minecraft.client.entity;

import com.mojang.authlib.GameProfile;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityOtherPlayerMP extends AbstractClientPlayer
{
    private boolean isItemInUse;
    private int otherPlayerMPPosRotationIncrements;
    private double otherPlayerMPX;
    private double otherPlayerMPY;
    private double otherPlayerMPZ;
    private double otherPlayerMPYaw;
    private double otherPlayerMPPitch;

    public EntityOtherPlayerMP(World worldIn, GameProfile gameProfileIn)
    {
        super(worldIn, gameProfileIn);
        this.stepHeight = 0.0F;
        this.noClip = true;
        this.renderOffsetY = 0.25F;
        this.renderDistanceWeight = 10.0D;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        return true;
    }

    public void setPositionAndRotation2(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean p_180426_10_)
    {
        this.otherPlayerMPX = x;
        this.otherPlayerMPY = y;
        this.otherPlayerMPZ = z;
        this.otherPlayerMPYaw = (double)yaw;
        this.otherPlayerMPPitch = (double)pitch;
        this.otherPlayerMPPosRotationIncrements = posRotationIncrements;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        this.renderOffsetY = 0.0F;
        super.onUpdate();
        this.prevLimbSwingAmount = this.limbSwingAmount;
        double d0 = this.field_70165_t - this.prevPosX;
        double d1 = this.field_70161_v - this.prevPosZ;
        float f = MathHelper.func_76133_a(d0 * d0 + d1 * d1) * 4.0F;

        if (f > 1.0F)
        {
            f = 1.0F;
        }

        this.limbSwingAmount += (f - this.limbSwingAmount) * 0.4F;
        this.limbSwing += this.limbSwingAmount;

        if (!this.isItemInUse && this.isEating() && this.field_71071_by.mainInventory[this.field_71071_by.currentItem] != null)
        {
            ItemStack itemstack = this.field_71071_by.mainInventory[this.field_71071_by.currentItem];
            this.setItemInUse(this.field_71071_by.mainInventory[this.field_71071_by.currentItem], itemstack.func_77973_b().getMaxItemUseDuration(itemstack));
            this.isItemInUse = true;
        }
        else if (this.isItemInUse && !this.isEating())
        {
            this.clearItemInUse();
            this.isItemInUse = false;
        }
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        if (this.otherPlayerMPPosRotationIncrements > 0)
        {
            double d0 = this.field_70165_t + (this.otherPlayerMPX - this.field_70165_t) / (double)this.otherPlayerMPPosRotationIncrements;
            double d1 = this.field_70163_u + (this.otherPlayerMPY - this.field_70163_u) / (double)this.otherPlayerMPPosRotationIncrements;
            double d2 = this.field_70161_v + (this.otherPlayerMPZ - this.field_70161_v) / (double)this.otherPlayerMPPosRotationIncrements;
            double d3;

            for (d3 = this.otherPlayerMPYaw - (double)this.field_70177_z; d3 < -180.0D; d3 += 360.0D)
            {
                ;
            }

            while (d3 >= 180.0D)
            {
                d3 -= 360.0D;
            }

            this.field_70177_z = (float)((double)this.field_70177_z + d3 / (double)this.otherPlayerMPPosRotationIncrements);
            this.field_70125_A = (float)((double)this.field_70125_A + (this.otherPlayerMPPitch - (double)this.field_70125_A) / (double)this.otherPlayerMPPosRotationIncrements);
            --this.otherPlayerMPPosRotationIncrements;
            this.setPosition(d0, d1, d2);
            this.setRotation(this.field_70177_z, this.field_70125_A);
        }

        this.prevCameraYaw = this.cameraYaw;
        this.updateArmSwingProgress();
        float f1 = MathHelper.func_76133_a(this.motionX * this.motionX + this.motionZ * this.motionZ);
        float f = (float)Math.atan(-this.motionY * 0.20000000298023224D) * 15.0F;

        if (f1 > 0.1F)
        {
            f1 = 0.1F;
        }

        if (!this.onGround || this.getHealth() <= 0.0F)
        {
            f1 = 0.0F;
        }

        if (this.onGround || this.getHealth() <= 0.0F)
        {
            f = 0.0F;
        }

        this.cameraYaw += (f1 - this.cameraYaw) * 0.4F;
        this.cameraPitch += (f - this.cameraPitch) * 0.8F;
    }

    /**
     * Sets the held item, or an armor slot. Slot 0 is held item. Slot 1-4 is armor. Params: Item, slot
     */
    public void setCurrentItemOrArmor(int slotIn, ItemStack stack)
    {
        if (slotIn == 0)
        {
            this.field_71071_by.mainInventory[this.field_71071_by.currentItem] = stack;
        }
        else
        {
            this.field_71071_by.armorInventory[slotIn - 1] = stack;
        }
    }

    /**
     * Send a chat message to the CommandSender
     */
    public void func_145747_a(IChatComponent component) {}

    /**
     * Returns {@code true} if the CommandSender is allowed to execute the command, {@code false} if not
     */
    public boolean func_70003_b(int permLevel, String commandName)
    {
        return false;
    }

    /**
     * Get the position in the world. <b>{@code null} is not allowed!</b> If you are not an entity in the world, return
     * the coordinates 0, 0, 0
     */
    public BlockPos func_180425_c()
    {
        return new BlockPos(this.field_70165_t + 0.5D, this.field_70163_u + 0.5D, this.field_70161_v + 0.5D);
    }
}
