package org.py.web.tool.registration;

import javax.servlet.Filter;

public interface Registration {
    void add(String name, Class<?> clazz, String mapping);
    void remove(String name);
    boolean exists(String name);
    void register();
}
