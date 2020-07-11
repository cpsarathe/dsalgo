package com.cp.thedailybyte;
/**
 * Given a string, return whether or not it uses capitalization correctly.
 * A string correctly uses capitalization if all letters are capitalized, no letters are capitalized,
 * or only the first letter is capitalized.
 * <p>
 * Ex: Given the following strings...
 * <p>
 * "USA", return true
 * "Calvin", return true
 * "compUter", return false
 * "coding", return true
 */
public class Capitalization {
    int sCount = 0;
    int lCount = 0;

    public static void main(String[] ar) {
        Capitalization obj = new Capitalization();
        System.out.println(obj.isCapitalized("USA"));

        //can you do it better than O(n) , May be I should try O(logn) binarySearch
        String word = "USA";

        obj.isCapitalizedBinarySearch(word.toCharArray(), 0, word.length());

        boolean isCapitalized = ( word.charAt(0)>=65 && word.charAt(0)<=90 ) ||  obj.sCount == word.length() || obj.lCount == word.length();
        System.out.println(isCapitalized);
    }

    public boolean isCapitalized(String word) {
        //we can loop through each character of String and check their ASCII code
        //if its >90 it's small character
        //if between 65 to 90 its CAPITAL
        //if between 97 to 122 its SMALL
        char[] chars = word.toCharArray();
        boolean isFirstOnlyCapital = false;
        int capitalCount = 0;
        int smallCount = 0;

        if (chars[0] >= 65 && chars[0] <= 90) {
            isFirstOnlyCapital = true;
        }

        //time complexity of this is O(n) as we have to iterate each characters
        //space O(1)
        for (int i = 0; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])) {
                capitalCount++;
            } else if (Character.isLowerCase(chars[i])) {
                smallCount++;
            }
        }
        return isFirstOnlyCapital || capitalCount == chars.length || smallCount == chars.length;

    }

    public void isCapitalizedBinarySearch(char[] word, int start, int end) {
        //o(logn) solution to check count of upper case and lower case in both sides of character array
        if (start < end) {
            int mid = (start + end) / 2;
            if (word[mid] >= 65 && word[mid] <= 90) {
                lCount++;
            } else if (word[mid] >= 97 && word[mid] <= 122) {
                sCount++;
            }
            isCapitalizedBinarySearch(word, start, mid);
            isCapitalizedBinarySearch(word, mid + 1, end);
        }
        return;
    }
}

