package pokersite.controller.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pokersite.model.entity.Issue;
import pokersite.controller.service.UserService;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

@WebServlet(name = "reportIssue", value = "/reportIssue")
public class ReportIssue extends HttpServlet {
    public void processRequest(HttpServletRequest request, HttpServletResponse respose) throws IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        Issue newIssue = new Issue();
        newIssue.setTitle(title);
        newIssue.setBody(description);
        newIssue.setDt_sent(Timestamp.from(Instant.now()));
        UserService.submitIssue(newIssue);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request,response);
    }
}
