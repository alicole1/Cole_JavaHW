import java.util.Arrays;

public class PartA {

    /*
     * method that swaps the values in the array.
     * takes the minimum position, the maximum position, and an array of ints as
     * arguments.
     */
    public static void swap(int min, int max, int[] array) throws Exception {
        try {
            // swaps the two numbers at the positions specified.
            int placeholder = array[min];
            array[min] = array[max];
            array[max] = placeholder;
        } catch (Exception e) {
            // throws an exception if the min / max falls outside the range.
            System.err.println("Oops! Specified integers are outside of range. No swap was done. ");
        }

    }

    public static void main(String[] args) throws Exception {
        // declares and initializes array of ints.
        int[] numbers = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // calls method.
        swap(2, 7, numbers);
        // prints new array to terminal.
        System.out.println(Arrays.toString(numbers));
    }
}
