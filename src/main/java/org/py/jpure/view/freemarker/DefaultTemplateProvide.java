package org.py.jpure.view.freemarker;

public final class DefaultTemplateProvide {
    private static final FreemarkerTemplate template;
    static {
        template = new FreemarkerTemplate(DefaultConfigurationProvide.configuration().configuration(), ".html");
    }
    private DefaultTemplateProvide() { }
    public static FreemarkerTemplate template() {
        return template;
    }
}
