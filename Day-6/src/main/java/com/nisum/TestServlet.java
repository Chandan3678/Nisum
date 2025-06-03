package com.nisum.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HealthCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        try (PrintWriter writer = resp.getWriter()) {
            writer.println("<div style='font-family:sans-serif; color:green;'>");
            writer.println("<h3>Servlet is up and running!</h3>");
            writer.println("</div>");
        }
    }
}
