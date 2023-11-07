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
        //TODO: Adapt this code to Create User from the Admin Interface
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String phone_number = request.getParameter("phone_number");

        User newUser = new User();
        // There is no Name in User Entity (small BUG on purpose)
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setFirst_name(first_name);
        newUser.setLast_name(last_name);
        newUser.setPhone_number(phone_number);
        UserService.registerUser(newUser);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request,response);
    }

}