package org.py.jpure.core.template;

import java.io.Writer;
import java.util.Map;
import java.util.function.Consumer;

public interface BaseTemplate {
    void process(String templateName, Writer out, Object model) throws Exception;
    void process(String templateName, Writer out, Consumer<Map<String, Object>> consumer) throws Exception;
}
