package pokersite.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "adServlet", value = "/addServlet")
public class AdServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Specify the ad images filenames
        String[] adImageNames = {
                "Christmas_ad.png",
                "New_game.png"
        };

        // Pick a random image filename
        int randomIndex = (int) (Math.random() * adImageNames.length);
        String adImageName = adImageNames[randomIndex];

        // Construct the relative path to the image
        String relativeImagePath = "images/" + adImageName;

        // Set the image path in the request attribute
        request.setAttribute("adContent", relativeImagePath);

        // Forward to the JSP page
        request.getRequestDispatcher("/ad.jsp").forward(request, response);
    }
}