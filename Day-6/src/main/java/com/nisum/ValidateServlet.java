package com.nisum.validation;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputValidator extends HttpServlet {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String user = req.getParameter("username");
        String userEmail = req.getParameter("email");

        resp.setContentType("text/html;charset=UTF-8");

        try (PrintWriter writer = resp.getWriter()) {

            String message;

            if (user == null || user.trim().isEmpty()) {
                message = "<span style='color:red;'>Error: Username cannot be empty.</span>";
            } else if (userEmail == null || userEmail.trim().isEmpty()) {
                message = "<span style='color:red;'>Error: Email is mandatory.</span>";
            } else {
                Matcher matcher = EMAIL_PATTERN.matcher(userEmail);
                if (!matcher.matches()) {
                    message = "<span style='color:red;'>Error: Email format is incorrect.</span>";
                } else {
                    message = "<span style='color:green;'>Validation successful!</span>";
                }
            }

            writer.println("<html><body>");
            writer.println("<h3>" + message + "</h3>");

            if (message.contains("successful")) {
                writer.println("<p>Username: <strong>" + user + "</strong></p>");
                writer.println("<p>Email Address: <strong>" + userEmail + "</strong></p>");
            } else {
                writer.println("<a href='form.html'>Return to form</a>");
            }

            writer.println("</body></html>");
        }
    }
}
package com.nisum.validation;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputValidator extends HttpServlet {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String user = req.getParameter("username");
        String userEmail = req.getParameter("email");

        resp.setContentType("text/html;charset=UTF-8");

        try (PrintWriter writer = resp.getWriter()) {

            String message;

            if (user == null || user.trim().isEmpty()) {
                message = "<span style='color:red;'>Error: Username cannot be empty.</span>";
            } else if (userEmail == null || userEmail.trim().isEmpty()) {
                message = "<span style='color:red;'>Error: Email is mandatory.</span>";
            } else {
                Matcher matcher = EMAIL_PATTERN.matcher(userEmail);
                if (!matcher.matches()) {
                    message = "<span style='color:red;'>Error: Email format is incorrect.</span>";
                } else {
                    message = "<span style='color:green;'>Validation successful!</span>";
                }
            }

            writer.println("<html><body>");
            writer.println("<h3>" + message + "</h3>");

            if (message.contains("successful")) {
                writer.println("<p>Username: <strong>" + user + "</strong></p>");
                writer.println("<p>Email Address: <strong>" + userEmail + "</strong></p>");
            } else {
                writer.println("<a href='form.html'>Return to form</a>");
            }

            writer.println("</body></html>");
        }
    }
}
