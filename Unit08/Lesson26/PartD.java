// Ali Cole
// Lesson 26 - Static Variables and Methods
// Part D

import java.util.ArrayList;

public class PartD {
    static void swap(ArrayList<Integer> list, int i, int j) {
        int placeholder = list.get(i);
        list.set(i, list.get(j));
        list.set(j, placeholder);
    }

    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<Integer>();
        myList.add(8);
        myList.add(6);
        myList.add(7);
        myList.add(5);
        myList.add(3);
        myList.add(0);
        myList.add(9);
        System.out.println("Before: " + myList);
        swap(myList, 2, 4);
        System.out.println("After:  " + myList);
    }
}
