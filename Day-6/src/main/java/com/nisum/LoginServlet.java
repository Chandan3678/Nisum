package com.nisum.auth;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthServlet extends HttpServlet {

    private static final String VALID_USER = "admin";
    private static final String VALID_PASS = "1234";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userInput = request.getParameter("username");
        String passInput = request.getParameter("password");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Authentication Result</title></head><body>");

        if (VALID_USER.equals(userInput) && VALID_PASS.equals(passInput)) {
            out.println("<h1>Access Granted</h1>");
            out.printf("<p>Welcome, <strong>%s</strong>! You have successfully logged in.</p>%n", userInput);
        } else {
            out.println("<h1>Access Denied</h1>");
            out.println("<p>The credentials you entered are incorrect. Please try again.</p>");
        }

        out.println("</body></html>");
    }
}
