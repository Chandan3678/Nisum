package com.nisum.web;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ReviewServlet extends HttpServlet {

    private static final List<String> reviews = Collections.synchronizedList(new LinkedList<>());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("name");
        String comment = request.getParameter("feedback");

        String combinedReview = String.format("User: %s | Comment: %s", user != null ? user : "Anonymous", comment != null ? comment : "No feedback");
        reviews.add(combinedReview);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html><head><title>Feedback Summary</title></head><body>");
        writer.printf("<h2>Hi %s, your input has been received!</h2>%n", user != null ? user : "Guest");
        writer.println("<h3>Collected Feedback:</h3><ol>");

        synchronized (reviews) {
            for (String entry : reviews) {
                writer.printf("<li>%s</li>%n", entry);
            }
        }

        writer.println("</ol></body></html>");
    }
}
