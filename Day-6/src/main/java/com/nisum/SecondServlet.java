package com.nisum.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class GreetingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        Object userObj = req.getAttribute("user");
        String userName = (userObj != null) ? userObj.toString() : "Guest";

        writer.println("<html><head><title>Greeting</title></head><body>");
        writer.printf("<h1>Hello, %s!</h1>%n", userName);
        writer.println("</body></html>");
    }
}
