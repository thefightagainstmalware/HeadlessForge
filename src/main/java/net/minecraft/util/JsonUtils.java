package net.minecraft.util;

import com.google.gson.JsonSyntaxException;
import com.google.gson.JsonPrimitive;
import net.minecraftforge.fml.relauncher.Side;
import com.google.gson.JsonArray;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 *
 */
public class JsonUtils extends Object {

    /**
     *
     */
    public JsonUtils() {
        
    }

    /**
     * Does the given JsonObject contain a string field with the given name?
     */
    public static boolean isString(JsonObject p_151205_0_,
                                   String p_151205_1_) {
        return true;
    }

    /**
     * Is the given JsonElement a string?
     */
    public static boolean isString(JsonElement p_151211_0_) {
        return true;
    }

    /**
     *
     */
    public static boolean isBoolean(JsonObject p_180199_0_,
                                    String p_180199_1_) {
        return true;
    }

    /**
     * Does the given JsonObject contain an array field with the given name?
     */
    public static boolean isJsonArray(JsonObject p_151202_0_,
                                      String p_151202_1_) {
        return true;
    }

    /**
     * Does the given JsonObject contain a field with the given name whose type is primitive (String, Java primitive, or
     * Java primitive wrapper)?
     */
    public static boolean isJsonPrimitive(JsonObject p_151201_0_,
                                          String p_151201_1_) {
        return true;
    }

    /**
     * Does the given JsonObject contain a field with the given name?
     */
    public static boolean hasField(JsonObject p_151204_0_,
                                   String p_151204_1_) {
        return true;
    }

    /**
     * Gets the string value of the given JsonElement.  Expects the second parameter to be the name of the element's
     * field if an error message needs to be thrown.
     */
    public static String getString(JsonElement p_151206_0_,
                                             String p_151206_1_) {
        return null;
    }

    /**
     * Gets the string value of the field on the JsonObject with the given name.
     */
    public static String getString(JsonObject p_151200_0_,
                                             String p_151200_1_) {
        return null;
    }

    /**
     * Gets the string value of the field on the JsonObject with the given name, or the given default value if the field
     * is missing.
     */
    public static String getString(JsonObject p_151219_0_,
                                             String p_151219_1_,
                                             String p_151219_2_) {
        return null;
    }

    /**
     * Gets the boolean value of the given JsonElement.  Expects the second parameter to be the name of the element's
     * field if an error message needs to be thrown.
     */
    public static boolean getBoolean(JsonElement p_151216_0_,
                                     String p_151216_1_) {
        return true;
    }

    /**
     * Gets the boolean value of the field on the JsonObject with the given name.
     */
    public static boolean getBoolean(JsonObject p_151212_0_,
                                     String p_151212_1_) {
        return true;
    }

    /**
     * Gets the boolean value of the field on the JsonObject with the given name, or the given default value if the
     * field is missing.
     */
    public static boolean getBoolean(JsonObject p_151209_0_,
                                     String p_151209_1_,
                                     boolean p_151209_2_) {
        return true;
    }

    /**
     * Gets the float value of the given JsonElement.  Expects the second parameter to be the name of the element's
     * field if an error message needs to be thrown.
     */
    public static float getFloat(JsonElement p_151220_0_,
                                 String p_151220_1_) {
        return 0;
    }

    /**
     * Gets the float value of the field on the JsonObject with the given name.
     */
    public static float getFloat(JsonObject p_151217_0_,
                                 String p_151217_1_) {
        return 0;
    }

    /**
     * Gets the float value of the field on the JsonObject with the given name, or the given default value if the field
     * is missing.
     */
    public static float getFloat(JsonObject p_151221_0_,
                                 String p_151221_1_,
                                 float p_151221_2_) {
        return 0;
    }

    /**
     * Gets the integer value of the given JsonElement.  Expects the second parameter to be the name of the element's
     * field if an error message needs to be thrown.
     */
    public static int getInt(JsonElement p_151215_0_,
                             String p_151215_1_) {
        return 0;
    }

    /**
     * Gets the integer value of the field on the JsonObject with the given name.
     */
    public static int getInt(JsonObject p_151203_0_,
                             String p_151203_1_) {
        return 0;
    }

    /**
     * Gets the integer value of the field on the JsonObject with the given name, or the given default value if the
     * field is missing.
     */
    public static int getInt(JsonObject p_151208_0_,
                             String p_151208_1_,
                             int p_151208_2_) {
        return 0;
    }

    /**
     * Gets the given JsonElement as a JsonObject.  Expects the second parameter to be the name of the element's field
     * if an error message needs to be thrown.
     */
    public static JsonObject getJsonObject(JsonElement p_151210_0_,
                                           String p_151210_1_) {
        return null;
    }

    /**
     *
     */
    public static JsonObject getJsonObject(JsonObject base,
                                           String key) {
        return null;
    }

    /**
     * Gets the JsonObject field on the JsonObject with the given name, or the given default value if the field is
     * missing.
     */
    public static JsonObject getJsonObject(JsonObject p_151218_0_,
                                           String p_151218_1_,
                                           JsonObject p_151218_2_) {
        return null;
    }

    /**
     * Gets the given JsonElement as a JsonArray.  Expects the second parameter to be the name of the element's field if
     * an error message needs to be thrown.
     */
    public static JsonArray getJsonArray(JsonElement p_151207_0_,
                                         String p_151207_1_) {
        return null;
    }

    /**
     * Gets the JsonArray field on the JsonObject with the given name.
     */
    public static JsonArray getJsonArray(JsonObject p_151214_0_,
                                         String p_151214_1_) {
        return null;
    }

    /**
     * Gets the JsonArray field on the JsonObject with the given name, or the given default value if the field is
     * missing.
     */
    public static JsonArray getJsonArray(JsonObject p_151213_0_,
                                         String p_151213_1_,
                                         JsonArray p_151213_2_) {
        return null;
    }

    /**
     * Gets a human-readable description of the given JsonElement's type.  For example: "a number (4)"
     */
    public static String toString(JsonElement p_151222_0_) {
        return null;
    }

}