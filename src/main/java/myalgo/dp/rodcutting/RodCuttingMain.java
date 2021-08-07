package myalgo.dp.rodcutting;

import java.util.Arrays;

public class RodCuttingMain {

    private static int maxProfit(int[] prices, int n) {
        if(n <= 0) {
            return 0;
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int curr = i + 1;
            int currAns = prices[i] + maxProfit(prices, n - curr);
            ans = Integer.max(ans, currAns);
        }

        return ans;
    }

    private static int maxProfitUsingDp(int[] prices, int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;

        for(int len = 1; len <= n; len++) {
            int ans = Integer.MIN_VALUE;
            for(int i = 0; i < len; i++) {
                int curr = i + 1;
                int currAns = prices[i] + dp[len - curr];
                ans = Integer.max(ans, currAns);
            }
            dp[len] = ans;
        }

        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};

//        System.out.println(maxProfit(prices, prices.length));
        System.out.println(maxProfitUsingDp(prices, prices.length));
    }
}
