package com.cp.thedailybyte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given two integer arrays, return their intersection.
 * Note: the intersection is the set of elements that are common to both arrays.
 *
 * Ex: Given the following arrays...
 *
 * nums1 = [2, 4, 4, 2], nums2 = [2, 4], return [2, 4]
 * nums1 = [1, 2, 3, 3], nums2 = [3, 3], return [3]
 * nums1 = [2, 4, 6, 8], nums2 = [1, 3, 5, 7], return []
 */
public class IntersectionOfArrays {

    public static void main(String[] ar) {
        IntersectionOfArrays obj = new IntersectionOfArrays();
        System.out.println(Arrays.equals(obj.intersection(new int[]{2, 4, 4, 2}, new int[]{2,4}) , new int[]{2,4}));
        System.out.println(Arrays.equals(obj.intersection(new int[]{2, 4, 6, 8}, new int[]{1, 3, 5, 7}) , new int[]{}));

        System.out.println("*******************************************");

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        //Here intersection means finding common elements in both array and storing it in output
        //If Brute force approach we have to loop through both array one inside another
        //that will be O(n*2)

        //For better way  , we can use Map to store num1s element with their counter.
        //we then loop through nums2 element and check if they exist in num1
        //if they exist in num1 that means we got our eligible output to store in list
        //since we dont want to show duplicates we can remove from map this key

        //O(n) space complexity for nums1 to store it in MAP
        //O(n) time complexity for nums2 to loop through

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int x = nums1[i];
            if (map.get(x) == null) {
                map.put(x, 1);
            } else {
                map.put(x, map.get(x) + 1);
            }
        }

        List<Integer> list = new ArrayList<Integer>();
        int k = 0;
        for (int i = 0; i < nums2.length; i++) {
            int x = nums2[i];
            if (map.containsKey(x)) {
                list.add(x);
                k++;
                map.remove(x);
            }
        }

        int[] output = list.stream().mapToInt(Integer::intValue).toArray();

        return output;
    }

}
