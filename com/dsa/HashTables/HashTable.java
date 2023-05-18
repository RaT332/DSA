package com.dsa.HashTables;

import java.util.LinkedList;

public class HashTable {
    private static class Entry{
        private final int key;
        private String value;

        public Entry(int key, String value){
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries;

    public HashTable(int size){
        entries = new LinkedList[size];
    }


    public void put(int key,String value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        getOrCreateBucket(key).addLast(new Entry(key, value));
    }


    public String get(int key) {
        var entry = getEntry(key);
       return  entry == null ? null : entry.value;
    }

    public String remove(int key) {
        var entry = getEntry(key);
        if (entry == null)
            throw new IllegalStateException();

        var value = entry.value;
        getBucket(key).remove(entry);
        return value;

    }

    private Entry getEntry(int key) {
        var bucket = getBucket(key);
        if (bucket != null)
            for (var entry : bucket)
                if (entry.key == key)
                    return entry;

        return null;
    }

    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        var index = hash(key);
        if (entries[index] == null)
            entries[index] = new LinkedList<>();

        return entries[index];
    }
    private int hash(int key) {
        return key % entries.length;
    }

}
