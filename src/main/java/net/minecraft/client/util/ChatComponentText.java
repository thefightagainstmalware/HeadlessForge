package net.minecraft.client.util;

import net.minecraft.util.ChatComponentStyle;
import net.minecraft.util.IChatComponent;

/**
 *
 */
public class ChatComponentText extends ChatComponentStyle {

    /**
     *
     */
    private final java.lang.String text;

    /**
     *
     */
    public ChatComponentText(String msg) {
        this.text = msg;
    }

    /**
     * Gets the text value of this ChatComponentText.  TODO: what are getUnformattedText and getUnformattedTextForChat
     * missing that made someone decide to create a third equivalent method that only ChatComponentText can implement?
     */
    public String getChatComponentText_TextValue() {
        return null;
    }

    /**
     * Gets the text of this component, without any special formatting codes added, for chat.  TODO: why is this two
     * different methods?
     */
    public String getUnformattedTextForChat() {
        return null;
    }

    @Override
    public IChatComponent func_150259_f() {
        return null;
    }

    /**
     * Creates a copy of this component.  Almost a deep copy, except the style is shallow-copied.
     */
    public ChatComponentText createCopy() {
        return null;
    }

    /**
     *
     */
    @Override
    public boolean equals(Object p_equals_1_) {
        return true;
    }

    /**
     *
     */
    @Override
    public String toString() {
        return null;
    }

}