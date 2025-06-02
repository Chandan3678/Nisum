package com.nisum;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreateUserServlet extends HttpServlet {

    private final Map<String, User> users = new HashMap<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String email = req.getParameter("email");

        if (username == null || email == null || username.isEmpty() || email.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Both username and email are required.");
            return;
        }

        users.put(email, new User(username, email));

        resp.setContentType("text/html");
        resp.getWriter().write("<h2>User Created Successfully</h2>");
        resp.getWriter().write("<p>Username: " + username + "</p>");
        resp.getWriter().write("<p>Email: " + email + "</p>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String pathInfo = req.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Email must be provided in the path.");
            return;
        }

        String email = pathInfo.substring(1);
        User user = users.get(email);

        if (user == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "User not found.");
            return;
        }

        resp.setContentType("application/json");
        resp.getWriter().write(user.toString());
    }
}