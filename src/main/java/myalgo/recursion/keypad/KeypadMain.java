package myalgo.recursion.keypad;

public class KeypadMain {
    public static void main(String[] args) {
        String[] keypad = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        String input = "235";
        String output = "";

        printKeypadOutput(keypad, input, output, 0);
    }

    private static void printKeypadOutput(String[] keypad, String input, String output, int i) {
        if(input.length() == i) {
            System.out.println(output);
            return;
        }

        if(input.charAt(i) == '0' || input.charAt(i) == '1') {
            printKeypadOutput(keypad, input, output, i + 1);
        } else {
            int i1 = Integer.parseInt(input.charAt(i) + "");
            for(int k = 0; k < keypad[i1].length(); k++) {
                printKeypadOutput(keypad, input, output + keypad[i1].charAt(k), i + 1);
            }
        }
    }
}
