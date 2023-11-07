package com.example.loginguestsignuppage;

import java.util.*;

import java.util.*;
import java.util.Collections;
import java.util.List;

public class GameLogicSinglePlayer {



    private static final int INITIAL_COINS = 100;
    private static final int HAND_SIZE = 5;
    private static final List<String> cardDeck = new ArrayList<>();
    private static int pot = 0;

    static{

        //creating the deck of cards
        String[] suits = new String[]{"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        //formatting suits and ranks
        for(String suit : suits){
            for(String rank :ranks){
                cardDeck.add(rank + " of " + suit);
            }
        }
    }

    public static void main(String[] args){

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
        for(int i = 0; i < HAND_SIZE; i ++){
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
        while (!userChoice1.equalsIgnoreCase("check") && !userChoice1.equalsIgnoreCase("bet")){
            System.out.println("Invalid choice.Please enter either 'check' or 'bet'.");
            userChoice1 = scanner.nextLine();
        }

        if(userChoice1.equals("check")){
            System.out.println("Moving on. Computers turn");
            int userBet1 = 0;
            computersTurnRound1(computerHand, userHand, deck, userBet1, userChoice1, computerCoins);

        }

        if(userChoice1.equals("bet")){
            System.out.println("How much would you like to bet?");
            int userBet1 = scanner.nextInt();
            pot += userBet1;
            System.out.println("The new pot's amount is " + pot);
            userCoins -= userBet1;
            System.out.println("You now have " + userCoins + " coins");
            computersTurnRound1(computerHand, userHand, deck, userBet1, userChoice1, computerCoins);
        }





    }

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

    private static boolean hasPair(List<String> computerHand) {
        Set<String> uniqueRanks = new HashSet<>();
        for (String card : computerHand) {
            String rank = card.split(" ")[0];
            if (!uniqueRanks.add(rank)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasThreeToStraight(List<String> computerHand) {
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

    private static boolean hasThreeToFlush(List<String> computerHand) {
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
}




