package myalgo.dp.knapsack;

import java.util.Arrays;

public class KnapsackMain {
    public static void main(String[] args) {
        int n = 4;
        int w = 11;

        int[] weights = {2, 7, 3, 4};
        int[] prices = {5, 20, 20, 10};

        System.out.println(maxProfitRecursive(weights, prices, n - 1, w));

        int[][] dp = new int[n][w + 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(maxProfitRecursiveTopDown(weights, prices, n - 1, w, dp));

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= w; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(maxProfitBottomUp(weights, prices, n, w));
    }

    private static int maxProfitBottomUp(int[] weights, int[] prices, int N, int W) {
        int[][] dp = new int[N + 1][W + 1];

        for(int n = 1; n <= N; n++) {
            for(int w = 1; w <= W; w++) {
                int inc = 0;
                int exc = 0;

                if(w - weights[n - 1] >= 0) {
                    inc = prices[n - 1] + dp[n - 1][w - weights[n - 1]];
                }
                exc = dp[n - 1][w];
                dp[n][w] = Integer.max(inc, exc);
            }
        }

        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= W; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[N][W];
    }

    private static int maxProfitRecursive(int[] weights, int[] prices, int n, int w) {
        if(n <= 0 || w <= 0) {
            return 0;
        } else {
            int ans = 0;
            if(w - weights[n] >= 0) {
                ans = prices[n] + maxProfitRecursive(weights, prices, n - 1, w - weights[n]);
            }
            return Integer.max(ans, maxProfitRecursive(weights, prices, n - 1, w));
        }
    }

    private static int maxProfitRecursiveTopDown(int[] weights, int[] prices, int n, int w, int[][] dp) {
        if(n <= 0 || w <= 0) {
            return 0;
        }

        if(dp[n][w] != -1) {
            return dp[n][w];
        }

        int ans = 0;
        if(w - weights[n] >= 0) {
            ans = prices[n] + maxProfitRecursiveTopDown(weights, prices, n - 1, w - weights[n], dp);
        }
        ans = Integer.max(ans, maxProfitRecursiveTopDown(weights, prices, n - 1, w, dp));
        return dp[n][w] = ans;
    }
}
