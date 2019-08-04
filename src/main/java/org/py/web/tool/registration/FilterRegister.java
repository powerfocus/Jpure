package org.py.web.tool.registration;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import java.util.concurrent.atomic.AtomicReference;

public class FilterRegister extends AbstractRegistration {
    public FilterRegister() { }
    public FilterRegister(ServletContext ctx) {
        super(ctx);
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
    }
}
