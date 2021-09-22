package myalgo.trie.suffixtrie;

public class SuffixTrie {
    Node root;

    public SuffixTrie() {
        root = new Node('\0');
    }

    public void insert(String word) {
        for(int i = 0; i < word.length(); i++) {
            insertWord(word.substring(i));
        }
    }

    private void insertWord(String word) {
        Node temp = root;

        for(char ch : word.toCharArray()) {
            if(!temp.children.containsKey(ch)) {
                Node node = new Node(ch);
                temp.children.put(ch, node);
            }
            temp = temp.children.get(ch);
        }

        temp.isEndOfWord = true;
    }

    public boolean search(String word) {
        Node temp = root;

        for(char ch : word.toCharArray()) {
            if(!temp.children.containsKey(ch)) {
               return false;
            }
            temp = temp.children.get(ch);
        }
        return temp.isEndOfWord;
    }
}
