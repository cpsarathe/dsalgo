package com.cp.thedailybyte.arraystring;

import java.util.HashMap;

/**
 * Given a string, return the index of its first unique character. If a unique character does not exist, return -1.
 * <p>
 * Ex: Given the following strings...
 * <p>
 * "abcabd", return 2
 * "thedailybyte", return 1
 * "developer", return 0
 */
public class FirstUniqueCharacter {

    public static void main(String[] ar) {
        FirstUniqueCharacter obj = new FirstUniqueCharacter();
        System.out.println(obj.findFirstUniqueCharacterIndex("abcabd") == 2);
        System.out.println(obj.findFirstUniqueCharacterIndex("thedailybyte") == 1);
        System.out.println(obj.findFirstUniqueCharacterIndex("developer") == 0);
        System.out.println("*******************************************");

    }

    public int findFirstUniqueCharacterIndex(String s) {
        //we can use map to store counter of each character
        //we then loop through charcater of string
        //if character has count==1 thats a first unqiue charcater
        //we then return loop index
        //O(N) space
        //O(N) time

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
