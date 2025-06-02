package com.nisum;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class ContextParamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext appContext = getServletContext();

        String orgName = appContext.getInitParameter("organization");
        String city = appContext.getInitParameter("location");

        response.setContentType("text/html");

        String html = "<html><head><title>Context Info</title></head><body>"
                    + "<h2>Context Parameter Details</h2>"
                    + "<p><strong>Organization:</strong> " + orgName + "</p>"
                    + "<p><strong>Location:</strong> " + city + "</p>"
                    + "</body></html>";

        response.getWriter().write(html);
    }
}
