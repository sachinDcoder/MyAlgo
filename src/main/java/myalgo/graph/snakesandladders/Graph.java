package myalgo.graph.snakesandladders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    int noOfVertex;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    public Graph(int noOfVertex) {
        this.noOfVertex = noOfVertex;

        for(int i = 0; i <= noOfVertex * noOfVertex; i++) {
            this.adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int u) {
        adj.get(v).add(u);
    }

    public int getShortedPath(int src, int dist) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        boolean[] isVisited = new boolean[noOfVertex * noOfVertex + 1];
        Arrays.fill(isVisited, false);
        isVisited[src] = true;

        int[] distance = new int[noOfVertex * noOfVertex + 1];
        Arrays.fill(distance, -1);
        distance[src] = 0;

        while(!queue.isEmpty()) {
            int curr = queue.poll();

            for(Integer nbr: adj.get(curr)) {
                if(!isVisited[nbr]) {
                    queue.add(nbr);
                    distance[nbr] = distance[curr] + 1;
                    isVisited[nbr] = true;
                }
            }
        }

        for(int i = 1; i <= noOfVertex * noOfVertex; i++) {
            System.out.println("Shorted distance to " + i + " is " + distance[i]);
        }

        return distance[dist];
    }

    public void printGraph() {
        for(ArrayList<Integer> adjList : adj) {
            System.out.print("head");
            for(Integer vertex : adjList) {
                System.out.print("->" + vertex);
            }
            System.out.println();
        }
    }
}
