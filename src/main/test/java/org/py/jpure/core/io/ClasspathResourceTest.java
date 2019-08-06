package org.py.jpure.core.io;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ClasspathResourceTest {
    @Test
    public void test() {
        ClasspathResource resource = new ClasspathResource("templates/index/index.html");
        try(InputStream ins = resource.getInputStream(); InputStreamReader reader = new InputStreamReader(ins, StandardCharsets.UTF_8)) {
            CharBuffer buffer = CharBuffer.allocate(128);
            StringWriter sw = new StringWriter();
            while(reader.read(buffer) != -1) {
                buffer.flip();
                sw.append(buffer.toString());
            }
            System.out.println(sw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2() throws IOException {
        ClasspathResource resource = new ClasspathResource("templates/index/index.html");
        ClasspathReader reader = new ClasspathReader(resource);
        System.out.println(reader.readCharacter(StandardCharsets.UTF_8));
    }
}