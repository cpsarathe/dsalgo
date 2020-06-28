package com.cp.thedailybyte;

/**
 * Best Time to Buy and Sell Stock
 * Given an array of integers where the ith integer represents the price of the stock on day i,
 * return the largest possible profit from completing one transaction (i.e. buying 1 share and selling 1 share).
 * Examples: Given the following prices...
 *
 * // Buy on day 1 and sell on day 5 for a profit of 5 - 1 = 4.
 * prices = [1, 2, 3, 4, 5], return 4.
 * // Buy on day 4 and sell on day 9 for a profit of 11 - 1 = 10.
 * prices = [4, 5, 2, 1, 6, 10, 4, 9, 11], return 4.
 * // Buying and selling the stock at any point would yield a negative profit.
 * prices = [33, 18, 8, 2], return 0
 */
public class BestTimeToBuySellStock {

    public static void main(String[] ar) {
        BestTimeToBuySellStock obj = new BestTimeToBuySellStock();
        int[] nums = {4, 5, 2, 1, 6, 10, 4, 9, 11};
        int profit = obj.findMaxProfit(nums);
        System.out.println(profit);

        System.out.println(obj.findMaxProfitBetter(nums));
    }

    public int findMaxProfit(int[] nums){
        // since its day wise stock , its going to be contiguous array.
        // we need to have 2 loops - first pointer will be compared with all elements in the loop
        // and whichever offers maximum profit we will store it in profit variable.
        // this will go on until every element of first loop end up matching their next element
        // in second loop

        //complexity is O(n2)
        int profit = 0;
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++){
                  if(nums[j] > nums[i]) {
                      profit = Math.max(profit, nums[j] - nums[i]);
                  }
            }
        }
        return profit;
    }

    public int findMaxProfitBetter(int[] nums){
        // since its day wise stock , its going to be contiguous array.
        // in one iteration only we can keep on identifying min as well as
        // profit as the time we calculate profit is always from latest min.

        //complexity is O(n)
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) {
                if(nums[i] > min) {
                    profit = Math.max(profit, nums[i] - min);
                } else {
                    min = nums[i];
                }
        }
        return profit;
    }
}
