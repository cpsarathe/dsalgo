package com.cp.leetcode.string;

import java.util.*;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 */
public class ValidParentheses {

    public static void main(String[] ar) {
        ValidParentheses obj = new ValidParentheses();
        System.out.println(obj.isValidParenthesis("(()])}[}[}[]][}}[}{})][[(]({])])}}(])){)((){") == false);
        System.out.println(obj.isValidParenthesis("()[]{}") == true);
        System.out.println(obj.isValidParenthesis("()[{]{}") == false);
        System.out.println('9' - '0');
        StringBuilder sb = new StringBuilder();
        sb.reverse();
    }

    public boolean isValidParenthesis(String s) {
        //There is a pattern , count of opening and closing parenthesis are same
        //They can't be odd number
        //One of Opening parenthesis will be followed by closing parenthesis.
        //We could use stack to store opening parenthesis
        //and check if we encounter closing parenthesis and stack top element is matching we could remove it
        //from stack and considered it a valid match
        //we could do this for all characters in String.

        if (s.length() == 0) return true;
        if (s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        //Space Complexity O(n)
        //Time Complexity O(n)
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else if (s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{') {
                stack.pop();
            } else if (s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[') {
                stack.pop();
            }
        }
        return stack.empty();
    }

}
