package com.nisum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Page2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String qualification = request.getParameter("qualification");
        String university = request.getParameter("university");

        HttpSession session = request.getSession();
        session.setAttribute("qualification", qualification);
        session.setAttribute("university", university);

        response.sendRedirect("confirm.jsp");
    }
}