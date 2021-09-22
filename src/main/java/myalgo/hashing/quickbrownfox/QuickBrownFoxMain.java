package myalgo.hashing.quickbrownfox;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class QuickBrownFoxMain {
    public static void main(String[] args) {
        String s = "thequickbrownfox";
        String[] words = {"the", "quickbrown", "fox", "quick", "brown"};

        System.out.println(calMinPartitions(s, words));
    }

    private static int calMinPartitions(String s, String[] words) {

        Set<String> wordLookUpSet = new HashSet<>(Arrays.asList(words));
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -2);
        return calMinPartitionsUsingRecursion(s,0, wordLookUpSet, dp) - 1;
    }

    private static int calMinPartitionsUsingRecursion(String s, int idx, Set<String> wordLookUpSet, int[] dp) {
        if(idx == s.length()) {
            return 0;
        }

        if(dp[idx] != -2) {
            return dp[idx];
        }

        int ans = Integer.MAX_VALUE;
        String currStr = "";

        for(int i = idx; i < s.length(); i++) {
            currStr += s.charAt(i);

            if(wordLookUpSet.contains(currStr)) {
//                System.out.println(currStr);
                int remainingAns = calMinPartitionsUsingRecursion(s, i + 1, wordLookUpSet, dp);
                if(remainingAns != -1) {
                    ans = Integer.min(ans, 1 + remainingAns);
                }
            }
        }

        if(ans == Integer.MAX_VALUE) {
            return dp[idx] = -1;
        }

        return dp[idx] = ans;
    }
}
