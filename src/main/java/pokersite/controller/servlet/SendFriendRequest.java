package pokersite.controller.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pokersite.controller.service.UserService;
import pokersite.model.entity.Friend_Request;
import pokersite.model.entity.User;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

@WebServlet(name = "sendFriendRequest", value = "/sendFriendRequest")
public class SendFriendRequest extends HttpServlet {
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User us = (User) session.getAttribute("User");
        User userToAdd = UserService.searchForUsersByUserName(request.getParameter("username")).get(0);
        Friend_Request fr = new Friend_Request();
        fr.setId_user_sender(us.getID());
        fr.setId_user_receiver(userToAdd.getID());
        fr.setStatus((byte) 0);
        fr.setDt_sent(Timestamp.from(Instant.now()));
        UserService.sendFriendRequest(fr);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request,response);
    }
}