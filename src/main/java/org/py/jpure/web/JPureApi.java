package org.py.jpure.web;

import org.py.jpure.context.WebRootResolver;
import org.py.jpure.core.model.JPureList;
import org.py.jpure.core.model.JPureMap;
import org.py.jpure.support.controller.Controller;

import javax.servlet.Servlet;
import java.util.logging.Filter;

public interface JPureApi {
    void initialize();
    void destroy();
    void configuration();
    void body();
    void startup(final WebRootResolver webRootResolver);
    JPureMap<String, Class<? extends Controller>> controllerMap();
    JPureList<Filter> filters();
    JPureList<Servlet> servlets();
    JPureMap<String, Class<? extends Interceptor>> interceptorMap();
}
