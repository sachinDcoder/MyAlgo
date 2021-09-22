package myalgo.binarysearch.minpair;

import java.util.Arrays;

public class MinPairMain {

    private static int findLowerBound(int[] arr, int n, int num) {
        int start = 0;
        int end = n;

        if(arr[n - 1] < num) {
            return n;
        }

        while(start <= end) {
            int mid = (start + end) / 2;

            if(arr[mid] == num) {
                return mid;
            } else if(num < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private static int[] findMinPair(int[] arr1, int[] arr2, int n, int m) {
        Arrays.sort(arr2);
        int[] minPair = new int[2];
        int diff = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int curr = arr1[i];
            int lowerBound = findLowerBound(arr2, m, curr);

            if(lowerBound >= 1 && curr - arr2[lowerBound - 1] < diff) {
                diff = curr - arr2[lowerBound - 1];
                minPair[0] = curr;
                minPair[1] = arr2[lowerBound - 1];
            }

            if(lowerBound == m && arr2[lowerBound] - curr < diff) {
                diff = arr2[lowerBound] - curr;
                minPair[0] = curr;
                minPair[1] = arr2[lowerBound];
            }
        }

        return minPair;
    }

    public static void main(String[] args) {
//        int[] arr1 = {-1, 5, 10, 20, 3};
        int[] arr1 = {-1, 5, 10, 20, 3};
        int[] arr2 = {26, 134, 135, 15, 17};

        int[] arrTemp = {-1, 5, 10, 20, 56};
//        System.out.println(findLowerBound(arrTemp, arr1.length, 78));

        int[] ans = findMinPair(arr1, arr2, arr1.length, arr2.length);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
