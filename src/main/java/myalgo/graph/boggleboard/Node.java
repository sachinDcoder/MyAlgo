package myalgo.graph.boggleboard;

import java.util.HashMap;
import java.util.Map;

public class Node {
    char data;
    Map<Character, Node> children;
    boolean terminal;
    String word;

    public Node(char data) {
        this.data = data;
        children = new HashMap<>();
        terminal = false;
        word = "";
    }
}
