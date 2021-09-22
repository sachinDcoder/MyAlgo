package myalgo.recursion.permutation;

public class PermutationMain {

    public static void main(String[] args) {
        String input = "ABC";

        printPermutation(input, 0, input.length() - 1);
    }

    private static void printPermutation(String input, int l, int r) {
        if(l == r) {
            System.out.println(input);
        } else {
            for(int i = l; i <= r; i++) {
                input = swapCharacter(input, l, i);
                printPermutation(input, l + 1, r);
                input = swapCharacter(input, l, i);
            }
        }
    }

    private static String swapCharacter(String input, int i, int j) {
        char[] inputChars = input.toCharArray();
        char temp = inputChars[i];
        inputChars[i] = inputChars[j];
        inputChars[j] = temp;
        return String.valueOf(inputChars);
    }
}
