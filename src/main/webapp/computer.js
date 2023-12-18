// computer.js
// computer.js

export default class Computer {
    constructor() {
        this.hand = [];
        this.name = "computer";
        this.ComputerCoins = 100;
        this.handBool = [false, false, false, false, false];
        // Add any additional properties specific to the computer player
    }

    setHand(hand) {
        this.hand = hand;
    }

    getHand() {
        return this.hand;
    }

    getHandBool() {
        return this.handBool;
    }

    replaceCards(deck) {
            const isAceInHand = this.isAceInHand();
            const maxReplacement = isAceInHand ? 4 : 3;

            // Randomly select cards to replace
            const cardsToReplace = [];
            while (cardsToReplace.length < maxReplacement) {
                const randomIndex = Math.floor(Math.random() * this.hand.length);
                if (!cardsToReplace.includes(randomIndex)) {
                    cardsToReplace.push(randomIndex);
                }
            }

            // Replace selected cards
            cardsToReplace.forEach(index => {
                this.hand[index] = deck.replaceOne()[0];
            });

    }

    toggleCardSelection(index) {
        this.handBool[index] = !this.handBool[index];
    }

    isCardSelected(index) {
        return this.handBool[index];
    }

    isAceInHand() {
        // Add logic to check if there is an Ace in the computer's hand
        return this.hand.some(card => card.rank === 14);
    }

    getSelectedCardCount() {
        return this.handBool.filter(selected => selected).length;
    }

    getLastSelectedIndex() {
        return this.handBool.lastIndexOf(true);
    }

    // Add any additional methods or properties specific to the computer player
}
