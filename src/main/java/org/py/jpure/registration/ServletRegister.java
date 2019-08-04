package org.py.jpure.registration;

import javax.servlet.ServletContext;
import java.util.concurrent.atomic.AtomicReference;

public class ServletRegister extends AbstractRegistration {
    public ServletRegister() {
    }

    public ServletRegister(ServletContext ctx) {
        super(ctx);
    }

    @Override
    public void register() {
        AtomicReference<String> av = new AtomicReference<>();
        elements.forEach((url, map) -> {
            av.set(url);
            map.forEach((name, clazz) -> {
                ctx.addServlet(name, clazz).addMapping(av.get());
            });
        });
    }
}
