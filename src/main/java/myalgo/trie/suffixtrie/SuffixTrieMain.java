package myalgo.trie.suffixtrie;

public class SuffixTrieMain {
    public static void main(String[] args) {
        SuffixTrie suffixTrie = new SuffixTrie();
        suffixTrie.insert("hello");

        System.out.println(suffixTrie.search("llo"));
        System.out.println(suffixTrie.search("ello"));
        System.out.println(suffixTrie.search("hello"));
        System.out.println(suffixTrie.search("elo"));
        System.out.println(suffixTrie.search("el"));
    }
}
