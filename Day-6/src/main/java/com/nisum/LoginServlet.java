package com.nisum;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private static final String Vusername = "admin";
    private static final String Vpassword = "1234";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        resp.setContentType("text/html");

        if(Vusername.equals(username)&&Vpassword.equals(password)){
            resp.getWriter().println("<h2>Login Successful!</h2>");
            resp.getWriter().println("<p>Welcome, " + username + "</p>");
        }else{
            resp.getWriter().println("<h2>Login Failed</h2>");
            resp.getWriter().println("<p>Invalid username or password.</p>");
        }
    }
}