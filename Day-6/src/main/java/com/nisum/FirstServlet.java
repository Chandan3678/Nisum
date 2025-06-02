package com.nisum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        request.setAttribute("user", username);

        RequestDispatcher rd = request.getRequestDispatcher("SecondServlet");
        rd.forward(request, response);
    }
}