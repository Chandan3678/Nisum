package com.nisum;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DemoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        String name = req.getParameter("name");

        resp.setContentType("text/html");
        resp.getWriter().println("<h2>This is a GET request</h2>");
        resp.getWriter().println("<p>Name:" + name + "</p>");
    }

    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        String name = req.getParameter("name");

        resp.setContentType("text/html");
        resp.getWriter().println("<h2>This is a POST request</h2>");
        resp.getWriter().println("<p>Name:" + name + "</p>");
    }


}