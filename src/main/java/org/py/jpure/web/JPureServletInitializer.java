package org.py.jpure.web;

import org.py.jpure.JPureInitialize;
import org.py.jpure.context.WebRootResolver;
import org.py.jpure.context.filter.CharacterEncodingFilter;
import org.py.jpure.context.listener.RootServletListener;
import org.py.jpure.context.servlet.DispatcherServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

@HandlesTypes(WebApplicationInitializer.class)
public class JPureServletInitializer implements ServletContainerInitializer {
    private static final WebRootResolver webRootResolver;
    private static final JPureApi jPureApi;
    static {
        webRootResolver = new WebRootResolver();
        jPureApi = JPureInitialize.get();
    }
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        servletContext.addListener(RootServletListener.class);
        webRootResolver.servletContext(servletContext);
        webRootResolver.addFilter("characterEncodingFilter", CharacterEncodingFilter.class, "/*");
        webRootResolver.register();
        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcherServlet", DispatcherServlet.class);
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/");

        jPureApi.startup(webRootResolver);
    }
}
