package com.stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.StringJoiner;

public class Stack <T> {
    class Node {
        T data;
        Node next;
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    public Stack() {}

    public Stack(T first) {
        push(first);
        count = 1;
    }

    public void push(T item) {
        if (isEmpty()) {
            head = tail = new Node(item);
        } else {
            tail.next = new Node(item);
            tail = tail.next;
        }
        count++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T temp = tail.data;
        removeLast();
        return temp;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return tail.data;
    }

    public T get(int index) {
        Node cur = head;
        int cur_index = 0;
        while (cur != null) {
            if (cur_index == index) {
                return cur.data;
            }
            cur = cur.next;
            cur_index++;
        }
        return null;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int length() {
        return count;
    }

    public void display() {
        Node cur = head;
        StringJoiner res = new StringJoiner(" -> ");
        while (cur != null) {
            res.add("["+cur.data+"]");
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

    // Private Linked List Methods for Stack Data Structure
    private void removeLast() {
        tail = getPrevious(tail);
        tail.next = null;
        count--;
    }

    private Node getPrevious(Node node) {
        Node cur = head;
        while (cur != null) {
            if (cur.next == node) {
               return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
