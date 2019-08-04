package org.py.jpure.registration;

import javax.servlet.ServletContext;
import java.util.function.Consumer;

public interface Registration {
    void add(String name, Class clazz, String mapping);
    void remove(String name);
    boolean exists(String name);
    void register();
    void register(Consumer<ServletContext> consumer);
}
