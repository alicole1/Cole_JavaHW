class Card {
    public enum SUIT {SPADE, HEART, CLUB, DIAMOND};
    public enum RANK {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE};

    private String cardSuit;
    private String cardRank;

    public Card(String cardSuit, String cardRank) {
        
    }

    public Card() {

    }

    public String getSuit() {
        char spade = '\u2660';
        char heart = '\u2661';
        char club = '\u2663';
        char diamond = '\u2662';

        return cardSuit;
    }

    public String getFace() {
        return cardRank;
    }


}

public class Unit5Proj {
    public static void main(String[] args) {
        
    }
}