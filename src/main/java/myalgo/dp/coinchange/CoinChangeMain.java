package myalgo.dp.coinchange;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class CoinChangeMain {
    private static int minNumberOfCoinsForChange(int money, int[] coins) {
        int[] dp = new int[money + 1];
        dp[0] = 0;

        for(int i = 1; i <= money; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(Integer c : coins) {
                if(i - c >= 0 && dp[i - c] != Integer.MAX_VALUE) {
                    dp[i] = Integer.min(dp[i], dp[i - c] + 1);
                }
            }
        }
        return dp[money];
    }

    private static List<Integer> coinsMakingMinNumberOfCoinsForChange(int money, int[] coins) {
        Pair<Integer, Integer>[] dp = new Pair[money + 1];
        dp[0] = new Pair<>(0, 0);

        for(int i = 1; i <= money; i++) {
            dp[i] = new Pair<>(Integer.MAX_VALUE, Integer.MAX_VALUE);
            for(Integer c : coins) {
                if(i - c >= 0 && dp[i - c].getKey() != Integer.MAX_VALUE && dp[i].getKey() >= dp[i - c].getKey() + 1) {
                    dp[i] = new Pair<>(dp[i - c].getKey() + 1, c);
                }
            }
        }

        List<Integer> coinsUsed = new ArrayList<>();
        int i = money;

        while(i > 0) {
            coinsUsed.add(dp[i].getValue());
            i = i - dp[i].getValue();
        }

        return coinsUsed;
    }

    public static void main(String[] args) {
        System.out.println(minNumberOfCoinsForChange(15, new int[]{1, 3, 7, 10}));
        System.out.println(coinsMakingMinNumberOfCoinsForChange(15, new int[]{1, 3, 7, 10}));

        System.out.println(minNumberOfCoinsForChange(16, new int[]{1, 5, 7, 10}));
        System.out.println(coinsMakingMinNumberOfCoinsForChange(16, new int[]{1, 5, 7, 10}));
    }
}
