package org.py.jpure.web;

import javax.servlet.ServletContext;

public interface WebApplicationInitializer {
    void Onstartup(ServletContext servletContext);
}
