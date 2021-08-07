package myalgo.dp.maximumnonadjsum;

public class MaxNonAdjSumMain {

    private static int calMaxNotAdjSum(int[] arr, int n) {
        int[] dp = new int[n];
        dp[0] = arr[0];

        if(n > 1) {
            dp[1] = Integer.max(arr[0], arr[1]);
        }

        for(int i = 2; i < n; i++) {
            dp[i] = Integer.max(dp[i - 1], dp[i - 2] + arr[i]);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {6, 10, 12, 7, 9, 14};

        System.out.println(calMaxNotAdjSum(arr, arr.length));
    }
}
