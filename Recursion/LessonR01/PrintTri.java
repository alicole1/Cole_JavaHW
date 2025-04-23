public class PrintTri {
    public static void printTriHelper(int finalCount, int currCount) {
        if (currCount > finalCount) {
            return;
        }
        for (int i = 0; i < currCount; i++) {
            System.out.print("*");
        }
        System.out.printf("%n");
        printTriHelper(finalCount, currCount + 1);
    }

    public static void printTri(int n) {
        printTriHelper(n, 1);
    }

    public static void main(String[] args) {
        printTri(5);
    }

}
