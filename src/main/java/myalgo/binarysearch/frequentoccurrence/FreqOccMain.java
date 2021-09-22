package myalgo.binarysearch.frequentoccurrence;

public class FreqOccMain {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 2, 3, 3, 3, 3, 4, 5, 5, 5, 10};
        int n = arr.length;

        System.out.println(findOccurrence(arr, n, 3));
    }

    private static int findOccurrence(int[] arr, int n, int key) {
        int upper = upperBound(arr, n, key);
        int lower = lowerBound(arr, n, key);

        if(lower == -1 || upper == -1) {
            return -1;
        }

        return upper - lower + 1;
    }
    private static int lowerBound(int[] arr, int n, int key) {
        int s = 0;
        int e = n - 1;
        int lower = -1;

        while(s<=e) {
            int mid = (s + e) / 2;

            if(arr[mid] == key) {
                lower = mid;
                e = mid - 1;
            } else if(arr[mid] < key) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return lower;
    }

    private static int upperBound(int[] arr, int n, int key) {
        int s = 0;
        int e = n - 1;
        int upper = -1;

        while(s<=e) {
            int mid = (s + e) / 2;

            if(arr[mid] == key) {
                upper = mid;
                s = mid + 1;
            } else if(arr[mid] < key) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return upper;
    }
}
