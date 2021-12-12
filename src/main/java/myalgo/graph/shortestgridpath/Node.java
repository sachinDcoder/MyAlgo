package myalgo.graph.shortestgridpath;

import java.util.Objects;

public class Node {
    int distance;
    int x;
    int y;

    public Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return distance == node.distance && x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, x, y);
    }
}
