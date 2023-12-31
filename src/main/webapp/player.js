import Deck from "./deck.js";

export default class Player{
    location;
    constructor() {
        this.playerCoins = 100
        this.hand = []
        this.name = "player"
        this.handBool = [false,false,false,false,false]
    }

    setHand(hand){
        this.hand = hand
    }

    getHand(){
        return this.hand
    }
    addCoins(i){
        this.playerCoins += i;
    }

    getCoins(){
        return this.playerCoins
    }

    getHandBool(){
        return this.handBool
    }
    bet(i){
        if (i > this.playerCoins){
            alert("not enough money")
            return false
        }
        else{
            this.playerCoins -= i
            return true;
        }
    }

    replaceCards(deck){
        for(var i in this.handBool){
            if(this.handBool[i]){
                console.log(this.hand);
                this.hand[i] = deck.replaceOne()[0];
            }
        }
    }
    toggleCardSelection(index){
        this.handBool[index] = !this.handBool[index];

    }

    isCardSelected(index){
        return this.handBool[index];
    }

    isAceInHand(){
        return this.hand.some(card => card.rank === 14);

    }

    getSelectedCardCount(){
        return this.handBool.filter(selected => selected).length;
    }

    getLastSelectedIndex() {
        return this.handBool.lastIndexOf(true);
    }

}