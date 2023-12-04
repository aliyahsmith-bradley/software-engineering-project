package Logic;

import org.junit.jupiter.api.Test;
import pokersite.Logic.fivedraw.ComputerPlayerLogic;
import static org.junit.jupiter.api.Assertions.*;

public class BotLogicTest {
    @Test
    public void betZeroTest(){
        ComputerPlayerLogic player = new ComputerPlayerLogic();
        player.bet(0);
        assertEquals(player.getHasBet(), true);
    }

    @Test
    public void betOverTest(){
        ComputerPlayerLogic player = new ComputerPlayerLogic();
        player.bet(120);
        assertEquals(player.getHasBet(), false);
    }

    @Test
    public void betUnderTest(){
        ComputerPlayerLogic player = new ComputerPlayerLogic();
        player.bet(-20);
        assertEquals(player.getHasBet(), false);
    }

    @Test
    public void setBaseBetAmountTest(){
        ComputerPlayerLogic player = new ComputerPlayerLogic();
        player.setBaseBetAmount(20);
        assertEquals(player.getBaseBetAmount(),20);
    }

    @Test
    public void setCompName(){
        ComputerPlayerLogic player = new ComputerPlayerLogic();
        player.setCompName("John");
        assertEquals(player.getCompName(), "John");
    }

    @Test
    public void setCompType(){
        ComputerPlayerLogic player = new ComputerPlayerLogic();
        player.setCompType(2);
        assertEquals(player.getCompType(), 2);
    }

}
