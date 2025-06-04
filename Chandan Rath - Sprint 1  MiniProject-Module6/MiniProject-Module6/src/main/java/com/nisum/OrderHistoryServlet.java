package com.nisum;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class OrderHistoryServlet extends HttpServlet {
    private Connection connection;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/modulesix_firstproject", "root", "tarush30"
            );
        } catch (Exception e) {
            throw new ServletException("DB connection failed", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String range = request.getParameter("range");
        if (range == null) range = "6months";

        String query;
        if ("1week".equals(range)) {
            query = "SELECT * FROM Orders WHERE OrderDate >= CURDATE() - INTERVAL 7 DAY ORDER BY OrderDate DESC";
        } else {
            int months;
            switch (range) {
                case "1month":
                    months = 1;
                    break;
                case "6months":
                    months = 6;
                    break;
                case "1year":
                    months = 12;
                    break;
                default:
                    months = 60;
            }
            query = "SELECT * FROM Orders WHERE OrderDate >= CURDATE() - INTERVAL " + months + " MONTH ORDER BY OrderDate DESC";
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)
        ) {
            while (rs.next()) {
                int orderId = rs.getInt("OrderID");
                Date orderDate = rs.getDate("OrderDate");
                double total = rs.getDouble("OrderTotal");
                String status = rs.getString("OrderStatus");

                out.println("<div class='order-card'>");
                out.println("  <div class='order-header'>");
                out.println("    <span>ORDER PLACED<br><strong>" + orderDate + "</strong></span>");
                out.println("    <span>TOTAL<br><strong>₹" + total + "</strong></span>");
                out.println("    <span>ORDER # " + orderId + "<br><a href='OrderDetails.html?orderId=" + orderId + "'>View order details</a></span>");
                out.println("  </div>");
                out.println("  <div class='order-body'>");
                out.println("    <img src='media/airtel-logo.png' alt='Logo' height='50'>");
                out.println("    <div>");
                out.println("      <h4>Mobile Prepaid Recharge</h4>");
                out.println("      <p>Status: " + status + "</p>");
                out.println("    </div>");
                out.println("    <button>Recharge Again</button>");
                out.println("  </div>");
                out.println("</div>");
            }
        } catch (SQLException e) {
            out.println("<p>Error fetching orders: " + e.getMessage() + "</p>");
        }
    }

    @Override
    public void destroy() {
        try {
            if (connection != null) connection.close();
        } catch (SQLException ignored) {}
    }
}
