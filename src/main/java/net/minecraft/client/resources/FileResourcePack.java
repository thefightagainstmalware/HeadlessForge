package net.minecraft.client.resources;

import com.google.common.base.Splitter;

/**
 *
 */
public class FileResourcePack extends AbstractResourcePack implements java.io.Closeable {

    /**
     *
     */
    public static final Splitter entryNameSplitter = Splitter.on('/').omitEmptyStrings().limit(2);

    /**
     *
     */
    private java.util.zip.ZipFile resourcePackZipFile;

    /**
     *
     */
    public FileResourcePack(java.io.File resourcePackFileIn) {
        super(resourcePackFileIn);
    }

    /**
     * 
     * @throws java.io.IOException
     */
    private java.util.zip.ZipFile getResourcePackZipFile()
                                                  throws java.io.IOException {
        return null;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    protected java.io.InputStream getInputStreamByName(String name)
                                                throws java.io.IOException {
        return null;
    }

    /**
     *
     */
    public boolean hasResourceName(String name) {
        return true;
    }

    /**
     *
     */
    public java.util.Set<String> getResourceDomains() {
        return null;
    }

    /**
     * 
     * @throws java.lang.Throwable
     */
    @Override
    protected void finalize()
                     throws Throwable {
        return;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    public void close()
               throws java.io.IOException {
        return;
    }

}