package myalgo.recursion.generatebrackets;

public class GenerateBracketsMain {

    private static void generateBrackets(int N, int openingCount, int closingCount, String output) {
        if(output.length() == 2*N) {
            System.out.println(output);
            return;
        }

        if(openingCount < N) {
            generateBrackets(N, openingCount + 1, closingCount, output + "(");
        }

        if(openingCount > closingCount) {
            generateBrackets(N, openingCount, closingCount + 1, output + ")");
        }
    }

    public static void main(String[] args) {
        generateBrackets(5, 0, 0, "");
    }
}
