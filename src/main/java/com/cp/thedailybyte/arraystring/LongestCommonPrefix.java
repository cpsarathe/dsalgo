package com.cp.thedailybyte.arraystring;

/**
 * Given an array of strings, return the longest common prefix that is shared amongst all strings.
 * Note: you may assume all strings only contain lowercase alphabetical characters.
 * <p>
 * Ex: Given the following arrays...
 * <p>
 * ["colorado", "color", "cold"], return "col"
 * ["a", "b", "c"], return ""
 * ["spot", "spotty", "spotted"], return "spot"]
 * ["flower","flow","flight"]
 * "dog","racecar","car"
 */
public class LongestCommonPrefix {

    public static void main(String[] ar) {
        LongestCommonPrefix obj = new LongestCommonPrefix();
        String[] input1 = {"colorado", "color", "cold"};
        String[] input2 = {"a", "b", "c"};
        String[] input3 = {"spot", "spotty", "spotted"};
        String[] input4 = {"flower", "flow", "flight"};
        String[] input5 = {"ba", "abc", "abcd","abcde"};
        System.out.println(obj.longestCommonPrefix(input1).equals("col"));
        System.out.println(obj.longestCommonPrefix(input2).equals(""));
        System.out.println(obj.longestCommonPrefix(input3).equals("spot"));
        System.out.println(obj.longestCommonPrefix(input4).equals("fl"));

        //we had 2 test cases failed using above approach.
        //can we do it better
        System.out.println("***************************************");
        System.out.println(obj.longestCommonPrefixCompareTo(input1).equals("col"));
        System.out.println(obj.longestCommonPrefixCompareTo(input2).equals(""));
        System.out.println(obj.longestCommonPrefixCompareTo(input3).equals("spot"));
        System.out.println(obj.longestCommonPrefixCompareTo(input4).equals("fl"));
        System.out.println(obj.longestCommonPrefixCompareTo(input5).equals(""));

    }

    public String longestCommonPrefix(String[] words) {
        //if first and second word have anything common then only we can check if any other string
        //also have common prefix or not
        //then check first word and second word what is common prefix
        //then we check if this prefix exist in all the given words or not
        if (words.length <= 1) {
            return words[0];
        }
        String s1 = words[0];
        String s2 = words[1];

        StringBuilder sb = new StringBuilder();
        int k = 0, i = 0, j = 0;
        //O(s1.length) time complexity.
        while (i < s1.length() || j < s2.length()) {
            if (i == s1.length() || j == s2.length()) {
                break;
            }
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            if (c1 == c2) {
                sb.insert(k++, c1);
            }
            i++;
            j++;
        }
        String prefix = sb.toString();
        //O(n) Time for checking prefix in all words
        for (String s : words) {
            if (!s.startsWith(prefix)) {
                return "";
            }
        }
        return prefix;
    }

    public String longestCommonPrefixCompareTo(String[] words) {
        //We can compare two strings at a time in one loop character by character till we dont find match
        //once match is found its taken it as prefix
        //Assume for the first two words we got prefix ,for subsequent words of the loops we need to compare only
        //those words with prefix.
        //so we keep on replacing words[i] with prefix
        String prefix = "";
        //O(n) time complexity as each of words getting compared
        //O(n) space complexity as we have to store prefix string each time we compare two words
        for (int i = 0; i < words.length; i++) {
            if (i + 1 >= words.length) {
                break;
            }
            String s1 = prefix;
            if (prefix.isEmpty()) {
                s1 = words[i];
            }
            String s2 = words[i + 1];
            prefix = compareToFindMatchingPrefix(s1, s2);
            if(prefix.isEmpty()) {
                return prefix;
            }
        }
        return prefix;
    }

    public String compareToFindMatchingPrefix(String s1, String s2) {
        int i = 0, j = 0, k = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) != s2.charAt(j)) {
                break;
            }
            i++;
            j++;
        }
        return s1.substring(0,i);
    }
}
