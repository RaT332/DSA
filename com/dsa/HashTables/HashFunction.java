package com.dsa.HashTables;

public class HashFunction {

    public static int hashValue(int key, int size) {
        return key % size;
    }

    public static int hashValue(String key,int size) {
        var hash = stringToInt(key);
        return hashValue(hash,size);
    }

    private static int stringToInt(String string) {
        int hash=0;
        for (var ch : string.toCharArray())
            hash += ch;
        return hash;
    }
}
