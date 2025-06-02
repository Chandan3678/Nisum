package com.nisum;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class UserRegistrationServlet extends HttpServlet {

    // Thread-safe user store
    private final Map<String, User> userDirectory = new ConcurrentHashMap<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("username");
        String userEmail = request.getParameter("email");

        if (isInvalid(name) || isInvalid(userEmail)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Username and Email must not be empty.");
            return;
        }

        userDirectory.put(userEmail, new User(name, userEmail));

        response.setContentType("text/html;charset=UTF-8");
        StringBuilder html = new StringBuilder();
        html.append("<html><body>")
            .append("<h2>New User Registered</h2>")
            .append("<p><strong>Name:</strong> ").append(name).append("</p>")
            .append("<p><strong>Email:</strong> ").append(userEmail).append("</p>")
            .append("</body></html>");

        response.getWriter().write(html.toString());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String emailLookup = extractEmailFromPath(request.getPathInfo());

        if (emailLookup == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing user email in the request path.");
            return;
        }

        User foundUser = userDirectory.get(emailLookup);

        if (foundUser == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "User with provided email not found.");
            return;
        }

        response.setContentType("application/json");
        response.getWriter().write(foundUser.toString()); // Make sure User#toString returns valid JSON
    }

    private boolean isInvalid(String input) {
        return input == null || input.trim().isEmpty();
    }

    private String extractEmailFromPath(String path) {
        return (path != null && path.length() > 1) ? path.substring(1) : null;
    }
}
