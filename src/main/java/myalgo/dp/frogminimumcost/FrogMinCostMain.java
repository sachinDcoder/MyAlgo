package myalgo.dp.frogminimumcost;

public class FrogMinCostMain {

    private static int getMinCostUsingDp(int[] jumps, int n) {
        int[] dp = new int[n];
        dp[0] = 0;

        if(n > 1) {
            dp[1] = Math.abs(jumps[0] - jumps[1]);
        }

        for(int i = 2; i < n; i++) {
            dp[i] = Integer.min(dp[i -1] + Math.abs(jumps[i] - jumps[i - 1]), dp[i - 2] + Math.abs(jumps[i] - jumps[i - 2]));
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
//        int[] jumps = {30, 10, 60, 10, 60, 50};
        int[] jumps = {10, 30, 40, 20};

        System.out.println(getMinCostUsingDp(jumps, jumps.length));
    }
}
