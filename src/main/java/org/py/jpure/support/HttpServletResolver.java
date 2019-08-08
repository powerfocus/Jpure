package org.py.jpure.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletResolver extends ServletResolver {
    public HttpServletResolver(HttpServletRequest req, HttpServletResponse resp) {
        request = req;
        response = resp;
        session = req.getSession();
    }
}
