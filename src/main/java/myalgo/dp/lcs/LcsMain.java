package myalgo.dp.lcs;

import java.util.Arrays;

public class LcsMain {

    private static int lcsRecursive(String s1, String s2, int i, int j) {
        if(s1.length() == i || s2.length() == j) {
            return 0;
        } else if(s1.charAt(i) == s2.charAt(j)) {
            return 1 + lcsRecursive(s1, s2, i + 1, j + 1);
        } else {
            return Integer.max(lcsRecursive(s1, s2, i, j + 1), lcsRecursive(s1, s2, i + 1, j));
        }
    }

    private static int lcsRecursiveTopDownDp(String s1, String s2, int i, int j, int[][] dp) {
        if(s1.length() == i || s2.length() == j) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)) {
//            System.out.print(s1.charAt(i));
            dp[i][j] = lcsRecursiveTopDownDp(s1, s2, i + 1, j + 1, dp);
            return 1 + dp[i][j];
        } else {
            dp[i][j] = Integer.max(lcsRecursiveTopDownDp(s1, s2, i, j + 1, dp), lcsRecursiveTopDownDp(s1, s2, i + 1, j, dp));
            return dp[i][j];
        }
    }

    private static int lcsBottomUp(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for(int i = 0; i < n1; i++) {
            Arrays.fill(dp[i], 0);
        }

        for(int i = 1; i <= n1; i++) {
            for(int j = 1; j <= n2; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Integer.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        int i = n1;
        int j = n2;
        String result = "";
        while(i != 0 || j != 0) {
            if(dp[i][j] == dp[i - 1][j]) {
                i--;
            } else if(dp[i][j] == dp[i][j - 1]) {
                j--;
            } else {
                result = s1.charAt(i - 1) + result;
                i--;
                j--;
            }
        }

        System.out.println(result);

        return dp[n1][n2];
    }

    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "ABEDG";

        int[][] dp = new int[s1.length()][s2.length()];

        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(lcsRecursive(s1, s2, 0, 0));

        System.out.println(lcsRecursiveTopDownDp(s1, s2, 0, 0, dp));

        System.out.println(lcsBottomUp(s1, s2));
    }
}
