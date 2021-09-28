package myalgo.graph.dijkshtra;

public class DijkshtraMain {
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(0, 3, 7);
        graph.addEdge(3, 2, 2);
        graph.addEdge(3, 4, 3);

        System.out.println(graph.dijkstra(0, 4));
    }
}
