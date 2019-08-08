package org.py.jpure.context.servlet;

import org.py.jpure.core.model.JPureMap;
import org.py.jpure.support.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends ResolverServlet {
    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);
    @Override
    protected void jungle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String url = request.getRequestURL().toString();
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        JPureMap<String, Class<? extends Controller>> controllerMap = jPureApi.controllerMap();
        jPureApi.body();
        log.info("uri: " + uri);
        log.info("url: " + url);
        log.info("contextPath: " + contextPath);
        log.info("servletPath: " + servletPath);
    }
}
