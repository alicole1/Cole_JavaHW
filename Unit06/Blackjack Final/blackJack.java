// Ali Cole AT Java
// Unit 6 Project: Blackjack
import java.util.ArrayList;
import java.util.Scanner;

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

    public char getSuitAscii() {
        char suit = 'a';

        // Sets ascii code as easy to interpret chars.
        char spade = '\u2660';
        char heart = '\u2661';
        char club = '\u2663';
        char diamond = '\u2662';

        // If else ladder for suit.
        if (cardSuit == Suit.SPADE) {
            suit = spade;
        } else if (cardSuit == Suit.HEART) {
            suit = heart;
        } else if (cardSuit == Suit.CLUB) {
            suit = club;
        } else if (cardSuit == Suit.DIAMOND) {
            suit = diamond;
        }
        return suit;
    }

    public char getRankAscii() {
        char rank = 'a';
        // If else ladder for rank.
        if (cardRank == Rank.ACE) {
            rank = 'A';
        } else if (cardRank == Rank.TWO) {
            rank = '2';
        } else if (cardRank == Rank.THREE) {
            rank = '3';
        } else if (cardRank == Rank.FOUR) {
            rank = '4';
        } else if (cardRank == Rank.FIVE) {
            rank = '5';
        } else if (cardRank == Rank.SIX) {
            rank = '6';
        } else if (cardRank == Rank.SEVEN) {
            rank = '7';
        } else if (cardRank == Rank.EIGHT) {
            rank = '8';
        } else if (cardRank == Rank.NINE) {
            rank = '9';
        } else if (cardRank == Rank.TEN) {
            rank = 'T';
        } else if (cardRank == Rank.JACK) {
            rank = 'J';
        } else if (cardRank == Rank.QUEEN) {
            rank = 'Q';
        } else if (cardRank == Rank.KING) {
            rank = 'K';
        }
        
        return rank;
    }

    // Getter for string representing face.
    public String getFace() {
        String face;

        StringBuilder sb = new StringBuilder();

        sb.append(getSuitAscii());
        sb.append(getRankAscii());

        face = sb.toString();
        return face;
    }
}

public class blackJack {
    public enum EndType {WIN, LOSE, TIE, BLACKJACK};

    /** METHOD: hit (get a new card). */
    public static void hit(ArrayList<Card> currHand) {
        Card newCard = new Card();
        currHand.add(newCard);
    }

    /** METHOD: display one hand. */
    public static void displayHand(ArrayList<Card> currHand) {
        // Make and print line one: (should look something like this: "  ___   ___   ___ ")
        StringBuilder cardDisplay = new StringBuilder();
        for (int i = 0; i < currHand.size(); i++) {
            cardDisplay.append("  ___ ");
        }
        cardDisplay.append("%n");

        // Make and print line two: (should look something like this: " |K  | |2  | |6  |")
        for (int i = 0; i < currHand.size(); i++) {
            cardDisplay.append(" |" + currHand.get(i).getRankAscii() + "  |");
        }
        cardDisplay.append("%n");

        // Make and print line three: (should look something like this: " | ♦ | | ♥ | | ♠ |")
        for (int i = 0; i < currHand.size(); i++) {
            cardDisplay.append(" | " + currHand.get(i).getSuitAscii() + " |");
        }
        cardDisplay.append("%n");

        // Make and print line four: (should look something like this: " |__K| |__2| |__6|")
        for (int i = 0; i < currHand.size(); i++) {
            cardDisplay.append(" |__" + currHand.get(i).getRankAscii() + "|");
        }
        cardDisplay.append("%n");

        // Print entire string.
        System.out.printf(cardDisplay.toString());
    }

    /** METHOD: display (show current hand). */
    public static void display(ArrayList<Card> dealerHand, ArrayList<Card> playerHand, boolean isPreFlipDealer, int dealerTotal, int playerTotal) {
        clearScreen();
        System.out.printf("%n============== CURRENT HANDS: =============================================== %n");

        // Special display conditions for hidden dealer. One card shown; total hidden.
        if (isPreFlipDealer == true) {

            // Display the first two cards of dealers. One face down.
            StringBuilder sb = new StringBuilder();
            sb.append("  ___   ___ %n |");
            sb.append(dealerHand.get(0).getRankAscii());
            sb.append("  | |## | %n | ");
            sb.append(dealerHand.get(0).getSuitAscii());
            sb.append(" | |###| %n |__");
            sb.append(dealerHand.get(0).getRankAscii());
            sb.append("| |_##| %n");
            System.out.printf(sb.toString());
        
            // Display the total.
            System.out.printf("%nDEALER: ???%n");

        // Other dealer condition. All cards shown; total shown.
        } else {
            displayHand(dealerHand);
            System.out.printf("%nDEALER: " + dealerTotal + "%n");
        }

        // Display player cards and total.
        displayHand(playerHand);
        System.out.printf("%nPLAYER: " + playerTotal + "%n");
    }
    
    /** METHOD: collect total (add together rank of all cards in hand). */
    public static int getTotal(ArrayList<Card> currHand) {
        int total = 0;
        int aceCounter = 0;
        for (int i = 0; i<currHand.size(); i++) {
            Card.Rank cardRank = currHand.get(i).getRank();

            // If else ladder for rank component.
            if (cardRank == Card.Rank.ACE) {
                aceCounter++;
            } else if (cardRank == Card.Rank.TWO) {
                total = total + 2;
            } else if (cardRank == Card.Rank.THREE) {
                total = total + 3;
            } else if (cardRank == Card.Rank.FOUR) {
                total = total + 4;
            } else if (cardRank == Card.Rank.FIVE) {
                total = total + 5;
            } else if (cardRank == Card.Rank.SIX) {
                total = total + 6;
            } else if (cardRank == Card.Rank.SEVEN) {
                total = total + 7;
            } else if (cardRank == Card.Rank.EIGHT) {
                total = total + 8;
            } else if (cardRank == Card.Rank.NINE) {
                total = total + 9;
            } else if (cardRank == Card.Rank.TEN || cardRank == Card.Rank.JACK || cardRank == Card.Rank.QUEEN || cardRank == Card.Rank.KING) {
                total = total + 10;
            } else if (cardRank == Card.Rank.ACE && total <= 10) {
                total = total + 11;
            } 
        }
        for (int i = 0; i<aceCounter; i++) {
            if (total <= 10) {
                total = total + 11;
            } else {
                total++;
            }
        }
        return total;
    }

    /** METHOD: clear screen */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    /** METHOD: delay */
    public static void delay(long msec) {
        try {
            Thread.sleep(msec);
        } catch (Exception e) {
        }
    }

    /** METHOD: end condition */
    public static boolean itsOver (String endMessage, EndType outcome) {
        // Set up strings for end screens
        String winScreen = "__   _____  _   _  __      _____ _  _   _ %n\\ \\ / / _ \\| | | | \\ \\    / /_ _| \\| | | | %n \\ V / (_) | |_| |  \\ \\/\\/ / | || .` | |_| %n  |_| \\___/ \\___/    \\_/\\_/ |___|_|\\_| (_) %n%n";
        String loseScreen = "__   _____  _   _   _    ___  ___ ___   %n\\ \\ / / _ \\| | | | | |  / _ \\/ __| __|  %n \\ V / (_) | |_| | | |_| (_) \\__ \\ _| _ %n  |_| \\___/ \\___/  |____\\___/|___/___(_) %n%n";
        String tieScreen = "__   _____  _   _   _____ ___ ___ ___ %n\\ \\ / / _ \\| | | | |_   _|_ _| __|__ \\%n \\ V / (_) | |_| |   | |  | || _|  /_/%n  |_| \\___/ \\___/    |_| |___|___|(_) %n%n";
        String blackjackScreen = " ___ _      _   ___ _  __  _  _   ___ _  __  _ _ %n| _ ) |    /_\\ / __| |/ / | |/_\\ / __| |/ / | | |%n| _ \\ |__ / _ \\ (__| ' < || / _ \\ (__| ' <  |_|_|%n|___/____/_/ \\_\\___|_|\\_\\__/_/ \\_\\___|_|\\_\\ (_|_) %n%n";

        System.out.println(endMessage);
        delay(750);

        if (outcome == EndType.LOSE) {
            System.out.printf(loseScreen);
        } else if (outcome == EndType.WIN) {
            System.out.printf(winScreen);
        } else if (outcome == EndType.TIE) {
            System.out.printf(tieScreen);
        } else if (outcome == EndType.BLACKJACK) {
            System.out.printf(blackjackScreen);
        }

        for (int i = 0; i < 3; i++) {
            System.out.print(". ");
            delay(250);
        }
        return false;
    }
    
    /** MAIN LOOP */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Set up boolean to break out of playing loop.
        boolean playing = false;

        clearScreen();

        while (true) { 
            // ASKS USER IF THEY WANT TO PLAY
            String playerResponse = "";
            System.out.print("Would you like to play a hand of blackjack? (y/n): ");
            playerResponse = scan.nextLine().toLowerCase();
            if (playerResponse.equals("n")) {
                System.out.println("Thanks for playing :)");
                break;
            } else if (playerResponse.equals("y")) {
                playing = true;
            }

            // IF YES, BLACKJACK LOOP
            while (playing == true) { 

                // Build dealers hand.
                ArrayList<Card> dealerHand = new ArrayList<Card>();
                int dealerTotal = getTotal(dealerHand);
                

                // Build players hand.
                ArrayList<Card> playerHand = new ArrayList<Card>();
                int playerTotal = getTotal(playerHand);
                
                // Show with no cards.
                display(dealerHand, playerHand, false, dealerTotal, playerTotal);
                delay(500);

                // Show with only one dealer card.
                hit(dealerHand);
                dealerTotal = getTotal(dealerHand);
                display(dealerHand, playerHand, false, dealerTotal, playerTotal);
                delay(500);

                // Show with one player one dealer.
                hit(playerHand);
                playerTotal = getTotal(playerHand);
                display(dealerHand, playerHand, false, dealerTotal, playerTotal);
                delay(500);

                // Show with one player two dealer.
                hit(dealerHand);
                dealerTotal = getTotal(dealerHand);
                display(dealerHand, playerHand, true, dealerTotal, playerTotal);
                delay(500);

                // Show two player two dealer.
                hit(playerHand);
                playerTotal = getTotal(playerHand);
                display(dealerHand, playerHand, true, dealerTotal, playerTotal);
                      
                // Check for if dealer needs to check for blackjack.
                if (dealerHand.get(0).getRank() == Card.Rank.ACE 
                || dealerHand.get(0).getRank() == Card.Rank.KING 
                || dealerHand.get(0).getRank() == Card.Rank.QUEEN
                || dealerHand.get(0).getRank() == Card.Rank.JACK
                || dealerHand.get(0).getRank() == Card.Rank.TEN) {
                    System.out.print("Dealer checking second card");
                    for (int i = 0; i < 3; i++) {
                        System.out.print(".");
                        delay(250);
                    }
                    if (dealerTotal == 21) {
                        display(dealerHand, playerHand, false, dealerTotal, playerTotal);
                    } else {
                        display(dealerHand, playerHand, true, dealerTotal, playerTotal);
                    }
                }

                // Check for "end conditions".
                // Tie: both dealer and player get blackjack.
                if (dealerTotal == 21 && playerTotal == 21) {
                    display(dealerHand, playerHand, false, dealerTotal, playerTotal);
                    playing = itsOver("You and dealer both got blackjack.", EndType.TIE);
                    break;
                // Win: player gets blackjack.
                } else if (playerTotal == 21) {
                    display(dealerHand, playerHand, false, dealerTotal, playerTotal);
                    playing = itsOver("Woah!!!", EndType.BLACKJACK);
                    break;
                // Lose: dealer gets blackjack.
                } else if (dealerTotal == 21) {
                    display(dealerHand, playerHand, false, dealerTotal, playerTotal);
                    playing = itsOver("Dealer got blackjack.", EndType.LOSE);
                    break;
                }

                // Player choices.
                while (! playerResponse.equals("s")) {
                    System.out.print("(H)it or (S)tand: ");
                    playerResponse = scan.nextLine().toLowerCase();
                    
                    // If the player hits.
                    if (playerResponse.equals("h")) {
                        System.out.print("Dealer is drawing your card");
                        for (int i = 0; i < 3; i++) {
                            System.out.print(".");
                            delay(250);
                        }
                        display(dealerHand, playerHand, true, dealerTotal, playerTotal);

                        hit(playerHand);
                        playerTotal = getTotal(playerHand);


                        // Tell players what they got.
                        System.out.print("You drew a " + playerHand.get(playerHand.size()-1).getRankAscii() + " of " + playerHand.get(playerHand.size()-1).getSuitAscii());
                        delay(750);

                        // Display new hand.
                        display(dealerHand, playerHand, true, dealerTotal, playerTotal);

                        // Account for busting.
                        if (playerTotal > 21) {
                            playing = itsOver("Aww man. You busted.", EndType.LOSE);
                            break;
                        }
                    }
                }
                
                // Breaks out of loop if player busted.
                if (playing == false) {
                    break;
                }

                // Dealer reveals their card.
                System.out.print("Dealer is revealing flipped card");
                for (int i = 0; i < 3; i++) {
                    System.out.print(".");
                    delay(250);
                }
                display(dealerHand, playerHand, true, dealerTotal, playerTotal);
                System.out.print("Dealer was holding a " + dealerHand.get(dealerHand.size()-1).getRankAscii() + " of " + dealerHand.get(dealerHand.size()-1).getSuitAscii());
                delay(750);

                // Shows with dealer face up.
                display(dealerHand, playerHand, false, dealerTotal, playerTotal);

                // Has dealer hit until they get over 17.
                while (dealerTotal < 17) {
                    System.out.print("Dealer is hitting");
                    for (int i = 0; i < 3; i++) {
                        System.out.print(".");
                        delay(250);
                    }
                    display(dealerHand, playerHand, false, dealerTotal, playerTotal);

                    hit(dealerHand);
                    dealerTotal = getTotal(dealerHand);
                    // Tell players what dealer got.
                    System.out.print("Dealer drew a " + dealerHand.get(dealerHand.size()-1).getRankAscii() + " of " + dealerHand.get(dealerHand.size()-1).getSuitAscii());
                    delay(1000);

                    display(dealerHand, playerHand, false, dealerTotal, playerTotal);
                }

                // Checks final "end conditions".
                if (dealerTotal > 21) {
                    playing = itsOver("Dealer busts!", EndType.WIN);
                } else if (playerTotal > dealerTotal) {
                    playing = itsOver("You scored more than dealer!", EndType.WIN);
                } else if (playerTotal == dealerTotal) {
                    playing = itsOver("You and dealer scored the same.", EndType.TIE);
                } else if (dealerTotal > playerTotal) {
                    playing = itsOver("Dealer scored more than you.", EndType.LOSE);
                }
                break;
            }
        }
    }
}