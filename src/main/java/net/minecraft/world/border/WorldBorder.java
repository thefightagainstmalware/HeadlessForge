package net.minecraft.world.border;

import net.minecraft.util.BlockPos;
import net.minecraft.entity.Entity;
import com.google.common.collect.Lists;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.ChunkCoordIntPair;

/**
 *
 */
public class WorldBorder extends Object {

    /**
     *
     */
    private final java.util.List<IBorderListener> listeners = Lists.newArrayList();

    /**
     *
     */
    private double centerX;

    /**
     *
     */
    private double centerZ;

    /**
     *
     */
    private double startDiameter;

    /**
     *
     */
    private double endDiameter;

    /**
     *
     */
    private long endTime;

    /**
     *
     */
    private long startTime;

    /**
     *
     */
    private int worldSize;

    /**
     *
     */
    private double damageAmount;

    /**
     *
     */
    private double damageBuffer;

    /**
     *
     */
    private int warningTime;

    /**
     *
     */
    private int warningDistance;

    /**
     *
     */
    public WorldBorder() {
        
    }

    /**
     *
     */
    public boolean contains(BlockPos pos) {
        return true;
    }

    /**
     *
     */
    public boolean contains(ChunkCoordIntPair range) {
        return true;
    }

    /**
     *
     */
    public boolean contains(AxisAlignedBB bb) {
        return true;
    }

    /**
     *
     */
    public double getClosestDistance(Entity entityIn) {
        return 0;
    }

    /**
     *
     */
    public double getClosestDistance(double x,
                                     double z) {
        return 0;
    }

    /**
     *
     */
    public EnumBorderStatus getStatus() {
        return null;
    }

    /**
     *
     */
    public double minX() {
        return 0;
    }

    /**
     *
     */
    public double minZ() {
        return 0;
    }

    /**
     *
     */
    public double maxX() {
        return 0;
    }

    /**
     *
     */
    public double maxZ() {
        return 0;
    }

    /**
     *
     */
    public double getCenterX() {
        return 0;
    }

    /**
     *
     */
    public double getCenterZ() {
        return 0;
    }

    /**
     *
     */
    public void func_177739_c(double x,
                              double z) {
        return;
    }

    /**
     *
     */
    public double func_177741_h() {
        return 0;
    }

    /**
     *
     */
    public long func_177732_i() {
        return 0;
    }

    /**
     *
     */
    public double func_177751_j() {
        return 0;
    }

    /**
     *
     */
    public void func_177750_a(double newSize) {
        return;
    }

    /**
     *
     */
    public void func_177738_a(double oldSize,
                              double newSize,
                              long time) {
        return;
    }

    /**
     *
     */
    protected java.util.List<IBorderListener> getListeners() {
        return null;
    }

    /**
     *
     */
    public void addListener(IBorderListener listener) {
        return;
    }

    /**
     *
     */
    public void setSize(int size) {
        return;
    }

    /**
     *
     */
    public int getSize() {
        return 0;
    }

    /**
     *
     */
    public double func_177742_m() {
        return 0;
    }

    /**
     *
     */
    public void func_177724_b(double bufferSize) {
        return;
    }

    /**
     *
     */
    public double func_177727_n() {
        return 0;
    }

    /**
     *
     */
    public void func_177744_c(double newAmount) {
        return;
    }

    /**
     *
     */
    public double getResizeSpeed() {
        return 0;
    }

    /**
     *
     */
    public int func_177740_p() {
        return 0;
    }

    /**
     *
     */
    public void func_177723_b(int warningTime) {
        return;
    }

    /**
     *
     */
    public int func_177748_q() {
        return 0;
    }

    /**
     *
     */
    public void func_177747_c(int warningDistance) {
        return;
    }

    /**
     *
     */
    public void removeListener(IBorderListener listener) {
        return;
    }

}