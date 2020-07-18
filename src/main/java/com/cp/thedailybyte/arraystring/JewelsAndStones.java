package com.cp.thedailybyte.arraystring;

/**
 * Given a string representing your stones and another string representing a list of jewels, return the number of stones that you have that are also jewels.
 * <p>
 * Ex: Given the following jewels and stones...
 * <p>
 * jewels = "abc", stones = "ac", return 2
 * jewels = "AaaddfFf", stones = "Af", return 3
 * jewels = "AYOPD", stones = "ayopd", return 0
 */
public class JewelsAndStones {

    public static void main(String[] ar) {
        JewelsAndStones obj = new JewelsAndStones();
        System.out.println(obj.stonesWhichAreJewels("abc", "ac") == 2);
        System.out.println(obj.stonesWhichAreJewels("AaaddfFf", "Af") == 3);
        System.out.println(obj.stonesWhichAreJewels("AYOPD", "ayopd") == 0);

        obj.reverse(123);
    }

    public int stonesWhichAreJewels(String jewels, String stones) {
        //The naive approach suggest we could do this in O(M*N)
        //M is stones length and N is jewels length
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            for (int j = 0; j < jewels.length(); j++) {
                if (stones.charAt(i) == jewels.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int reverse(int x) {
        int cx = x, cy = x;
        int count = 0;
        boolean isNegative = false;
        if(x<0){
            isNegative = true;
            cx = cx * -1;
            cy = cy * -1;
        }
        while(cx!=0) {
            cx = cx / 10;
            count++;
        }

        int rev = 0 , rem = 0;
        while(cy!=0) {
            rem = cy % 10 ;
            cy   = cy / 10;
            long res  = (rem * power(10,(count-1)));
            if(res < Integer.MIN_VALUE) return 0;
            if(res < Integer.MAX_VALUE) return 0;
            rev = (int) (rev + res);
            count--;
        }

        if(isNegative) {
            rev = rev * -1;
        }

        return rev;
    }

    public long power(long x , long y){
        int i  = 1;
        if(y<=0) {
            return 1;
        }
        while(i < y) {
            x = x * x;
            i++;
        }
        return x;
    }
}
