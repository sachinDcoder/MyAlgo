package myalgo.binarysearch.angrybird;

import java.util.Arrays;

public class AngryBirdsMain {

    private static int getMinLargestDist(int[] nests, int b, int n) {
        Arrays.sort(nests);
        int start = 0;
        int end = nests[n - 1] - nests[0];
        int ans = -1;

        while(start <= end) {
            int mid = (start + end) / 2;

            boolean canPlace = canPlaceBirds(nests, b, n, mid);
            if(canPlace) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    private static boolean canPlaceBirds(int[] nests, int b, int n, int sep) {
        int cnt = 1;
        int location = nests[0];

        for(int i = 1; i < n; i++) {
            if(nests[i] - location >= sep) {
                cnt += 1;
                location = nests[i];
                if(cnt == b) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int bird = 3;
        int[] nests = {1, 2, 4, 8, 9};

        int n = nests.length;

        System.out.println(getMinLargestDist(nests, bird, n));
    }
}
