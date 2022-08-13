package net.minecraft.realms;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
public class RealmsServerPing extends Object {

    /**
     *
     */
    public volatile java.lang.String nrOfPlayers;

    /**
     *
     */
    public volatile long lastPingSnapshot;

    /**
     *
     */
    public volatile java.lang.String playerList;

    /**
     *
     */
    public RealmsServerPing() {
        
    }

}