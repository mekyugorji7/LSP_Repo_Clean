package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a set of integers.
 * A set is a collection of elements with no duplicates.
 * This implementation stores integers and provides various set operations.
 * 
 * @author Chukwuemeka Ugorji
 * @version 1.0
 * @see ArrayList
 */

public class IntegerSet {
    // Store the set elements in an ArrayList.
    private List<Integer> set = new ArrayList<Integer>();

    /**
     * Default Constructor - creates an empty set
     */
    public IntegerSet() {
    }

    /**
     * Constructor to initialize the set with existing elements
     * @param set ArrayList of integers to initialize the set
     */
    public IntegerSet(ArrayList<Integer> set) {
        // Filter out duplicates
        for (Integer item : set) {
            if (!this.set.contains(item)) {
                this.set.add(item);
            }
        }
    }

    /**
     * Clears the internal representation of the set
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the length of the set
     * 
     * @return The number of elements in the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Determines if two sets are equal
     * Two sets are equal if they contain all of the same values in ANY order
     * 
     * @param o Object to compare with
     * @return true if the sets are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        IntegerSet that = (IntegerSet) o;
        
        if (this.length() != that.length()) return false;
        
        // Check if all elements in this set are in the other set
        for (Integer item : this.set) {
            if (!that.contains(item)) {
                return false;
            }
        }
        
        return true;
    }

    /**
     * Checks if the set contains a specific value
     * 
     * @param value The value to check
     * @return true if the value is in the set, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Finds the largest element in the set
     * 
     * @return The largest element in the set
     * @throws IllegalStateException if the set is empty
     */
    public int largest() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot find largest element in an empty set");
        }
        
        int max = set.get(0);
        for (Integer item : set) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }

    /**
     * Finds the smallest element in the set
     * 
     * @return The smallest element in the set
     * @throws IllegalStateException if the set is empty
     */
    public int smallest() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot find smallest element in an empty set");
        }
        
        int min = set.get(0);
        for (Integer item : set) {
            if (item < min) {
                min = item;
            }
        }
        return min;
    }

    /**
     * Adds an item to the set if it's not already present
     * 
     * @param item The integer to add to the set
     */
    public void add(int item) {
        if (!contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if it's present
     * 
     * @param item The integer to remove from the set
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Set union operation: adds all elements from intSetb to this set
     * 
     * @param intSetb The set to union with
     */
    public void union(IntegerSet intSetb) {
        for (int i = 0; i < intSetb.length(); i++) {
            int element = intSetb.set.get(i);
            if (!this.contains(element)) {
                this.add(element);
            }
        }
    }

    /**
     * Set intersection operation: keeps only elements that appear in both sets
     * 
     * @param intSetb The set to intersect with
     */
    public void intersect(IntegerSet intSetb) {
        List<Integer> result = new ArrayList<>();
        
        for (Integer item : this.set) {
            if (intSetb.contains(item)) {
                result.add(item);
            }
        }
        
        this.set = result;
    }

    /**
     * Set difference operation: removes elements that appear in intSetb
     * 
     * @param intSetb The set to subtract
     */
    public void diff(IntegerSet intSetb) {
        List<Integer> result = new ArrayList<>();
        
        for (Integer item : this.set) {
            if (!intSetb.contains(item)) {
                result.add(item);
            }
        }
        
        this.set = result;
    }

    /**
     * Set complement operation: keeps only elements in intSetb that are not in this set
     * 
     * @param intSetb The universe set
     */
    public void complement(IntegerSet intSetb) {
        List<Integer> result = new ArrayList<>();
        
        for (Integer item : intSetb.set) {
            if (!this.contains(item)) {
                result.add(item);
            }
        }
        
        this.set = result;
    }

    /**
     * Checks if the set is empty
     * 
     * @return true if the set has no elements, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set
     * 
     * @return A string representation of the set
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < set.size(); i++) {
            sb.append(set.get(i));
            if (i < set.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}