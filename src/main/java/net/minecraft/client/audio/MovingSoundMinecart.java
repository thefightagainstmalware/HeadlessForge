package net.minecraft.client.audio;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class MovingSoundMinecart extends MovingSound
{
    private final EntityMinecart minecart;
    private float distance = 0.0F;

    public MovingSoundMinecart(EntityMinecart minecartIn)
    {
        super(new ResourceLocation("minecraft:minecart.base"));
        this.minecart = minecartIn;
        this.repeat = true;
        this.repeatDelay = 0;
    }

    /**
     * Like the old updateEntity(), except more generic.
     */
    public void update()
    {
        if (this.minecart.isDead)
        {
            this.donePlaying = true;
        }
        else
        {
            this.xPosF = (float)this.minecart.field_70165_t;
            this.yPosF = (float)this.minecart.field_70163_u;
            this.zPosF = (float)this.minecart.field_70161_v;
            float f = MathHelper.func_76133_a(this.minecart.motionX * this.minecart.motionX + this.minecart.motionZ * this.minecart.motionZ);

            if ((double)f >= 0.01D)
            {
                this.distance = MathHelper.func_76131_a(this.distance + 0.0025F, 0.0F, 1.0F);
                this.volume = 0.0F + MathHelper.func_76131_a(f, 0.0F, 0.5F) * 0.7F;
            }
            else
            {
                this.distance = 0.0F;
                this.volume = 0.0F;
            }
        }
    }
}
