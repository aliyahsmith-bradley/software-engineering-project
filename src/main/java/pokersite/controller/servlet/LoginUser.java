package pokersite.controller.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pokersite.controller.service.UserService;
import pokersite.model.entity.User;
import java.io.IOException;

@WebServlet(name = "loginUser", value = "/loginUser")
public class LoginUser extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User logged = UserService.loginUser(email, password);
        if(logged!=null){
            //Session is how we (safe) persist info from a specif user in a webapp
            HttpSession session = request.getSession();
            logged.setPassword(""); //For security lets scrub the password
            session.setAttribute("User",logged); //adding user to session
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("login.jsp?msg=1");
        }
    }

}
