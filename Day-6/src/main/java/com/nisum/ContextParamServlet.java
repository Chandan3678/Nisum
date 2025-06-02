package com.nisum;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextParamServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        ServletContext context = req.getServletContext();

        String organization = context.getInitParameter("organization");
        String location = context.getInitParameter("location");

        resp.setContentType("text/html");
        resp.getWriter().println("<h2>Context Parameters</h2>");
        resp.getWriter().println("<p>Organization: " + organization + "</p>");
        resp.getWriter().println("<p>Location: " + location + "</p>");
    }
}