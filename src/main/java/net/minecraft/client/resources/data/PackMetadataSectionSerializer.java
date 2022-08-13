package net.minecraft.client.resources.data;

import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonParseException;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.IChatComponent;

/**
 *
 */
public class PackMetadataSectionSerializer extends BaseMetadataSectionSerializer<PackMetadataSection> {

    /**
     *
     */
    public PackMetadataSectionSerializer() {
        
    }

    /**
     * 
     * @throws JsonParseException
     */
    public PackMetadataSection deserialize(JsonElement p_deserialize_1_,
                                           Type p_deserialize_2_,
                                           JsonDeserializationContext p_deserialize_3_)
                                    throws JsonParseException {
        return null;
    }

    /**
     *
     */
    public JsonElement serialize(PackMetadataSection p_serialize_1_,
                                 Type p_serialize_2_,
                                 JsonSerializationContext p_serialize_3_) {
        return null;
    }

    /**
     * The name of this section type as it appears in JSON.
     */
    public String getSectionName() {
        return null;
    }

}