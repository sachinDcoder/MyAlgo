package myalgo.dp.fibonacci;

public class FibonacciMain {

    private static int fibVarsOnly(int number) {
        int first = 0;
        int second = 1;
        int third = 0;

        if(number == 0) {
            return first;
        }
        if(number == 1) {
            return second;
        }

        for(int i = 2; i <= number; i++) {
            third = first + second;
            first = second;
            second = third;
        }

        return third;
    }
    public static void main(String[] args) {
        System.out.println(fibVarsOnly(4));
    }
}
