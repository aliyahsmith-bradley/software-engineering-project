package pokersite.Logic.fivedraw;

import java.util.ArrayList;

public class PlayerLogic {
    static final int INITIAL_COINS = 100;
    static final int MAX_HAND_SIZE = 5;
    static final int MIN_BET_AMOUNT = 5;
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
        this.coins = coins;
    }

    public void addCoins(int coins){
        this.coins += coins;
    }

    public void setBetAmount(int betAmount) {
        if (betAmount > MIN_BET_AMOUNT && betAmount < coins){
            this.betAmount = betAmount;
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

}
