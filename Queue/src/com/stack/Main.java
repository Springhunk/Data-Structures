package com.stack;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        System.out.println("Enqueue");
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.display();
        System.out.println("Dequeue");
        q.dequeue();
        q.display();
    }
}
