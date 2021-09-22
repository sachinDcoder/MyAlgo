package myalgo.binarysearch.squareroot;

public class SqRootMain {
    private static double squareRoot(int num, int precision) {
        int start = 0;
        int end = num;
        double ans = 0.0;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(mid * mid == num) {
                return mid;
            } else if(mid * mid < num){
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        double inc = 0.1;

        for(int p = 1; p <= precision; p++) {

            while(ans * ans <= num) {
                ans += inc;
            }
            ans -= inc;

            inc = inc/10.0;
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(squareRoot(10, 3));
    }
}
