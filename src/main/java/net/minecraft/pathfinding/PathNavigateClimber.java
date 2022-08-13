package net.minecraft.pathfinding;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class PathNavigateClimber extends PathNavigateGround
{
    /** Current path navigation target */
    private BlockPos targetPosition;

    public PathNavigateClimber(EntityLiving entityLivingIn, World worldIn)
    {
        super(entityLivingIn, worldIn);
    }

    /**
     * Returns path to given BlockPos
     */
    public PathEntity getPathToPos(BlockPos pos)
    {
        this.targetPosition = pos;
        return super.getPathToPos(pos);
    }

    /**
     * Returns the path to the given EntityLiving. Args : entity
     */
    public PathEntity getPathToEntityLiving(Entity entityIn)
    {
        this.targetPosition = new BlockPos(entityIn);
        return super.getPathToEntityLiving(entityIn);
    }

    /**
     * Try to find and set a path to EntityLiving. Returns true if successful. Args : entity, speed
     */
    public boolean tryMoveToEntityLiving(Entity entityIn, double speedIn)
    {
        PathEntity pathentity = this.getPathToEntityLiving(entityIn);

        if (pathentity != null)
        {
            return this.setPath(pathentity, speedIn);
        }
        else
        {
            this.targetPosition = new BlockPos(entityIn);
            this.speed = speedIn;
            return true;
        }
    }

    public void onUpdateNavigation()
    {
        if (!this.noPath())
        {
            super.onUpdateNavigation();
        }
        else
        {
            if (this.targetPosition != null)
            {
                double d0 = (double)(this.theEntity.width * this.theEntity.width);

                if (this.theEntity.getDistanceSqToCenter(this.targetPosition) >= d0 && (this.theEntity.field_70163_u <= (double)this.targetPosition.func_177956_o() || this.theEntity.getDistanceSqToCenter(new BlockPos(this.targetPosition.func_177958_n(), MathHelper.func_76128_c(this.theEntity.field_70163_u), this.targetPosition.func_177952_p())) >= d0))
                {
                    this.theEntity.getMoveHelper().setMoveTo((double)this.targetPosition.func_177958_n(), (double)this.targetPosition.func_177956_o(), (double)this.targetPosition.func_177952_p(), this.speed);
                }
                else
                {
                    this.targetPosition = null;
                }
            }
        }
    }
}
