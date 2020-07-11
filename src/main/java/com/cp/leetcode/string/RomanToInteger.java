package com.cp.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * <p>
 * Example 1:
 * <p>
 * Input: 'III'
 * Output: 3
 * Example 2:
 * <p>
 * Input: 'IV'
 * Output: 4
 * Example 3:
 * <p>
 * Input: 'IX'
 * Output: 9
 * Example 4:
 * <p>
 * Input: 'LVIII'
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 * <p>
 * Input: 'MCMXCIV'
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class RomanToInteger {

    public static void main(String[] ar) {
        RomanToInteger obj = new RomanToInteger();
        System.out.println(obj.romanToInt("MCMXCIV") == 1994);
        System.out.println(obj.romanToInt("IV") == 4);
        System.out.println(obj.romanToInt("IX") == 9);
        System.out.println(obj.romanToInt("LVIII") == 58);
    }

    public int romanToInt(String s) {

        //we maintain a symbol table based on static rule
        //we then maintain current and next pointer from given string
        //to check if curent and next combined exist in symbol map
        Map<Character, Integer> rSymbolMap = new HashMap<>();
        rSymbolMap.put('I', 1);
        rSymbolMap.put('V', 5);
        rSymbolMap.put('X', 10);
        rSymbolMap.put('L', 50);
        rSymbolMap.put('C', 100);
        rSymbolMap.put('D', 500);
        rSymbolMap.put('M', 1000);

        char[] chars = s.toCharArray();
        int i = 0;
        char c = ' ';
        char n = ' ';
        int intVal = 0;

        //Time complexity O(n)
        while (i < chars.length) {
            c = chars[i];
            n = i < chars.length - 1 ? chars[i + 1] : ' ';
            if (c == 'I' && (n == 'V' || n == 'X')) {
                intVal = intVal + rSymbolMap.get(n) - rSymbolMap.get(c);
                i = i + 2;
                continue;
            } else if (c == 'X' && (n == 'L' || n == 'C')) {
                intVal = intVal + rSymbolMap.get(n) - rSymbolMap.get(c);
                i = i + 2;
                continue;
            } else if (c == 'C' && (n == 'D' || n == 'M')) {
                intVal = intVal + rSymbolMap.get(n) - rSymbolMap.get(c);
                i = i + 2;
                continue;
            } else {
                intVal = intVal + rSymbolMap.get(c);
                i++;
            }
        }
        return intVal;
    }

}
