package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FiveCardDrawGame {
    private static final int HAND_SIZE = 5;
    private static ArrayList<String> playerHand;
    private static ArrayList<String> computerHand;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Five Card Draw!");

        // Create a deck of cards
        ArrayList<String> deck = createDeck();
        Collections.shuffle(deck);

        // Deal initial hands
        playerHand = new ArrayList<>();
        computerHand = new ArrayList<>();
        dealCards(deck, playerHand, computerHand);

        // Show initial hands
        System.out.println("Your hand: " + playerHand);
        System.out.println("Computer's hand: " + computerHand);

        // Allow the player to discard and redraw
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

    private static ArrayList<String> createDeck() {
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

    private static void dealCards(ArrayList<String> deck, ArrayList<String> playerHand, ArrayList<String> computerHand) {
        double[] dealtCards
    }
}