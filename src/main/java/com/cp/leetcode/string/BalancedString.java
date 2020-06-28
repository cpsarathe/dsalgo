package com.cp.leetcode.string;

/**
 * https://leetcode.com/problems/split-a-string-in-balanced-strings
 *
 * Example 1:
 *
 * Input: s = "RLRRLLRLRL"
 * Output: 4
 * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 * Example 2:
 *
 * Input: s = "RLLLLRRRLR"
 * Output: 3
 * Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
 * Example 3:
 *
 * Input: s = "LLLLRRRR"
 * Output: 1
 * Explanation: s can be split into "LLLLRRRR".
 *
 */
public class BalancedString {
    public static void main(String[] ar) {
        BalancedString obj = new BalancedString();
        System.out.println(obj.balancedStringSplit("RLLLLRRRLR"));
    }

    public int balancedStringSplit(String s) {
        // I looked at pattern carefully and realized strng could start from either L or R
        // we consider one split or balanced when count of L and count of R matches
        // with this I defined two pointers rCount and lCount which will increase each time they encountered
        // if there is match of rCount and lCount we can consider it as one match and increase maxSplit counter
        // and reset lCount , rCount to 0
        int rCount = 0;
        int lCount = 0;
        int maxSplit = 0;
        int i = 0;
        while(i<s.length()) {
            if(s.charAt(i)=='L'){
                lCount++;
            }
            if(s.charAt(i)=='R'){
                rCount++;
            }
            if(lCount==rCount) {
                maxSplit++;
                lCount = 0;
                rCount = 0;
            }
            i++;
        }
        return maxSplit;
    }

}
