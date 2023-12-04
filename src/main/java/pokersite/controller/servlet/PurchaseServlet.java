package pokersite.controller.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final Map<String, Double> featurePurchaseAmounts = new HashMap<>();

    static{
        featurePurchaseAmounts.put("bucket of coins", 30.0);
        featurePurchaseAmounts.put("cup of coins", 10.0);
        featurePurchaseAmounts.put("three coins", 5.0);
        featurePurchaseAmounts.put("sounds", 8.0);
        featurePurchaseAmounts.put("backgrounds", 10.0);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String feature = request.getParameter("feature");

        Double currentBalance = (Double) request.getSession().getAttribute("balance");
        if(currentBalance == null){
            currentBalance = 0.0;
        }

        Double purchaseAmount = featurePurchaseAmounts.get(feature);
        if(purchaseAmount == null){
            purchaseAmount = 10.0;
        }

        currentBalance -= purchaseAmount;
        request.getSession().setAttribute("balance", currentBalance);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Purchase Result</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>You have purchased more " + feature + ".</h1>");
            out.println("<p>Your new balance is $" + currentBalance + "</p>");
            out.println("</body>");
            out.println("</html");
        }
    }
}
