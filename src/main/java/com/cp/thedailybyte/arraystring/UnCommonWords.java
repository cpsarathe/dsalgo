package com.cp.thedailybyte.arraystring;

import java.util.*;

public class UnCommonWords {

    public static void main(String[] ar) {
        UnCommonWords obj = new UnCommonWords();
        boolean tc1 = Arrays.equals(obj.uncommonFromSentencesBetter("this apple is sweet", "this apple is sour"), new String[]{"sweet", "sour"});
        boolean tc2 = Arrays.equals(obj.uncommonFromSentencesBetter("apple apple", "banana"), new String[]{"banana"});
        boolean tc3 = Arrays.equals(obj.uncommonFromSentencesBetter("the quick", "brown fix"), new String[]{"the", "quick", "brown", "fix"});

        System.out.println(tc1);
        System.out.println(tc2);
        System.out.println(tc3);
    }

    public String[] uncommonFromSentences(String A, String B) {
        //we have to split sentence to form array of words for each string.
        //naive way is to loop through both array and find uncommon word
        //this will cause O(N*2)

        //Another approache is to create a Map with counter for both sentence string
        //loop through A , B each word and check if it exist in map exactly one time and
        //doesn't exist in another then store it in list for uncommon words

        //Two Map we need so O(M+N) is space
        //O(N) for looping and checking from map is O(1) so all in all O(N) time complexity

        String[] aArr = A.split(" ");
        String[] bArr = B.split(" ");

        HashMap<String, Integer> aSet = new HashMap();
        HashMap<String, Integer> bSet = new HashMap();

        int i = 0, j = 0;
        while (i < aArr.length) {
            //In java you can set default and if exist increment counter
            aSet.merge(aArr[i], 1, Integer::sum);
            i++;
        }
        while (j < bArr.length) {
            bSet.merge(bArr[j], 1, Integer::sum);
            j++;
        }

        i = 0;
        j = 0;
        List<String> list = new ArrayList();
        while (i < aArr.length || j < bArr.length) {
            if (i < aArr.length && aSet.get(aArr[i]) == 1 && !bSet.containsKey(aArr[i])) {
                list.add(aArr[i]);
            }
            if (j < bArr.length && bSet.get(bArr[j]) == 1 && !aSet.containsKey(bArr[j])) {
                list.add(bArr[j]);
            }
            i++;
            j++;
        }

        String[] strings = list.stream().toArray(String[]::new);

        return strings;
    }

    public String[] uncommonFromSentencesBetter(String A, String B) {
        String[] aArr = A.split(" ");
        String[] bArr = B.split(" ");
        HashMap<String, Integer> countWordMap = new HashMap();
        int i = 0, j = 0;
        while (i < aArr.length || j < bArr.length) {
            if (i < aArr.length) {
                setWordCountMap(aArr[i],countWordMap);
            }
            if (j < bArr.length) {
                setWordCountMap(bArr[i],countWordMap);
            }
            i++;
            j++;
        }

        List<String> list = new ArrayList();
        for (Map.Entry<String, Integer> entry : countWordMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 1) {
                list.add(key);
            }
        }
        String[] strings = list.stream().toArray(String[]::new);

        return strings;
    }

    private void setWordCountMap(String word , HashMap<String, Integer> countWordMap){
        if (countWordMap.containsKey(word)) {
            countWordMap.put(word, -1);
        } else {
            countWordMap.put(word, 1);
        }
    }
}
