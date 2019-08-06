package org.py.jpure.support;

import java.util.Map;

public interface Model {
    Model addAttribute(String key, Object attribute);
    Model addAllAttribute(Map<String, ?> attributes);
    boolean containsAttribute(String name);
}
