package org.py.jpure.web;

import org.py.jpure.core.JPureList;
import org.py.jpure.core.JPureMap;

import javax.servlet.Servlet;
import java.util.logging.Filter;

public abstract class AbstractHttpApi implements JPureApi {
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
    public JPureMap<String, Object> controller() {
        return new JPureMap<>();
    }

    @Override
    public JPureList<Filter> filters() {
        return new JPureList<>();
    }

    @Override
    public JPureList<Servlet> servlets() {
        return new JPureList<>();
    }

    @Override
    public JPureMap<String, Object> interceptor() {
        return new JPureMap<>();
    }
}
