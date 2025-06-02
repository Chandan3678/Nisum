package com.nisum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GetterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        if (session != null) {
            String username = (String) session.getAttribute("username");
            String role = (String) session.getAttribute("role");

            if (username != null && role != null) {
                out.println("<h3>Session Data Retrieved:</h3>");
                out.println("<p>Username: " + username + "</p>");
                out.println("<p>Role: " + role + "</p>");
            } else {
                out.println("<p>No session data found.</p>");
            }
        } else {
            out.println("<p>No session found. Please access the setter servlet first.</p>");
        }
    }
}
