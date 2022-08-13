package net.minecraft.client.entity;

import net.minecraft.util.StringUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.renderer.ThreadDownloadImageData;

/**
 *
 */
public abstract class AbstractClientPlayer extends EntityPlayer {

    /**
     *
     */
    private NetworkPlayerInfo playerInfo;

    /**
     *
     */
    public AbstractClientPlayer(World worldIn,
                                GameProfile playerProfile) {
        super(worldIn, playerProfile);
    }

    /**
     * Returns true if the player is in spectator mode.
     */
    public boolean isSpectator() {
        return true;
    }

    /**
     * Checks if this instance of AbstractClientPlayer has any associated player data.
     */
    public boolean hasPlayerInfo() {
        return true;
    }

    /**
     *
     */
    protected NetworkPlayerInfo getPlayerInfo() {
        return null;
    }

    /**
     * Returns true if the player has an associated skin.
     */
    public boolean hasSkin() {
        return true;
    }

    /**
     * Returns true if the player instance has an associated skin.
     */
    public ResourceLocation getLocationSkin() {
        return null;
    }

    /**
     *
     */
    public ResourceLocation getLocationCape() {
        return null;
    }

    /**
     *
     */
    public static ThreadDownloadImageData getDownloadImageSkin(ResourceLocation resourceLocationIn,
                                                               String username) {
        return null;
    }

    /**
     * Returns true if the username has an associated skin.
     */
    public static ResourceLocation getLocationSkin(String username) {
        return null;
    }

    /**
     *
     */
    public String getSkinType() {
        return null;
    }

    /**
     *
     */
    public float getFovModifier() {
        return 0;
    }

}