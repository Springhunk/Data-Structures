package com.linkedlist;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class LinkedList <T> {
    public class Node {
        private T item;
        private Node next;

        public Node(T item) {
            this.item = item;
        }
    }

    private Node head;
    private Node tail;
    int count = 0;

    public void insert(int index, T item) {
        if (index < 0 || index > count) {
            throw new IllegalArgumentException();
        }
        Node cur = head;
        Node new_node = new Node(item);
        int cur_index = 0;
        while (cur != null) {
            if (cur_index == index) {
                Node new_node2 = new Node(item);
                new_node.next = cur.next;
                cur.next = new_node;
                _set(index+1, cur.item);
                _set(index, new_node2.item);
                break;
            }
            cur = cur.next;
            cur_index++;
        }
        count++;
    }

    public void delete(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }

        if (index == 0) {
            head = head.next;
            count--;
            return;
        }

        if (index == count - 1) {
            tail = getPrev(tail);
            tail.next = null;
            count--;
            return;
        }

        Node cur = head;
        int cur_index = 0;
        while (cur != null) {
            Node last_node = cur;
            cur = cur.next;
            if (cur_index == index) {
                last_node.next = cur.next;
            }
            cur_index++;
        }
        count--;
    }

    public void addFirst(T item) {
        if (isEmpty()) {
            head = tail = new Node(item);
        } else {
            Node new_node = new Node(item);
            new_node.next = head;
            head = new_node;
        }
        count++;
    }

    public void addLast(T item) {
        if (isEmpty()) {
            head = tail = new Node(item);
        } else {
            tail.next = new Node(item);
            tail = tail.next;
        }
        count++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        head = head.next;
        count--;
    }

    public void removeLast() {
        tail = getPrev(tail);
        tail.next = null;
        count--;
    }

    public T get(int index) {
        if (isEmpty() || index >= length()) {
            throw new NoSuchElementException();
        }

        Node cur = head;
        int cur_index = 0;
        while (cur != null) {
            if (cur_index == index) {
                return cur.item;
            }
            cur = cur.next;
            cur_index++;
        }
        return null;
    }

    public void set(int index, T item) {
        if (isEmpty() || index >= count) {
            throw new IllegalArgumentException();
        }

        Node cur = head;
        int cur_index = 0;
        while (cur != null) {
            if (cur_index == index) {
                cur.item = item;
            }
            cur = cur.next;
            cur_index++;
        }
    }

    public boolean contains(T item) {
        Node cur = head;
        while (cur != null) {
            if (cur.item == item) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    private Node getPrev(Node node) {
       Node cur = head;
       while (cur != null) {
           if (cur.next == node) {
               return cur;
           }
           cur = cur.next;
       }
       return null;
    }

    public void print() {
        Node cur = head;
        StringJoiner res = new StringJoiner(" -> ", "", "");
        while (cur != null) {
            res.add("["+ cur.item +"]");
            cur = cur.next;
        }
        System.out.println(res);
    }

    public void printItems() {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.item);
            cur = cur.next;
        }
    }

    public int length() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private void _set(int index, T item) {
        if (isEmpty() || index > count) {
            throw new IllegalArgumentException();
        }

        Node cur = head;
        int cur_index = 0;
        while (cur != null) {
            if (cur_index == index) {
                cur.item = item;
            }
            cur = cur.next;
            cur_index++;
        }
    }
}
