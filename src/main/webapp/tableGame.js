import Deck from "./deck.js";
import Player from "./player.js"

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
readyReplaceButton.addEventListener("click", userReplace)
const computerCardSlot = document.querySelector(".comp-hand")
const playerCardSlot = document.querySelector(".player-hand")

const computer = new Player();
computer.setHand(deck.dealFive())
console.log(computer.hand)

const user = new Player();
user.setHand(deck.dealFive())

function userReplace(){
    user.replaceCards(deck)
    console.log(user.getHand())
    playerCardSlot.innerHTML = ""
    showHand(playerCardSlot, user.getHand(), user.getHandBool());
}

startGame()
function startGame(){

    showHand(computerCardSlot, computer.getHand(), computer.getHandBool());


    user.getHand().forEach((card,index) =>{
        const cardElement = card.getHTML(index, user.getHandBool());

        cardElement.addEventListener("click", () => {
            user.toggleCardSelection(index);

            cardElement.classList.toggle("selected", user.isCardSelected(index));
        });
        playerCardSlot.appendChild(cardElement);
    });

}

