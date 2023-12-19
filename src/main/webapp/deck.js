
export default class Deck{
    constructor(cards = this.initializeDeck()) {
        this.cards = cards
    }

    initializeDeck(){
        var  listCards = []
        listCards.push(new Card("2_of_clubs", 2, "clubs"))
        listCards.push(new Card("2_of_spades", 2, "spades"));
        listCards.push(new Card("2_of_diamonds", 2, "diamonds"));
        listCards.push(new Card("2_of_hearts", 2, "hearts"));
        listCards.push(new Card("3_of_clubs", 3, "clubs"));
        listCards.push(new Card("3_of_diamonds", 3, "diamonds"));
        listCards.push(new Card("3_of_hearts", 3, "hearts"));
        listCards.push(new Card("3_of_spades", 3, "spades"));
        listCards.push(new Card("4_of_clubs", 4, "clubs"));
        listCards.push(new Card("4_of_diamonds", 4, "diamonds"));
        listCards.push(new Card("4_of_hearts", 4, "hearts"));
        listCards.push(new Card("4_of_spades",4, "spades"));
        listCards.push(new Card("5_of_clubs", 5, "clubs"));
        listCards.push(new Card("5_of_spades", 5, "spades"));
        listCards.push(new Card("5_of_diamonds", 5, "diamonds"));
        listCards.push(new Card("5_of_hearts", 5, "hearts"));
        listCards.push(new Card("6_of_clubs", 6, "clubs"));
        listCards.push(new Card("6_of_diamonds", 6, "diamonds"));
        listCards.push(new Card("6_of_hearts", 6, "hearts"));
        listCards.push(new Card("6_of_spades", 6, "spades"));
        listCards.push(new Card("7_of_clubs", 7, "clubs"));
        listCards.push(new Card("7_of_spades", 7, "spades"));
        listCards.push(new Card("7_of_diamonds", 7, "diamonds"));
        listCards.push(new Card("7_of_hearts", 7, "hearts"));
        listCards.push(new Card("8_of_clubs", 8, "clubs"));
        listCards.push(new Card("8_of_hearts", 8, "hearts"));
        listCards.push(new Card("8_of_spades", 8, "spades"));
        listCards.push(new Card("8_of_diamonds", 8, "diamonds"));
        listCards.push(new Card("9_of_clubs", 9, "clubs"));
        listCards.push(new Card("9_of_hearts", 9, "hearts"));
        listCards.push(new Card("9_of_spades", 9, "spades"));
        listCards.push(new Card("9_of_diamonds", 9, "diamonds"));
        listCards.push(new Card("10_of_clubs", 10, "clubs"));
        listCards.push(new Card("10_of_hearts", 10, "hearts"));
        listCards.push(new Card("10_of_spades", 10, "spades"));
        listCards.push(new Card("10_of_diamonds", 10, "diamonds"));
        listCards.push(new Card("ace_of_clubs", 14, "clubs"));
        listCards.push(new Card("ace_of_hearts", 14, "hearts"));
        listCards.push(new Card("ace_of_spades", 14, "spades"));
        listCards.push(new Card("ace_of_diamonds", 14, "diamonds"));
        listCards.push(new Card("jack_of_clubs2", 11, "clubs"));
        listCards.push(new Card("jack_of_hearts2", 11, "hearts"));
        listCards.push(new Card("jack_of_spades2", 11, "spades"));
        listCards.push(new Card("jack_of_diamonds2", 11, "diamonds"));
        listCards.push(new Card("queen_of_clubs2", 12, "clubs"));
        listCards.push(new Card("queen_of_hearts2", 12, "hearts"));
        listCards.push(new Card("queen_of_spades2", 12, "spades"));
        listCards.push(new Card("queen_of_diamonds2", 12, "diamonds"));
        listCards.push(new Card("king_of_clubs2", 13, "clubs"));
        listCards.push(new Card("king_of_hearts2", 13, "hearts"));
        listCards.push(new Card("king_of_spades2", 13, "spades"));
        listCards.push(new Card("king_of_diamonds2", 13, "diamonds"));

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
    constructor(name, rank, suit) {
        this.name = name
        this.rank = rank;
        this.suit = suit;
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
