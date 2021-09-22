package myalgo.hashing.anagrams;

import java.lang.reflect.Array;
import java.util.*;

public class CountAnagramsMain {
    public static void main(String[] args) {
        String s = "abba";
//        String s = "abcd";

        System.out.println(countAnagrams(s));
    }

//    private static int[] getHashOfString(String s, int i, int j) {
//        int[] hash = new int[26];
//
//        for(int k = i; k <= j; k++) {
//            hash[s.charAt(k) - 'a']++;
//        }
//        System.out.println(s.substring(i, j + 1));
//        System.out.println(Arrays.toString(hash));
//
//        return hash;
//    }

    private static Map<Character, Integer> getHashOfString(String s, int i, int j) {
        Map<Character, Integer> hash = new HashMap<>();

        for(int k = i; k <= j; k++) {
            if(hash.containsKey(s.charAt(k))) {
                hash.put(s.charAt(k), hash.get(s.charAt(k)) + 1);
            } else {
                hash.put(s.charAt(k), 1);
            }
        }

        return hash;
    }

    private static int countAnagrams(String s) {
        int length = s.length();
        int cnt = 0;
//        Map<int[], Integer> freq = new HashMap<>();
        Map<Map<Character, Integer>, Integer> freq = new HashMap<>();

        for(int i = 0; i < length; i++) {
            for(int j = i; j < length; j++) {
                Map<Character, Integer> hash = getHashOfString(s, i, j);

                if(freq.containsKey(hash)) {
                    freq.put(hash, freq.get(hash) + 1);
                } else {
                    freq.put(hash, 1);
                }
            }
        }

        for(Map.Entry<Map<Character, Integer>, Integer> e : freq.entrySet()) {
//            System.out.println("e.getValue() " + e.getValue());
            cnt += (e.getValue() * (e.getValue() - 1) / 2);
        }

        return cnt;
    }
}
