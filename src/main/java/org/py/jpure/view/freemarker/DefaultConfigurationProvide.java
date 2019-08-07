package org.py.jpure.view.freemarker;

public final class DefaultConfigurationProvide {
    private static final FreemarkerConfiguration cfg;
    static {
        cfg = new FreemarkerConfiguration();
    }
    private DefaultConfigurationProvide() { }
    public static FreemarkerConfiguration configuration() {
        return cfg;
    }
}
