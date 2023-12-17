import Deck from "./deck.js";

export default class Player{
    location;
    constructor() {
        this.coins = 100
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
        this.coins += i;
    }

    getCoins(){
        return this.coins
    }

    getHandBool(){
        return this.handBool
    }
    bet(i){
        if (i < this.coins){

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

}