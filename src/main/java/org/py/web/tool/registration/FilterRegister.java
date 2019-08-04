package org.py.web.tool.registration;

import javax.servlet.ServletContext;

public class FilterRegister extends AbstractRegistration {
    public FilterRegister() { }
    public FilterRegister(ServletContext ctx) {
        super(ctx);
    }
}
