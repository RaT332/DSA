package com.dsa.LinkedList;

import java.util.NoSuchElementException;

public class LinkedList {
    private Node first;
    private Node last;
    private int count;

    private class Node {
        private int value;

        private Node next;

        private Node(int value) {
            this.value=value;
        }
    }

    public void addLast(int item) {
        var node = new Node(item);
        if (isEmpty()) first = last = node;
        else {
            last.next=node;
            last=node;
        }
        count++;
    }

    public void addFirst(int item) {
        var node = new Node(item);
        if (isEmpty()) first = last = node;
        else {
            node.next = first;
            first = node;
        }
        count++;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void removeFirst() {
        count--;
        ifEmptyOrOne();
        var previous = first;
        first = first.next;
        previous.next = null;
    }

    public void removeLast() {
        count--;
       ifEmptyOrOne();
       var previous = getPrevious(last);
       last = previous;
       last.next = null;

    }

    public int[] toArray() {
        int[] array = new int[count];
        var current = first;
        var i = 0;
        while (current != null) {
            array[i++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse() {
        if (isEmpty()) return;

        Node previous = first;
        Node current = first.next;
        while (current != last) {
            Node next=current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last.next=previous;
        first.next=null;
        last=first;
        first=current;
    }

    public int getKthNodeFromTheEnd(int k) {

        if (isEmpty())
            throw new IllegalStateException();

        Node p1;
        Node p2;
        p1 = p2 = first;

        //Increasing Distance Between Pointers.
        for (int index = 0; index < k-1; index++) {
            p2=p2.next;
            if (p2 == null)
                throw new IllegalArgumentException();
        }

        //Moving Pointers.
        while (p2 != last){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1.value;
    }

    public int size() {
        return count;
    }

    public void printMiddleExercise() {
         var a = first;
         var b = first;
         while (b != last && b.next != last) {
             b = b.next.next;
             a = a.next;
         }
         if (b == last)
             System.out.println(a.value);
          else
          System.out.println(a.value + "," + a.next.value);
    }
    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    private void ifEmptyOrOne() {
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last){
            first = last = null;
            return;
        }
    }

}

