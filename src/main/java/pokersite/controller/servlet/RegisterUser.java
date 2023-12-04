// SPDX-License-Identifier: MIT
package pokersite.controller.servlet;

import java.io.*;
import pokersite.controller.service.UserService;
import pokersite.model.entity.User;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "registerUser", value = "/registerUser")
public class RegisterUser extends HttpServlet {
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve user info from sign up form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String phone_number = request.getParameter("phone_number");

        // Create a new user
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setFirst_name(first_name);
        newUser.setLast_name(last_name);
        newUser.setPhone_number(phone_number);
        newUser.setPermission(0);
        UserService.registerUser(newUser);

        /*
        // Log the user into their account and redirect back to Sign In Page (if successful)
        User logged = UserService.registerUser(newUser);

        if(logged!=null) {
            HttpSession session = request.getSession();
            session.setAttribute("User", newUser);
            response.sendRedirect("SignInPage.jsp");
        } else {
            // If the log in fails, user will be redirected to main page
            response.sendRedirect("index.jsp");
        }
         */
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request,response);
    }
}