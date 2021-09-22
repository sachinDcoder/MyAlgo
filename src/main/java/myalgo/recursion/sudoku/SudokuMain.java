package myalgo.recursion.sudoku;

public class SudokuMain {
    public static void main(String[] args) {
        int n = 9;
        int[][] mat = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 3},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9},
        };

        if(!solveSudoku(mat, 0, 0, n)) {
            System.out.println("No Solution Exist");
        }
    }

    private static boolean solveSudoku(int[][] mat, int i, int j, int n) {
        if(i == n) {
            for(int x = 0; x < n; x++) {
                for(int y = 0; y < n; y++) {
                    System.out.print(mat[x][y] + " ");
                }
                System.out.println();
            }
            return true;
        }

        if(j == n) {
            return solveSudoku(mat, i + 1, 0, n);
        }

        for(int number = 1; number <= 9; number++) {
            if(isSafe(mat, i, j, number, n)) {
                mat[i][j] = number;
                if(solveSudoku(mat, i, j + 1, n)) {
                    return true;
                }
            }
        }

        mat[i][j] = 0;
        return false;
    }

    private static boolean isSafe(int[][] mat, int i, int j, int number, int n) {
        for(int x = 0; x < n; x++) {
            if(mat[i][x] == number || mat[x][j] == number) {
                return false;
            }
        }

        int gridSize = (int) Math.sqrt(n);
        int gr = (i / gridSize) * gridSize;
        int gc = (j / gridSize) * gridSize;

        for(int x = gr; x < gr + 3; x++) {
            for(int y = gc; y < gc + 3; y++) {
                if(mat[x][y] == number) {
                    return false;
                }
            }
        }

        return true;
    }
}
