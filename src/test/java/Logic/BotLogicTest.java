package Logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pokersite.Logic.fivedraw.PlayerLogic;

public class BotLogicTest {
    @Test
    public void createPlayerTest(){
        PlayerLogic player = new PlayerLogic();
        assertEquals(player.getHand().size(), 0);
    }

    @Test
    public void addCardTest(){
        PlayerLogic player = new PlayerLogic();
        player.addCard("two_of_spades");
        assertEquals(player.getHand().size(), 1);
    }

    @Test
    public void maxCardTest(){
        PlayerLogic player = new PlayerLogic();
        player.addCard("two_of_spades");
        player.addCard("three_of_spades");
        player.addCard("four_of_spades");
        player.addCard("five_of_spades");
        player.addCard("six_of_spades");
        player.addCard("seven_of_spades");
        assertEquals(player.getHand().size(), 5);
    }

    @Test
    public void innitCoinTest(){
        PlayerLogic player = new PlayerLogic();
        assertEquals(player.getCoins(), 100);
    }

    @Test
    public void makeBetTest(){
        PlayerLogic player = new PlayerLogic();
        player.setBetAmount(10);
        assertEquals(player.getBetAmount(), 10);
    }

    @Test
    public void minBetTest(){
        PlayerLogic player = new PlayerLogic();
        player.setBetAmount(2);
        assertEquals(player.getBetAmount(), 0);
    }

    @Test
    public void maxBetAmount(){
        PlayerLogic player = new PlayerLogic();
        player.setBetAmount(120);
        assertEquals(player.getBetAmount(), 0);
    }
}
