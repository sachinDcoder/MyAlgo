package myalgo.binarysearch.rotatingarr;

public class RotatingMain {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int length = arr.length;

        System.out.println(searchKeyInRotatedArr(arr, length, 1));
    }

    private static int searchKeyInRotatedArr(int[] arr, int length, int key) {
        int start = 0;
        int end = length - 1;

        while(start<=end) {
            int mid = (start + end) / 2;

            if(arr[mid] == key) {
                return mid;
            } else if(arr[start] <= arr[mid]) {
                if(arr[start] <= key && key <= arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if(arr[mid] <= arr[end]) {
                if(arr[mid] <= key && key <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
