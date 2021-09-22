package myalgo.trie.trie;

public class TrieMain {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] words = {"apple", "ape", "no", "news", "new", "not", "never"};

        for(String word : words) {
            trie.insert(word);
        }

        System.out.println("apple : " + trie.search("apple"));
        System.out.println("news : " + trie.search("news"));
        System.out.println("ne : " + trie.search("ne"));
        System.out.println("never : " + trie.search("never"));
        System.out.println("neve : " + trie.search("neve"));
    }
}
