package org.py.jpure.context.servlet;

import org.py.jpure.JPureInitialize;
import org.py.jpure.web.JPureApi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class ResolverServlet extends HttpServlet {
    protected JPureApi jPureApi;
    {
        jPureApi = JPureInitialize.get();
    }
    protected void jungle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        jungle(req, resp);
    }
}
