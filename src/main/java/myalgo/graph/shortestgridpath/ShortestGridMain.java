package myalgo.graph.shortestgridpath;

import java.util.*;

public class ShortestGridMain {


    public static void main(String[] args) {
//        int[][] grid = {
//                {31, 100, 64, 12, 18},
//                {10, 13, 47, 157, 6},
//                {100, 113, 174, 11, 33},
//                {88, 124, 41, 20, 140},
//                {99, 32, 111, 41, 20},
//        };

        int[][] grid = {
                {5,4,2,9,6,0,3,5,1,4,9,8,4,9,7,5,1},
                {3,4,9,2,9,9,0,9,7,9,4,7,8,4,4,5,8},
                {6,1,8,9,8,0,3,7,0,9,8,7,4,9,2,0,1},
                {4,0,0,5,1,7,4,7,6,4,1,0,1,0,6,2,8},
                {7,2,0,2,9,3,4,7,0,8,9,5,9,0,1,1,0},
                {8,2,9,4,9,7,9,3,7,0,3,6,5,3,5,9,6},
                {8,9,9,2,6,1,2,5,8,3,7,0,4,9,8,8,8},
                {5,8,5,4,1,5,6,6,3,3,1,8,3,9,6,4,8},
                {0,2,2,3,0,2,6,7,2,3,7,3,1,5,8,1,3},
                {4,4,0,2,0,3,8,4,1,3,3,0,7,4,2,9,8},
                {5,9,0,4,7,5,7,6,0,8,3,0,0,6,6,6,8},
                {0,7,1,8,3,5,1,8,7,0,2,9,2,2,7,1,5},
                {1,0,0,0,6,2,0,0,2,2,8,0,9,7,0,8,0},
                {1,1,7,2,9,6,5,4,8,7,8,5,0,3,8,1,5},
                {8,9,7,8,1,1,3,0,1,2,9,4,0,1,5,3,1},
                {9,2,7,4,8,7,3,9,2,4,2,2,7,8,2,6,7},
                {3,8,1,6,0,4,8,9,8,0,2,5,3,5,5,7,5},
                {1,8,2,5,7,7,1,9,9,8,9,2,4,9,5,4,0},
                {3,4,4,1,5,3,3,8,8,6,3,5,3,8,7,1,3}
        };

        System.out.println(findShortestDistance(grid));
    }

    private static int findShortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];

        for(int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Set<Node> set = new HashSet<>();
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparing(node -> node.distance));


        dist[0][0] = grid[0][0];
        set.add(new Node(0, 0, dist[0][0]));
        pq.add(new Node(0, 0, dist[0][0]));

        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};

        while(!set.isEmpty() && !pq.isEmpty()) {
            Node currNode = pq.poll();
            int cx = currNode.x;
            int cy = currNode.y;
            int cDistance = currNode.distance;

//            System.out.println("cDistance " + cDistance);

            set.remove(currNode);

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n && (cDistance + grid[nx][ny] < dist[nx][ny])) {
                    Node temp = new Node(nx, ny, dist[nx][ny]);
                    set.remove(temp);

                    dist[nx][ny] = cDistance + grid[nx][ny];
                    Node newNode = new Node(nx, ny, dist[nx][ny]);
                    set.add(newNode);
                    pq.add(newNode);
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }

        return dist[m - 1][n - 1];
    }
}
