package org.py.jpure.context.servlet;

import org.py.jpure.core.io.ClasspathReader;
import org.py.jpure.core.io.ClasspathResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DispatcherServlet extends ResolverServlet {
    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getOutputStream().write(new ClasspathReader(new ClasspathResource("/public/wb.jpg")).readBytes());
    }
}

