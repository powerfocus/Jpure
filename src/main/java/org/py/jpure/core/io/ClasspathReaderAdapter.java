package org.py.jpure.core.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public final class ClasspathReaderAdapter {
    public static StringBuffer readAllText(Resource resource, Charset charset) throws IOException {
        StringBuffer strBuffer = new StringBuffer();
        try(InputStream inputStream = resource.getInputStream(); InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset)) {
            CharBuffer buffer = CharBuffer.allocate(128);
            while(inputStreamReader.read(buffer) != -1) {
                buffer.flip();
                strBuffer.append(buffer.toString());
            }
        }
        return strBuffer;
    }
    public static byte[] readAllByte(Resource resource) throws IOException {
        byte[] bytes = null;
        try(InputStream inputStream = resource.getInputStream(); ByteArrayOutputStream byteOut = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[128];
            int readSize = 0;
            while((readSize = inputStream.read(buffer)) != -1) {
                byteOut.write(buffer, 0, readSize);
            }
            bytes = byteOut.toByteArray();
        }
        return bytes;
    }
}
