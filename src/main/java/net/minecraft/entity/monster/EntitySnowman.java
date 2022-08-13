package net.minecraft.entity.monster;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntitySnowman extends EntityGolem implements IRangedAttackMob
{
    public EntitySnowman(World worldIn)
    {
        super(worldIn);
        this.setSize(0.7F, 1.9F);
        ((PathNavigateGround)this.getNavigator()).setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAIArrowAttack(this, 1.25D, 20, 10.0F));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityLiving.class, 10, true, false, IMob.mobSelector));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224D);
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();

        if (!this.field_70170_p.isRemote)
        {
            int i = MathHelper.func_76128_c(this.field_70165_t);
            int j = MathHelper.func_76128_c(this.field_70163_u);
            int k = MathHelper.func_76128_c(this.field_70161_v);

            if (this.isWet())
            {
                this.attackEntityFrom(DamageSource.drown, 1.0F);
            }

            if (this.field_70170_p.getBiomeGenForCoords(new BlockPos(i, 0, k)).getFloatTemperature(new BlockPos(i, j, k)) > 1.0F)
            {
                this.attackEntityFrom(DamageSource.onFire, 1.0F);
            }

            for (int l = 0; l < 4; ++l)
            {
                i = MathHelper.func_76128_c(this.field_70165_t + (double)((float)(l % 2 * 2 - 1) * 0.25F));
                j = MathHelper.func_76128_c(this.field_70163_u);
                k = MathHelper.func_76128_c(this.field_70161_v + (double)((float)(l / 2 % 2 * 2 - 1) * 0.25F));
                BlockPos blockpos = new BlockPos(i, j, k);

                if (this.field_70170_p.func_180495_p(blockpos).func_177230_c().func_149688_o() == Material.field_151579_a && this.field_70170_p.getBiomeGenForCoords(new BlockPos(i, 0, k)).getFloatTemperature(blockpos) < 0.8F && Blocks.snow_layer.canPlaceBlockAt(this.field_70170_p, blockpos))
                {
                    this.field_70170_p.setBlockState(blockpos, Blocks.snow_layer.func_176223_P());
                }
            }
        }
    }

    protected Item getDropItem()
    {
        return Items.snowball;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        int i = this.rand.nextInt(16);

        for (int j = 0; j < i; ++j)
        {
            this.dropItem(Items.snowball, 1);
        }
    }

    /**
     * Attack the specified entity using a ranged attack.
     */
    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_)
    {
        EntitySnowball entitysnowball = new EntitySnowball(this.field_70170_p, this);
        double d0 = p_82196_1_.field_70163_u + (double)p_82196_1_.getEyeHeight() - 1.100000023841858D;
        double d1 = p_82196_1_.field_70165_t - this.field_70165_t;
        double d2 = d0 - entitysnowball.field_70163_u;
        double d3 = p_82196_1_.field_70161_v - this.field_70161_v;
        float f = MathHelper.func_76133_a(d1 * d1 + d3 * d3) * 0.2F;
        entitysnowball.setThrowableHeading(d1, d2 + (double)f, d3, 1.6F, 12.0F);
        this.playSound("random.bow", 1.0F, 1.0F / (this.func_70681_au().nextFloat() * 0.4F + 0.8F));
        this.field_70170_p.func_72838_d(entitysnowball);
    }

    public float getEyeHeight()
    {
        return 1.7F;
    }
}
