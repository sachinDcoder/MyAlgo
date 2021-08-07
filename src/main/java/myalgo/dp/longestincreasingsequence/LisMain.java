package myalgo.dp.longestincreasingsequence;

import java.util.Arrays;

public class LisMain {

    private static int findLongestIncreasingSequence(int[] arr, int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        for(int i = 1; i < n; i++) {
            int tempMaxLength = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(tempMaxLength <= dp[j] && arr[j] < arr[i]) {
                    tempMaxLength = dp[j] + 1;
                }
            }

            dp[i] = tempMaxLength;
        }

        System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] arr = {50, 4, 10, 8, 30, 100, 2};

        System.out.println(findLongestIncreasingSequence(arr, arr.length));
    }
}
