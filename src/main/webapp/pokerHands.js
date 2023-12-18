
export function determineWinner(userHand, computerHand) {
    const userHandStrength = evaluateHandStrength(userHand);
    const computerHandStrength = evaluateHandStrength(computerHand);
    const resultMessageContainer = document.getElementById("result-message");

    console.log("User Hand Strength:", userHandStrength);
    console.log("Computer Hand Strength:", computerHandStrength);

    let resultMessage = "";

    if (userHandStrength > computerHandStrength) {
        resultMessage = "Congratulations! You win!";
    } else if (userHandStrength < computerHandStrength) {
        resultMessage = "Computer wins. Better luck next time!";
    } else {
        resultMessage = "It's a tie! The pot will be split.";
    }

    resultMessageContainer.textContent = resultMessage;
}

    function evaluateHandStrength(hand) {
        // Sum up the ranks of the cards in the hand
        const handValue = hand.reduce((total, card) => total + card.rank, 0);
        return handValue;
    }

