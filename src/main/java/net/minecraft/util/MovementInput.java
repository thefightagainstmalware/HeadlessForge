package net.minecraft.util;

/**
 *
 */
public class MovementInput extends Object {

    /**
     * The speed at which the player is strafing. Postive numbers to the left and negative to the right.
     */
    public float moveStrafe;

    /**
     * The speed at which the player is moving forward. Negative numbers will move backwards.
     */
    public float moveForward;

    /**
     *
     */
    public boolean jump;

    /**
     *
     */
    public boolean sneak;

    /**
     *
     */
    public MovementInput() {
        
    }

    /**
     *
     */
    public void updatePlayerMoveState() {
        return;
    }

}