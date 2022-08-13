package net.minecraft.client.util;

import com.google.gson.*;
import net.minecraft.util.ChatStyle;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map.Entry;

public interface IChatComponent extends Iterable<IChatComponent>
{
    IChatComponent setChatStyle(ChatStyle style);

    ChatStyle getChatStyle();

    /**
     * Appends the given text to the end of this component.
     */
    IChatComponent appendText(String text);

    /**
     * Appends the given component to the end of this one.
     */
    IChatComponent appendSibling(IChatComponent component);

    /**
     * Gets the text of this component, without any special formatting codes added, for chat.  TODO: why is this two
     * different methods?
     */
    String getUnformattedTextForChat();

    /**
     * Get the text of this component, <em>and all child components</em>, with all special formatting codes removed.
     */
    String getUnformattedText();

    /**
     * Gets the text of this component, with formatting codes added for rendering.
     */
    String getFormattedText();

    List<IChatComponent> getSiblings();

    /**
     * Creates a copy of this component.  Almost a deep copy, except the style is shallow-copied.
     */
    IChatComponent createCopy();

    public static class Serializer implements JsonDeserializer<IChatComponent>, JsonSerializer<IChatComponent>
    {
        private static final Gson GSON;

        public IChatComponent deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) throws JsonParseException
        {
            return null;
        }

        private void serializeChatStyle(ChatStyle style, JsonObject object, JsonSerializationContext ctx)
        {

        }

        public JsonElement serialize(IChatComponent p_serialize_1_, Type p_serialize_2_, JsonSerializationContext p_serialize_3_)
        {
            return null;
        }

        public static String componentToJson(IChatComponent component)
        {
            return GSON.toJson((Object)component);
        }

        public static IChatComponent jsonToComponent(String json)
        {
            return (IChatComponent)GSON.fromJson(json, IChatComponent.class);
        }

        static
        {
            GsonBuilder gsonbuilder = new GsonBuilder();
            gsonbuilder.registerTypeHierarchyAdapter(IChatComponent.class, new IChatComponent.Serializer());
            GSON = gsonbuilder.create();
        }
    }
}
