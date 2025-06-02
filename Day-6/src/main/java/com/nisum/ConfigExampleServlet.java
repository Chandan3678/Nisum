package com.nisum;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class ConfigExampleServlet extends HttpServlet {

    private String developerName;
    private String project;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        developerName = config.getInitParameter("developerName");
        project = config.getInitParameter("project");

        System.out.printf("Servlet initialized with developerName: %s, project: %s%n",
                          developerName, project);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        StringBuilder htmlResponse = new StringBuilder();
        htmlResponse.append("<html><body>")
                    .append("<h2>Initialization Parameters</h2>")
                    .append("<p>Developer: ").append(developerName).append("</p>")
                    .append("<p>Project: ").append(project).append("</p>")
                    .append("</body></html>");

        response.getWriter().write(htmlResponse.toString());
    }
}
