package myalgo.slidingwindow.housing;

import java.util.Arrays;

public class HousingMain {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 4, 1, 3, 2, 1, 1, 2};
        int sum = 8;
        int n = arr.length;
        solveHousing(arr, sum, n);
    }

    private static void solveHousing(int[] arr, int sum, int n) {
        int i = 0;
        int j = 0;
        int temp = 0;

        while(i < n && j < n) {
            if(temp < sum) {
                temp += arr[j++];
            } else if(temp == sum) {
                System.out.println(i + " " + (j - 1));
                temp += arr[j++];
            } else if(temp > sum) {
                temp -= arr[i++];
            }
        }
    }
}
