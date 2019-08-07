package org.py.arena;

import org.py.jpure.core.JPureList;
import org.py.jpure.core.JPureMap;
import org.py.jpure.web.AbstractHttpApi;

import javax.servlet.Servlet;
import java.util.logging.Filter;

public class JPureMain extends AbstractHttpApi {
    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void configuration() {
        super.configuration();
    }

    @Override
    public JPureMap<String, Object> controller() {
        return super.controller();
    }

    @Override
    public JPureList<Filter> filters() {
        return super.filters();
    }

    @Override
    public JPureList<Servlet> servlets() {
        return super.servlets();
    }

    @Override
    public JPureMap<String, Object> interceptor() {
        return super.interceptor();
    }
}
