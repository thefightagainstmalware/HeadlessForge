package net.minecraft.server.gui;

import net.minecraft.util.ITickable;
import net.minecraft.server.MinecraftServer;

/**
 *
 */
public class PlayerListComponent extends javax.swing.JList implements ITickable {

    /**
     *
     */
    private MinecraftServer server;

    /**
     *
     */
    private int ticks;

    /**
     *
     */
    public PlayerListComponent(MinecraftServer server) {
        
    }

    /**
     * Like the old updateEntity(), except more generic.
     */
    public void update() {
        return;
    }

}