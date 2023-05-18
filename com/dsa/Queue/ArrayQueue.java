package com.dsa.Queue;

import java.util.Arrays;

public class ArrayQueue {
    private final int[] queue = new int[5];
    private int front;
    private int rear;
    private int count;

    public void enqueue(int item) {
        if (isFull())
            throw new IllegalStateException();
        queue[rear]=item;
        rear = (rear + 1) % queue.length;
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        var item = queue[front];
        queue[front]=0;
        front = (front + 1) % queue.length;
        count--;
        return item;
    }

    public int peek() {
        return queue[front];
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }

    public boolean isEmpty() {
        return count==0;
    }

    public boolean isFull() {
        return count == queue.length;
    }

}
