package Logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pokersite.Logic.fivedraw.PlayerLogic;

public class PlayerLogicTest {

    //Player Logic
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
    public void setHandTest(){
        PlayerLogic player = new PlayerLogic();
        player.setHand("two_of_spades", "three_of_spades", "four_of_spades", "five_of_spades", "six_of_spades");
        assertEquals(player.getHand().size(), 5);
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

    @Test
    public void defaultHasBetTest(){
        PlayerLogic player = new PlayerLogic();
        assertEquals(player.getHasBet(), false);
    }
    @Test
    public void setHasBetTest(){
        PlayerLogic player = new PlayerLogic();
        player.setHasBet(true);
        assertEquals(player.getHasBet(), true);
    }

    @Test
    public void setCoinsTest(){
        PlayerLogic player = new PlayerLogic();
        player.setCoins(40);
        assertEquals(player.getCoins(), 40);
    }

    @Test
    public void minSetCoinTest(){
        PlayerLogic player = new PlayerLogic();
        player.setCoins(-20);
        assertEquals(player.getCoins(), 100);
    }

    @Test
    public void addCoinsTest(){
        PlayerLogic player = new PlayerLogic();
        player.addCoins(20);
        assertEquals(player.getCoins(), 120);
    }

    @Test
    public void minAddCoinsTest(){
        PlayerLogic player = new PlayerLogic();
        player.addCoins(-120);
        assertEquals(player.getCoins(), 100);
    }


}
