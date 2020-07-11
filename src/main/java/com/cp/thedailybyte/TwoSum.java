package com.cp.thedailybyte;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return whether or not two numbers sum to a given target, k.
 * Note: you may not sum a number with itself.
 *
 * Ex: Given the following...
 *
 * [1, 3, 8, 2], k = 10, return true (8 + 2)
 * [3, 9, 13, 7], k = 8, return false
 * [4, 2, 6, 5, 2], k = 4, return true (2 + 2)
 *
 */
public class TwoSum {
    public static void main(String[] ar) {
        TwoSum obj = new TwoSum();
        int[] nums1 = {1,3,8,2};

        int[] nums2 = {3, 9, 13, 7};
        System.out.println(obj.isTwoSumExists(nums1,10) == true);
    }

    public boolean isTwoSumExists(int[] nums , int target){
        //There is straightforward way to run through two loops and check if two sum equals to target or not
        //However O(n2) is the complexity which is for sure is not expected

        //we need to find the way without O(N2) can we do it.
        //if target is madeup of values present in array then we can
        //target - val = anotherVal
        //10-8 = 2

        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0 ;i<nums.length ;i++){
            map.put(target - nums[i], i);
        }

        for(int i =0 ;i<nums.length ;i++){
            int c =  target - nums[i];
            if(map.containsKey(c) && map.containsKey(nums[i])){
                return true;
            }
        }

        return false;
    }
}
