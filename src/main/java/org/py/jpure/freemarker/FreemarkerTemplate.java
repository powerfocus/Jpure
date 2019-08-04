package org.py.jpure.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public final class FreemarkerTemplate {
    private Configuration cfg;
    public FreemarkerTemplate(Configuration cfg) {
        this.cfg = cfg;
    }
    public void process(final String templateName, final Writer out, Object model) throws IOException, TemplateException {
        Template template = cfg.getTemplate(templateName);
        template.process(model, out);
    }
    public void process(final String templateName, final Writer out, Consumer<Map<String, Object>> consumer) throws IOException, TemplateException {
        Template template = cfg.getTemplate(templateName);
        Map<String, Object> map = new HashMap<>();
        consumer.accept(map);
        template.process(map, out);
    }
}
