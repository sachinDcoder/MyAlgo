package myalgo.stackandqueue.redundantparanthesis;

import java.util.Stack;

public class RedundantParaMain {
    public static void main(String[] args) {
//        String input = "((a+(b))+c)";
        String input = "((a+b)+c)";
        System.out.println(checkRedundant(input) ? "Redundant" : "Not Redundant");
    }

    private static boolean checkRedundant(String input) {
        int length = input.length();

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < length; i++) {
            if(input.charAt(i) != ')') {
                stack.push(input.charAt(i));
            } else {
                boolean operatorFound = false;
                while (!stack.empty() && stack.peek() != '(') {
                    Character pop = stack.pop();
                    if(checkOperator(pop)) {
                        operatorFound = true;
                    }
                }
                stack.pop();
                if(!operatorFound) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean checkOperator(char c) {
        if(c == '+' || c == '-' || c == '*' || c == '/') {
            return true;
        }
        return false;
    }
}
