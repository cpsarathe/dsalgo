package com.cp.leetcode.string;

/**
 * https://leetcode.com/problems/remove-vowels-from-a-string/
 */
public class RemoveVowels {

    public static void main(String[] ar) {
        RemoveVowels obj = new RemoveVowels();
        System.out.println(obj.removeVowels("aeiouyytwqueilk"));
    }

    public String removeVowels(String S) {
        //we can loop through each character and ignore when vowels found
        //if no vowels then add it in StringBuilder
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                continue;
            }
            sb.insert(k, chars[i]);
            k++;
        }
        return sb.toString();

    }
}
