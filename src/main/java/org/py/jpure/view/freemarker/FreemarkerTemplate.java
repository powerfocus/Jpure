package org.py.jpure.view.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.py.jpure.core.template.BaseTemplate;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public final class FreemarkerTemplate implements BaseTemplate {
    private Configuration cfg;
    private String extname;
    public FreemarkerTemplate(final Configuration cfg, final String extname) {
        this.cfg = cfg;
        this.extname = extname;
    }
    public Template process(final String templateName) throws IOException {
        Objects.requireNonNull(templateName, "template name not null.");
        return cfg.getTemplate(templateName.concat(extname));
    }
    @Override
    public void process(final String templateName, final Writer out, Object model) throws IOException, TemplateException {
        Template template = process(templateName);
        template.process(model, out);
    }
    @Override
    public void process(final String templateName, final Writer out, Consumer<Map<String, Object>> consumer) throws IOException, TemplateException {
        Template template = process(templateName);
        Map<String, Object> data = new HashMap<>();
        consumer.accept(data);
        template.process(data, out);
    }
}
