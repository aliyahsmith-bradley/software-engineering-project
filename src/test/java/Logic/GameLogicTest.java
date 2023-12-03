package Logic;

import org.junit.jupiter.api.Test;
import pokersite.Logic.fivedraw.GameLogicSinglePlayer;

import static org.junit.jupiter.api.Assertions.*;
public class GameLogicTest {

    @Test
    public void getMaxNumPlayers(){
        GameLogicSinglePlayer game = new GameLogicSinglePlayer();
        game.initializeGame();
        assertEquals(game.getMaxNumPlayers(), 6);
    }

    @Test
    public void getMinNumPlayers(){
        GameLogicSinglePlayer game = new GameLogicSinglePlayer();
        game.initializeGame();
        assertEquals(game.getMinNumPlayers(), 2);
    }

    @Test
    public void dealTableTest(){
        GameLogicSinglePlayer game = new GameLogicSinglePlayer();
        game.initializeGame();
        assertEquals(game.getPlayers().size(), 2);
    }

    @Test
    public void userHandSizeTest(){
        GameLogicSinglePlayer game = new GameLogicSinglePlayer();
        game.initializeGame();
        assertEquals(game.getUserHand().size(), game.getHandSize());
    }

    @Test
    public void compHandSize(){
        GameLogicSinglePlayer game = new GameLogicSinglePlayer();
        game.initializeGame();
        assertEquals(game.getComputerHand().size(), game.getHandSize());
    }
}
