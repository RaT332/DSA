package com.gfg.questions.Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramChecker {
    // Brute Force
    // Time Complexity : O(n^2)
    // Space Complexity : O(total size of strings)
    static boolean brCheck(String a, String b){
        if (a.length() == b.length()) {
            int count=0;
            char[] second = b.toCharArray();
            for (char first : a.toCharArray()) {
                for (int i = 0; i < b.length(); i++) {
                    if (first == second[i]){
                        second[i]=0;
                        count++;
                        break;
                    }
                }
            }

            if (count == a.length())
                return true;

        }
        return false;
    }

    // Optimal Solution 1
    // Time Complexity : O(n)
    // Space Complexity : O(total size of strings)

    public static boolean o1Check(String a, String b) {
        if (a.length() != b.length())
            return false;

        char[] first = a.toCharArray();
        char[] second = b.toCharArray();

        Arrays.sort(first);
        Arrays.sort(second);

        for (int i = 0; i < a.length(); i++)
            if (first[i] != second[i])
                return false;

        return true;
    }

    // HashMap Approach (Optimal Solution)
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public static boolean o2Check(String a, String b) {

        Map<Character,Integer> map = new HashMap<>();

        if (a.length()!=b.length())
            return false;

        for (char ch : a.toCharArray())
            map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);

        for (char ch : b.toCharArray())
            if(map.containsKey(ch))
                    map.put(ch,map.get(ch)-1);

        for (var key : map.keySet())
            if(map.get(key)!=0)
                return false;

        return true;

        }
    // Two Count Approach (better Solution)
    // There can be 256 characters maximum
    // Time Complexity : O(n)
    // Space Complexity : O(256*2) -> O(1)
    public static boolean b1Check(String a,String b){

        int NO_OF_CHARS = 256;

        int[] count1 = new int[NO_OF_CHARS];
        int[] count2 = new int[NO_OF_CHARS];

        for (int i = 0; i < a.length() && i < b.length(); i++) {
            count1[a.toCharArray()[i]]++;
            count2[b.toCharArray()[i]]++;
        }

        for (int i = 0; i < NO_OF_CHARS; i++) {
            if(count1[i]!=count2[i])
                return false;
        }

    return true;

    }
    // One Count Approach (better Solution)
    // Time Complexity : O(n)
    // Space Complexity : O(256) -> O(1)
    public static boolean b2Check(String a,String b){

            int NO_OF_CHARS = 256;

            int[] count = new int[NO_OF_CHARS];


            for (int i = 0; i < a.length() && i < b.length(); i++) {
                count[a.toCharArray()[i]]++;
                count[b.toCharArray()[i]]--;
            }

            for (int i = 0; i < NO_OF_CHARS; i++) {
                if(count[i]!=0)
                    return false;
            }

            return true;

    }


    }

