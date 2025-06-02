package com.nisum;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class LoggingFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURL = httpRequest.getRequestURL().toString();

        System.out.println("Request URL Logged: " + requestURL);

        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}
