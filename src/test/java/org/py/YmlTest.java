package org.py;

import org.junit.Test;
import org.py.jpure.core.io.ClasspathResource;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class YmlTest {
    @Test
    public void test() {
        Yaml yaml = new Yaml();
        ClasspathResource resource = new ClasspathResource("app.yml");
        try(InputStream ins = resource.getInputStream()) {
            Map<String, Object> data = yaml.load(ins);
            System.out.println(data);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
