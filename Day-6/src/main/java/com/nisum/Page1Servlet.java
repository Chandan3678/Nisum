package com.nisum.session;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UserInfoCollectorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String userName = req.getParameter("name");
        String userEmail = req.getParameter("email");

        HttpSession userSession = req.getSession(true);
        userSession.setAttribute("userName", userName);
        userSession.setAttribute("userEmail", userEmail);

        res.sendRedirect("nextPage.html");
    }
}
