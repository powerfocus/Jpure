package org.py.jpure.core.io;

import java.io.*;
import java.nio.CharBuffer;

public class ClasspathReader extends ResourceReader {
    public ClasspathReader(Resource resource) {
        super(resource);
    }

    @Override
    public String readCharacter() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try(InputStream inputStream = resource.getInputStream(); InputStreamReader reader = new InputStreamReader(inputStream)) {
            CharBuffer buffer = CharBuffer.allocate(128);
            while(reader.read(buffer) != -1) {
                buffer.flip();
                stringBuilder.append(buffer.toString());
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public byte[] readBytes() throws IOException {
        byte[] re = null;
        try(InputStream inputStream = resource.getInputStream();
            ByteArrayOutputStream bout = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[128];
            int rlen = 0;
            while((rlen = inputStream.read(buffer)) != -1) {
                bout.write(buffer, 0, rlen);
            }
            re = bout.toByteArray();
        }
        return re;
    }
}
