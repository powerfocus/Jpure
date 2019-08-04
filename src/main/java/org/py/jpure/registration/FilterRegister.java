package org.py.jpure.registration;

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
        elements.forEach((url, map) -> {
            av.set(url);
            map.forEach((name, clazz) -> {
                ctx.addFilter(name, clazz).addMappingForUrlPatterns(null, false, av.get());
            });
        });
    }
}
