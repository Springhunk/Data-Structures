package com.javadynamicarray;

public class Main {

    public static void main(String[] args) {
        int[] test = {1200, 32560};
        DArray numbers = new DArray(4);
        numbers.append(10);
        numbers.append(20);
        numbers.append(30);
        numbers.append(40);
        numbers.extend(test);
        numbers.insert(0, 100);
        numbers.print();

        System.out.println(numbers.length());
    }
}