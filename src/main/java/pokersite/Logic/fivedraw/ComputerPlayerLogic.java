package pokersite.Logic.fivedraw;

public class ComputerPlayerLogic extends PlayerLogic {
    String compName = "Placeholder";
    int compType = 1;
    int baseBetAmount = 10;
    boolean checked = false;

    public void setBaseBetAmount(int baseBetAmount){
        this.baseBetAmount = baseBetAmount;
    }

    public int getBaseBetAmount() {
        return baseBetAmount;
    }

    public void setCompName(String compName){
        this.compName = compName;
    }

    public void setCompType(int compType){
        this.compType = compType;
    }

    public int getCompType() {
        return compType;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean getChecked(){
        return checked;
    }

    public int chooseBet(){

        return 1;
    }

    public int bet(int betAmount){
        int chooseBet = chooseBet();
        if (validateBet(betAmount) == 1){
            // then bet away!
            setBetAmount(betAmount);
            subCoins(betAmount);
            setHasBet(true);
            return 1;
        }
        return 0;
    }

    public int turn(int userBet1){
        int bet = 0;

        // if the user checked, the computer will also check
        if (userBet1 == 0) {
            System.out.println("Computer Bets");
            checked = true;
            bet += 5;
            bet(betAmount);
        }

        // if the userbet1 was not too big but not too small, computer will call
        else if (userBet1 >= 20 && userBet1 <= 30 && userBet1<= coins) {
            bet(userBet1);
            System.out.println("Computer matched your bet of " + userBet1);
            checked = false;
        }
        //if the userbet1 is too small, lets raise it
        else if (userBet1 >= 1 && userBet1 < 20) {
            int difference = 0;
            bet = userBet1 + 5;
            bet(bet);
            System.out.println("Computer raised your bet of " + userBet1 + " with " + bet);
            System.out.println("User, you must add the difference of computers bet and your past bet and add it to the pot");
            difference = bet - userBet1;
            checked = false;

        } else {
            System.out.println("Computer Folds, your turn");
            checked = false;
        }


        return 1;
    }

}
