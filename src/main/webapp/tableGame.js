import Deck from "./deck.js";
import Player from "./player.js"
import Computer from "./computer.js";


const user = new Player();
const computer = new Computer();
var pot = 0
var didFold = false
var didCheck = false
var userbet = 0
var lastBet = 0

function toggleChangeCards(){
    console.log("in the function, not doing much");
    var newcards = document.getElementById("changeCards");
    var displaySetting = newcards.style.display;

    if (displaySetting == "block"){
        newcards.style.display = 'none';
    }else{
        newcards.style.display = 'block'
    }
}

function toggleBetButton(){
    console.log("getting to functions toggleBetButton")
    var betbutton = document.getElementById("betButton")
    var displaySetting = betbutton.style.display

    if (displaySetting == 'block'){
        betbutton.style.display = 'none';
    }else{
        betbutton.style.display = 'block'
    }
}

const betButtonListener = document.getElementById("betSubmit")
betButtonListener.addEventListener("click", () => {
    var bet = document.getElementById("bet")
    console.log(bet.value)
    if(bet.value > 0){
        toggleChangeCards()
        toggleBetButton()
    }
    else{
        alert("That's too low for a bet!")
    }
})

const foldListener = document.getElementById("foldButton")
foldListener.addEventListener("click", () =>{
    didFold = true
    hasFolded()
    console.log("didFold:" + didFold)
})

const checkListener = document.getElementById("checkButton")
checkListener.addEventListener("click", ()=> {
    didCheck = true;
    toggleChangeCards()
    toggleBetButton()
    console.log("did check: " + didCheck)
})

const changedCardsListener = document.getElementById("changeCards")
changedCardsListener.addEventListener("click", ()=>{
    userReplace();

    setTimeout(() => {
        computerReplace();
    }, 1000);
    toggleBetButton()
    toggleChangeCards()
})
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
function updatePotBox(){
    const potBox = document.getElementById("pot-amount")
    potBox.innerHTML = Number(pot)
    console.log(pot)
}

function userDefaultBet(){
    if (user.bet(10)){
        pot += 10
    }
    updateMoneyBox()
    updatePotBox()
}



const deck = new Deck();
deck.shuffleDeck()

const bet = document.getElementById("bet-button")
bet.addEventListener("click", userDefaultBet)


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
updateMoneyBox()

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


function determineWinner(userHand, computerHand) {
    const userHasPair = hasPair(userHand);
    const computerHasPair = hasPair(computerHand);
    const userHandStrength = evaluateHandStrength(userHand);
    const computerHandStrength = evaluateHandStrength(computerHand);
    const resultMessageContainer = document.getElementById("result-message");

    console.log("User Hand Strength:", userHandStrength);
    console.log("Computer Hand Strength:", computerHandStrength);

    let resultMessage = "";

    if (userHandStrength > computerHandStrength || userHasPair) {
        resultMessage = "Congratulations! You win!";
        user.addCoins(pot);
    } else if (userHandStrength < computerHandStrength || computerHasPair) {
        resultMessage = "Computer wins. Better luck next time!";
    } else {
        resultMessage = "It's a tie! The pot will be split.";
        user.addCoins(pot / 2);
    }

    pot = 0;
    updatePotBox();
    updateMoneyBox();
    resultMessageContainer.textContent = resultMessage;



}


startGame();

function startGame() {
    pot += computer.bet()
    updatePotBox()


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

function hasFolded(){
    console.log("You folded, better luck next time!")
}

//-----------------------------------------------------------------------------------------------------------------------
function hasPair(hand){
    const ranks = new Set();

    for(const card of hand){
        console.log(card.rank)
        if(ranks.has(card.rank)){
            return true;
        }
        ranks.add(card.rank);
    }
    return false;
}