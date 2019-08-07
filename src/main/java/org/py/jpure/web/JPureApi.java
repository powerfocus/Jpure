package org.py.jpure.web;

import org.py.jpure.core.JPureList;
import org.py.jpure.core.JPureMap;

import javax.servlet.Servlet;
import java.util.logging.Filter;

public interface JPureApi {
    void initialize();
    void destroy();
    void configuration();
    JPureMap<String, Object> controller();
    JPureList<Filter> filters();
    JPureList<Servlet> servlets();
    JPureMap<String, Object> interceptor();
}
