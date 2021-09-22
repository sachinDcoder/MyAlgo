package myalgo.trie.maxxor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

import static java.util.stream.Stream.generate;

public class MaxXorMain {
    public static int calMaximumXOR(Trie trie, List<String> binNums) {
        int maxXor = 0;

        for(String binNum : binNums) {
            Node temp = trie.root;
            String ans = "";
            int idx = 0;

            while (temp != null) {
                if (temp.children[1] != null && binNum.charAt(idx) == '0') {
                    ans += '1';
                    temp = temp.children[1];
                } else if (temp.children[0] != null && binNum.charAt(idx) == '1') {
                    ans += '1';
                    temp = temp.children[0];
                } else if (temp.children[1] != null) {
                    ans += '0';
                    temp = temp.children[1];
                } else if (temp.children[0] != null) {
                    ans += '0';
                    temp = temp.children[0];
                } else {
                    break;
                }
                idx++;
            }

            System.out.println("ans " + ans);
            maxXor = Integer.max(maxXor, Integer.parseInt(ans, 2));
        }

        return maxXor;
    }

    public static int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        int maxValue = Arrays.stream(nums).max().getAsInt();
        int maxBinaryLength = Integer.toBinaryString(maxValue).length();
        List<String> binNums = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            String numBinary = Integer.toBinaryString(nums[i]);
            int numLength = numBinary.length();
            String numBinaryWithFixedLength = generate(() -> "0").limit(maxBinaryLength - numLength).collect(joining()) + Integer.toBinaryString(nums[i]);
            binNums.add(numBinaryWithFixedLength);
            trie.insert(numBinaryWithFixedLength);

            System.out.println(numBinaryWithFixedLength);
        }

        return calMaximumXOR(trie, binNums);
    }

    public static void main(String[] args) {
        int[] nums = {14,70,53,83,49,91,36,80,92,51,66,70};

        System.out.println(findMaximumXOR(nums));
    }
}
