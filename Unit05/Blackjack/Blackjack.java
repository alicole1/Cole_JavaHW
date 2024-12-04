// Ali Cole AT Java
// Unit 5 Project: Card Class

import java.util.Random;

class Card {
    // Create public enums for rank and suit.
    public enum Suit {SPADE, HEART, CLUB, DIAMOND};
    public enum Rank {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE};

    // Create private vars for this cards rank and suit.
    private Suit cardSuit;
    private Rank cardRank;

    // A private method that returns a random suit.
    private Suit randSuit() {
        int randSuitNum = (int) (Math.random() * 4); // Int from 0-3
        if (randSuitNum == 0) {
            return Suit.SPADE;
        } else if (randSuitNum == 1) {
            return Suit.HEART;
        } else if (randSuitNum == 2) {
            return Suit.CLUB;
        } else {
            return Suit.DIAMOND;
        }
    }

    // A private method that returns a random rank.
    private Rank randRank() {
        int randRankNum = 1 + (int) (Math.random() * 13); // Int from 1-13
        if (randRankNum == 1) {
            return Rank.ACE;
        } else if (randRankNum == 2) {
            return Rank.TWO;
        } else if (randRankNum == 3) {
            return Rank.THREE;
        } else if (randRankNum == 4) {
            return Rank.FOUR;
        } else if (randRankNum == 5) {
            return Rank.FIVE;
        } else if (randRankNum == 6) {
            return Rank.SIX;
        } else if (randRankNum == 7) {
            return Rank.SEVEN;
        } else if (randRankNum == 8) {
            return Rank.EIGHT;
        } else if (randRankNum == 9) {
            return Rank.NINE;
        } else if (randRankNum == 10) {
            return Rank.TEN;
        } else if (randRankNum == 11) {
            return Rank.JACK;
        } else if (randRankNum == 12) {
            return Rank.QUEEN;
        } else {
            return Rank.KING;
        }
    }

    // Constructor var that sets specifc vals for suit and rank.
    public Card(Suit givenCardSuit, Rank givenCardRank) {
        cardSuit = givenCardSuit;
        cardRank = givenCardRank;
    }

    // Construtor var that sets random vals for suit and rank.
    public Card() {
        cardSuit = randSuit();
        cardRank = randRank();
    }

    // Getter for rank.
    public Rank getRank() {
        return cardRank;
    }

    // Getter for suit.
    public Suit getSuit() {
        return cardSuit;
    }

    // Getter for string representing face.
    public String getFace() {
        String face;

        // Sets ascii code as easy to interpret chars.
        char spade = '\u2660';
        char heart = '\u2661';
        char club = '\u2663';
        char diamond = '\u2662';

        StringBuilder sb = new StringBuilder();

        // If else ladder for suit component.
        if (cardSuit == Suit.SPADE) {
            sb.append(spade);
        } else if (cardSuit == Suit.HEART) {
            sb.append(heart);
        } else if (cardSuit == Suit.CLUB) {
            sb.append(club);
        } else if (cardSuit == Suit.DIAMOND) {
            sb.append(diamond);
        }

        // If else ladder for rank component.
        if (cardRank == Rank.ACE) {
            sb.append('A');
        } else if (cardRank == Rank.TWO) {
            sb.append('2');
        } else if (cardRank == Rank.THREE) {
            sb.append('3');
        } else if (cardRank == Rank.FOUR) {
            sb.append('4');
        } else if (cardRank == Rank.FIVE) {
            sb.append('5');
        } else if (cardRank == Rank.SIX) {
            sb.append('6');
        } else if (cardRank == Rank.SEVEN) {
            sb.append('7');
        } else if (cardRank == Rank.EIGHT) {
            sb.append('8');
        } else if (cardRank == Rank.NINE) {
            sb.append('9');
        } else if (cardRank == Rank.TEN) {
            sb.append('T');
        } else if (cardRank == Rank.JACK) {
            sb.append('J');
        } else if (cardRank == Rank.QUEEN) {
            sb.append('Q');
        } else if (cardRank == Rank.KING) {
            sb.append('K');
        }

        face = sb.toString();
        return face;
    }
}

public class Blackjack {
    public static void main(String[] args) {
        // Construct card object with given rank and suit and display.
        Card card = new Card(Card.Suit.HEART, Card.Rank.QUEEN);
        String face = card.getFace();
        System.out.printf("The following card should be the queen of hearts,%n   %s%n", face);

        //  Display 10 random cards.
        System.out.println("10 random cards...");
        for (int i = 0; i<10; i++) {
            Card randCard = new Card(); // Construct new card object with rand rank and suit.
            System.out.println("   " + randCard.getFace()); 
        }
    }
}