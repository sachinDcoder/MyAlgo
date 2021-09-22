package myalgo.trie.trie;

import java.util.HashMap;
import java.util.Map;

public class Node {
    char data;
    Map<Character, Node> children;
    boolean isEndOfWord;

    public Node(char data) {
        this.data = data;
        children = new HashMap<>();
        isEndOfWord = false;
    }
}
