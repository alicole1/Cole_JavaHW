public class PrintTri {
    public static void printTri(int n) {
        int currStars = 1;
        if (currStars == n) {
            for (int i = 0; i < n; i++) {
                System.out.print("*");
            }
            System.out.printf("%n");
        } else {
            for (int i = 0; i < currStars; i++) {
                System.out.print("*");
            }
            System.out.printf("%n");
            printTri(currStars + 1);
        }
    }

    public static void main(String[] args) {
        printTri(5);
    }

}
