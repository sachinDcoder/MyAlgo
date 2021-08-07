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

    public static void main(String[] args) {
        int[] prices = {2, 3, 5, 1, 4};

        System.out.println(calMaxProfit(prices, 0, prices.length - 1, 1));

        int[][] dp = new int[prices.length][prices.length];
        System.out.println(calMaxProfitTopDownDp(prices, 0, prices.length - 1, 1, dp));

        for(int i = 0; i < prices.length; i++) {
            for(int j = 0; j < prices.length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
