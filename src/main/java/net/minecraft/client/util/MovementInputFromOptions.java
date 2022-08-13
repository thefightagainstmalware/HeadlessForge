package net.minecraft.client.util;

import net.minecraft.client.settings.GameSettings;

/**
 *
 */
public class MovementInputFromOptions extends MovementInput {

    /**
     *
     */
    private final GameSettings gameSettings;

    /**
     *
     */
    public MovementInputFromOptions(GameSettings gameSettingsIn) {
    	gameSettings = gameSettingsIn;
    }

    /**
     *
     */
    @Override
    public void updatePlayerMoveState() {
        return;
    }

}