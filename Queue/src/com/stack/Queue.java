package com.stack;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class Queue <T> {

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    Queue() {}

    Queue(T item) {
        this.head = new Node(item);
        count = 1;
    }

    public void enqueue(T item) {
        if (isEmpty()) {
           head = tail = new Node(item);
        } else {
            tail.next = new Node(item);
            tail = tail.next;
        }
        count++;
    }

    public void dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        head = head.next;
        count--;
    }

    public int length() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void display() {
        Node cur = head;
        StringJoiner res = new StringJoiner(" -> ");
        while (cur != null) {
            res.add("["+(cur.data)+"]");
            cur = cur.next;
        }
        System.out.println(res);
    }

    public void printItems() {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

}
