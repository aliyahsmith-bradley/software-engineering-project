package pokersite.controller.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pokersite.controller.service.UserService;
import pokersite.model.entity.Friend_Request;
import pokersite.model.entity.Friendship;
import pokersite.model.entity.User;

import java.io.IOException;

@WebServlet(name = "removeFriend", value = "/removeFriend")
public class RemoveFriend extends HttpServlet {
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User us = (User) session.getAttribute("User");
        Integer fsID = Integer.valueOf(request.getParameter("friend"));

        Friendship fs = UserService.findFriendByFriendshipID(fsID);


        Friend_Request frToRemove = UserService.findFrByUserIDSenderAndUserIDReceiver(fs.getId_user1(), us.getID());
        frToRemove.setStatus((byte) 0);

        UserService.removeFriend(fs, frToRemove);



    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request,response);
    }
}
