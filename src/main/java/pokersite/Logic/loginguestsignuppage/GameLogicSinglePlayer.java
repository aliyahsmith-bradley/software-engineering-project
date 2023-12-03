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
    public static int userCoins = 0;
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
        System.out.println("Welcome to Single Player Five Card Draw!");
        game.displayUserCoins();
        game.displayPotAmount();


        game.usersFirstTurn();



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

    public static void displayComputerHand() {
            System.out.println("Computer Hand: ");
            for (int i = 0; i < computerHand.size(); i++) {
                System.out.println(i + ": " + computerHand.get(i));
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
                " put in $10 into the pot: ");
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
            System.out.println("Computer Bets");
            computerChecked = true;
            betAmount += 5;
            pot += 5;
            computerCoins -= 5;
            userNewCards();
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
            userNewCards();

        }
        //if the userbet1 is too small, lets raise it
        else if (userBet1 >= 1 && userBet1 < 20) {
            int difference = 0;
            computerBet = userBet1 + 5;
            pot += computerBet;
            computerCoins -= computerBet;
            System.out.println("Computer raised your bet of " + userBet1 + " with " + computerBet);
            betAmount += computerBet;
            System.out.println("User, you must add the difference of computers bet and your past bet and add it to the pot");
            difference = computerBet - userBet1;
            computerCoins -= difference;
            pot += difference;
            userCoins = userCoins -difference;
            displayPotAmount();
            displayUserCoins();
            userNewCards();
            computerChecked = false;
            userNewCards();

        } else {
            System.out.println("Computer Folds, your turn");
            userNewCards();
            computerChecked = false;
            userNewCards();
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

        while(!exchangeChoice.equalsIgnoreCase("yes") && !exchangeChoice.equalsIgnoreCase("no")){
            System.out.println("Please enter yes or no");
            exchangeChoice = scanner.nextLine();
        }

        if(exchangeChoice.equalsIgnoreCase("yes")){
            exchangeUserCards();
        }
        else{
            computerNewCards();
        }
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
    public static void computerNewCards() {
        System.out.println("Computer is exchanging cards...");

        // Determine the number of cards the computer can exchange
        int maxCardsToExchange = (computerHand.contains("Ace")) ? 4 : 3;

        // Generate a list of random indices to exchange
        List<Integer> indicesToExchange = generateRandomIndices(maxCardsToExchange);

        // Exchange cards
        for (int index : indicesToExchange) {
            if (index >= 0 && index < computerHand.size()) {
                String removedCard = computerHand.remove(index);
                deck.add(removedCard);
            } else {
                System.out.println("Invalid index: " + index);
            }
        }

        // Deal new cards to the computer to ensure it has only 5 cards
        computerHand = dealHand();

        System.out.println("Computer has exchanged cards.");

        // After exchanging cards, go to the userRounds function
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
    public static void userRounds() {
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

        if (userChoice.equalsIgnoreCase("check")) {
            if (computerChecked) {
                System.out.println("You checked");
                computersTurn2();
            } else {
                System.out.println("Computer didn't check. You must do something else.");

                // ask them if they want to raise, call or fold
                System.out.println("Do you want to raise, call, or fold?");
                userChoice2 = scanner.nextLine();
            }
        } else if (userChoice.equalsIgnoreCase("call")) {
            System.out.println("You must match the bet of: " + betAmount + " this is your current coin balance " + userCoins);
            System.out.println("Would you like to match the bet? (y/n)");
            String choice = scanner.nextLine();

            while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
                System.out.println("Please enter y (for yes) or n (for n)");
                choice = scanner.nextLine();
            }

            if (choice.equalsIgnoreCase("y")) {
                userCoins -= betAmount;
                pot += betAmount;
                betAmount += betAmount;

                displayPotAmount();
                displayUserCoins();
                displayBetAmount();
                computersTurn2();
                return; // Added to exit the method after calling computersTurn2()
            } else {
                System.out.print("You entered no, pick a new choice (raise or fold)");
                userChoice3 = scanner.nextLine();
            }
        } else if (userChoice.equalsIgnoreCase("raise")) {
            displayUserCoins();
            displayBetAmount();

            System.out.println("What would you like to bet? ");
            int finalBet = getUserBet();

            while (finalBet <= betAmount || finalBet > userCoins) {
                System.out.println("Your raise has to be bigger than the bet amount, or you bet too much");
                finalBet = getUserBet();
            }

            betAmount += finalBet;
            pot += finalBet;
            userCoins -= finalBet;
        } else {
            System.out.print("You folded, going to computers turn");
            computersTurn2();
            return; // Added to exit the method after calling computersTurn2()
        }

        // Call computersTurn2() outside the if-else block
        computersTurn2();
    }


    public static void computersTurn2() {
        int computerBet = 0;

        // if betAmount is still 0, that means everyone checked
        if (getCurrentBetAmount() == 0) {
            System.out.println("Computer Checked");


           winner();
        }

        // if the user choice is call was not too big but not too small, computer will call
        else if (getCurrentBetAmount()>= 20 && getCurrentBetAmount() <= 30) {
            computerBet = betAmount;
            pot += computerBet;
            computerCoins -= computerBet;
            System.out.println("Computer matched the bet of " + getCurrentBetAmount());
            displayPotAmount();

            winner();

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


            winner();


        } else { //if user choice is fold
            System.out.println("Computer Folds");


            winner();

        }

    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------
    /*
        Purpose: to see who has the highest hand and wins
     */
    public static void winner() {
        displayUserHand();
        displayComputerHand();


        boolean userPair = hasPair(userHand);
        boolean computerPair = hasPair(computerHand);

        boolean userTwoPair = hasTwoPair(userHand);
        boolean computerTwoPair = hasTwoPair(computerHand);

        boolean userThreeOfAKind = hasThreeOfAKind(userHand);
        boolean computerThreeOfAKind = hasThreeOfAKind(computerHand);

        boolean userStraight = hasStraight(userHand);
        boolean computerStraight = hasStraight(computerHand);

        boolean userFlush = hasFlush(userHand);
        boolean computerFlush = hasFlush(computerHand);

        boolean userFullHouse = hasFullHouse(userHand);
        boolean computerFullHouse = hasFullHouse(computerHand);

        boolean userFourOfAKind = hasFourOfAKind(userHand);
        boolean computerFourOfAKind = hasFourOfAKind(computerHand);

        boolean userStraightFlush = hasStraightFlush(userHand);
        boolean computerStraightFlush = hasStraightFlush(computerHand);

        boolean userRoyalFlush = hasRoyalFlush(userHand);
        boolean computerRoyalFlush = hasRoyalFlush(computerHand);


        if ((userFlush || userPair || userTwoPair || userThreeOfAKind || userStraight || userFullHouse || userFourOfAKind || userStraightFlush || userRoyalFlush)
                && (!computerFlush && !computerPair && !computerTwoPair && !computerThreeOfAKind && !computerStraight && !computerFullHouse && !computerFourOfAKind && !computerStraightFlush && !computerRoyalFlush)) {
            System.out.println("Congratulations! You win!");
            userCoins += pot;
        }
        else if ((computerFlush || computerPair || computerTwoPair || computerThreeOfAKind || computerStraight || computerFullHouse || computerFourOfAKind || computerStraightFlush || computerRoyalFlush) &&
                (!userFlush && !userPair && !userTwoPair && !userThreeOfAKind && !userStraight && !userFullHouse && !userFourOfAKind && !userStraightFlush && !userRoyalFlush)) {
            System.out.println("Computer wins. Better luck next time!");
            computerCoins += pot;

        }
        else {
            int userHighCard = getHighestCardRank(userHand);
            int computerHighCard = getHighestCardRank(computerHand);

            if (userHighCard > computerHighCard) {
                System.out.println("Congratulations! You win!");
                userCoins += pot;
            } else if (userHighCard < computerHighCard) {
                System.out.println("Computer wins. Better luck next time!");
                computerCoins += pot;
            } else {
                System.out.println("It's a tie! The pot will be split.");
                int halfPot = pot / 2;
                userCoins += halfPot;
                computerCoins += halfPot;
            }
        }

        System.out.println("Thanks for playing! Goodbye!");
        System.exit(0);
    }

    private static List<String> getRanks() {
        // Helper method to get a list of all ranks
        return Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace");
    }

    private static int getHighestCardRank(List<String> hand) {
        List<String> ranks = getRanks();

        int maxRankIndex = -1;

        for (String card : hand) {
            String cardRank = card.split("_of_")[0];
            int currentRankIndex = ranks.indexOf(cardRank);

            if (currentRankIndex > maxRankIndex) {
                maxRankIndex = currentRankIndex;
            }
        }

        return maxRankIndex;
    }


    private static Map<String, Integer> getRanksFrequency(List<String> hand) {
        // Helper method to get a map of frequencies for each rank
        Map<String, Integer> rankFrequency = new HashMap<>();

        for (String rank : getRanks()) {
            rankFrequency.put(rank, Collections.frequency(hand, rank));
        }

        return rankFrequency;
    }


    private static boolean hasPair(List<String> hand) {
        return getRanksFrequency(hand).containsValue(2);  // Check if there is a pair
    }

    private static boolean hasTwoPair(List<String> hand) {
        Map<String, Integer> ranksFrequency = getRanksFrequency(hand);
        int pairCount = 0;

        for (int frequency : ranksFrequency.values()) {
            if (frequency == 2) {
                pairCount++;
            }
        }

        return pairCount == 2;  // Check if there are two pairs
    }

    private static boolean hasThreeOfAKind(List<String> hand) {
        return getRanksFrequency(hand).containsValue(3);  // Check if there is three of a kind
    }

    private static boolean hasStraight(List<String> hand) {
        List<String> ranks = getRanks();
        Collections.sort(ranks);

        for (int i = 0; i < ranks.size() - 1; i++) {
            int currentRankIndex = ranks.indexOf(hand.get(i).split("_of_")[0]);
            int nextRankIndex = ranks.indexOf(hand.get(i + 1).split("_of_")[0]);

            if (nextRankIndex - currentRankIndex != 1) {
                return false;
            }
        }

        return true;  // Check if it is a straight
    }

    private static boolean hasFlush(List<String> hand) {
        String suit = hand.get(0).split("_of_")[1];
        return hand.stream().allMatch(card -> card.endsWith(suit));  // Check if it is a flush
    }

    private static boolean hasFullHouse(List<String> hand) {
        Map<String, Integer> ranksFrequency = getRanksFrequency(hand);
        boolean hasThreeOfAKind = false;
        boolean hasPair = false;

        for (int frequency : ranksFrequency.values()) {
            if (frequency == 3) {
                hasThreeOfAKind = true;
            } else if (frequency == 2) {
                hasPair = true;
            }
        }

        return hasThreeOfAKind && hasPair;  // Check if it is a full house
    }

    private static boolean hasFourOfAKind(List<String> hand) {
        return getRanksFrequency(hand).containsValue(4);  // Check if there is four of a kind
    }

    private static boolean hasStraightFlush(List<String> hand) {
        return hasFlush(hand) && hasStraight(hand);  // Check if it is a straight flush
    }

    private static boolean hasRoyalFlush(List<String> hand) {
        return hasStraightFlush(hand) && hand.contains("Ace_of") && hand.contains("King_of") &&
                hand.contains("Queen_of") && hand.contains("Jack_of") && hand.contains("10_of");  // Check if it is a royal flush
    }

}
