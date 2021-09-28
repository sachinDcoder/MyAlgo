package myalgo.graph.cycledetection.directedgraph;

import java.util.ArrayList;
import java.util.Arrays;

public class DirectedGraph {
    private int noOfVertex;
    private ArrayList<ArrayList<Integer>> adjacencyList;

    public DirectedGraph(int noOfVertex) {
        this.noOfVertex = noOfVertex;
        this.adjacencyList = new ArrayList<>(noOfVertex);

        for(int i = 0; i < noOfVertex; i++) {
            this.adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
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

    public boolean cycleDetection() {
        boolean[] visited = new boolean[noOfVertex];
        boolean[] stack = new boolean[noOfVertex];
        Arrays.fill(visited, false);
        Arrays.fill(stack, false);

        for(int i = 0 ; i < noOfVertex ; i++) {
            if(!visited[i]) {
                boolean foundBackEdge = dfs(i, visited, stack);
                if(foundBackEdge) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, boolean[] visited, boolean[] stack) {
        visited[i] = true;
        stack[i] = true;

        for(Integer nbr : adjacencyList.get(i)) {
            if(stack[nbr]) {
                return true;
            } else if(!visited[nbr]) {
                boolean foundBackEdge = dfs(nbr, visited, stack);
                if(foundBackEdge) {
                    return true;
                }
            }
        }

        stack[i] = false;
        return false;
    }
}
