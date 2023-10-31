
import main.java.FiveCardDrawGame;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;


public class FiveCardDrawGameTest {

    public static void main(String[] args) {
        testGame();
    }

    public static void testGame() {
        System.out.println("Running Five Card Draw Game test...");

        // Simulate a game with fixed inputs for testing purposes
        String input = "1 2 3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        FiveCardDrawGame.main(null);

        // Retrieve the hands and perform assertions based on expected results
        ArrayList<String> playerHand = FiveCardDrawGame.getPlayerHand();
        ArrayList<String> computerHand = FiveCardDrawGame.getComputerHand();

        // Perform assertions based on the game logic
        assert playerHand.size() == 5;
        assert computerHand.size() == 5;

        // Additional assertions can be added based on the specific game logic
        // For example, you can test whether the hands contain valid cards, etc.

        System.out.println("Five Card Draw Game test passed!");

    }
}
