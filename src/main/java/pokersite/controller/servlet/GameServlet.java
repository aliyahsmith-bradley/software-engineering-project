package pokersite.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pokersite.Logic.fivedraw.GameLogicSinglePlayer;

import java.io.IOException;


@WebServlet("/game")
public class GameServlet extends HttpServlet {
    // Initialize userCoins directly in the servlet
    private static int userCoins = 100;  // Set the initial value here

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Servlet initialized!");
        // You can perform additional initialization here if needed
    }

    private GameLogicSinglePlayer gameLogic = new GameLogicSinglePlayer();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Handling GET request for /game");

        gameLogic.initializeGame();


        // Retrieve userCoins value from GameLogicSinglePlayer class
        //int userCoins = GameLogicSinglePlayer.getUserCoins();

        // Set userCoins as an attribute in the request
        request.setAttribute("userCoins", userCoins);

        // Forward the request to the JSP page for rendering
        request.getRequestDispatcher("/SinglePlayerGame.jsp").forward(request, response);
    }

    public static class AdBean {
        private String adContent;

        public String getAdContent() {
            return adContent;
        }

        public void setAdContent(String adContent) {
            this.adContent = adContent;
        }
    }
}







