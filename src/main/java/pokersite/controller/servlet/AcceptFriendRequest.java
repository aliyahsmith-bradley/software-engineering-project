
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
import java.sql.Timestamp;
import java.time.Instant;

@WebServlet(name = "acceptFriendRequest", value = "/acceptFriendRequest")
public class AcceptFriendRequest extends HttpServlet {
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User us = (User) session.getAttribute("User");
        User userToAdd = UserService.searchForUsersByUserName(request.getParameter("username")).get(0);

        Friendship fs = new Friendship();
        fs.setId_user1(userToAdd.getID());
        fs.setId_user2(us.getID());
        fs.setDt_accepted(Timestamp.from(Instant.now()));

        Friend_Request frToAccept = UserService.findFriendRequestByFrID(Integer.valueOf(request.getParameter("friendRequest")));
        frToAccept.setStatus((byte) 1);

        UserService.acceptFriendRequest(fs, frToAccept);


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request,response);
    }
}

