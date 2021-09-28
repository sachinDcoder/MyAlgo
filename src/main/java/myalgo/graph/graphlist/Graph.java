package myalgo.graph.graphlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int noOfVertex;
    private ArrayList<ArrayList<Integer>> adjacencyList;

    public Graph(int noOfVertex) {
        this.noOfVertex = noOfVertex;
        this.adjacencyList = new ArrayList<>(noOfVertex);

        for(int i = 0; i < noOfVertex; i++) {
            this.adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, boolean isDirected) {
        adjacencyList.get(u).add(v);
        if(!isDirected) {
            adjacencyList.get(v).add(u);
        }
    }

    public void printGraph() {
        for(ArrayList<Integer> adjList : adjacencyList) {
            System.out.print("head");
            for(Integer vertex : adjList) {
                System.out.print("->" + vertex);
            }
            System.out.println();
        }
    }

    public void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        boolean[] isVisited = new boolean[noOfVertex];
        Arrays.fill(isVisited, false);
        isVisited[v] = true;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.println(curr);

            for(Integer nbr : adjacencyList.get(curr)) {
                if(!isVisited[nbr]) {
                    queue.add(nbr);
                    isVisited[nbr] = true;
                }
            }
        }
    }
}
