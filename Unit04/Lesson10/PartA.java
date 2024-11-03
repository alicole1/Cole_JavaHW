public class PartA {
    public static void main(String[] args) {
        /* 
        * Provided Code:
        String name = "Harry";
        System.out.println("The last letter of the name is " + name.charAt(name.length()));
        
        * What kind of error?
        Runtime error; system cannot print charcter at 5 bc there is no char 5
        */

        String name = "Harry";
        System.out.println("The last letter of the name is " + name.charAt(name.length()-1));
    }
}