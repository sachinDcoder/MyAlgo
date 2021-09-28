package myalgo.graph.cycledetection.directedgraph;

public class DirectedGraphCycleMain {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 2);
//        graph.addEdge(2, 0);

        System.out.println(graph.cycleDetection());
    }
}
