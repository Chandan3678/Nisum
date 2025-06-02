package com.nisum;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentTimeServlet extends HttpServlet {

    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String formattedTime = getCurrentFormattedTime();

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(buildHtmlResponse(formattedTime));
    }

    private String getCurrentFormattedTime() {
        return LocalDateTime.now().format(TIME_FORMAT);
    }

    private String buildHtmlResponse(String time) {
        return "<html><body>" +
               "<h1>Server Time</h1>" +
               "<p><em>" + time + "</em></p>" +
               "</body></html>";
    }
}
