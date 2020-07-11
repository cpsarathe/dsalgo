package com.cp.thedailybyte;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t return whether or not s is an anagram of t.
 * Note: An anagram is a word formed by reordering the letters of another word.
 * <p>
 * Ex: Given the following strings...
 * <p>
 * s = "cat", t = "tac", return true
 * s = "listen", t = "silent", return true
 * s = "program", t = "function", return false
 * Thanks,
 * The Daily Byte
 */
public class Anagram {

    public static void main(String[] ar) {
        Anagram obj = new Anagram();
        System.out.println(obj.isValidAnagram("rail safety", "fairy tales") == true);
        System.out.println(obj.isValidAnagram("listen", "silent") == true);
        System.out.println(obj.isValidAnagram("program", "function") == false);

        System.out.println("*******************************************");

        System.out.println(obj.isValidAnagramBetterApproach("rail safety", "fairy tales") == true);
        System.out.println(obj.isValidAnagramBetterApproach("listen", "silent") == true);
        System.out.println(obj.isValidAnagramBetterApproach("program", "function") == false);

        //can you do it better

    }

    public boolean isValidAnagram(String s1, String s2) {
        //Anagram should have same length string
        //We need to check if occurence of individual character in both string is same or not
        //we can run through two loop but that would be (N*2)
        //we can use two hashMap to store both string characters
        //we can run again the loop from one string and check if each of character present in another map
        //O(M+N) space and O(N) is time complexity
        int i = 0, j = 0;
        HashMap<Character, Integer> firstMap = new HashMap<>();
        HashMap<Character, Integer> secondMap = new HashMap<>();
        while (i < s1.length() || j < s2.length()) {
            if (i < s1.length()) {
                if (firstMap.get(s1.charAt(i)) == null) {
                    firstMap.put(s1.charAt(i), 1);
                } else {
                    firstMap.put(s1.charAt(i), firstMap.get(s1.charAt(i)) + 1);
                }
            }
            if (j < s2.length()) {
                if (secondMap.get(s2.charAt(j)) == null) {
                    secondMap.put(s2.charAt(j), 1);
                } else {
                    secondMap.put(s2.charAt(j), secondMap.get(s2.charAt(j)) + 1);
                }
            }
            i++;
            j++;
        }
        for (Map.Entry<Character, Integer> entry : firstMap.entrySet()) {
            Character c = entry.getKey();
            Integer val = entry.getValue();
            if (secondMap.get(c) == null || !secondMap.get(c).equals(val)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidAnagramBetterApproach(String s1, String s2) {
        //May be in one hashMap we could maintain counter and if we found counter of zero length or did not find
        //character in map we know its not anagram
        int i = 0, j = 0;
        HashMap<Character, Integer> firstMap = new HashMap<>();
        while (i < s1.length()) {
            if (firstMap.get(s1.charAt(i)) == null) {
                firstMap.put(s1.charAt(i), 1);
            } else {
                firstMap.put(s1.charAt(i), firstMap.get(s1.charAt(i)) + 1);
            }
            i++;
        }
        for (j = 0; j < s2.length(); j++) {
            Character c = s2.charAt(j);
            if (!firstMap.containsKey(c) || firstMap.get(c) == 0) {
                return false;
            } else {
                firstMap.put(c, firstMap.get(c) - 1);
            }
        }
        return true;
    }
}
