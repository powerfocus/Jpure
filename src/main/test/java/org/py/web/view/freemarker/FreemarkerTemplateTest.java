package org.py.web.view.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.junit.Before;
import org.junit.Test;
import sun.net.util.IPAddressUtil;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class FreemarkerTemplateTest {
    private Configuration cfg;
    @Before
    public void before() throws IOException {
        cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDirectoryForTemplateLoading(new File("src/main/webapp/WEB-INF/freemarker"));
        cfg.setDefaultEncoding("utf-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);
    }
    @Test
    public void test() throws IOException, TemplateException {
        Map<String, Object> root = new HashMap<>();
        root.put("user", "BigJoe");
        Map<String, Object> latest = new HashMap<>();
        root.put("latestProduct", latest);
        latest.put("url", "products/greenmouse");
        latest.put("name", "green mouse");
        Template template = cfg.getTemplate("index.html");
        Writer out = new OutputStreamWriter(System.out);
        template.process(root, out);
    }
    @Test
    public void process() throws IOException, TemplateException {
        FreemarkerTemplate freemarkerTemplate = new FreemarkerTemplate(cfg);
        Map<String, Object> root = new HashMap<>();
        root.put("user", "BigJoe");
        Map<String, Object> latest = new HashMap<>();
        root.put("latestProduct", latest);
        latest.put("url", "products/greenmouse");
        latest.put("name", "green mouse");
        freemarkerTemplate.process("index.html", new OutputStreamWriter(System.out), root);
    }
}