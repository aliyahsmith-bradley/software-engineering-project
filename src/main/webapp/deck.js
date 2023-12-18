
export default class Deck{
    constructor(cards = this.initializeDeck()) {
        this.cards = cards
    }

    initializeDeck(){
        var  listCards = []
        listCards.push(new Card("2_of_clubs", 2))
        listCards.push(new Card("2_of_spades", 2));
        listCards.push(new Card("2_of_diamonds", 2));
        listCards.push(new Card("2_of_hearts", 2));
        listCards.push(new Card("3_of_clubs", 3));
        listCards.push(new Card("3_of_diamonds", 3));
        listCards.push(new Card("3_of_hearts", 3));
        listCards.push(new Card("3_of_spades", 3));
        listCards.push(new Card("4_of_clubs", 4));
        listCards.push(new Card("4_of_diamonds", 4));
        listCards.push(new Card("4_of_hearts", 4));
        listCards.push(new Card("4_of_spades",4));
        listCards.push(new Card("5_of_clubs", 5));
        listCards.push(new Card("5_of_spades", 5));
        listCards.push(new Card("5_of_diamonds", 5));
        listCards.push(new Card("5_of_hearts", 5));
        listCards.push(new Card("6_of_clubs", 6));
        listCards.push(new Card("6_of_diamonds", 6));
        listCards.push(new Card("6_of_hearts", 6));
        listCards.push(new Card("6_of_spades", 6));
        listCards.push(new Card("7_of_clubs", 7));
        listCards.push(new Card("7_of_spades", 7));
        listCards.push(new Card("7_of_diamonds", 7));
        listCards.push(new Card("7_of_hearts", 7));
        listCards.push(new Card("8_of_clubs", 8));
        listCards.push(new Card("8_of_hearts", 8));
        listCards.push(new Card("8_of_spades", 8));
        listCards.push(new Card("8_of_diamonds", 8));
        listCards.push(new Card("9_of_clubs", 9));
        listCards.push(new Card("9_of_hearts", 9));
        listCards.push(new Card("9_of_spades", 9));
        listCards.push(new Card("9_of_diamonds", 9));
        listCards.push(new Card("10_of_clubs", 10));
        listCards.push(new Card("10_of_hearts", 10));
        listCards.push(new Card("10_of_spades", 10));
        listCards.push(new Card("10_of_diamonds", 10));
        listCards.push(new Card("ace_of_clubs", 14));
        listCards.push(new Card("ace_of_hearts", 14));
        listCards.push(new Card("ace_of_spades", 14));
        listCards.push(new Card("ace_of_diamonds", 14));
        listCards.push(new Card("jack_of_clubs2", 11));
        listCards.push(new Card("jack_of_hearts2", 11));
        listCards.push(new Card("jack_of_spades2", 11));
        listCards.push(new Card("jack_of_diamonds2", 11));
        listCards.push(new Card("queen_of_clubs2", 12));
        listCards.push(new Card("queen_of_hearts2", 12));
        listCards.push(new Card("queen_of_spades2", 12));
        listCards.push(new Card("queen_of_diamonds2", 12));
        listCards.push(new Card("king_of_clubs2", 13));
        listCards.push(new Card("king_of_hearts2", 13));
        listCards.push(new Card("king_of_spades2", 13));
        listCards.push(new Card("king_of_diamonds2", 13));

        return listCards
    }
    shuffleDeck() {
        for (var i = this.cards.length - 1; i > 0; i--) {
            var j = Math.floor(Math.random() * (i + 1));
            var temp = this.cards[i];
            this.cards[i] = this.cards[j];
            this.cards[j] = temp;
        }
    }

    dealFive(){
        var hand = this.cards.slice(0,5)
        this.cards.shift();
        this.cards.shift();
        this.cards.shift();
        this.cards.shift();
        this.cards.shift();

        return hand
    }

    replaceOne(){
        var card = this.cards.slice(0,1)
        console.log(card)
        this.cards.shift()
        return card
    }


}
class Card{
    constructor(name, rank) {
        this.name = name
        this.rank = rank;
        this.img = "images/" + name + ".png"
    }

    getHTML(i, list){
        const cardDiv = document.createElement('div')
        cardDiv.innerHTML = "<img src='" + this.img + "'  height=\"100px\" width=\"70px\" >"
        cardDiv.classList.add("cardShown")
        return cardDiv
    }

    getUserHTML(i, list){
        const cardDiv = document.createElement('div')
        cardDiv.innerHTML = "<img src='" + this.img + "' class='card' height=\"100px\" width=\"70px\" >"
        cardDiv.classList.add("cardShown")
        cardDiv.addEventListener("click", function(){
            list[i] = !list[i];
            console.log(list)
        })
        return cardDiv
    }

    updateUserHTML(location, List){


    }

}
