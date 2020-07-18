package com.cp.thedailybyte.arraystring;

/**
 * This question is asked by Google. Given a string, reverse all of its characters and return the resulting string.
 *
 * Ex: Given the following strings...
 *
 * “Cat”, return “taC”
 * “The Daily Byte”, return "etyB yliaD ehT”
 * “civic”, return “civic”
 */
public class ReverseAString {

    public static void main(String[] ar) {
        ReverseAString obj = new ReverseAString();
        String str = "The Daily Byte";
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        //since we have to reverse , we can start loop from end
        for(int x= words.length-1 ;x>=0;x--) {
            sb.append(obj.reverse(words[x]));
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }

    public String reverse(String word){
        //we can convert string to char Array and keep two pointers one from left to right
        //another from right to left and keep swaping chracaters.
        //loop will run until mid of Array
        char[] chars = word.toCharArray();
        for(int i=0 ,j=chars.length-1;i<chars.length/2;i++,j--){
            char c = chars[j];
            chars[j] = chars[i];
            chars[i] = c;
        }
        return new String(chars);
    }
}
