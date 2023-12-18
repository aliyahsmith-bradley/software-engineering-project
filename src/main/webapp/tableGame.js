import Deck from "./deck.js";
import Player from "./player.js"
import Computer from "./computer.js";

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

const deck = new Deck();
deck.shuffleDeck()

const readyReplaceButton = document.getElementById("ready-replace")
readyReplaceButton.addEventListener("click", () => {
    userReplace();

    setTimeout(() => {
        computerReplace();
    }, 1000);
});

const computerCardSlot = document.querySelector(".comp-hand")
const playerCardSlot = document.querySelector(".player-hand")

const computer = new Computer();
computer.setHand(deck.dealFive())
console.log(computer.getHand());

const user = new Player();
user.setHand(deck.dealFive())

function userReplace(){
    user.replaceCards(deck)
    console.log(user.getHand())
    playerCardSlot.innerHTML = ""
    showHand(playerCardSlot, user.getHand(), user.getHandBool());
}

function computerReplace() {
    if (user.getSelectedCardCount() > 0) {
        computer.replaceCards(deck);
        console.log(computer.getHand());
        computerCardSlot.innerHTML = "";
        showHand(computerCardSlot, computer.getHand(), computer.getHandBool());
    } else {
        console.log("User must replace cards first.");
    }
}


startGame();

function startGame() {
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
