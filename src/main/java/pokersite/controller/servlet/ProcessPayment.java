package pokersite.controller.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ProcessPayment")
public class ProcessPayment extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String cardNumber = request.getParameter("cardNumber");
        String expirationDate = request.getParameter("expirationDate");
        String cvv = request.getParameter("cvv");

        if (cardNumber == null || expirationDate == null || cvv == null ||
                cardNumber.isEmpty() || expirationDate.isEmpty() || cvv.isEmpty()) {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("Invalid credit card information. Please provide all required details.");
                return;
            }
        }

        // For demonstration purposes, let's assume the payment is successful.
        boolean paymentSuccessful = true;

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (paymentSuccessful) {
                out.println("Payment successful! Thank you for your purchase.");
            } else {
                out.println("Payment failed. Please check your credit card information and try again.");
            }
        }
    }
}

