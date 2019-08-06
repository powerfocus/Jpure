package org.py.jpure.support;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractModel extends ConcurrentHashMap<String, Object> implements Model {
    @Override
    public Model addAttribute(String key, Object attribute) {
        put(key, attribute);
        return this;
    }

    @Override
    public Model addAllAttribute(Map<String, ?> attributes) {
        putAll(attributes);
        return this;
    }

    @Override
    public boolean containsAttribute(String name) {
        return containsKey(name);
    }
}
