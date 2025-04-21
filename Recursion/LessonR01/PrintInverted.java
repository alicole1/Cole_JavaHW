public class PrintInverted {
    public static void printInverted(int n) {
        if (n == 1) {
            System.out.println("*");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.print("*");
            }
            System.out.printf("%n");
            printInverted(n - 1);
        }
    }

    public static void main(String[] args) {
        printInverted(5);
    }
}