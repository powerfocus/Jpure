package org.py.jpure.core.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class AbstractResource implements Resource {
    protected ClassLoader cl;
    protected String filename;
    public AbstractResource() {
    }

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public File getFile() throws IOException {
        throw new IllegalStateException("unspecified resource.");
    }

    @Override
    public InputStream getInputStream() {
        throw new IllegalStateException("unspecified resource.");
    }

    @Override
    public OutputStream getOutputStream() {
        throw new IllegalStateException("unspecified resource.");
    }

    @Override
    public boolean isReadable() {
        return false;
    }

    @Override
    public boolean isFile() {
        return false;
    }
}
