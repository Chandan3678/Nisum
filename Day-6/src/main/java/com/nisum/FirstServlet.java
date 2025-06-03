package com.nisum.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class InitiateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        String userInput = req.getParameter("username");
        if (userInput == null) {
            userInput = "Guest";
        }

        req.setAttribute("user", userInput);

        RequestDispatcher dispatcher = req.getRequestDispatcher("NextStepServlet");
        dispatcher.forward(req, res);
    }
}
