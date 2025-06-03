package com.nisum.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class RequestHeaderViewer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>HTTP Headers</title></head><body>");
        out.println("<h1>Incoming Request Headers</h1>");
        out.println("<table border='1' cellpadding='5'><tr><th>Header Name</th><th>Header Value</th></tr>");

        Enumeration<String> headers = req.getHeaderNames();
        while (headers.hasMoreElements()) {
            String headerName = headers.nextElement();
            String headerValue = req.getHeader(headerName);
            out.printf("<tr><td>%s</td><td>%s</td></tr>%n", headerName, headerValue);
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}
