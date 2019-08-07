package org.py.jpure.context.servlet;

import org.py.jpure.JPureInitialize;
import org.py.jpure.core.io.ClasspathReaderAdapter;
import org.py.jpure.web.JPureApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends ResolverServlet {
    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);
    private JPureApi jPureApi;
    {
        jPureApi = JPureInitialize.get();
    }
    @Override
    protected void jungle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getOutputStream().write(ClasspathReaderAdapter.readAllByte("/public/wb.jpg"));
    }
}
