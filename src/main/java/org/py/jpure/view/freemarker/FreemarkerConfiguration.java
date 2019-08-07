package org.py.jpure.view.freemarker;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.py.jpure.core.util.Classloader;

public final class FreemarkerConfiguration {
    private ClassLoader cl;
    private String baseTemplatePath;
    private String charset;
    private TemplateExceptionHandler exceptionHandler;
    public FreemarkerConfiguration() {
        cl = Classloader.defaultClassLoader();
        baseTemplatePath = "templates";
        charset = "utf-8";
        exceptionHandler = TemplateExceptionHandler.HTML_DEBUG_HANDLER;
    }
    public FreemarkerConfiguration(ClassLoader cl, String templatePath, String charset) {
        this.cl = cl;
        this.baseTemplatePath = templatePath;
        this.charset = charset;
        exceptionHandler = TemplateExceptionHandler.DEBUG_HANDLER;
    }
    public Configuration configuration() {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setClassLoaderForTemplateLoading(cl, baseTemplatePath);
        cfg.setDefaultEncoding(charset);
        cfg.setTemplateExceptionHandler(exceptionHandler);
        return cfg;
    }
    public FreemarkerConfiguration setExceptionHandler(TemplateExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
        return this;
    }
    public FreemarkerConfiguration setCharset(String charset) {
        this.charset = charset;
        return this;
    }
    public FreemarkerConfiguration setTemplatePath(String templatePath) {
        this.baseTemplatePath = templatePath;
        return this;
    }
    public FreemarkerConfiguration setClassloader(ClassLoader classloader) {
        this.cl = classloader;
        return this;
    }
}
