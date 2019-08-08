package org.py.jpure.support;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

public abstract class ServletResolver {
    protected ServletRequest request;
    protected ServletResponse response;
    protected HttpSession session;

    public ServletRequest getRequest() {
        return request;
    }

    public ServletResponse getResponse() {
        return response;
    }

    public HttpSession getSession() {
        return session;
    }
}
