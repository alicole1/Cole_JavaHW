
import java.util.Arrays;

public class PartA {
    public static void swap(int min, int max, int[] array) throws Exception {
        try {
            int placeholder = array[min];
            array[min] = array[max];
            array[max] = placeholder;
        } catch (Exception e) {
            System.err.println("Oops! Specified integers are outside of range. No swap was done. ");
        }

    }

    public static void main(String[] args) throws Exception {
        int[] numbers = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        swap(2, 7, numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
