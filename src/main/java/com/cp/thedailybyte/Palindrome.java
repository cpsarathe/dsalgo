package com.cp.thedailybyte;

/**
 * Note: a palindrome is a sequence of characters that reads the same forwards and backwards.
 *
 * Ex: Given the following strings...
 *
 * "level", return true
 * "algorithm", return false
 * "A man, a plan, a canal: Panama.", return true
 */
public class Palindrome {

    public static void main(String[] ar) {
        Palindrome obj = new Palindrome();
//        String str = "A man, a plan, a canal: Panama.";
        String str = "level";
        System.out.println(obj.isPalindrome(str));
    }

    public boolean isPalindrome(String str){
        str = str.toLowerCase();
        char[] chars = str.toCharArray();
        //A to Z 65 to 90
        //a to z  97 to 122
        int j = chars.length - 1;
        for(int i=0;i<chars.length/2;i++){
            //check for non alphabetic characters and ignore
            if(chars[i] < 65 || chars[i] > 122 ) {
                continue;
            }
            //if from last found then move right pointer and keep left pointer same
            if(chars[j] < 65 || chars[j] > 122 ) {
                j--; i--;
                continue;
            }
            if(chars[i]!=chars[j]){
                return false;
            }
            j--;
        }
        return true;
    }

}
