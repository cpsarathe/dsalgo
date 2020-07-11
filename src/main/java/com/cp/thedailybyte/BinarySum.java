package com.cp.thedailybyte;

/**
 *  Given two binary strings (strings containing only 1s and 0s) return their sum (also as a binary string).
 * Note: neither binary string will contain leading 0s unless the string itself is 0
 *
 * Ex: Given the following binary strings...
 *
 * "100" + "1", return "101"
 * "11" + "1", return "100"
 * "1" + "0", return  "1"
 */
public class BinarySum {

    public static void main(String[] ar) {
        BinarySum obj = new BinarySum();
        System.out.println(obj.binarySum("110","11"));
    }

    public String binarySum(String first , String second) {
        int i = first.length() - 1;
        int j = second.length() - 1;
        int sum = 0 , carry = 0 , k=0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0 ) {
            sum = carry;
            if(i>=0) {
                sum = sum + first.charAt(i) - '0';
                i--;
            }
            if(j>=0) {
                sum = sum + second.charAt(j) - '0';
                j--;
            }
            sb.insert(k,sum%2);
            carry = sum / 2;
            k++;
        }
        if(carry>0){
            sb.insert(k,carry);
        }
        return sb.reverse().toString();
    }
}