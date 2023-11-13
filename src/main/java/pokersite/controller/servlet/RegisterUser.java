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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String phone_number = request.getParameter("phone_number");

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setFirst_name(first_name);
        newUser.setLast_name(last_name);
        newUser.setPhone_number(phone_number);
        UserService.registerUser(newUser);

        response.sendRedirect("index.jsp");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request,response);
    }
}