package myalgo.dp.nkladder;

import java.util.Arrays;

public class NkLadderMain {

    private static int countWays(int n, int k) {
        if(n < 0) {
            return 0;
        } else if(n == 0) {
            return 1;
        }

        int sum = 0;
        for(int jump = 1; jump <= k; jump++) {
            sum += countWays(n - jump, k);
        }

        return sum;
    }

    private static int countWaysUsingDpTopDown(int n, int k, int[] dp) {
        if(n < 0) {
            return 0;
        } else if(n == 0) {
            return 1;
        }

        if(dp[n] != 0) {
            return dp[n];
        }

        int sum = 0;
        for(int jump = 1; jump <= k; jump++) {
            sum += countWaysUsingDpTopDown(n - jump, k, dp);
        }

        return dp[n] = sum;
    }

    private static int countWaysUsingDpBottomUp(int n, int k) {
        int[] dp = new int[n+1];

        dp[0] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                if(i - j >= 0) {
                    dp[i] = dp[i] + dp[i - j];
                }
            }
        }

        return dp[n];
    }

    private static int countWaysUsingDpBottomUpOptimized(int n, int k) {
        int[] dp = new int[n+1];

        dp[0] = dp[1] = 1;

        for(int i = 2; i <= k; i++) {
            dp[i] = 2 * dp[i - 1];
        }

        for(int i = k + 1; i <= n; i++) {
            if(i - k - 1 >= 0) {
                dp[i] = 2 * dp[i - 1] - dp[i - k - 1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
//        System.out.println(countWays(4, 3));
//
//        int[] dp = new int[100];
//        Arrays.fill(dp, 0);
//        System.out.println(countWaysUsingDpTopDown(4, 3, dp));

//        System.out.println(countWaysUsingDpBottomUp(4, 3));

          System.out.println(countWaysUsingDpBottomUpOptimized(6, 4));
    }
}
