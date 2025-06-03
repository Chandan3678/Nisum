package com.nisum.session;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class EducationInfoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String degree = req.getParameter("qualification");
        String institute = req.getParameter("university");

        HttpSession eduSession = req.getSession(true);
        eduSession.setAttribute("degree", degree);
        eduSession.setAttribute("institute", institute);

        res.sendRedirect("confirmation.jsp");
    }
}
