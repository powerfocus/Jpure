package org.py.jpure.context;

import org.py.jpure.registration.FilterRegister;
import org.py.jpure.registration.ServletRegister;

import javax.servlet.ServletContext;
import java.util.Objects;

public class WebRootResolver {
    private FilterRegister filterRegister;
    private ServletRegister servletRegister;

    public WebRootResolver() {
        filterRegister = new FilterRegister();
        servletRegister = new ServletRegister();
    }

    public void addServlet(String name, Class clazz, String mapping) {
        if(!servletRegister.exists(name)) {
            servletRegister.add(name, clazz, mapping);
        }
    }

    public void addFilter(String name, Class clazz, String mapping) {
        if(!filterRegister.exists(name)) {
            filterRegister.add(name, clazz, mapping);
        }
    }

    public void register() {
        filterRegister.register();
        servletRegister.register();
    }

    public void servletContext(ServletContext ctx) {
        Objects.requireNonNull(ctx, "required servlet context.");
        filterRegister.setCtx(ctx);
        servletRegister.setCtx(ctx);
    }
}
