package com.example.loginguestsignuppage;


import java.io.IOException;
import java.io.PrintWriter;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "FiveCardDrawServlet", value = "/fivecarddraw")
public class FiveCardDrawServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Welcome to Five Card Draw!</h1>");
        // Add your game logic here
        out.println("</body></html>");
    }
}
