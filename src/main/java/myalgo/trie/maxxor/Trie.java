package myalgo.trie.maxxor;

public class Trie {
    Node root;

    public Trie() {
        root = new Node('\0');
    }

    public void insert(String binary) {
        Node temp = root;

        for(Character ch : binary.toCharArray()) {
            if(temp.children[ch - '0'] == null) {
                temp.children[ch - '0'] = new Node(ch);
            }
            temp = temp.children[ch - '0'];
        }
    }
}
