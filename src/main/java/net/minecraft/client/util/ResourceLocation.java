package net.minecraft.client.util;

/**
 *
 */
public class ResourceLocation extends Object {

    /**
     *
     */
    protected final java.lang.String resourceDomain;

    /**
     *
     */
    protected final java.lang.String resourcePath;

    /**
     *
     */
    protected ResourceLocation(int p_i45928_1_,
                               String... resourceName) {
        this.resourceDomain = resourceName[0];
        this.resourcePath = resourceName[1];
        
    }

    /**
     *
     */
    public ResourceLocation(String resourceName) {
        this.resourceDomain = resourceName.split("/")[0];
        this.resourcePath = resourceName.split("/")[1];
    }

    /**
     *
     */
    public ResourceLocation(String resourceDomainIn,
                            String resourcePathIn) {
        this.resourceDomain = resourceDomainIn;
        this.resourcePath = resourcePathIn;
    }

    /**
     * Splits an object name (such as minecraft:apple) into the domain and path parts and returns these as an array of
     * length 2. If no colon is present in the passed value the returned array will contain {null, toSplit}.
     */
    protected static String[] splitObjectName(String toSplit) {
        return null;
    }

    /**
     *
     */
    public String getResourcePath() {
        return null;
    }

    /**
     *
     */
    public String getResourceDomain() {
        return null;
    }

    /**
     *
     */
    @Override
    public String toString() {
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
    public int hashCode() {
        return 0;
    }

}