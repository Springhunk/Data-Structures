package com.linkedlist;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();
        l.addLast(10);
        l.addLast(20);
        l.addLast(30);
        l.addFirst(0);
        l.removeFirst();
        System.out.println(l.length());
        l.print();
    }
}
