package myalgo.dp.countingsequence;

import java.util.Arrays;

public class CountingSeqMain {

    public static void main(String[] args) {
        String s1 = "ABCDCE";
        String s2 = "ABC";
//        String s1 = "ABBCDCECC";
//        String s2 = "ABC";

        System.out.println(countingSequenceByRecursive(s1, s2, s1.length() - 1, s2.length() - 1));

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(countingSequenceByTopDownDp(s1, s2, s1.length(), s2.length() , dp));

        for (int i = 0; i <= s1.length(); i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println();

        System.out.println(countingSequenceByBottomUp(s1, s2));
    }

    private static int countingSequenceByBottomUp(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        int[][] dp = new int[l1 + 1][l2 + 1];
        Arrays.fill(dp[0], 0);

        for(int  i = 0; i <= l1; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= l1; i++) {
            for(int j = 1; j <= l2; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i = 0; i <= l1; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[l1][l2];
    }

    private static int countingSequenceByTopDownDp(String s1, String s2, int i, int j, int[][] dp) {
        if(j == 0) {
            return dp[i][j] = 1;
        } else if(i == 0) {
            return dp[i][j] = 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return dp[i][j] = countingSequenceByTopDownDp(s1, s2, i - 1, j, dp) + countingSequenceByTopDownDp(s1, s2, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = countingSequenceByTopDownDp(s1, s2, i - 1, j, dp);
        }
    }

    private static int countingSequenceByRecursive(String s1, String s2, int i, int j) {
        if(j == -1) {
            return 1;
        } else if(i == -1) {
            return 0;
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            return countingSequenceByRecursive(s1, s2, i - 1, j) + countingSequenceByRecursive(s1, s2, i - 1, j - 1);
        } else {
            return countingSequenceByRecursive(s1, s2, i - 1, j);
        }
    }
}
