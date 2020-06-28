package com.cp.algos;

public class MergeSort {

    public static void main(String[] ar) {
        MergeSort obj = new MergeSort();
        int[] nums = {19,5,7};
        int start = 0;
        int end = nums.length;
        obj.merge_sort(nums,start,end-1);
        for(int i= start;i<end;i++){
            System.out.println(nums[i]);
        }
    }

    public void merge_sort(int[] nums , int start , int end){
        if(start<end){
            int mid = (start + end) / 2;
            merge_sort(nums,start,mid);
            merge_sort(nums,mid+1,end);
            merge(nums , start , mid , end);
        }
    }

    public void merge(int[] nums , int start , int mid , int end){
        int i = start, j = mid + 1 , k = 0;
        int[] temp = new int[end - start + 1];
        while(i<=mid && j<=end){
            if(nums[i] > nums[j]) {
                temp[k] = nums[j];
                k++; j++;
            } else {
                temp[k] = nums[i];
                k++; i++;
            }
        }

        while(i<=mid){
            temp[k] = nums[i];
            i++;
            k++;
        }

        while(j<=end){
            temp[k] = nums[j];
            j++;
            k++;
        }

        // copy temp to original nums array
        for(i = start; i <= end; i++) {
            nums[i] = temp[i - start];
        }
    }
}
