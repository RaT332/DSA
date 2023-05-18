package com.dsa.Array;


import java.util.Arrays;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
            resizeIfNeeded();
        items[count++] = item;
    }

    public void insertAt(int item, int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();
        resizeIfNeeded();
        for (int i = count; i > index; i--) {
            items[i] = items[i-1];
        }
        items[index]=item;
        count++;
    }
    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++)
            items[i] = items[i + 1];

        count--;

    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++)
            if (item == items[i]) return i;
        return -1;
    }

    public int max() {
        int max = 0;
        for (int i = 0; i < count; i++) {
            if (max < items[i]) max = items[i];
        }
        return max;
    }

    public Array intersect(Array another) {
        var intersection = new Array(count);
        for (int item : items)
            if (another.indexOf(item)>=0)
                intersection.insert(item);

        return intersection;


    }

    public void reverse() {
       var reversed = new int[count];
        for (int i = 0; i < count; i++) reversed[i] = items[count-i-1];

        items = reversed;

    }

    public void resizeIfNeeded() {
        if (items.length == count){
        var newItems = new int[count*2];
        for (int i = 0; i < count; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
        }
    }
    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }


}
