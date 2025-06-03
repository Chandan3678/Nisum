package com.nisum.database;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class StudentRecordsServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "admin@123";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter writer = response.getWriter()) {

            writer.println("<html><head><title>Students Overview</title></head><body>");
            writer.println("<h1>List of Students</h1>");
            writer.println("<table border='1' cellpadding='8' cellspacing='0'>");
            writer.println("<thead><tr><th>ID</th><th>Name</th><th>Roll Number</th><th>Department</th></tr></thead>");
            writer.println("<tbody>");

            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                 Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM students")) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String studentName = resultSet.getString("name");
                    String rollNo = resultSet.getString("class");
                    String department = resultSet.getString("department");

                    writer.printf("<tr><td>%d</td><td>%s</td><td>%s</td><td>%s</td></tr>%n",
                            id, studentName, rollNo, department);
                }
            }

            writer.println("</tbody></table>");
            writer.println("</body></html>");

        } catch (Exception ex) {
            throw new ServletException("Database access error: " + ex.getMessage(), ex);
        }
    }
}
