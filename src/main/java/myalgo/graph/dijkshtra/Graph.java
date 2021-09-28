package myalgo.graph.dijkshtra;

import java.util.*;

public class Graph {
    int noOfVertex;
    List<List<Node>> adj;

    public Graph(int noOfVertex) {
        this.noOfVertex = noOfVertex;

        adj = new ArrayList<>(noOfVertex);
        for(int i = 0 ; i < noOfVertex ; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int w) {
        adj.get(u).add(new Node(v, w));
        adj.get(v).add(new Node(u, w));
    }

    public int dijkstra(int source, int dist) {
        int[] distance = new int[noOfVertex];
        Set<Node> set = new HashSet<>();
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[source] = 0;
        pq.add(new Node(source, 0));
        set.add(new Node(source, 0));

        while(!set.isEmpty() && !pq.isEmpty()) {
            Node curr = pq.poll();
//            System.out.println("curr " + curr);
            set.remove(curr);

            for(Node nbr : adj.get(curr.node)) {
                if(curr.weight + nbr.weight < distance[nbr.node]) {
                    distance[nbr.node] = curr.weight + nbr.weight;
                    set.remove(nbr);
                    Node newNode = new Node(nbr.node, distance[nbr.node]);
                    set.add(newNode);
                    pq.add(newNode);
                }
            }
        }

        for(int i = 0; i < noOfVertex; i++) {
            System.out.println("Shorted distance of " + i + " from " + source + " is " + distance[i]);
        }

        return distance[dist];
    }
}
