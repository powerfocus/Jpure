package org.py.web.context.listener;

import org.py.web.context.filter.CharacterEncodingFilter;
import org.py.web.tool.registration.FilterRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RootServletListener implements ServletContextListener {
    private static final Logger log = LoggerFactory.getLogger(RootServletListener.class);
    private static final FilterRegister filterRegister;
    static {
        filterRegister = new FilterRegister();
    }
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        /*FilterRegistration.Dynamic encodingFilter = context.addFilter("characterEncodingFilter", CharacterEncodingFilter.class);
        encodingFilter.addMappingForUrlPatterns(null, false, "/*");*/
        filterRegister.setCtx(context);
        filterRegister.add("characterEncodingFilter", CharacterEncodingFilter.class, "/*");
        filterRegister.register();
        log.info(getClass().getName() + " initialized.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info(getClass().getName() + " destroyed.");
    }
}