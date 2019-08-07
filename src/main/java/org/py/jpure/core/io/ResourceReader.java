package org.py.jpure.core.io;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public abstract class ResourceReader implements Reader {
    protected Resource resource;

    @Override
    public String readCharacter(Charset charset) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try(InputStream inputStream = resource.getInputStream(); InputStreamReader reader = new InputStreamReader(inputStream, charset)) {
            CharBuffer buffer = CharBuffer.allocate(128);
            while(reader.read(buffer) != -1) {
                buffer.flip();
                stringBuilder.append(buffer.toString());
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public StringBuffer readCharacter(Resource resource, Charset charset) throws IOException {
        StringBuffer stringBuilder = new StringBuffer();
        try(InputStream inputStream = resource.getInputStream(); InputStreamReader reader = new InputStreamReader(inputStream, charset)) {
            CharBuffer buffer = CharBuffer.allocate(128);
            while(reader.read(buffer) != -1) {
                buffer.flip();
                stringBuilder.append(buffer.toString());
            }
        }
        return stringBuilder;
    }

    @Override
    public byte[] readBytes() throws IOException {
        byte[] bytes = null;
        try(InputStream inputStream = resource.getInputStream();
            ByteArrayOutputStream bout = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[128];
            int readSize = 0;
            while((readSize = inputStream.read(buffer)) != -1) {
                bout.write(buffer, 0, readSize);
            }
            bytes = bout.toByteArray();
        }
        return bytes;
    }
}
