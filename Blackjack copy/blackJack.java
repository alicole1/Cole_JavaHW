                } else if (playerTotal > dealerTotal) {
                    System.out.println("You win!");
                    delay(50);
                    System.out.println("WIN!");
                    delay(100);
                } else if (playerTotal == dealerTotal) {
                    System.out.println("You tie");
                    delay(50);
                    System.out.println("TIE!");
                    delay(100);
                } else if (dealerTotal > playerTotal) {
                    System.out.println("You lose :(");
                    delay(50);
                    System.out.println("LOSE");
                    delay(100);
                }
                playing = false;
                break;
            }

        }
        System.out.println("Loop broken");

    }
}