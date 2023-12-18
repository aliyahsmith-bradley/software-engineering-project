
export function evaluateHandStrength(hand) {
    const ranks = getRanks(hand);

    // Sort ranks in descending order
    ranks.sort((a, b) => b - a);

    // Return the highest card in the hand
    return ranks[0];
}

function getRanks(hand) {
    // Extract the ranks from the card names
    return hand.map(card => getRankFromCard(card));
}

function getRankFromCard(card) {
    // Assuming the card names follow the format: [rank]_of_[suit]
    const rankString = card.split("_of_")[0];

    // Convert ranks to numeric values
    switch (rankString) {
        case "2": return 2;
        case "3": return 3;
        case "4": return 4;
        case "5": return 5;
        case "6": return 6;
        case "7": return 7;
        case "8": return 8;
        case "9": return 9;
        case "10": return 10;
        case "jack": return 11;
        case "queen": return 12;
        case "king": return 13;
        case "ace": return 1;
        default: return 0; // Default to 0 if unknown rank
    }
}