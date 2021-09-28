package myalgo.graph.bfs;

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

    public void findShortedDistanceUsingBfs(int source, int dist) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        boolean[] visited = new boolean[noOfVertex];
        int[] parent = new int[noOfVertex];
        int[] distance = new int[noOfVertex];

        Arrays.fill(visited, false);
        Arrays.fill(parent, -1);
        Arrays.fill(distance, -1);
        visited[source] = true;
        distance[source] = 0;
        parent[source] = source;

        while(!queue.isEmpty()) {
            int curr = queue.poll();

            for(Integer nbr : adjacencyList.get(curr)) {
                if(!visited[nbr]) {
                    queue.add(nbr);
                    parent[nbr] = curr;
                    distance[nbr] = distance[curr] + 1;
                    visited[nbr] = true;
                }
            }
        }

//        for(int i = 0; i < noOfVertex; i++) {
//            System.out.println("Shorted distance to " + i + " is " + distance[i]);
//        }
        System.out.println("Shorted distance to " + source + " is " + distance[dist]);

        int temp = dist;
        while(temp != source) {
            System.out.print(temp + " -- ");
            temp = parent[temp];
        }
        System.out.println(source);
    }
}
