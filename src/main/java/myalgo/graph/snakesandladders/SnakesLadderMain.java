package myalgo.graph.snakesandladders;

public class SnakesLadderMain {
    public static void main(String[] args) {
        int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        System.out.println(snakesAndLadders(board));
    }

    public static int snakesAndLadders(int[][] board) {
        int n = board[0].length;
        int grid = 1;

        Graph graph = new Graph(n);

        for(int i = n, k = 1; i >= 0; i--, k++) {
            for(int j = 1; j <= n; j++) {
                for(int dice = 1; dice <= 6; dice++) {
                    int y = (dice + j) % 6;
                    if(y == 0) {
                        y = 6;
                    }

                    int x = (i - (dice + j) / 7);
                    if(x <= 0 || (grid + dice > n * n)) {
                        break;
                    }

                    if(board[x - 1][y - 1] == -1) {
                        graph.addEdge(grid, grid + dice);
                    } else {
                        graph.addEdge(grid, board[x - 1][y - 1]);
                    }
                }
                grid++;
            }
        }

        graph.printGraph();

        return graph.getShortedPath(1, n * n);
    }
}
