package myalgo.graph.dfs;

import java.util.*;

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

    public void dfs(int source) {
        boolean[] visited = new boolean[noOfVertex];
        Arrays.fill(visited, false);

        dfsHelper(source, visited);
    }

    private void dfsHelper(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + "-->");

        for(Integer nbr: adjacencyList.get(node)) {
            if(!visited[nbr]) {
                dfsHelper(nbr, visited);
            }
        }
    }

    public void dfsIterative(int source) {
        boolean[] visited = new boolean[noOfVertex];
        Arrays.fill(visited, false);

        Stack<Integer> stack = new Stack<>();
        stack.add(source);
        visited[source] = true;

        while(!stack.empty()) {
            int node = stack.pop();
            System.out.print(node + "-->");

            for(Integer nbr: adjacencyList.get(node)) {
                if(!visited[nbr]) {
                    stack.add(nbr);
                    visited[nbr] = true;
                }
            }
        }
    }

    public boolean detectCycleHelper(int node, int parent, boolean[] visited) {
        visited[node] = true;

        for(Integer nbr : adjacencyList.get(node)) {
            if(!visited[nbr]) {
                boolean check = detectCycleHelper(nbr, node, visited);
                if(check) {
                    return true;
                }
            } else if(nbr != parent) {
                return true;
            }
        }

        return false;
    }

    public boolean detectCycle() {
        boolean[] visited = new boolean[noOfVertex];
        Arrays.fill(visited, false);

        return detectCycleHelper(0, -1, visited);
    }
}
