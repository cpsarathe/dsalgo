package com.cp.leetcode.string;

/**
 * https://leetcode.com/problems/add-strings/
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class AddTwoStrings {

    public static void main(String[] ar) {
        AddTwoStrings obj = new AddTwoStrings();
        System.out.println(obj.addStrings("0","9"));
    }

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int k = 0;
        int carry = 0;
        String big = num1.length() >= num2.length() ? num1 : num2;
        String small = num1.length() < num2.length() ? num1 : num2;
        int j = small.length() - 1;
        for(int i= big.length()-1 ; i>=0; i--){
            char c1 = big.charAt(i);
            if(j<0 && i>=0 ) {
                int x1 = Character.getNumericValue(big.charAt(i));
                int res = x1 + carry;
                sb.insert(k,res % 10);
                carry = res / 10;
            }
            else if(j>=0 && i<0 ) {
                int x2 = Character.getNumericValue(small.charAt(j));
                int res = x2 + carry;
                sb.insert(k,res % 10);
                carry = res / 10;
            } else {
                char c2 = small.charAt(j);
                int x1 = Character.getNumericValue(c1);
                int x2 = Character.getNumericValue(c2);
                int y  = carry + x1 + x2 ;
                if(y > 9) {
                    carry = y / 10;
                    y = y % 10;
                } else {
                    carry = 0;
                }
                sb.insert(k,y);
            }

            k++;
            j--;
        }
        if(carry > 0) {
            sb.insert(k,carry);
        }
        return sb.reverse().toString();

    }

}
