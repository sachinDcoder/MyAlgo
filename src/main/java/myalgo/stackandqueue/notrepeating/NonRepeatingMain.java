package myalgo.stackandqueue.notrepeating;

import java.util.ArrayDeque;
import java.util.Queue;

public class NonRepeatingMain {
    public static void main(String[] args) {
        String input = "aabccbcd";

        System.out.println(nonFirstRepeatingChar(input));
    }

    private static String nonFirstRepeatingChar(String input) {
        String output = "";
        int[] frequencies = new int[27];
        Queue<Character> queue = new ArrayDeque<>();

        for(int i = 0; i < input.length(); i++) {
            queue.add(input.charAt(i));
            frequencies[input.charAt(i) - 'a'] += 1;

            while(!queue.isEmpty()) {
                int idx = queue.peek() - 'a';
                if(frequencies[idx] > 1) {
                    queue.remove();
                } else {
                    output = output + queue.peek();
                    break;
                }
            }

            if(queue.isEmpty()) {
                output = output + "-1";
            }
        }

        return output;
    }
}
