package org.py.jpure.web;

import org.py.jpure.core.model.JPureList;
import org.py.jpure.core.model.JPureMap;
import org.py.jpure.support.controller.Controller;

import javax.servlet.Servlet;
import java.util.logging.Filter;

public interface JPureApi {
    void initialize();
    void destroy();
    void configuration();
    JPureMap<String, Class<? extends Controller>> controller();
    JPureList<Filter> filters();
    JPureList<Servlet> servlets();
    JPureMap<String, Class<? extends Interceptor>> interceptor();
}
