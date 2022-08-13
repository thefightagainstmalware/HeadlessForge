package net.minecraft.entity.monster;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

/**
 *
 */
public class EntityGiantZombie extends EntityMob {

    /**
     *
     */
    public EntityGiantZombie(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    @Override
    public float getEyeHeight() {
        return 0;
    }

    /**
     *
     */
    @Override
    protected void applyEntityAttributes() {
        return;
    }

    /**
     *
     */
    @Override
    public float getBlockPathWeight(BlockPos pos) {
        return 0;
    }

}