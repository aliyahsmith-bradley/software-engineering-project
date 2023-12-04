package pokersite.controller.servlet;

import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pokersite.controller.service.UserService;
import pokersite.model.entity.User;


@WebServlet(name = "getUserNameByID", value = "/getUserNameByID")
public class GetUserNameByID extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        User user = UserService.findUserByUserID(id);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(user);

        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}