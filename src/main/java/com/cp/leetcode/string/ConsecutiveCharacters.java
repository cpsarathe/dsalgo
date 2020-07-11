package com.cp.leetcode.string;

/**
 *
 * https://leetcode.com/problems/consecutive-characters/
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 2
 * Explanation: The substring "ee" is of length 2 with the character 'e' only.
 * Example 2:
 *
 * Input: s = "abbcccddddeeeeedcba"
 * Output: 5
 * Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
 * Example 3:
 *
 * Input: s = "triplepillooooow"
 * Output: 5
 * Example 4:
 *
 * Input: s = "hooraaaaaaaaaaay"
 * Output: 11
 * Example 5:
 *
 * Input: s = "tourist"
 * Output: 1
 */
public class ConsecutiveCharacters {


    public static void main(String[] ar) {
        ConsecutiveCharacters obj = new ConsecutiveCharacters();
        System.out.println(obj.maxPower("leetcode") == 2);
        System.out.println(obj.maxPower("abbcccddddeeeeedcba") == 5);
        System.out.println(obj.maxPower("triplepillooooow") == 5);
        System.out.println(obj.maxPower("tourist") == 1);
    }

    public int maxPower(String s) {
        //we can solve this problem using two pointer
        //when ever we encounter consective charcaters we increase counter
        //if there is a mismatch
        //we assigned counter to max and it repeats until lopp ends and we endup finding max

        //o(n) time complexity
        int i = 0;
        int count = 1, max = 0;
        while(i < s.length()) {
            char c = s.charAt(i);
            char n = i+1 < s.length() ? s.charAt(i+1) : ' ';
            if(c==n) {
                count++;
            } else {
                max = Math.max(max,count);
                count = 1;
            }
            i++;
        }
        return max;
    }
}
