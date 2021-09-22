package myalgo.trie.cutelittlecat;

import java.util.HashMap;
import java.util.Map;

public class CuteCatMain {
    public static void main(String[] args) {
        String document = "little cute cat loves to code in c++,java and python";
        String[] words = {"cute cat", "ttle", "cat", "quick", "dog"};

        documentSearch(document, words);
    }

    private static void documentSearch(String document, String[] words) {
        Trie trie = new Trie();
        Map<String, Boolean> wordMap = new HashMap<>();

        for(String word : words) {
            trie.insert(word);
            wordMap.put(word, false);
        }

        for(int i = 0; i < document.length(); i++) {
            searchHelper(trie, document, i, wordMap);
        }

        System.out.println(wordMap.toString());
    }

    private static void searchHelper(Trie trie, String document, int i, Map<String, Boolean> wordMap) {
        Node temp = trie.root;

        for(int j = i; j < document.length(); j++) {
            char ch = document.charAt(j);

            if (temp == null || !temp.children.containsKey(ch)) {
                return;
            }
            temp = temp.children.get(ch);

            if (temp.isEndOfWord) {
                String str = document.substring(i, j+1);
                System.out.println("str: " + str);
                wordMap.put(str, true);
            }
        }
    }
}
