package org.py.web.tool.registration;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;

public class AbstractRegistration implements Registration {
    private ServletContext ctx;
    private ConcurrentMap<String, ConcurrentMap<String, Class<?>>> filters;
    public AbstractRegistration() {
        filters = new ConcurrentHashMap<>();
    }
    public AbstractRegistration(ServletContext ctx) {
        this();
        this.ctx = Objects.requireNonNull(ctx, "context object require not null.");
    }
    @Override
    public void add(String name, Class<?> clazz, String mapping) {
        filters.put(mapping, new ConcurrentHashMap<String, Class<?>>() {{put(name, clazz);}});
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
        AtomicReference<String> av = new AtomicReference<>();
        filters.forEach((url, map) -> {
            av.set(url);
            map.forEach((name, clazz) -> {
                ctx.addFilter(name, (Class<? extends Filter>) clazz).addMappingForUrlPatterns(null, false, av.get());
            });
        });
        /*for (Map.Entry<String, ConcurrentMap<String, Class<?>>> e : filters.entrySet()) {
            String url = e.getKey();
            ConcurrentMap<String, Class<?>> map = e.getValue();
            for (Map.Entry<String, Class<?>> entry : map.entrySet()) {
                String name = entry.getKey();
                Class<?> clazz = entry.getValue();
                ctx.addFilter(name, (Class<? extends Filter>) clazz).addMappingForUrlPatterns(null, false, url);
            }
        }*/
    }

    public ServletContext getCtx() {
        return ctx;
    }

    public void setCtx(ServletContext ctx) {
        this.ctx = ctx;
    }

    public ConcurrentMap<String, ConcurrentMap<String, Class<?>>> getFilters() {
        return filters;
    }

    public void setFilters(ConcurrentMap<String, ConcurrentMap<String, Class<?>>> filters) {
        this.filters = filters;
    }
}
