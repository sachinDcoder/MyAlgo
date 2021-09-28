package myalgo.graph.bfs;

public class ShortedDistanceUsingBfsMain {
    public static void main(String[] args) {
        Graph graph = new Graph(7);

        graph.addEdge(0, 1, false);
        graph.addEdge(1, 2, false);
        graph.addEdge(2, 3, false);
        graph.addEdge(3, 5, false);
        graph.addEdge(5, 6, false);
        graph.addEdge(4, 5, false);
        graph.addEdge(0, 4, false);
        graph.addEdge(3, 4, false);

        graph.printGraph();

        System.out.println();

        graph.findShortedDistanceUsingBfs(1, 6);
    }
}
