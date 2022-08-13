package net.minecraft.world;

/**
 *
 */
public enum EnumDifficulty {
    EASY, HARD, NORMAL, PEACEFUL;
    /**
     *
     */
    private static final EnumDifficulty[] difficultyEnums = values();

    /**
     *
     */
    private final int difficultyId = ordinal();

    /**
     *
     */
    private final java.lang.String difficultyResourceKey = "difficulty." + name().toLowerCase();
    /**
     *
     */
    public int getDifficultyId() {
        return 0;
    }

    /**
     *
     */
    public static EnumDifficulty func_151523_a(int p_151523_0_) {
        return null;
    }

    /**
     *
     */
    public String func_151526_b() {
        return null;
    }

}