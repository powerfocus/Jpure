package org.py.jpure.freemarker;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class FreemarkerTemplateTest {
    private Configuration cfg;
    @Before
    public void before() throws IOException {
        cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setClassLoaderForTemplateLoading(ClassLoader.getSystemClassLoader(), "templates");
        //cfg.setDirectoryForTemplateLoading(new File("src/main/webapp/WEB-INF/freemarker"));
        cfg.setDefaultEncoding("utf-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);
    }
    @Test
    public void test0() throws IOException, TemplateException {
        FreemarkerTemplate template = new FreemarkerTemplate(cfg, ".html");
        template.process("index/index.html", new OutputStreamWriter(System.out), null);
    }
    @Test
    public void test() throws IOException, TemplateException {
        FreemarkerTemplate freemarkerTemplate = new FreemarkerTemplate(cfg, ".html");
        Map<String, Object> root = new HashMap<>();
        root.put("user", "BigJoe");
        Map<String, Object> latest = new HashMap<>();
        root.put("latestProduct", latest);
        latest.put("url", "products/greenmouse");
        latest.put("name", "green mouse");
        freemarkerTemplate.process("index/index", new OutputStreamWriter(System.out), root);
    }
    @Test
    public void test2() throws IOException, TemplateException {
        FreemarkerTemplate template = new FreemarkerTemplate(cfg, ".html");
        StringWriter writer = new StringWriter();
        template.process("index.html", writer, map -> {
            map.put("user", "BigJoe");
            Map<String, Object> latest = new HashMap<>();
            map.put("latestProduct", latest);
            latest.put("url", "products/greenmouse");
            latest.put("name", "green mouse");
        });
        System.out.println(writer);
    }
}