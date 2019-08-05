package org.py.jpure.core.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Resource {
    boolean exists();
    default boolean isReadable() {
        return exists();
    }
    default boolean isFile() {
        return false;
    }
    File getFile() throws IOException;
    InputStream getInputStream();
    OutputStream getOutputStream();
}
