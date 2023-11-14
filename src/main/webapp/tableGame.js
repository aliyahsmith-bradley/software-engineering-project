var cardObjectDefinition = [
    {id:1, imagePath: 'images/2_of_clubs.png'},
    {id:2, imagePath: 'images/2_of_spades.png'},
    {id:3, imagePath: 'images/2_of_diamonds.png'},
    {id:4, imagePath: 'images/2_of_hearts.png'},
    {id:5, imagePath: 'images/3_of_clubs.png'}
]

const backCardImg = '/images/card-back.jpg'

let cards = []
const playGameButtonElem = document.getElementById('dealCards')

const cardContainerElem = document.querySelector('.card-container')

const collapsedGridTemplate = 'a a a a a'
const cardCollectionCellClass = ".c-pos-1"

loadGame()
function loadGame(){
    createCards()

    cards = document.querySelectorAll(".card")

    playGameButtonElem.addEventListener('click', ()=>startGame())

}

function startGame(){
    initializeNewGame()
    startRound()
}

function initializeNewGame(){

}

function startRound(){
    initializeNewRound()
    collectCards()
}

function initializeRound(){

}

function collectCards(){
    transformGridArea(collapsedGridTemplate)
    addCardsToGridArea(cardCollectionCellClass)
}
function transformGridArea(areas){
    cardContainerElem.style.gridTemplateAreas = areas
}

function addCardsToGridArea(cellPositionClassName){
    const cellPositionElem = document.querySelector(cellPositionClassName)

    cards.forEach(card,index => {
        addChildElement(cellPositionElem, card)
    })
}

function createCards(){
    cardObjectDefinition.forEach((cardItem)=>{createCard(cardItem)} )
}
function createCard(cardItem){
    const cardElem = createElement('div')
    const cardInnerElem = createElement('div')
    const cardFrontElem = createElement('div')
    const cardBackElem = createElement('div')

    //now establish front and back card elements/images
    const cardFrontImg = createElement('img')
    const cardBackImg = createElement('img')

    //make it part of the card class
    addClassToElement(cardElem, 'card')
    addIDtoCard(cardElem, cardItem.id)

    addClassToElement(cardInnerElem, 'card-inner')
    addClassToElement(cardFrontElem, 'card-front')
    addClassToElement(cardBackElem, 'card-back')

    //adding images to front and back
    addSrcToImgElem(cardBackImg, backCardImg)
    addSrcToImgElem(cardBackImg, cardItem.imagePath)

    addClassToElement(cardBackImg, 'card-img')
    addClassToElement(cardFrontImg, 'card-img')

    addChildElement(cardFrontElem, cardFrontImg)
    addChildElement(cardBackElem, cardBackImg)

    addChildElement(cardInnerElem, cardFrontElem)
    addChildElement(cardInnerElem, cardBackElem)

    addChildElement(cardElem, cardInnerElem)

    addCardToGridCell(cardElem)
}

function createElement(elementType){
    return document.createElement(elementType)
}

function addClassToElement(element, className){
    element.classList.add(className)
}

function addIDtoCard(elem, id){
    elem.id = id
}

function addSrcToImgElem(elem, src){
    elem.src = src
}
function addChildElement(parent, child){
    parent.appendChild(child)
}

function addCardToGridCell(card){
    const cardPositionClassName = mapCardIdToGrid(card)
    const cardPosElem = document.querySelector(cardPositionClassName)

    addChildElement(cardPosElem, card)
}
function mapCardIdToGrid(card){
    if (1 == card.id){
        return '.c-pos-1'
    }
    else if (card.id == 2){
        return '.c-pos-2'
    }
    else if (card.id == 3){
        return '.c-pos-3'
    }else if (card.id == 4){
        return '.c-pos-4'
    }else if (card.id == 5){
        return '.c-pos-5'
    }
}


function background1(){
    document.body.style.backgroundImage = "linear-gradient(#181e33, #546a80, #546a80, #181e33)";
    document.body.style.backgroundSize = "100% 100%"
}

function background2(){
    document.body.style.background = "#f3f3f3 url('./images/casino_room.jpg') no-repeat center center";
    document.body.style.backgroundSize = "100% 100%"

}

function background3(){
    document.body.style.background = "#f3f3f3 url('./images/terracotta background.png') no-repeat right top";
    document.body.style.backgroundSize = "100% 100%"

}

