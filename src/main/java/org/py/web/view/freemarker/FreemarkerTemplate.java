package org.py.web.view.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.Writer;

public final class FreemarkerTemplate {
    private final static Configuration cfg;
    private FreemarkerTemplate() { }
    static {
        cfg = new Configuration(Configuration.VERSION_2_3_28);
    }
    public static synchronized void process(final String templateName, final Writer out, Object model) throws IOException, TemplateException {
        Template template = cfg.getTemplate(templateName);
        template.process(model, out);
    }
}
