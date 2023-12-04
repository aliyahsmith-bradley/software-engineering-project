package pokersite.controller.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DisplayBalanceServlet")
public class DisplayBalanceServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Retrieve the user's balance from the session
        Double balance = (Double) request.getSession().getAttribute("balance");
        if (balance == null) {
            balance = 0.0; // Default balance if not set yet
        }

        // Display the user's balance
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Display Balance</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Your Current Balance: $" + balance + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
