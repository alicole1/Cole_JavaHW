// Ali Cole AT Java
// Unit 06 Lesson 17 - Multidimensional Arrays
// Part B

public class PartB {
    public static void printArray(int[][] array) {
        for (int i = 0; i<array.length; i++) {
            System.out.print("  ");
            for (int j = 0; j<array[0].length; j++) {
                if (j == array[0].length - 1) {
                    System.out.println(array[i][j]);
                } else {
                    System.out.print(array[i][j] + ", ");
                }

            }
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        int[][] firstArray = {
            {8,6,7},
            {5,3,0},
        };

        int[][] secondArray = {
            {0,7,6,5},
            {2,2,0,1},
            {8,4,5,7},
        };

        System.out.println("First array:");
        printArray(firstArray);

        System.out.println("Second array:");
        printArray(secondArray);
    }
}