// SPDX-License-Identifier: MIT
package edu.loyola.cs.se.website.controller.servlet;

import java.io.*;

import edu.loyola.cs.se.website.controller.service.UserService;
import edu.loyola.cs.se.website.model.entity.User;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "registerUser", value = "/registerUser")
public class RegisterUser extends HttpServlet {

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //TODO: Adapt this code to Create User from the Admin Interface
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User newUser = new User();
        // There is no Name in User Entity (small BUG on purpose)
        newUser.setUsername(username);
        newUser.setPassword(password);
        UserService.registerUser(newUser);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request,response);
    }

}