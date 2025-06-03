package com.nisum.session;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionInitializer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        HttpSession currentSession = req.getSession(true);

        currentSession.setAttribute("userName", "Madhusmita");
        currentSession.setAttribute("userRole", "Student");

        writer.println("<h2>Session data initialized!</h2>");
        writer.println("<p><a href='getter'>Visit GetterServlet to view session data</a></p>");
    }
}
