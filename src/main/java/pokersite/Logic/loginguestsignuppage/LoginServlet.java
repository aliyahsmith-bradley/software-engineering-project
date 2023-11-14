package com.example.loginguestsignuppage;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Perform validation or authentication logic here
        if (isValidUser(username, password)) {
            response.sendRedirect("Welcome.jsp"); // Redirect to the welcome page on successful login
        } else {
            response.sendRedirect("Login.jsp"); // Redirect back to the login page if authentication fails
        }
    }

    private boolean isValidUser(String username, String password) {
        // Add your own logic to validate the user credentials from the database or any other data source
        // For the sake of example, we are using simple hardcoded values
        return username.equals("validUsername") && password.equals("validPassword");
    }
}
