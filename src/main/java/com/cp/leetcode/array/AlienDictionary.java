package com.cp.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
public class AlienDictionary {

    public static void main(String[] ar) {
        AlienDictionary alienDictionary = new AlienDictionary();
        alienDictionary.testCase1();
        alienDictionary.testCase2();
        alienDictionary.testCase3();
        alienDictionary.testCase4();
    }

    public void testCase1() {
        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words,order)==true ? "Pass" : "Fail");
    }

    public void testCase2() {
        String[] words = {"word","world","row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        System.out.println(isAlienSorted(words,order)==false ? "Pass" : "Fail");
    }

    public void testCase3() {
        String[] words = {"apple","app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words,order)==false ? "Pass" : "Fail");
    }

    public void testCase4() {
        String[] words = {"apap","app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words,order)==true ? "Pass" : "Fail");
    }

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> orderMap = new HashMap<>();
        for(int i=0;i<order.length();i++) {
            orderMap.put(order.charAt(i),i+1);
        }

        for(int i=1;i<=words.length-1;i++) {
            //first string is greater than second string return false
            if(comapareTwoString(words[i-1],words[i],orderMap) > 0 ){
                return false;
            }
        }

        return true;

    }

    public int comapareTwoString(String s1 , String s2 , Map<Character,Integer> orderMap) {
        int len1 = s1.length();
        int len2 = s2.length();
        int minL = Math.min(len1,len2);
        int k = 0;
        //loop for the minimum length of the string out of s1 , s2
        while(k < minL) {
            int cIndex1 = orderMap.get(s1.charAt(k));
            int cIndex2 = orderMap.get(s2.charAt(k));
            //if not equal return the difference , if -ve s1 < s2 , if +ve s1 > s2
            if(cIndex1 != cIndex2) {
                return cIndex1 - cIndex2;
            }
            k++;
        }
        //if still not identified smaller word, then check their length
        //if -ve s1 < s2 , if +ve s1 > s2
        return len1 - len2;
    }


}
