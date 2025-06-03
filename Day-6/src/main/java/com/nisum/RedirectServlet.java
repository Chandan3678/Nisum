package com.nisum.utility;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ExternalLinkForwarder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String targetURL = "https://www.google.com";
        response.setStatus(HttpServletResponse.SC_FOUND); // 302 status code
        response.setHeader("Location", targetURL);
    }
}
