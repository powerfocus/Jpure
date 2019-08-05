package org.py.jpure.core.io;

import java.io.InputStream;
import java.io.OutputStream;

public class ClasspathResource extends AbstractFileResource {
    public ClasspathResource(String filename) {
        super(filename);
    }

    @Override
    public InputStream getInputStream() {
        return cl.getResourceAsStream(filename);
    }

    @Override
    public OutputStream getOutputStream() {
        return super.getOutputStream();
    }
}
