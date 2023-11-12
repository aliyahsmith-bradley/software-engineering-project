package pokersite.controller.servlet;

import java.io.*;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import pokersite.controller.service.UserService;
import pokersite.model.entity.Friend_Request;
import pokersite.model.entity.User;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "searchFriendRequest", value = "/searchFriendRequest")
public class SearchFriendRequest extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");

        List<Friend_Request> friendRequests = UserService.findFriendRequests(user);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(friendRequests);

        RequestDispatcher dispatcher = request.getRequestDispatcher("friendRequests.jsp");
        request.setAttribute("jsonData", json);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}