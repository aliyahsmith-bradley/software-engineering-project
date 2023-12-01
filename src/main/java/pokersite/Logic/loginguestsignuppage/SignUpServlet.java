package pokersite.Logic.loginguestsignuppage;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import jakarta.servlet.annotation.*;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String firstName = request.getParameter("firstName");
        /* Should replace with this upon next iteration:
        User user = getUserFromDatabase(request.getParameter("username")); */

        String firstName = "Stella";
        request.setAttribute("firstName", firstName);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/UserProfile.jsp");
        dispatcher.forward(request, response);

        //request.getRequestDispatcher("/UserProfile.jsp").forward(request, response);

        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Add your database storage logic here

        // Redirect to a page after sign-up
        response.sendRedirect("/UserProfile.jsp");
    }
}