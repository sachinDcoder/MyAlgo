package myalgo.dp.minimumjumps;

import java.util.Arrays;

public class MinJumpMain {

    private static int minJumpCount(int[] jumps, int index, int n) {
        if(index >= n - 1) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for(int j = 1; j <= jumps[index]; j++) {
            ans = Integer.min(ans, minJumpCount(jumps, index + j, n));
        }

        return ans + 1;
    }

    private static int minJumpCountUsingDp(int[] jumps, int index, int n, int[] dp) {
        if(index >= n - 1) {
            return 0;
        }

        if(dp[index] != 0) {
            return dp[index];
        }

        int ans = Integer.MAX_VALUE;
        for(int j = 1; j <= jumps[index]; j++) {
            ans = Integer.min(ans, minJumpCountUsingDp(jumps, index + j, n, dp));
        }

        return dp[index] = ans + 1;
    }

    public static void main(String[] args) {
        int[] maxJumps = {3, 4, 2, 1, 2, 3, 10, 1, 1, 1, 2, 5};
//        int[] maxJumps = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
//
//        System.out.println(minJumpCount(maxJumps, 0, maxJumps.length));

//        int[] maxJumps = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int[] dp = new int[maxJumps.length + 1];
        Arrays.fill(dp, 0);

        System.out.println(minJumpCountUsingDp(maxJumps, 0, maxJumps.length, dp));
    }
}
