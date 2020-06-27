package com.cp.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public static void main(String[] ar) {
        TwoSum object = new TwoSum();
        int[] nums = {2, 7, 12, 15};
        int target = 19;
        int[] indices = object.twoSum(nums, target);
        System.out.println(indices[0] + " - " + indices[1]);

        System.out.println("**************");

        int[] indices1 = object.twoSumBetter(nums, target);
        System.out.println(indices1[0] + " - " + indices1[1]);
    }


    public int[] twoSum(int[] nums, int target) {
        //If we maintain 2 pointer and run loop by firstPointer starting from 0 and secondPointer is
        // fristPointer + 1 , in this way it will always compare one element of array wih another element.
        // if we found a match store indices and break to return;

        // worst case O(n2)
        int[] indices = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                    break;
                }
            }
        }

        //can we do it better
        //In our case what is fixes is two sum e.g a+b=c , which could be b = c - a
        //2 + 7 = 9 or 9 - 2 =7


        return indices;
    }

    public int[] twoSumBetter(int[] nums, int target) {
        //can we do it better
        //In our case what is fixed is two sum e.g a+b=c , which could be b = c - a
        //2 + 7 = 9 or 9 - 2 = 7

        //but we need something to lookup and map fits better here. Which adds O(n) space complexity
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        // worst case O(n)
        int[] indices = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if ( numsMap.containsKey(complement) && i != numsMap.get(complement) ) {
                indices[0] = i;
                indices[1] = numsMap.get(complement);
                break;
            }
        }
        return indices;
    }

}
