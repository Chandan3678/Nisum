package com.nisum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SetterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        session.setAttribute("username", "Madhusmita");
        session.setAttribute("role", "Student");

        out.println("<h3>Session attributes set successfully!</h3>");
        out.println("<a href='getter'>Go to GetterServlet</a>");
    }
}
