package org.py.jpure.context.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class RootServletListener implements ServletContextListener {
    private static final Logger log = LoggerFactory.getLogger(RootServletListener.class);
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info(getClass().getName() + " initialized. web starting up...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info(getClass().getName() + " destroyed. web site closed.");
    }
}
