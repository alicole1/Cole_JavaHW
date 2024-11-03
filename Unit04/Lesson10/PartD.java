public class PartD {
    public static void main(String[] args) {

        for (int i = 1; i < 6; i++) {

            // Loop to add .s
            for (int a = 0; a < 5 - i; a++) {
                System.out.print(".");
            }

            // Loop to add numbers
            for (int b = 0; b < i; b++) {
                System.out.print(i);
            }
            
            // After each completeed line, go to next
            System.out.println("");
        }
    }
}
