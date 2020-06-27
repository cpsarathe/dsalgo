package com.cp.leetcode.array;

/**
 * https://leetcode.com/problems/running-sum-of-1d-array
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 * Example 2:
 *
 * Input: nums = [1,1,1,1,1]
 * Output: [1,2,3,4,5]
 * Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
 *
 */
public class RunningSum {

    public static void main(String[] ar) {
        int[] nums = {3,1,2,10,1};
        int[] output = new int[nums.length];
        //if we look pattern  running sum is sum of all the records so far
        //in just one iteration O(n) and with O(1) space complexity we could achieve it.
        int sum = 0;
        for(int i=0;i<nums.length;i++) {
            sum = sum + nums[i];
            output[i] = sum;
        }
        for(int i=0;i<output.length;i++) {
            System.out.println(output[i]);
        }

    }

}

