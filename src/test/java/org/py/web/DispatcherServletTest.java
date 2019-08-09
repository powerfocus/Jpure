package org.py.web;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DispatcherServletTest {
    private static final Logger log = LoggerFactory.getLogger(DispatcherServletTest.class);
    @Test
    public void reader() {
        log.info("test begin.");
        try(InputStream ins = ClassLoader.getSystemClassLoader().getResourceAsStream("templates/index/index.html");
            InputStreamReader reader = new InputStreamReader(ins, StandardCharsets.UTF_8)) {
            CharBuffer buffer = CharBuffer.allocate(128);
            List<String> lines = new ArrayList<>();
            while(reader.read(buffer) != -1) {
                buffer.flip();
                lines.add(buffer.toString());
            }
            String html = lines.stream().reduce("", String::concat);
            System.out.println(html);
        } catch(IOException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}