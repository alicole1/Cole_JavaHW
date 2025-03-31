// Ali Cole
// Lesson 33 - Creating an Interface
// Part B

public class Demo {
    public static void main(String[] args) {
        Animal elephant = new Animal("Tank", 10000);
        Animal ant = new Animal("Pipsqueak", 1);

        switch (ant.compareTo(elephant)) {
            case -1:
                System.out.println(ant.getName() + " has a smaller weight than " + elephant.getName());
                break;
            case 0:
                System.out.println(ant.getName() + " has the same weight as " + elephant.getName());
                break;
            case 1:
                System.out.println(ant.getName() + " has a larger weight than " + elephant.getName());
                break;
            default:
                throw new AssertionError();
        }
    }
}
