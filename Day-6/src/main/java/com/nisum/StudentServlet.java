package com.nisum;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class StudentServlet extends HttpServlet {
    String url = "jdbc:mysql://localhost:3306/jdbc";
    String username = "root";
    String password = "admin@123";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><head><title>Student List</title></head><body>");
        out.println("<h2>Student Records</h2>");
        out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Roll No</th><th>Department</th></tr>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("id") + "</td>"
                        + "<td>" + rs.getString("name") + "</td>"
                        + "<td>" + rs.getString("class") + "</td></tr>"
                        + "<td>" + rs.getString("department") + "</td></tr>");
            }

            out.println("</table>");
            con.close();
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }

        out.println("</body></html>");
    }
}