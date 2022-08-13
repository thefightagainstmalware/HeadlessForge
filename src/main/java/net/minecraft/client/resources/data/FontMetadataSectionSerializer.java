package net.minecraft.client.resources.data;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 *
 */
public class FontMetadataSectionSerializer extends BaseMetadataSectionSerializer<FontMetadataSection> {

    /**
     *
     */
    public FontMetadataSectionSerializer() {
        
    }

    /**
     * 
     * @throws JsonParseException
     */
    public FontMetadataSection deserialize(JsonElement p_deserialize_1_,
                                           Type p_deserialize_2_,
                                           JsonDeserializationContext p_deserialize_3_)
                                    throws JsonParseException {
        return null;
    }

    /**
     * The name of this section type as it appears in JSON.
     */
    public String getSectionName() {
        return null;
    }

}