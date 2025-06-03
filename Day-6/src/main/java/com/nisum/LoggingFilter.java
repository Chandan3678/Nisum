package com.nisum.middleware;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RequestLoggerFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        // Initialization logic if needed
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        if (req instanceof HttpServletRequest) {
            HttpServletRequest incomingRequest = (HttpServletRequest) req;
            String fullURL = incomingRequest.getRequestURL().toString();
            System.out.printf(">> Incoming request to: %s%n", fullURL);
        }

        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        // Cleanup logic if needed
    }
}
