package pokersite.controller.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SaveCreditCardServlet")
public class SaveCreditCardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String cardNumber = request.getParameter("cardNumber");
        String expirationDate = request.getParameter("expirationDate");
        String cvv = request.getParameter("cvv");


        // Save credit card information to the database
        saveCreditCardToDatabase(cardNumber, expirationDate, cvv);

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("Credit card information saved successfully!");
    }

    private void saveCreditCardToDatabase(String cardNumber, String expirationDate, String cvv) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/credit_card";
        String dbUser = "amsmith-bradleu@loyola.edu";
        String dbPassword = "Fefe2132$";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
                String sql = "INSERT INTO credit_card (credit_card_num, expiration_date, cvv) VALUES (?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, cardNumber);
                    statement.setString(2, expirationDate);
                    statement.setString(3, cvv);
                    statement.executeUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle database errors
        }
    }
}

