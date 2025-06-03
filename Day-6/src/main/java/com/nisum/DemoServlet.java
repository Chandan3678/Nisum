package com.nisum.web;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RequestHandlerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        processRequest(request, response, "GET");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        processRequest(request, response, "POST");
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response, String methodType)
            throws IOException {

        String userName = request.getParameter("name");
        if (userName == null || userName.trim().isEmpty()) {
            userName = "Guest";
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Request Response</title></head>");
        out.println("<body>");
        out.printf("<h1>Received a %s Request</h1>%n", methodType);
        out.printf("<div><strong>User:</strong> %s</div>%n", userName);
        out.println("</body>");
        out.println("</html>");
    }
}
