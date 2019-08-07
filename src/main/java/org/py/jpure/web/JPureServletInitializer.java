package org.py.jpure.web;

import org.py.jpure.context.servlet.DispatcherServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

@HandlesTypes(WebApplicationInitializer.class)
public class JPureServletInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcherServlet", DispatcherServlet.class);
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/");
    }
}
