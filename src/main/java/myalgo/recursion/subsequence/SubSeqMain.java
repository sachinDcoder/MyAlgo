package myalgo.recursion.subsequence;

public class SubSeqMain {
    public static void main(String[] args) {
        String input = "abc";
        String output = "";

        printSubSequence(input, output);
    }

    private static void printSubSequence(String input, String output) {
        if(input.length() == 0) {
            System.out.println(output);
            return;
        }

        printSubSequence(input.substring(1), output + input.charAt(0));
        printSubSequence(input.substring(1), output);
    }
}
