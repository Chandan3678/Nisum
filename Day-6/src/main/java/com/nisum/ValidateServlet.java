package com.nisum;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ValidateServlet extends HttpServlet {

    private static final String EMAIL = "^[\\w.-]+@[\\w.-]+\\.\\w{2,}$";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String errorMessage = null;
        if (username == null || username.trim().isEmpty()) {
            errorMessage = "Username is required.";
        } else if (email == null || email.trim().isEmpty()) {
            errorMessage = "Email is required.";
        } else if (!Pattern.matches(EMAIL, email)) {
            errorMessage = "Invalid email format.";
        }

        out.println("<html><body>");
        if (errorMessage != null) {
            out.println("<h3 style='color:red;'>Error: " + errorMessage + "</h3>");
            out.println("<a href='form.html'>Go Back</a>");
        } else {
            out.println("<h3 style='color:green;'>Success! Your data is valid.</h3>");
            out.println("<p>Username: " + username + "</p>");
            out.println("<p>Email: " + email + "</p>");
        }
        out.println("</body></html>");
    }
}