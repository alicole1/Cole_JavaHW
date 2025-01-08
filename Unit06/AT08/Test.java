import org.derryfield.util.Random;

public class Test {
   public static void main(String[] args) {
       int number = Random.getRandomInteger(6);
       System.out.println("The random integer is " + number);
   }
}
