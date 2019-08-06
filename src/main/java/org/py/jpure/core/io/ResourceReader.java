package org.py.jpure.core.io;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

public abstract class ResourceReader implements Reader {
    protected Resource resource;
    public ResourceReader(Resource resource) {
        Objects.requireNonNull(resource, "required resource.");
        this.resource = resource;
    }

    @Override
    public String readCharacter(Charset charset) throws IOException {
        return null;
    }

    @Override
    public byte[] readBytes() throws IOException {
        return new byte[0];
    }
}
