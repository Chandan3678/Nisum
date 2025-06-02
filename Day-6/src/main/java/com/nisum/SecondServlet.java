package com.nisum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SecondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = (String) request.getAttribute("user");

        out.println("<h2>Welcome, " + name + "!</h2>");
    }
}