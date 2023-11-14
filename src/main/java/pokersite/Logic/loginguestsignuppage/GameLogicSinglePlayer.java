package pokersite.Logic.loginguestsignuppage;

import java.lang.reflect.Array;
import java.util.*;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameLogicSinglePlayer {


    private static final int INITIAL_COINS = 100;
    private static final int HAND_SIZE = 5;
    private static final List<String> cardDeck = new ArrayList<>();
    private static int pot = 0;


    static {

        //creating the deck of cards
        String[] suits = new String[]{"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        //formatting suits and ranks
        for (String suit : suits) {
            for (String rank : ranks) {
                cardDeck.add(rank + "_of_" + suit);
            }
        }
    }

    public static ArrayList<String> dealHand(ArrayList<String> deck){
        Collections.shuffle(deck);

        ArrayList<String> hand = new ArrayList<>();

        for (int i = 0; i < HAND_SIZE; i++) {
            hand.add(deck.get(i));
        }
        removeCardsFromDeck(deck, hand);
        return hand;
    }

    public static ArrayList<String> removeCardsFromDeck(ArrayList<String> deck, ArrayList<String> cardsToRemove){
        deck.removeIf(cardsToRemove::contains);
        return deck;
    }
    public static void main(String[] args) {

        //Copy card deck
        List<String> deck = new ArrayList<>(cardDeck);
        // Testing: System.out.println("Deck before shuffle, " + deck);

        //Shuffle the cards
        Collections.shuffle(deck);

        //Assign five cards to the user then five to the computer
        List<String> userHand = new ArrayList<>();
        List<String> computerHand = new ArrayList<>();
        List<String> cardsToRemove = new ArrayList<>();

        //Testing: System.out.println("Deck after shuffle, " + deck);

        //assign five cards to user then remove those from the deck
        for (int i = 0; i < HAND_SIZE; i++) {
            userHand.add(deck.get(i));
            cardsToRemove.add(deck.get(i));
        }

        //Testing: System.out.println("User hand: " + userHand);
        deck.removeIf(cardsToRemove::contains);

        //Testing: System.out.println("Deck dealing out userHand " + deck);

        //clear the cards to remove array
        cardsToRemove.clear();

        //cards to remove from deck
        for (int i = 0; i < HAND_SIZE; i++) {
            computerHand.add(deck.get(i + HAND_SIZE));
            cardsToRemove.add(deck.get(i + HAND_SIZE));
        }

        //Testing: System.out.println("Computer hand: " + computerHand);
        deck.removeIf(cardsToRemove::contains);

        //Testing: System.out.println("Deck dealing out computerHand " + deck);


        Scanner scanner = new Scanner(System.in);

        //start off the computer and user with 100 coins to start
        int userCoins = INITIAL_COINS;
        int computerCoins = INITIAL_COINS;


        System.out.println("Welcome to Five Card Draw: Feeling Lucky?");


        //give the user their hand
        System.out.println("Lets start with you User. Here is your hand: " + userHand + " and you have this many coins: "
                + userCoins);
        System.out.println("What would you like to do, check or bet?");
        String userChoice1 = scanner.nextLine();


        //do the first ever round for the user
        while (!userChoice1.equalsIgnoreCase("check") && !userChoice1.equalsIgnoreCase("bet")) {
            System.out.println("Invalid choice.Please enter either 'check' or 'bet'.");
            userChoice1 = scanner.nextLine();
        }

        if (userChoice1.equals("check")) {
            System.out.println("Moving on. Computers turn");
            int userBet1 = 0;
            computersTurn(userChoice1, userBet1, computerCoins, userCoins, userHand, deck, computerHand);

        }

        if (userChoice1.equals("bet")) {
            System.out.println("How much would you like to bet?");
            int userBet1 = scanner.nextInt();
            pot += userBet1;
            System.out.println("The new pot's amount is " + pot);
            userCoins -= userBet1;
            System.out.println("You now have " + userCoins + " coins");
            computersTurn(userChoice1, userBet1, computerCoins, userCoins, userHand, deck, computerHand);
        }
    }

    private static void computersTurn(String userChoice1, int userBet1, int computerCoins, int userCoins, List<String> userHand, List<String> deck, List<String> computerHand) {

        if (userChoice1.equals("check")) {
            System.out.println("Computer Checked");
            userRound2(userHand, deck, computerHand, userCoins, computerCoins, userBet1);
        }
        if (userChoice1.equals("bet")) {
            int computerBet = 0;
            int amountHaveToRaise = 0;
            computerBet = userBet1;
            pot += computerBet;
            computerCoins -= computerBet;
            System.out.println("Computer matched your bet of " + userBet1);
            amountHaveToRaise += userBet1;
            System.out.println("Current pot is " + pot);
            userRound2(userHand, deck, computerHand, userCoins, computerCoins, userBet1);
        }


    }

    //getting the new cards
    private static List<String> replaceCards(List<String> userHand, List<String> deck, Scanner scanner, boolean hasAce, int maxReplacements) {
        System.out.println("Your current hand: " + userHand);
        System.out.println("Which cards would you like to discard? Please enter the indices (starting from 0) separated by spaces:");

        String[] indices = scanner.nextLine().split(" ");
        List<String> newCards = new ArrayList<>();
        for (String index : indices) {
            int i = Integer.parseInt(index);
            if (i >= 0 && i < userHand.size() && newCards.size() < maxReplacements) {
                userHand.remove(i);
                userHand.add(i, deck.get(0));
                deck.remove(0);
                newCards.add(deck.get(0));
            }
        }

        return userHand;
    }


    //getting new cards
    private static void userRound2(List<String> userHand, List<String> deck, List<String> computerHand, int userCoins, int computerCoins, int userBet1) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to get new cards? (yes or no)");
        String askNewCards = scanner.nextLine();

        while (!askNewCards.equalsIgnoreCase("yes") && !askNewCards.equalsIgnoreCase("no")) {
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
        if (askNewCards.equals("yes") && !hasAce) {//user does not have an ace of any suit
            int maxReplacements = 3;
            List<String> updatedHand = replaceCards(userHand, deck, scanner, hasAce, maxReplacements);
            System.out.println("Computer did not want new cards");
            restOfRounds(userCoins, computerCoins, userBet1);

        }
        if (askNewCards.equals("yes") && hasAce) {//user does not have a ace of any suit)
            int maxReplacements = 4;
            List<String> updatedHand = replaceCards(userHand, deck, scanner, hasAce, maxReplacements);
            System.out.println("Your new hand is: " + updatedHand);
            System.out.println("Computer did not want new cards");
            restOfRounds(userCoins, computerCoins, userBet1);

        }
        if (askNewCards.equals("no")) {
            System.out.println("Computer wants new cards");
            //System.out.println("Computer's current hand is: " + computerHand);
            if (!computerHand.isEmpty() && hasAce) {
                Random random = new Random();
                for (int i = 0; i < 4; i++) {
                    int randomIndex = random.nextInt(4); // Generate a random integer from 0 to 4
                    if (randomIndex < computerHand.size()) {
                        // Replace the card at the randomly chosen index with a new card from the deck
                        computerHand.set(randomIndex, deck.remove(0));
                        restOfRounds(userCoins, computerCoins, userBet1);
                    }
                }
                if (!computerHand.isEmpty() && !hasAce) {
                    for (int i = 0; i < 4; i++) {
                        int randomIndex = random.nextInt(3); // Generate a random integer from 0 to 3
                        if (randomIndex < computerHand.size()) {
                            // Replace the card at the randomly chosen index with a new card from the deck
                            computerHand.set(randomIndex, deck.remove(0));
                        }
                    }
                    restOfRounds(userCoins, computerCoins, userBet1);
                }
                //System.out.println("Computer's new hand is: " + computerHand);

                }
            }

        }

        public static void restOfRounds(int userCoins, int computerCoins, int userBet1){

            //while both players have coins
            while(userCoins > 0 && computerCoins > 0){
                Scanner scanner = new Scanner(System.in);
                System.out.println("User, would you like to raise, check, fold ");
                String userGo = scanner.nextLine();

                while (!userGo.equalsIgnoreCase("check") && !userGo.equalsIgnoreCase("call") && !userGo.equalsIgnoreCase("raise") && !userGo.equalsIgnoreCase("fold")) {
                    System.out.println("Invalid choice.Please enter either 'check', 'raise' or 'fold' ");
                    userGo = scanner.nextLine();
                }

                if(userGo.equalsIgnoreCase("raise")){
                    System.out.println("How much would you like to raise?");
                    int userRaise = scanner.nextInt();
                    if (userRaise > userCoins){
                        System.out.println("You dont have that many coins, please enter again. You have: " + userCoins + " coins");
                        userRaise = scanner.nextInt();
                    }
                    else {
                        pot += userRaise;
                        System.out.println("The new pot's amount is " + pot);
                        userCoins -= userRaise;
                        System.out.println("You now have " + userCoins + " coins");
                        System.out.println("Computers turn");
                        computerCoins = computerCoins - userRaise;
                        System.out.println("Computer matched your raise");
                        pot = pot + userRaise;
                        System.out.println("The new pot's amount is " + pot);
                    }
                }
                if(userGo.equalsIgnoreCase("fold")){
                    System.out.println("You folded for this round. Computers Go");
                    //Computer go function
                }

                if(userGo.equalsIgnoreCase("check")) {
                    System.out.println("The last bet was: " + userBet1 + "Would you like to match this bet?");
                    String userCheck = scanner.nextLine();
                    while (!userCheck.equalsIgnoreCase("yes") && !userCheck.equalsIgnoreCase("no")){
                        System.out.println("Invalid choice.Please enter either 'check', 'raise' or 'fold' ");
                        userCheck = scanner.nextLine();
                    }
                    if (userCheck.equalsIgnoreCase("yes")) {
                        pot = pot + userBet1;
                        System.out.println("Ok, your bet is: " + userBet1 + "the current pot is: " + userBet1 + pot);
                        //Computer Go Function
                    }
                    if (userCheck.equalsIgnoreCase("no")) {
                        System.out.println("Ok, moving on to computer");
                        //Computer Go Function
                    }
                }
            }
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


