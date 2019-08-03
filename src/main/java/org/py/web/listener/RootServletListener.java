package org.py.web.listener;

import org.py.web.filter.CharacterEncodingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RootServletListener implements ServletContextListener {
    private static final Logger log = LoggerFactory.getLogger(RootServletListener.class);
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        FilterRegistration.Dynamic encodingFilter = context.addFilter("characterEncodingFilter", CharacterEncodingFilter.class);
        encodingFilter.addMappingForUrlPatterns(null, false, "/*");
        log.info(getClass().getName() + " initialized.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info(getClass().getName() + " destroyed.");
    }
}
