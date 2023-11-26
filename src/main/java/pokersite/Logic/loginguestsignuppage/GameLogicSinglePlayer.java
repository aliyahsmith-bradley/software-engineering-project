package pokersite.Logic.loginguestsignuppage;

import java.util.*;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class GameLogicSinglePlayer {

    private static final int INITIAL_COINS = 100;
    private static final int HAND_SIZE = 5;
    private static final List<String> cardDeck = new ArrayList<>();
    private static List<String> deck = new ArrayList<>();
    private static List<String> userHand = new ArrayList<>();
    private static List<String> computerHand = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int userCoins = 0;
    private static int computerCoins = 0;
    private static int betAmount = 0;
    private static int pot = 0;
    private static int userBet1 = 0;
    private static boolean computerChecked = false;

    static {
        String[] suits = new String[]{"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cardDeck.add(rank + "_of_" + suit);
            }
        }
    }

    public static void main(String[] args) {


        GameLogicSinglePlayer game = new GameLogicSinglePlayer();

        // Initialize the game
        game.initializeGame();

        // Display initial game state
        System.out.println("Welcome to Single Player Poker!");
        game.displayUserCoins();
        game.displayPotAmount();

        // Start the game loop
        while (true) {
            // User's turn
            game.usersFirstTurn();

            // Check if the game should continue (based on user input)
            System.out.println("Do you want to play another round? (yes/no)");
            String playAgain = scanner.nextLine();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;  // Exit the game loop if the user doesn't want to play again
            }

            // Reset game state for the next round
            game.initializeGame();
        }

        //close the scanner
        scanner.close();

        // Display farewell message
        System.out.println("Thanks for playing! Goodbye!");
    }

    public static void initializeGame() {
        deck = new ArrayList<>(cardDeck);
        Collections.shuffle(deck);
        userHand = dealHand();
        computerHand = dealHand();
        userCoins = INITIAL_COINS;
        computerCoins = INITIAL_COINS;
        pot = 0;
        betAmount = 0;
    }

    public static List<String> dealHand() {
        List<String> hand = new ArrayList<>();

        for (int i = 0; i < HAND_SIZE; i++) {
            hand.add(deck.get(i));
        }
        removeCardsFromDeck(hand);
        return hand;
    }

    public static void removeCardsFromDeck(List<String> cardsToRemove) {
        deck.removeAll(cardsToRemove);
    }

    public static void displayUserHand() {
        System.out.println("Your Hand: ");
        for (int i = 0; i < userHand.size(); i++) {
            System.out.println(i + ": " + userHand.get(i));
        }
    }

    public static void displayUserCoins() {
        System.out.println("User Coins: " + userCoins);
    }

    public static void displayPotAmount() {
        System.out.println("Pot Amount: " + pot);
    }

    public static void displayBetAmount() {
        System.out.println("Bet Amount " + betAmount);
    }

    public static int getUserCoins() {
        return userCoins;
    }

    public static int getComputerCoins() {
        return computerCoins;
    }

    public static int getPotAmount() {
        return pot;
    }

    public static int getCurrentBetAmount() {
        return betAmount;
    }

    private static int getUserBet() {
        while (true) {
            try {
                int userBet1 = scanner.nextInt();
                if (userBet1 > userCoins) {
                    System.out.println("You don't have that many coins. Please enter a valid bet amount. You have: " + userCoins + " coins");
                } else {
                    return userBet1;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for the bet amount.");
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        }
    }


    public void usersFirstTurn() {
        displayUserHand();

        System.out.print("Hello User and welcome to Five Card Draw! Since this is the start of the game, everyone must" +
                "put in $10 into the pot");
        userCoins -= 10;
        computerCoins -= 10;
        pot = 20;

        displayUserCoins();
        displayPotAmount();

        System.out.println("Would you like to check or bet?");
        String userChoice1 = scanner.nextLine();

        while (!userChoice1.equalsIgnoreCase("check") && !userChoice1.equalsIgnoreCase("bet")) {
            System.out.println("Invalid choice. Please enter either 'check' or 'bet");
            userChoice1 = scanner.nextLine();
        }

        if (userChoice1.equals("check")) {
            System.out.print("Ok, you bet nothing, moving on to computer.");
            int userBet1 = 0;
            computersTurn(userBet1);
        }

        if (userChoice1.equals("bet")) {
            System.out.println("How much would you like to bet?");
            userBet1 = getUserBet();
            betAmount += userBet1;
            pot += userBet1;
            userCoins -= userBet1;
            displayPotAmount();
            displayUserCoins();
            computersTurn(userBet1);
        }
    }

    public static Boolean computersTurn(int userBet1) {
        int computerBet = 0;
        boolean computerChecked = false;

        // if the user checked, the computer will also check
        if (userBet1 == 0) {
            System.out.println("Computer Checked");
            userNewCards();
            computerChecked = true;
        }

        // if the userbet1 was not too big but not too small, computer will call
        else if (userBet1 >= 20 && userBet1 <= 30) {
            computerBet = userBet1;
            pot += computerBet;
            computerCoins -= computerBet;
            System.out.println("Computer matched your bet of " + userBet1);
            displayPotAmount();
            userNewCards();
            computerChecked = false;

        }
        //if the userbet1 is too small, lets raise it
        else if (userBet1 >= 1 && userBet1 < 20) {
            int difference = 0;
            computerBet = userBet1 + 5;
            pot += computerBet;
            computerCoins -= computerBet;
            System.out.println("Computer raised your bet of " + userBet1 + " with " + computerBet);
            betAmount += computerBet;
            System.out.println("User, you must add the different of computers bet and your bet and add it to the pot");
            difference = computerBet - userBet1;
            computerCoins -= difference;
            pot += difference;
            displayPotAmount();
            userNewCards();
            computerChecked = false;

        } else {
            System.out.println("Computer Folds, your turn");
            userNewCards();
            computerChecked = false;
        }
        return  computerChecked;
    }

    /*
        Purpose: To see if the user wants new cards or not
     */
    public static void userNewCards() {
        displayUserHand();

        System.out.println("Do you want to exchange cards? (yes/no)");
        String exchangeChoice = scanner.nextLine();

        if (exchangeChoice.equalsIgnoreCase("yes")) {
            exchangeUserCards();
        }

        computerNewCards();
    }

    /*
        Purpose: before the next round, the user has the option to get new cards
     */
    public static void exchangeUserCards(){

        displayUserHand();

        //checks to see if the user has a ace
        boolean hasAce = userHand.stream().anyMatch(card -> card.contains("Ace"));

        // Determine the maximum number of cards to exchange based on the presence of Ace
        int maxCardsToExchange = hasAce ? 4 : 3;

        System.out.println("Enter the indices (starting at 0) of the cards you want to replace (comma-separated, up" +
                "to " +maxCardsToExchange + ")");
        String input = scanner.nextLine();
        String[] indicesStr = input.split(",");
        List<Integer> indices = new ArrayList<>();

        for (String indexStr : indicesStr) {
            try {
                int index = Integer.parseInt(indexStr.trim());
                if (index >= 0 && index < HAND_SIZE) {
                    indices.add(index);
                } else {
                    System.out.println("Invalid index: " + index);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + indexStr);
            }
        }

        // Check if the number of selected cards is within the allowed range
        if (indices.size() > maxCardsToExchange) {
            System.out.println("You can only exchange up to " + maxCardsToExchange + " cards.");
            return;
        }

        // Replace selected cards
        for (int index : indices) {
            userHand.set(index, deck.remove(0));
        }

        // Display new hand
        displayUserHand();
        computerNewCards();
    }

    /*
        Purpose is to swap out Computer Cards the same way as user
     */
    public static void computerNewCards(){
        System.out.println("Computer is exchanging cards...");

        // Determine the number of cards the computer can exchange
        int maxCardsToExchange = (computerHand.contains("Ace")) ? 4 : 3;

        // Generate a list of random indices to exchange
        List<Integer> indicesToExchange = generateRandomIndices(maxCardsToExchange);

        // Exchange cards
        for (int index : indicesToExchange) {
            String removedCard = computerHand.remove(index);
            deck.add(removedCard);
        }

        // Deal new cards to the computer
        computerHand.addAll(dealHand());

        System.out.println("Computer has exchanged cards.");
        userRounds();
    }

    /*
        Purpose: Generates a random number for computer for its cards
     */
    private static List<Integer> generateRandomIndices(int count) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int randomIndex = new Random().nextInt(computerHand.size());
            indices.add(randomIndex);
        }
        return indices;
    }

    /*
        Purpose: to do one more round for the player
     */
    public static void userRounds(){

        displayUserHand();

        System.out.println("This is the final round, User would you like to check, call, raise or fold?");
        String userChoice = scanner.nextLine();

        while (!userChoice.equalsIgnoreCase("check") && !userChoice.equalsIgnoreCase("call") &&
                !userChoice.equalsIgnoreCase("raise") && !userChoice.equalsIgnoreCase("fold")) {
            System.out.println("Invalid choice. Please enter either 'check', 'call', 'raise', 'fold'");
            userChoice = scanner.nextLine();
        }

        String userChoice2 = "";
        String userChoice3 = "";

        if(userChoice.equalsIgnoreCase("check")){
            if (computerChecked) {
                System.out.println("You checked");
                computersTurn2();

            } else {
                System.out.println("Computer didn't check. You must do something else.");

                //ask them if they want to raise, call or fold
                System.out.println("Do you want to raise, call, or fold?");
                userChoice2 = scanner.nextLine();
                while (!userChoice2.equalsIgnoreCase("raise") && !userChoice2.equalsIgnoreCase("call") &&
                        !userChoice2.equalsIgnoreCase("fold")) {
                    System.out.println("Invalid choice. Please enter either 'raise', 'call', or 'fold'");
                    userChoice2 = scanner.nextLine();
                    computersTurn2();
                }

            }
        } else if (userChoice.equalsIgnoreCase("call") || userChoice2.equalsIgnoreCase("call")){
            System.out.println("You must match the bet of: " + betAmount + "this is your current coin balance " + userCoins);
            System.out.println("Would you like to match the bet? (y/n)");
            String choice = scanner.nextLine();

            while(!choice.equalsIgnoreCase("y") || !choice.equalsIgnoreCase("n")){
                System.out.println("Please enter y (for yes) or n (for n)");
                choice = scanner.nextLine();
            }

            if(choice.equalsIgnoreCase("y")){
                userCoins -= betAmount;
                pot += betAmount;
                betAmount += betAmount;

                displayPotAmount();
                displayUserCoins();
                displayBetAmount();
                computersTurn2();
            }
            else{
                System.out.print("You entered no, pick a new choice (raise or fold)");
                userChoice3= scanner.nextLine();
                while(!userChoice3.equalsIgnoreCase("raise") || !userChoice3.equalsIgnoreCase("fold")){
                    System.out.println("Please enter raise or fold");
                    userChoice3 = scanner.nextLine();
                }

                computersTurn2();
            }


        } else if (userChoice.equalsIgnoreCase("raise") || userChoice2.equalsIgnoreCase("raise") ||
                userChoice3.equalsIgnoreCase("raise")) {

            displayUserCoins();
            displayBetAmount();

            System.out.println("What would you like to bet? ");
            int finalBet = getUserBet();

            if (finalBet <= betAmount || finalBet > userCoins) {
                System.out.println("Your raise has to be bigger than the bet amount, or you bet too much");
                finalBet = getUserBet();

            } else {
                betAmount += finalBet;
                pot += finalBet;
                userCoins -= finalBet;
                computersTurn2();
            }
        }
        else {
            System.out.print("You folded, going to computers turn");
            computersTurn2();
        }

    }


    public static void computersTurn2() {
        int computerBet = 0;

        // if betAmount is still 0, that means everyone checked
        if (getCurrentBetAmount() == 0) {
            System.out.println("Computer Checked");


            //go to winner Function
        }

        // if the user choice is call was not too big but not too small, computer will call
        else if (getCurrentBetAmount()>= 20 && getCurrentBetAmount() <= 30) {
            computerBet = betAmount;
            pot += computerBet;
            computerCoins -= computerBet;
            System.out.println("Computer matched the bet of " + getCurrentBetAmount());
            displayPotAmount();

            //go to winners function

        }
        //if the userchoice is raise
        else if (getCurrentBetAmount() >= 1 && getCurrentBetAmount() < 20) {
            int difference = 0;
            computerBet = betAmount + 5;
            pot += computerBet;
            computerCoins -= computerBet;
            System.out.println("Computer raised the bet of " + getCurrentBetAmount() + " with " + computerBet);
            betAmount += computerBet;
            System.out.println("User, you must add the different of computers bet and your bet and add it to the pot");
            difference = computerBet - betAmount;
            computerCoins -= difference;
            pot += difference;
            displayPotAmount();


            // go to winners function


        } else { //if user choice is fold
            System.out.println("Computer Folds, your turn");


            //go to winners function

        }

    }

    /*
        Purpose: to see who has the highest hand and wins
     */
    public static void winner(){

    }

}





    //COMPLICATED. Logic below, ignore for now
    //-----------------------------------------------------------------------------------------------------------------------------------
/*
    private static List<String> shuffleCards(List<String> deck, List<String> userHand) {
        List<String> newCards = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (deck.isEmpty()) {
                break;
            }
            String drawnCard = deck.remove(0);
            newCards.add(drawnCard);
        }
        return newCards;
    }

    private static List<String> replaceCards(List<String> userHand, List<String> deck, Scanner scanner, boolean hasAce) {
        System.out.println("Your current hand: " + userHand);
        System.out.println("Which cards would you like to discard? Please enter the indices (starting from 0) separated by spaces:");

        String[] indices = scanner.nextLine().split(" ");
        List<String> newCards = new ArrayList<>();
        int maxReplacements = hasAce ? 4 : 3;
        for (String index : indices) {
            int i = Integer.parseInt(index);
            if (i >= 0 && i < userHand.size() && newCards.size() < maxReplacements) {
                userHand.remove(i);
                userHand.add(i, deck.get(0));
                deck.remove(0);
            }
        }

        return userHand;
    }


    private static void userRound2(List<String> userHand, List<String> deck){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to get new cards? (yes or no)");
        String askNewCards = scanner.nextLine();

        while (!askNewCards.equalsIgnoreCase("yes") && !askNewCards.equalsIgnoreCase("no")){
            System.out.println("Invalid choice.Please enter either 'yes' or 'no'.");
            askNewCards = scanner.nextLine();
        }

        boolean hasAce = false;
        for (String card : userHand) {
            if (card.startsWith("Ace")) {
                hasAce = true;
                break;
            }
        }
        if(askNewCards.equals("yes") && !hasAce) {//user does not have a ace of any suit)
            List<String> updatedHand = replaceCards(userHand, deck, scanner, hasAce);
            System.out.println("Your new hand is: " + updatedHand);

        }
        if(askNewCards.equals("yes") && hasAce) {//user does not have a ace of any suit)
            List<String> updatedHand = replaceCards(userHand, deck, scanner, hasAce);
            System.out.println("Your new hand is: " + updatedHand);

        }

    }


    class BetResult {
        int computerBet;
        int updatedPot;

        public BetResult(int computerBet, int updatedPot) {
            this.computerBet = computerBet;
            this.updatedPot = updatedPot;
        }
    }

    private static void computersTurnRound1(List<String> computerHand, List<String> userHand, List<String> deck, int userBet1,String userChoice1, int computerCoins){
        GameLogicSinglePlayer game = new GameLogicSinglePlayer();

        if(decideComputerAction(computerHand, userChoice1, computerCoins).equals("check")){
            userRound2(userHand, deck);
        }else if(decideComputerAction(computerHand, userChoice1, computerCoins).equals("fold")) {
            userRound2(userHand, deck);

        }else if(decideComputerAction(computerHand, userChoice1, computerCoins).equals("call")) {
            // did a bet and return the bet the computer did and the new pot amount
            BetResult result = game.decideComputerBet(userBet1,computerCoins, decideComputerAction(computerHand, userChoice1, computerCoins));
            int computerBet = result.computerBet;
            int updatedPot = result.updatedPot;
            System.out.println("Computer did a bet of " + computerBet);
            System.out.println("The new pot amount is " + updatedPot);
            System.out.println("Your Turn User");
            userRound2(userHand, deck);
        }else{
            BetResult result = game.decideComputerBet(userBet1, computerCoins, decideComputerAction(computerHand, userChoice1, computerCoins));
            int computerBet = result.computerBet;
            int updatedPot = result.updatedPot;
            System.out.println("Computer did a call of " + computerBet);
            System.out.println("The new pot amount is " + updatedPot);
            System.out.println("Your Turn User");
            userRound2(userHand, deck);

        }
    }
    private BetResult decideComputerBet(int userBet1, int computerCoins, String decideComputerAction) {

        if(decideComputerAction.equals("raise")){
            int computerBet = 0;
            computerBet = userBet1 + 10;
            pot = computerBet + userBet1;
            return new BetResult(computerBet, pot);
        }else if(decideComputerAction.equals("call")){
            int computerBet = 0;
            if(userBet1 > 0) {
                computerCoins = computerCoins - userBet1;
                pot = userBet1 + userBet1;
                return new BetResult(computerBet, pot);
            }
            pot = computerBet + userBet1;
            return new BetResult(computerBet, pot);

        }

        return new BetResult(0, 0); // Placeholder value
    }

    private static String decideComputerAction(List<String> computerHand, String userChoice1, int computerCoins) {

        //if it is a good hand, they should raise
        if (hasPair(computerHand) || hasThreeToFlush(computerHand) || hasThreeToFlush(computerHand)) {
            return "raise";

            //if its a ok hand, just call
        } else if (computerCoins > 0 && userChoice1.equals("bet")){
            return "call";

            //if you can check and its a mid hand, check
        }else if(userChoice1.equals("check") && !(hasPair(computerHand) || hasThreeToFlush(computerHand) || hasThreeToFlush(computerHand)))
        {
            return "check";

            //bad hand, dont do nothing
        } else {
            return "fold";
        }


    }


        private static boolean hasPair (List < String > computerHand) {
            Set<String> uniqueRanks = new HashSet<>();
            for (String card : computerHand) {
                String rank = card.split(" ")[0];
                if (!uniqueRanks.add(rank)) {
                    return true;
                }
            }
            return false;
        }

        private static boolean hasThreeToStraight (List < String > computerHand) {
            List<String> ranks = new ArrayList<>();
            for (String card : computerHand) {
                String rank = card.split(" ")[0];
                ranks.add(rank);
            }
            Collections.sort(ranks);
            int count = 1;
            for (int i = 0; i < ranks.size() - 1; i++) {
                if (ranks.get(i + 1).equals(ranks.get(i))) {
                    continue;
                }
                if (ranks.indexOf(ranks.get(i)) + 2 < ranks.indexOf(ranks.get(i + 1))) {
                    count = 1;
                } else {
                    count++;
                }
                if (count == 3) {
                    return true;
                }
            }
            return false;
        }

        (List < String > computerHand) {
            Map<String, Integer> suitsCount = new HashMap<>();
            for (String card : computerHand) {
                String suit = card.split(" ")[2];
                suitsCount.put(suit, suitsCount.getOrDefault(suit, 0) + 1);
                if (suitsCount.get(suit) >= 3) {
                    return true;
                }
            }
            return false;
        }
    */


