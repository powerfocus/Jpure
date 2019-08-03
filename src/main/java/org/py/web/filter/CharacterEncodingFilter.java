package org.py.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    private final static Logger log = LoggerFactory.getLogger(CharacterEncodingFilter.class);
    private FilterConfig config;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info(getClass().getName() + " initialize.");
        config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info(getClass().getName() + " filter character encoding.");
    }

    @Override
    public void destroy() {
        log.info(CharacterEncodingFilter.class.getName() + " destroy.");
        config = null;
    }
}
