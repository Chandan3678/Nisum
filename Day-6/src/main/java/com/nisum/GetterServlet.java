package com.nisum.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = res.getWriter();

        HttpSession userSession = req.getSession(false);

        writer.println("<!DOCTYPE html>");
        writer.println("<html><head><title>User Session Info</title></head><body>");

        if (userSession != null) {
            String name = (String) userSession.getAttribute("username");
            String userRole = (String) userSession.getAttribute("role");

            if (name != null && userRole != null) {
                writer.println("<h2>Welcome Back!</h2>");
                writer.printf("<p><strong>Name:</strong> %s</p>%n", name);
                writer.printf("<p><strong>Role:</strong> %s</p>%n", userRole);
            } else {
                writer.println("<p>Session exists, but required data is missing.</p>");
            }
        } else {
            writer.println("<p>No active session found. Please log in or set session data first.</p>");
        }

        writer.println("</body></html>");
    }
}
