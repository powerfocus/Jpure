package org.py.jpure.registration;

import javax.servlet.ServletContext;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Consumer;

public abstract class AbstractRegistration implements Registration {
    protected ServletContext ctx;
    protected ConcurrentMap<String, ConcurrentMap<String, Class>> elements;
    public AbstractRegistration() {
        elements = new ConcurrentHashMap<>();
    }
    public AbstractRegistration(ServletContext ctx) {
        this();
        this.ctx = Objects.requireNonNull(ctx, "context object require not null.");
    }
    @Override
    public void add(String name, Class clazz, String mapping) {
        elements.put(mapping, new ConcurrentHashMap<String, Class>() {{put(name, clazz);}});
    }

    @Override
    public void remove(String name) {
        if(elements.containsKey(name))
            elements.remove(name);
    }

    @Override
    public boolean exists(String name) {
        return elements.containsKey(name);
    }

    @Override
    public void register() {
        throw new IllegalStateException("method undefined.");
    }

    @Override
    public void register(Consumer<ServletContext> consumer) {
        consumer.accept(ctx);
    }

    public ServletContext getCtx() {
        return ctx;
    }

    public void setCtx(ServletContext ctx) {
        this.ctx = ctx;
    }

    public ConcurrentMap<String, ConcurrentMap<String, Class>> getelements() {
        return elements;
    }

    public void setelements(ConcurrentMap<String, ConcurrentMap<String, Class>> elements) {
        this.elements = elements;
    }
}
