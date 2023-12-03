package pokersite.Logic.fivedraw;

import org.checkerframework.checker.units.qual.A;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FiveCardDrawGame {
    private static final int HAND_SIZE = 5;
    private ArrayList<String> playerHand;
    private ArrayList<String> computerHand;
    private ArrayList<ArrayList<String>> players;

    public FiveCardDrawGame() {
        playerHand = new ArrayList<>();
        computerHand = new ArrayList<>();

        players.add(playerHand);
        players.add(computerHand);
    }

//    public String displayHand(ArrayList<String> hand){
//
//    }
//    public void displayHands(){
//
//    }
    public void placeBets(){

    }
    public void playGame() {
        System.out.println("Welcome to Five Card Draw!");

        // Create a deck of cards
        ArrayList<String> deck = createDeck();
        Collections.shuffle(deck);

        // Deal initial hands
        dealCards(deck, playerHand, computerHand);

        // Show initial hands
        System.out.println("Your hand: " + playerHand);
        System.out.println("Computer's hand: " + computerHand);

        // Allow the player to discard and redraw
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the indices of the cards you want to discard (e.g. 1 3 4), or 0 to stand pat: ");
        String input = scanner.nextLine();
        if (!input.equals("0")) {
            String[] indices = input.split(" ");
            for (String index : indices) {
                int i = Integer.parseInt(index);
                if (i >= 1 && i <= HAND_SIZE) {
                    playerHand.set(i - 1, deck.remove(0));
                }
            }
        }

        // Redraw the player's hand
        while (playerHand.size() < HAND_SIZE) {
            playerHand.add(deck.remove(0));
        }

        // Show the final hands
        System.out.println("Your final hand: " + playerHand);
        System.out.println("Computer's final hand: " + computerHand);
    }

    private ArrayList<String> createDeck() {
        ArrayList<String> deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " of " + suit);
            }
        }
        return deck;
    }

    private void dealCards(ArrayList<String> deck, ArrayList<String> playerHand, ArrayList<String> computerHand) {
        for (int i = 0; i < HAND_SIZE; i++) {
            playerHand.add(deck.remove(0));
            computerHand.add(deck.remove(0));
        }
    }

    // Add more methods as needed for the game logic
}