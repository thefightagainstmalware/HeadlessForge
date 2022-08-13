package net.minecraft.util;

public class ChatComponentSelector extends ChatComponentStyle
{
    /**
     * The selector used to find the matching entities of this text component
     */
    private final String selector;

    public ChatComponentSelector(String selectorIn)
    {
        this.selector = selectorIn;
    }

    /**
     * Gets the selector of this component, in plain text.
     */
    public String getSelector()
    {
        return this.selector;
    }

    /**
     * Gets the text of this component, without any special formatting codes added, for chat.  TODO: why is this two
     * different methods?
     */
    public String getUnformattedTextForChat()
    {
        return this.selector;
    }

    /**
     * Creates a copy of this component.  Almost a deep copy, except the style is shallow-copied.
     */
    public ChatComponentSelector func_150259_f()
    {
        ChatComponentSelector chatcomponentselector = new ChatComponentSelector(this.selector);
        chatcomponentselector.setChatStyle(this.func_150256_b().createShallowCopy());

        for (IChatComponent ichatcomponent : this.getSiblings())
        {
            chatcomponentselector.func_150257_a(ichatcomponent.func_150259_f());
        }

        return chatcomponentselector;
    }

    public boolean equals(Object p_equals_1_)
    {
        if (this == p_equals_1_)
        {
            return true;
        }
        else if (!(p_equals_1_ instanceof ChatComponentSelector))
        {
            return false;
        }
        else
        {
            ChatComponentSelector chatcomponentselector = (ChatComponentSelector)p_equals_1_;
            return this.selector.equals(chatcomponentselector.selector) && super.equals(p_equals_1_);
        }
    }

    public String toString()
    {
        return "SelectorComponent{pattern=\'" + this.selector + '\'' + ", siblings=" + this.siblings + ", style=" + this.func_150256_b() + '}';
    }
}
