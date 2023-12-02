package pokersite.controller.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pokersite.controller.service.UserService;
import pokersite.model.entity.Friendship;
import pokersite.model.entity.Message;
import pokersite.model.entity.User;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

@WebServlet(name = "sendMessage", value = "/sendMessage")
public class SendMessage extends HttpServlet {
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User us = (User) session.getAttribute("User");
        User userToSendMessage = UserService.findUserByUserID(Integer.valueOf(request.getParameter("friend")));
        String message = request.getParameter("message");
        Message ms = new Message();
        ms.setId_user_sender(us.getID());
        ms.setId_user_receiver(userToSendMessage.getID());
        ms.setMessage(message);
        ms.setDt_sent(Timestamp.from(Instant.now()));
        UserService.sendMessage(ms);
        response.sendRedirect("testPage.jsp");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }
}
