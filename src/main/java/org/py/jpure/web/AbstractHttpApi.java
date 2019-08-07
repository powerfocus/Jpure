package org.py.jpure.web;

import org.py.jpure.core.model.JPureList;
import org.py.jpure.core.model.JPureMap;
import org.py.jpure.support.controller.Controller;

import javax.servlet.Servlet;
import java.util.logging.Filter;

public abstract class AbstractHttpApi implements JPureApi {
    protected JPureMap<String, Controller> controllerMap;
    protected JPureMap<String, Interceptor> interceptorMap;
    protected JPureList<Servlet> servlets;
    protected JPureList<Filter> filters;
    protected JPureMap<String, Object> configuration;
    protected AbstractHttpApi() {
        controllerMap = new JPureMap<>();
        interceptorMap = new JPureMap<>();
        servlets = new JPureList<>();
        filters = new JPureList<>();
        configuration = new JPureMap<>();
    }
    @Override
    public void initialize() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void configuration() {

    }

    @Override
    public JPureMap<String, Controller> controller() {
        return controllerMap;
    }

    @Override
    public JPureList<Filter> filters() {
        return filters;
    }

    @Override
    public JPureList<Servlet> servlets() {
        return servlets;
    }

    @Override
    public JPureMap<String, Interceptor> interceptor() {
        return interceptorMap;
    }
}
