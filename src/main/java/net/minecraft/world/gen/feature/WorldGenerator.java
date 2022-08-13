package net.minecraft.world.gen.feature;

import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;

/**
 *
 */
public abstract class WorldGenerator extends Object {

    /**
     * Sets wither or not the generator should notify blocks of blocks it changes. When the world is first generated,
     * this is false, when saplings grow, this is true.
     */
    private final boolean doBlockNotify;

    /**
     *
     */
    public WorldGenerator() {
        this(false);
    }

    /**
     *
     */
    public WorldGenerator(boolean notify) {
        this.doBlockNotify = notify;

    }

    /**
     *
     */
    public abstract boolean generate(World worldIn,
                                     java.util.Random rand,
                                     BlockPos position);

    /**
     *
     */
    public void func_175904_e() {
        return;
    }

    /**
     *
     */
    protected void setBlockAndNotifyAdequately(World worldIn,
                                               BlockPos pos,
                                               IBlockState state) {
        return;
    }

}