package com.nisum;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class HeaderDisplayServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body><h2>Request Headers</h2><ul>");

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            out.println("<li><strong>" + name + ":</strong> " + value + "</li>");
        }

        out.println("</ul></body></html>");
    }
}