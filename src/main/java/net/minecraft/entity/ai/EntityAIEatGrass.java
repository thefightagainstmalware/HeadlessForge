package net.minecraft.entity.ai;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockStateHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class EntityAIEatGrass extends EntityAIBase
{
    private static final Predicate<IBlockState> field_179505_b = BlockStateHelper.forBlock(Blocks.tallgrass).where(BlockTallGrass.TYPE, Predicates.equalTo(BlockTallGrass.EnumType.GRASS));

    /** The entity owner of this AITask */
    private EntityLiving grassEaterEntity;

    /** The world the grass eater entity is eating from */
    private World entityWorld;

    /** Number of ticks since the entity started to eat grass */
    int eatingGrassTimer;

    public EntityAIEatGrass(EntityLiving grassEaterEntityIn)
    {
        this.grassEaterEntity = grassEaterEntityIn;
        this.entityWorld = grassEaterEntityIn.field_70170_p;
        this.setMutexBits(7);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.grassEaterEntity.func_70681_au().nextInt(this.grassEaterEntity.isChild() ? 50 : 1000) != 0)
        {
            return false;
        }
        else
        {
            BlockPos blockpos = new BlockPos(this.grassEaterEntity.field_70165_t, this.grassEaterEntity.field_70163_u, this.grassEaterEntity.field_70161_v);
            return field_179505_b.apply(this.entityWorld.func_180495_p(blockpos)) ? true : this.entityWorld.func_180495_p(blockpos.func_177977_b()).func_177230_c() == Blocks.field_150349_c;
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.eatingGrassTimer = 40;
        this.entityWorld.setEntityState(this.grassEaterEntity, (byte)10);
        this.grassEaterEntity.getNavigator().clearPathEntity();
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.eatingGrassTimer = 0;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return this.eatingGrassTimer > 0;
    }

    /**
     * Number of ticks since the entity started to eat grass
     */
    public int getEatingGrassTimer()
    {
        return this.eatingGrassTimer;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        this.eatingGrassTimer = Math.max(0, this.eatingGrassTimer - 1);

        if (this.eatingGrassTimer == 4)
        {
            BlockPos blockpos = new BlockPos(this.grassEaterEntity.field_70165_t, this.grassEaterEntity.field_70163_u, this.grassEaterEntity.field_70161_v);

            if (field_179505_b.apply(this.entityWorld.func_180495_p(blockpos)))
            {
                if (this.entityWorld.func_82736_K().func_82766_b("mobGriefing"))
                {
                    this.entityWorld.func_175655_b(blockpos, false);
                }

                this.grassEaterEntity.eatGrassBonus();
            }
            else
            {
                BlockPos blockpos1 = blockpos.func_177977_b();

                if (this.entityWorld.func_180495_p(blockpos1).func_177230_c() == Blocks.field_150349_c)
                {
                    if (this.entityWorld.func_82736_K().func_82766_b("mobGriefing"))
                    {
                        this.entityWorld.playAuxSFX(2001, blockpos1, Block.func_149682_b(Blocks.field_150349_c));
                        this.entityWorld.func_180501_a(blockpos1, Blocks.field_150346_d.func_176223_P(), 2);
                    }

                    this.grassEaterEntity.eatGrassBonus();
                }
            }
        }
    }
}
