package pokersite.controller.servlet;

import java.io.*;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pokersite.controller.service.UserService;
import pokersite.model.entity.Issue;
import pokersite.model.entity.User;


@WebServlet(name = "getIssues", value = "/getIssues")
public class GetIssues extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User us = (User) session.getAttribute("User");

        List<Issue> issues = UserService.getIssues();

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(issues);

        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}