package myalgo.dp.countingtrees;

import java.util.Arrays;

public class CountingTreesMain {

    private static int countingTreesRecursive(int N) {
        if(N == 0 || N == 1) {
            return 1;
        }

        int ans = 0;
        for(int i = 1; i <= N; i++) {
            int x = countingTreesRecursive(i - 1);
            int y = countingTreesRecursive(N - i);
            ans += (x * y);
        }

        return ans;
    }

    private static int countingTreesTopDownDp(int N, int[] dp) {
        if(N == 0 || N == 1) {
            return 1;
        }

        if(dp[N] != 0) {
            return dp[N];
        }

        int ans = 0;
        for(int i = 1; i <= N; i++) {
            int x = countingTreesTopDownDp(i - 1, dp);
            int y = countingTreesTopDownDp(N - i, dp);
            ans += (x * y);
        }

        return dp[N] = ans;
    }

    private static int countingTreesBottomUpDp(int N) {
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 0);
        dp[0] = dp[1] = 1;

        for(int n = 2; n <= N; n++) {
            for(int i = 1; i <= n; i++) {
                dp[n] += (dp[i - 1] * dp[n - i]);
            }
        }

        return dp[N];
    }

    public static void main(String[] args) {
        int N = 5;

        System.out.println(countingTreesRecursive(N));

        int[] dp = new int[N + 1];
        Arrays.fill(dp, 0);
        System.out.println(countingTreesTopDownDp(N, dp));

        System.out.println(countingTreesBottomUpDp(N));
    }
}
