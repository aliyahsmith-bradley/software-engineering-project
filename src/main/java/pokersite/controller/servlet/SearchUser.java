package pokersite.controller.servlet;

import java.io.*;
import java.util.List;
import jakarta.servlet.ServletException;
import pokersite.controller.service.UserService;
import pokersite.model.entity.User;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.servlet.RequestDispatcher;

@WebServlet(name = "searchUser", value = "/searchUser")
public class SearchUser extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        List<User> users = UserService.findByUserName(username);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(users);

        RequestDispatcher dispatcher = request.getRequestDispatcher("addFriends.jsp");
        request.setAttribute("jsonData", json);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
    public void destory() {
    }
}