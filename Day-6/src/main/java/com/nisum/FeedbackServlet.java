package com.nisum;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FeedbackServlet extends HttpServlet {
    private static final List<String> feedbackList = new ArrayList<>();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String name = req.getParameter("name");
        String feedback = req.getParameter("feedback");

        String entry = "Name: " + name + " | Feedback: " + feedback;
        feedbackList.add(entry);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<h2>Thank you for your feedback, " + name + "!</h2>");
        out.println("<h3>All Feedbacks:</h3>");
        out.println("<ul>");
        for (String fb : feedbackList) {
            out.println("<li>" + fb + "</li>");
        }
        out.println("</ul>");
    }
}