package myalgo.dp.wineselling;

public class WineSellingMain {

    private static int calMaxProfit(int[] prices, int i, int j, int year) {
        if(i == j) {
            return year * prices[i];
        }

        return Integer.max(year * prices[i] + calMaxProfit(prices, i + 1, j, year + 1), year * prices[j] + calMaxProfit(prices, i, j - 1, year + 1));
    }

    private static int calMaxProfitTopDownDp(int[] prices, int i, int j, int year, int[][] dp) {
        if(i > j) {
            return 0;
        }

        if(dp[i][j] != 0) {
            return dp[i][j];
        }

        return dp[i][j] = Integer.max(year * prices[i] + calMaxProfitTopDownDp(prices, i + 1, j, year + 1, dp)
                , year * prices[j] + calMaxProfitTopDownDp(prices, i, j - 1, year + 1, dp));
    }

    private static int calMaxProfitBottomUp(int[] prices, int N) {
        int[][] dp = new int[N][N];

        for(int i = N - 1; i >= 0; i--) {
            for(int j = 0; j < N; j++) {
                if(i == j) {
                    dp[i][i] = prices[i] * N;
                } else if(i < j) {
                    int y = N - (j - i);
                    int pickLeft = prices[i] * y + dp[i + 1][j];
                    int pickRight = prices[j] * y + dp[i][j - 1];
                    dp[i][j] = Integer.max(pickLeft, pickRight);
                }
            }
        }

        for(int i = 0; i < prices.length; i++) {
            for(int j = 0; j < prices.length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[0][N-1];

    }

    public static void main(String[] args) {
        int[] prices = {2, 3, 5, 1, 4};
//        int[] prices = {2, 5, 3};

        System.out.println(calMaxProfit(prices, 0, prices.length - 1, 1));

        int[][] dp = new int[prices.length][prices.length];
        System.out.println(calMaxProfitTopDownDp(prices, 0, prices.length - 1, 1, dp));

        for(int i = 0; i < prices.length; i++) {
            for(int j = 0; j < prices.length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(calMaxProfitBottomUp(prices, prices.length));
    }
}
