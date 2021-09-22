package myalgo.recursion.subsetsum;

public class SubsetSumMain {
    private static boolean subsetSum(int a[], int sum, int output, int index) {
        if(output == sum) {
            return true;
        }

        if(index == a.length) {
            return false;
        }


        if(subsetSum(a, sum, output + a[index], index + 1) || subsetSum(a, sum, output, index + 1)) {
            return true;
        } else {
            return false;
        }
    }


    private static int countSubsets(int[] arr, int i, int n, int sum) {
        if(sum == 0) {
            return 1;
        }

        if(i == n) {
            return 0;
        }

        int inc = countSubsets(arr, i + 1, n, sum - arr[i]);
        int exc = countSubsets(arr, i + 1, n, sum);

        return inc + exc;
    }

    public static void main(String[] args) {
        int[] arr = {10, 12, 15, 7, 19, 20};

        System.out.println(subsetSum(arr, 35, 0, 0));

        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println(countSubsets(arr1, 0, arr1.length, 6));
    }
}
