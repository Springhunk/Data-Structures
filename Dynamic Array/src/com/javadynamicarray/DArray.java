package com.javadynamicarray;

import java.util.Arrays;

public class DArray {
    private int[] items;
    private int count;

    // Constructor
    public DArray(int length) {
        items = new int[length+1];
    }

    // Append to end of array
    public void append(int item) {
        // If the array is full, resize it.
        if (items.length == count) {
            int[] new_items = new int[count*2];
            System.arraycopy(items, 0, new_items, 0, count);
            items = new_items;
        }
        // Add the new item at the end.
        items[count++] = item;
    }

    // Insert item at specific index
    public void insert(int index, int item) {
        if (index < 0|| index >= count) {
            throw new IllegalArgumentException();
        }

        int[] new_items = new int[count*2];
        // Copy elements to new_items
        for (int i = count-1; i >= index; i--) {
            items[i+1] = items[i];
        }
        items[index] = item;
        count++;
    }

    // Extend the array with the value of another array
    public void extend(int[] item) {
        for (int i : item) {
            append(i);
        }
    }

    // Remove first occurrence of item
    public void remove(int item) {
        for (int i = 0; i < count; i++) {
            if (items[i] == item) {
                removeAt(index(item));
            }
        }
    }

    // Remove at index
    public void removeAt(int index) {
        if (index < 0|| index >= count) {
            throw new IllegalArgumentException();
        }
        // Shift Items to the left
        System.arraycopy(items, index + 1, items, index, count - index);
        count--;
    }

    // Get Index of Item
    public int index(int item) {
        // If item is found, return the number of the iterations.
        for (int i = 0; i < count; i++) {
            if (items[i] == item)
                return i;
        }
        return -1;
    }

    // Set an index to the item
    public void set(int index, int item) {
        // Check if index exists.
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        items[index] = item;
    }

    public int get(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        return items[index];
    }

    // Bubble Sort
    public void bsort() {
        for (int i = 0; i < count; i++) {
            for (int j = 1; j < count; j++) {
                if (items[j] < items[j-1]) {
                    int temp = items[j];
                    items[j] = items[j-1];
                    items[j-1] = temp;
                }
            }
        }
    }

    // Insertion Sort
    public void isort() {
        for (int i = 1; i < count; i++) {
            int current = items[i];
            int j = i - 1;
            while (j >= 0 && items[j] > current) {
                items[j + 1] = items[j];
                j--;
            }
            items[j+1] = current;
        }
    }

    // Reverse the array
    public void reverse() {
        for (int i = 0; i < count/2; i++) {
            int temp = items[i];
            items[i] = items[count - i - 1];
            items[count - i - 1] = temp;
        }
    }

    // Returns the count
    public int length() {
        return count;
    }

    // Check if item exists
    public boolean containsItem(int item) {
        // Check if item is in array.
        for (int i = 0; i < count; i++) {
            if (items[i] == item) {
                return true;
            }
        }
        return false;
    }

    // Check if array is empty
    public boolean isEmpty() {
        for (int i = 0; i < count; i++) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }

    // Clear the array
     public void clear() {
         items = null;
         count = 0;
     }

    // Print the array as a string
    public void print() {
        int[] new_items = new int[count];
        if (count >= 0) System.arraycopy(items, 0, new_items, 0, count);
        System.out.println(Arrays.toString(new_items));
    }

    // Iterate and print every item in the array
    public void printItems() {
        for (int i : items) {
            System.out.println(i);
        }
    }
}
