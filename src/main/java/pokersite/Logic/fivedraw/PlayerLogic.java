package pokersite.Logic.fivedraw;

import java.math.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerLogic {
    static final int INITIAL_COINS = 100;
    static final int MAX_HAND_SIZE = 5;
    static final int MIN_BET_AMOUNT = 0;
    ArrayList<String> hand = new ArrayList<String>();

    int coins = INITIAL_COINS;

    Boolean hasBet = false;

    int betAmount = 0;


    public void addCard(String card){
        if (hand.size() + 1 <= MAX_HAND_SIZE){
            this.hand.add(card);
        }
    }

    public void setHasBet(Boolean val){
        this.hasBet = val;
    }

    public void setCoins(int coins) {
        if (coins > 0){
            this.coins = coins;
        }
    }

    public void addCoins(int coins){
        coins = Math.abs(coins);
        this.coins += coins;
    }

    public int subCoins(int coins){
        coins = -1 * Math.abs(coins);
        if (this.coins + coins >=0){
            this.coins -= coins;
            return 1;
        }
        return 0;
    }

    public void setBetAmount(int betAmount) {
        if (betAmount > MIN_BET_AMOUNT && betAmount < coins){
            this.betAmount = betAmount;
        }
    }

    public void setHand(String card1, String card2, String card3, String card4, String card5){
        addCard(card1);
        addCard(card2);
        addCard(card3);
        addCard(card4);
        addCard(card5);
    }

    public void setHand(List<String> cards){
        for(int i = 0; i <= cards.size(); i++){
            if (hand.size() < MAX_HAND_SIZE){
                hand.add(cards.get(i));
            }
        }
    }

    public ArrayList<String> getHand(){
        return hand;
    }

    public Boolean getHasBet(){
        return hasBet;
    }

    public int getBetAmount() {
        return betAmount;
    }

    public int getCoins(){
        return coins;
    }

    public static int getInitialCoins() {
        return INITIAL_COINS;
    }

    public static int getMaxHandSize() {
        return MAX_HAND_SIZE;
    }

    public static int getMinBetAmount() {
        return MIN_BET_AMOUNT;
    }

    public Integer validateBet(Integer bet){
        if (bet > coins) {
            System.out.println("You don't have that many coins. Please enter a valid bet amount. You have: " + coins + " coins");
        } else {
            return 1;
        }
        return 0;
    }

    public int bet(int betAmount){
        if (validateBet(betAmount) == 1){
            // then bet away!
            setBetAmount(betAmount);
            subCoins(betAmount);
            setHasBet(true);
            return 1;
        }
        return 0;
    }

}
