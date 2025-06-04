package com.nisum;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class OrderDetailsServlet extends HttpServlet {
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

        String orderId = request.getParameter("orderId");
        if (orderId == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing orderId parameter");
            return;
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // ORDER MAIN
            PreparedStatement psOrder = connection.prepareStatement("SELECT * FROM Orders WHERE OrderID = ?");
            psOrder.setInt(1, Integer.parseInt(orderId));
            ResultSet rsOrder = psOrder.executeQuery();

            if (rsOrder.next()) {
                out.println("<h2>Order Detail</h2>");
                out.println("<div class='section'>");
                out.println("<div class='field'><span class='label'>Order ID:</span> " + orderId + "</div>");
                out.println("<div class='field'><span class='label'>Order Date:</span> " + rsOrder.getString("OrderDate") + "</div>");
                out.println("<div class='field'><span class='label'>Status:</span> " + rsOrder.getString("OrderStatus") + "</div>");
                out.println("<div class='field'><span class='label'>Total:</span> Rs. " + rsOrder.getDouble("OrderTotal") + "</div>");
                out.println("</div>");
            }

            // ORDER ITEMS
            out.println("<h2>Ordered Items</h2><div class='section'><table><thead><tr><th>OrderItemID</th><th>ProductID</th><th>SKU</th><th>Qty</th><th>UnitPrice</th><th>Discount</th><th>FinalPrice</th><th>Size</th><th>Color</th></tr></thead><tbody>");
            PreparedStatement psItems = connection.prepareStatement("SELECT * FROM OrderItems WHERE OrderID = ?");
            psItems.setInt(1, Integer.parseInt(orderId));
            ResultSet rsItems = psItems.executeQuery();
            while (rsItems.next()) {
                out.println("<tr><td>" + rsItems.getInt("OrderItemID") + "</td><td>" + rsItems.getInt("ProductID") + "</td><td>" + rsItems.getString("SKU") + "</td><td>" + rsItems.getInt("Quantity") + "</td><td>" + rsItems.getDouble("UnitPrice") + "</td><td>" + rsItems.getDouble("Discount") + "</td><td>" + rsItems.getDouble("FinalPrice") + "</td><td>" + rsItems.getString("Size") + "</td><td>" + rsItems.getString("Color") + "</td></tr>");
            }
            out.println("</tbody></table></div>");

            // SHIPMENT
            out.println("<h2>Shipment Details</h2><div class='section'>");
            PreparedStatement psShip = connection.prepareStatement("SELECT * FROM Shipments WHERE OrderID = ?");
            psShip.setInt(1, Integer.parseInt(orderId));
            ResultSet rsShip = psShip.executeQuery();
            if (rsShip.next()) {
                out.println("<script>const shipmentStatus = \"" + rsShip.getString("ShipmentStatus") + "\";</script>");
                out.println("<div class='field'><span class='label'>Shipment ID:</span> " + rsShip.getInt("ShipmentID") + "</div>");
                out.println("<div class='field'><span class='label'>Status:</span> " + rsShip.getString("ShipmentStatus") + "</div>");
                out.println("<div class='field'><span class='label'>Tracking ID:</span> " + rsShip.getString("ShipmentTrackingID") + "</div>");
                out.println("<div class='field'><span class='label'>Shipped Date:</span> " + rsShip.getString("ShipmentDate") + "</div>");
                out.println("<div class='field'><span class='label'>Delivered Date:</span> " + rsShip.getString("DeliveredDate") + "</div>");
            }
            out.println("</div>");

            // SHIPMENT ITEMS
            out.println("<h2>Shipment Items</h2><div class='section'><table><thead><tr><th>OrderItemID</th><th>ShippedQty</th></tr></thead><tbody>");
            PreparedStatement psShipItems = connection.prepareStatement("SELECT * FROM ShipmentItems WHERE ShipmentID IN (SELECT ShipmentID FROM Shipments WHERE OrderID = ?)");
            psShipItems.setInt(1, Integer.parseInt(orderId));
            ResultSet rsShipItems = psShipItems.executeQuery();
            while (rsShipItems.next()) {
                out.println("<tr><td>" + rsShipItems.getInt("OrderItemID") + "</td><td>" + rsShipItems.getInt("ShippedQty") + "</td></tr>");
            }
            out.println("</tbody></table></div>");

            // INVOICE
            out.println("<h2>Invoice Details</h2><div class='section'>");
            PreparedStatement psInvoice = connection.prepareStatement("SELECT * FROM OrderInvoice WHERE OrderID = ?");
            psInvoice.setInt(1, Integer.parseInt(orderId));
            ResultSet rsInv = psInvoice.executeQuery();
            if (rsInv.next()) {
                out.println("<div class='field'><span class='label'>Invoice Number:</span> " + rsInv.getString("InvoiceNumber") + "</div>");
                out.println("<div class='field'><span class='label'>Invoice Date:</span> " + rsInv.getString("InvoiceDate") + "</div>");
                out.println("<div class='field'><span class='label'>Total Amount:</span> " + rsInv.getDouble("InvoiceAmount") + "</div>");
                out.println("<div class='field'><span class='label'>Payment Mode:</span> " + rsInv.getString("PaymentMode") + "</div>");
            }
            out.println("</div>");

            // BUTTON GROUP
            out.println("<div class='button-group'>");
            out.println("<button onclick='downloadInvoice()'>Download Invoice</button>");
            out.println("<button onclick='trackPackage()'>Track Package</button>");
            out.println("<button id='feedbackBtn'>Leave Seller Feedback</button>");
            out.println("<button id='deliveryFeedbackBtn'>Leave Delivery Feedback</button>");
            out.println("<button id='productReviewBtn'>Write a Product Review</button>");
            out.println("<button id='buyAgainBtn'>Buy Again</button>");
            out.println("</div>");

            // MODALS
            // Seller Feedback Modal
            out.println("<div id='feedbackModal' style='display:none; position:fixed; z-index:100; left:0; top:0; width:100%; height:100%; background:rgba(0,0,0,0.5)'>");
            out.println("<div style='background:#fff; margin:10% auto; padding:20px; width:80%; max-width:500px; border-radius:8px;'>");
            out.println("<span onclick=\"document.getElementById('feedbackModal').style.display='none'\" style='float:right; cursor:pointer; font-size:24px;'>&times;</span>");
            out.println("<h3 style='margin-top:0;'>Seller Feedback</h3>");
            out.println("<div class='stars' style='font-size:24px; margin:15px 0;'>");
            out.println("<span class='star' data-value='1' style='cursor:pointer; color:#ddd; margin-right:5px;'>&#9733;</span>");
            out.println("<span class='star' data-value='2' style='cursor:pointer; color:#ddd; margin-right:5px;'>&#9733;</span>");
            out.println("<span class='star' data-value='3' style='cursor:pointer; color:#ddd; margin-right:5px;'>&#9733;</span>");
            out.println("<span class='star' data-value='4' style='cursor:pointer; color:#ddd; margin-right:5px;'>&#9733;</span>");
            out.println("<span class='star' data-value='5' style='cursor:pointer; color:#ddd; margin-right:5px;'>&#9733;</span>");
            out.println("</div>");
            out.println("<textarea id='feedbackText' placeholder='Your feedback...' style='width:100%; height:100px; padding:8px; border:1px solid #ddd; border-radius:4px;'></textarea>");
            out.println("<div style='display:flex; gap:10px; margin-top:15px;'>");
            out.println("<button id='submitFeedbackBtn' style='padding:8px 15px; background:#ff3d6b; color:white; border:none; border-radius:4px; cursor:pointer;'>Submit</button>");
            out.println("<button id='closeFeedbackBtn' style='padding:8px 15px; background:#ddd; border:none; border-radius:4px; cursor:pointer;'>Cancel</button>");
            out.println("</div>");
            out.println("</div></div>");

            // Delivery Feedback Modal
            out.println("<div id='dfModal' style='display:none; position:fixed; z-index:100; left:0; top:0; width:100%; height:100%; background:rgba(0,0,0,0.5)'>");
            out.println("<div style='background:#fff; margin:10% auto; padding:20px; width:80%; max-width:500px; border-radius:8px;'>");
            out.println("<span onclick=\"document.getElementById('dfModal').style.display='none'\" style='float:right; cursor:pointer; font-size:24px;'>&times;</span>");
            out.println("<h3 style='margin-top:0;'>Delivery Feedback</h3>");
            out.println("<div class='stars' style='font-size:24px; margin:15px 0;'>");
            out.println("<span class='star' data-value='1' style='cursor:pointer; color:#ddd; margin-right:5px;'>&#9733;</span>");
            out.println("<span class='star' data-value='2' style='cursor:pointer; color:#ddd; margin-right:5px;'>&#9733;</span>");
            out.println("<span class='star' data-value='3' style='cursor:pointer; color:#ddd; margin-right:5px;'>&#9733;</span>");
            out.println("<span class='star' data-value='4' style='cursor:pointer; color:#ddd; margin-right:5px;'>&#9733;</span>");
            out.println("<span class='star' data-value='5' style='cursor:pointer; color:#ddd; margin-right:5px;'>&#9733;</span>");
            out.println("</div>");
            out.println("<textarea id='dfeedbackText' placeholder='Your feedback about delivery...' style='width:100%; height:100px; padding:8px; border:1px solid #ddd; border-radius:4px;'></textarea>");
            out.println("<div style='display:flex; gap:10px; margin-top:15px;'>");
            out.println("<button id='submitDeliveryFeedbackBtn' style='padding:8px 15px; background:#ff3d6b; color:white; border:none; border-radius:4px; cursor:pointer;'>Submit</button>");
            out.println("<button id='closeDeliveryFeedbackBtn' style='padding:8px 15px; background:#ddd; border:none; border-radius:4px; cursor:pointer;'>Cancel</button>");
            out.println("</div>");
            out.println("</div></div>");

            // Product Review Modal
            out.println("<div id='productmodal' style='display:none; position:fixed; z-index:100; left:0; top:0; width:100%; height:100%; background:rgba(0,0,0,0.5)'>");
            out.println("<div style='background:#fff; margin:10% auto; padding:20px; width:80%; max-width:500px; border-radius:8px;'>");
            out.println("<span onclick=\"document.getElementById('productmodal').style.display='none'\" style='float:right; cursor:pointer; font-size:24px;'>&times;</span>");
            out.println("<h3 style='margin-top:0;'>Product Review</h3>");
            out.println("<textarea id='reviewText' placeholder='Your review about the product...' style='width:100%; height:100px; padding:8px; border:1px solid #ddd; border-radius:4px;'></textarea>");
            out.println("<div style='display:flex; gap:10px; margin-top:15px;'>");
            out.println("<button id='submitProductReviewBtn' style='padding:8px 15px; background:#ff3d6b; color:white; border:none; border-radius:4px; cursor:pointer;'>Submit</button>");
            out.println("<button id='closeProductReviewBtn' style='padding:8px 15px; background:#ddd; border:none; border-radius:4px; cursor:pointer;'>Cancel</button>");
            out.println("</div>");
            out.println("</div></div>");

        } catch (SQLException e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }

    @Override
    public void destroy() {
        try {
            if (connection != null) connection.close();
        } catch (SQLException ignored) {}
    }
}