package myalgo.dp.boxstacking;

import java.util.Arrays;
import java.util.Comparator;

public class BoxStackingMain {
    public static void main(String[] args) {
        int[][] boxes = {
                {2, 1, 2},
                {3, 2, 3},
                {2, 2, 8},
                {2, 3, 4},
                {2, 2, 1},
                {4, 4, 5}
        };

        int height = boxStacking(boxes);
        System.out.println(height);
    }

    private static int boxStacking(int[][] boxes) {
        int n = boxes.length;
        Arrays.sort(boxes, Comparator.comparingInt(a -> a[2]));

        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {
            dp[i] = boxes[i][2];
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(canPlace(boxes[i], boxes[j])) {
                    dp[i] = Integer.max(dp[i], dp[j] + boxes[i][2]);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    private static boolean canPlace(int[] ibox, int[] jbox) {
        return ibox[0] > jbox[0] && ibox[1] > jbox[1] && ibox[2] > jbox[2];
    }

}
