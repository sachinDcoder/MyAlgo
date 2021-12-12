package myalgo.graph.boggleboard;

public class Trie {
    Node root;

    public Trie() {
        root = new Node('\0');
    }

    public void insert(String word) {
        Node temp = root;

        for(char ch : word.toCharArray()) {
            if(!temp.children.containsKey(ch)) {
                Node newNode = new Node(ch);
                temp.children.put(ch, newNode);
            }

            temp = temp.children.get(ch);
        }

        temp.terminal = true;
        temp.word = word;
    }
}
