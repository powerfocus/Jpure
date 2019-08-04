package org.py.web.context.listener;

import org.py.web.context.WebRootResolver;
import org.py.web.context.filter.CharacterEncodingFilter;
import org.py.web.tool.registration.FilterRegister;
import org.py.web.tool.registration.ServletRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RootServletListener implements ServletContextListener {
    private static final Logger log = LoggerFactory.getLogger(RootServletListener.class);
    private static final WebRootResolver webRootResolver;
    static {
        webRootResolver = new WebRootResolver();
    }
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        webRootResolver.servletContext(sce.getServletContext());
        webRootResolver.addFilter("characterEncodingFilter", CharacterEncodingFilter.class, "/*");
        webRootResolver.register();
        log.info(getClass().getName() + " initialized. web starting up...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info(getClass().getName() + " destroyed. web site closed.");
    }
}
