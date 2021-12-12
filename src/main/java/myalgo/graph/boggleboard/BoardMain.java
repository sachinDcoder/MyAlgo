package myalgo.graph.boggleboard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BoardMain {

    public static void main(String[] args) {
//        String[] words = {"SNAKE", "FOR", "QUEZ", "SNACK", "SNACKS", "GO", "TUNES", "CAT"};
//
//        char[][] board = {
//                {'S', 'E', 'R', 'T'},
//                {'U', 'N', 'K', 'S'},
//                {'T', 'C', 'A', 'T'}
//        };

        String[] words = {"abc","abcd"};

        char[][] board = {
                {'a', 'b', 'c', 'e'},
                {'x', 'x', 'c', 'd'},
                {'x', 'x', 'b', 'a'}
        };

        int n = board.length;
        int m = board[0].length;

        Trie trie = new Trie();
        for(String word : words) {
            trie.insert(word);
        }

        Set<String> output = new HashSet<>();
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dfs(board, trie.root, i, j, visited, output);
            }
        }

        System.out.println(new ArrayList<>(output));
    }

    private static void dfs(char[][] board, Node node, int i, int j, boolean[][] visited, Set<String> output) {
        char ch = board[i][j];

        if(!node.children.containsKey(ch)) {
            return;
        }

        visited[i][j] = true;
        node = node.children.get(ch);

        if(node.terminal) {
            output.add(node.word);
        }

        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

        for(int k = 0; k < 8; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];

            if(ni >= 0 && nj >= 0 && ni < board.length && nj < board[0].length && !visited[ni][nj]) {
                dfs(board, node, ni, nj, visited, output);
            }
        }

        visited[i][j] = false;
    }
}
