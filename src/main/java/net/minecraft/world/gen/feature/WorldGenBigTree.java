package net.minecraft.world.gen.feature;

import net.minecraft.util.MathHelper;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.BlockLog;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

/**
 *
 */
public class WorldGenBigTree extends WorldGenAbstractTree {

    /**
     *
     */
    private java.util.Random rand;

    /**
     *
     */
    private World world;

    /**
     *
     */
    private BlockPos basePos;

    /**
     *
     */
    int heightLimit;

    /**
     *
     */
    int height;

    /**
     *
     */
    double heightAttenuation;

    /**
     *
     */
    double branchSlope;

    /**
     *
     */
    double scaleWidth;

    /**
     *
     */
    double leafDensity;

    /**
     *
     */
    int trunkSize;

    /**
     *
     */
    int heightLimitLimit;

    /**
     * Sets the distance limit for how far away the generator will populate leaves from the base leaf node.
     */
    int leafDistanceLimit;

    /**
     *
     */
    java.util.List<WorldGenBigTree.FoliageCoordinates> field_175948_j;

    /**
     *
     */
    public WorldGenBigTree(boolean p_i2008_1_) {
        super(p_i2008_1_);
    }

    /**
     * Generates a list of leaf nodes for the tree, to be populated by generateLeaves.
     */
    void generateLeafNodeList() {
        return;
    }

    /**
     *
     */
    void func_181631_a(BlockPos p_181631_1_,
                       float p_181631_2_,
                       IBlockState p_181631_3_) {
        return;
    }

    /**
     * Gets the rough size of a layer of the tree.
     */
    float layerSize(int p_76490_1_) {
        return 0;
    }

    /**
     *
     */
    float leafSize(int p_76495_1_) {
        return 0;
    }

    /**
     * Generates the leaves surrounding an individual entry in the leafNodes list.
     */
    void generateLeafNode(BlockPos pos) {
        return;
    }

    /**
     *
     */
    void func_175937_a(BlockPos p_175937_1_,
                       BlockPos p_175937_2_,
                       Block p_175937_3_) {
        return;
    }

    /**
     * Returns the absolute greatest distance in the BlockPos object.
     */
    private int getGreatestDistance(BlockPos posIn) {
        return 0;
    }

    /**
     *
     */
    private BlockLog.EnumAxis func_175938_b(BlockPos p_175938_1_,
                                            BlockPos p_175938_2_) {
        return null;
    }

    /**
     * Generates the leaf portion of the tree as specified by the leafNodes list.
     */
    void generateLeaves() {
        return;
    }

    /**
     * Indicates whether or not a leaf node requires additional wood to be added to preserve integrity.
     */
    boolean leafNodeNeedsBase(int p_76493_1_) {
        return true;
    }

    /**
     * Places the trunk for the big tree that is being generated. Able to generate double-sized trunks by changing a
     * field that is always 1 to 2.
     */
    void generateTrunk() {
        return;
    }

    /**
     * Generates additional wood blocks to fill out the bases of different leaf nodes that would otherwise degrade.
     */
    void generateLeafNodeBases() {
        return;
    }

    /**
     * Checks a line of blocks in the world from the first coordinate to triplet to the second, returning the distance
     * (in blocks) before a non-air, non-leaf block is encountered and/or the end is encountered.
     */
    int checkBlockLine(BlockPos posOne,
                       BlockPos posTwo) {
        return 0;
    }

    /**
     *
     */
    @Override
    public void func_175904_e() {
        return;
    }

    /**
     *
     */
    public boolean generate(World worldIn,
                            java.util.Random rand,
                            BlockPos position) {
        return true;
    }

    /**
     * Returns a boolean indicating whether or not the current location for the tree, spanning basePos to to the height
     * limit, is valid.
     */
    private boolean validTreeLocation() {
        return true;
    }

    public class FoliageCoordinates {
    }
}