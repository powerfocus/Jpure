package org.py.web.tool.registration;

import javax.servlet.ServletContext;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

public abstract class AbstractRegistration implements Registration {
    protected ServletContext ctx;
    protected ConcurrentMap<String, ConcurrentMap<String, Class>> filters;
    public AbstractRegistration() {
        filters = new ConcurrentHashMap<>();
    }
    public AbstractRegistration(ServletContext ctx) {
        this();
        this.ctx = Objects.requireNonNull(ctx, "context object require not null.");
    }
    @Override
    public void add(String name, Class clazz, String mapping) {
        filters.put(mapping, new ConcurrentHashMap<String, Class>() {{put(name, clazz);}});
    }

    @Override
    public void remove(String name) {
        if(filters.containsKey(name))
            filters.remove(name);
    }

    @Override
    public boolean exists(String name) {
        return filters.containsKey(name);
    }

    @Override
    public void register() {

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

    public ConcurrentMap<String, ConcurrentMap<String, Class>> getFilters() {
        return filters;
    }

    public void setFilters(ConcurrentMap<String, ConcurrentMap<String, Class>> filters) {
        this.filters = filters;
    }
}
