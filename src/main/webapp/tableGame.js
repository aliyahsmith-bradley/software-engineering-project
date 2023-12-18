import Deck from "./deck.js";
import Player from "./player.js"
import Computer from "./computer.js";

const user = new Player();
const computer = new Computer();


function showHand(location, hand, list){
    for (var i in hand){
        location.appendChild(hand[i].getHTML(i, list))
    }
}
function showUserHand(location, hand, list){
    for (var i in hand){
        location.appendChild(hand[i].getUserHTML(i, list))
    }
}
function updateMoneyBox(){
    const moneyBox = document.getElementById("user-coin-amount")
    moneyBox.innerHTML = user.getCoins()
    console.log(user.getCoins())
}



const deck = new Deck();
deck.shuffleDeck()

const updateMoneyButton = document.getElementById("bet-button")
updateMoneyButton.addEventListener("click", updateMoneyBox)


const readyReplaceButton = document.getElementById("ready-replace")
readyReplaceButton.addEventListener("click", () => {
    userReplace();

        setTimeout(() => {
            computerReplace();
        }, 1000);

});



const computerCardSlot = document.querySelector(".comp-hand")
const playerCardSlot = document.querySelector(".player-hand")

computer.setHand(deck.dealFive())
console.log(computer.getHand());

user.setHand(deck.dealFive())

function userReplace(){
    user.replaceCards(deck);
    console.log(user.getHand());
    playerCardSlot.innerHTML = "";
    showHand(playerCardSlot, user.getHand(), user.getHandBool());
}

function computerReplace() {

        computer.replaceCards(deck);
        console.log(computer.getHand());
        computerCardSlot.innerHTML = "";
        showHand(computerCardSlot, computer.getHand(), computer.getHandBool());
        determineWinner();

}


function evaluateHandStrength(hand) {
    // Sum up the ranks of the cards in the hand
    const handValue = hand.reduce((total, card) => total + card.rank, 0);

    return handValue;
}

function determineWinner() {
    const userHandStrength = evaluateHandStrength(user.getHand());
    const computerHandStrength = evaluateHandStrength(computer.getHand());
    const resultMessageContainer = document.getElementById("result-message" );

    console.log("User Hand Strength:", userHandStrength);
    console.log("Computer Hand Strength:", computerHandStrength);

    let resultMessage = "";

    if (userHandStrength > computerHandStrength) {
        resultMessage = ("Congratulations! You win!");
    } else if (userHandStrength < computerHandStrength) {
        resultMessage = ("Computer wins. Better luck next time!");
    } else {
        resultMessage = ("It's a tie! The pot will be split.");
    }

    resultMessageContainer.textContent = resultMessage;
}



startGame();

function startGame() {

    const keepHandButton = document.getElementById("keep-Hand")
    keepHandButton.addEventListener("click", () => {
        computerReplace();  // Call computerReplace directly
    });

    user.getHand().forEach((card, index) => {
        const cardElement = card.getHTML(index, user.getHandBool());
        cardElement.addEventListener("click", () => {
            const isAceInHand = user.isAceInHand();
            const maxSelection = isAceInHand ? 4 : 3;

            // Check if the clicked card is already selected
            if (user.isCardSelected(index)) {
                // Toggle the selected state directly
                user.toggleCardSelection(index);

                // Remove the "selected" class for visual indication
                cardElement.classList.remove("selected");
            } else if (user.getSelectedCardCount() < maxSelection) {
                // Toggle the selected state if the maximum number of cards is not reached
                user.toggleCardSelection(index);

                // Toggle the "selected" class for visual indication
                cardElement.classList.toggle("selected", user.isCardSelected(index));
            } else {
                // If the maximum number of cards is reached, do nothing (prevent highlighting)
                console.log("Maximum number of cards reached. Cannot select more.");
            }
        });

        playerCardSlot.appendChild(cardElement);
    });

    // Additional code to show other hands or perform other tasks
    showHand(computerCardSlot, computer.getHand(), computer.getHandBool());
}
