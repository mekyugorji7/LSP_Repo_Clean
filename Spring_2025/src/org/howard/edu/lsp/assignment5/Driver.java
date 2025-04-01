package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;

/**
 * Driver class to test the IntegerSet implementation
 * 
 * @author Chukwuemeka Ugorji
 * @version 1.0
 * @see IntegerSet
 */
public class Driver {
    
    public static void main(String[] args) {
        // Test default constructor and add method
        System.out.println("Testing default constructor and add method:");
        IntegerSet set1 = new IntegerSet();
        System.out.println("Initial set1: " + set1);
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("After adding 1, 2, 3 to set1: " + set1);
        
        // Test adding duplicate elements
        System.out.println("\nTesting adding duplicate element:");
        System.out.println("Before adding duplicate: " + set1);
        set1.add(2); // Should not add since 2 is already in the set
        System.out.println("After trying to add 2 again: " + set1);
        
        // Test length method
        System.out.println("\nTesting length method:");
        System.out.println("Value of set1 is: " + set1);
        System.out.println("Length of set1 is: " + set1.length());
        
        // Test contains method
        System.out.println("\nTesting contains method:");
        System.out.println("Value of set1 is: " + set1);
        System.out.println("set1 contains 2: " + set1.contains(2));
        System.out.println("set1 contains 5: " + set1.contains(5));
        
        // Test smallest and largest methods
        System.out.println("\nTesting smallest and largest methods:");
        System.out.println("Value of set1 is: " + set1);
        System.out.println("Smallest value in set1 is: " + set1.smallest());
        System.out.println("Largest value in set1 is: " + set1.largest());
        
        // Test remove method
        System.out.println("\nTesting remove method:");
        System.out.println("Value of set1 before removal: " + set1);
        set1.remove(2);
        System.out.println("Value of set1 after removing 2: " + set1);
        
        // Test ArrayList constructor
        System.out.println("\nTesting ArrayList constructor:");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(10); // Adding duplicate
        IntegerSet set2 = new IntegerSet(list);
        System.out.println("set2 created from ArrayList [10, 20, 30, 10]: " + set2);
        
        // Test isEmpty method
        System.out.println("\nTesting isEmpty method:");
        System.out.println("Is set1 empty? " + set1.isEmpty());
        IntegerSet emptySet = new IntegerSet();
        System.out.println("Is emptySet empty? " + emptySet.isEmpty());
        
        // Test clear method
        System.out.println("\nTesting clear method:");
        System.out.println("Value of set1 before clearing: " + set1);
        set1.clear();
        System.out.println("Value of set1 after clearing: " + set1);
        
        // Re-initialize set1 for further testing
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        // Test equals method
        System.out.println("\nTesting equals method:");
        IntegerSet set3 = new IntegerSet();
        set3.add(3);
        set3.add(2);
        set3.add(1);
        System.out.println("set1: " + set1);
        System.out.println("set3: " + set3);
        System.out.println("set1 equals set3: " + set1.equals(set3));
        
        System.out.println("set2: " + set2);
        System.out.println("set1 equals set2: " + set1.equals(set2));
        
        // Test union method
        System.out.println("\nTesting union method:");
        IntegerSet set4 = new IntegerSet();
        set4.add(3);
        set4.add(4);
        set4.add(5);
        
        System.out.println("Value of set1 before union: " + set1);
        System.out.println("Value of set4: " + set4);
        set1.union(set4);
        System.out.println("Result of union of set1 and set4: " + set1);
        
        // Test intersect method
        System.out.println("\nTesting intersect method:");
        IntegerSet set5 = new IntegerSet();
        set5.add(1);
        set5.add(2);
        set5.add(3);
        
        IntegerSet set6 = new IntegerSet();
        set6.add(3);
        set6.add(4);
        set6.add(5);
        
        System.out.println("Value of set5 before intersection: " + set5);
        System.out.println("Value of set6: " + set6);
        set5.intersect(set6);
        System.out.println("Result of intersection of set5 and set6: " + set5);
        
        // Test diff method
        System.out.println("\nTesting diff method:");
        IntegerSet set7 = new IntegerSet();
        set7.add(1);
        set7.add(2);
        set7.add(3);
        set7.add(4);
        
        IntegerSet set8 = new IntegerSet();
        set8.add(3);
        set8.add(4);
        set8.add(5);
        
        System.out.println("Value of set7 before difference: " + set7);
        System.out.println("Value of set8: " + set8);
        set7.diff(set8);
        System.out.println("Result of difference of set7 and set8 (set7 - set8): " + set7);
        
        // Test complement method
        System.out.println("\nTesting complement method:");
        IntegerSet set9 = new IntegerSet();
        set9.add(1);
        set9.add(2);
        
        IntegerSet universalSet = new IntegerSet();
        universalSet.add(1);
        universalSet.add(2);
        universalSet.add(3);
        universalSet.add(4);
        universalSet.add(5);
        
        System.out.println("Value of set9 before complement: " + set9);
        System.out.println("Value of universal set: " + universalSet);
        set9.complement(universalSet);
        System.out.println("Result of complement of set9 relative to universal set: " + set9);
    }
}