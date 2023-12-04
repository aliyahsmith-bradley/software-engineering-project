package pokersite.controller.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pokersite.controller.service.UserService;
import pokersite.model.entity.BadWord;

import java.io.IOException;

@WebServlet(name = "banWord", value = "/banWord")
public class BanWord extends HttpServlet {
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String badword = request.getParameter("word");
        BadWord wordToBan = new BadWord();
        wordToBan.setBadword(badword);
        UserService.banWord(wordToBan);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        processRequest(request,response);
    }
}
