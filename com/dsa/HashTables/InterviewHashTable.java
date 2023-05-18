package com.dsa.HashTables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InterviewHashTable {




    // Interview Question.
    public static char firstNonRepeatingCharacterIn(String string) {

        Map<Character, Integer> map = new HashMap<>();

        char[] charArray = string.toCharArray();
        for (char ch : charArray) {
            var count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
        }

        for (char ch : charArray) {
            if (map.get(ch) == 1) return ch;
        }
            return Character.MIN_VALUE;
        }

    public static char firstReapeatingCharacterIn(String string) {

        Set<Character> set = new HashSet<>();

        for (var ch : string.toCharArray()) {
            if (set.contains(ch)) return ch;
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
    }

