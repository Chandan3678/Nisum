package com.nisum;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ConfigExampleServlet extends HttpServlet {

    private String developerName;
    private String project;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.developerName = config.getInitParameter("developerName");
        this.project = config.getInitParameter("project");
        System.out.println("Servlet initialized with developerName: " + developerName + ", project: " + project);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.getWriter().println("<h2>Initialization Parameters</h2>");
        resp.getWriter().println("<p>Developer: " + developerName + "</p>");
        resp.getWriter().println("<p>Project: " + project + "</p>");
    }
}