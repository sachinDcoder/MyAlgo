package myalgo.graph.dijkshtra;

public class Node {
    int weight;
    int node;

    public Node(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "weight=" + weight +
                ", node=" + node +
                '}';
    }
}
