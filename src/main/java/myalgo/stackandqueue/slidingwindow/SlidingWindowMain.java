package myalgo.stackandqueue.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMain {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 5};
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        int[] ans = solveSlidingWindowMax(arr, k);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] solveSlidingWindowMax(int[] arr, int k) {
        int n = arr.length;
        int[] output = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            while(!deque.isEmpty() && arr[i] > arr[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        for(int i = k; i < n; i++) {
            if (!deque.isEmpty()) {
                output[i - k] = arr[deque.peekFirst()];
            }

            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while(!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        if (!deque.isEmpty()) {
            output[n - k] = arr[deque.peekFirst()];
        }

        return output;
    }
}
