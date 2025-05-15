package practice;

import java.util.*;

class Node {
    String id;
    double x, y;
    double dx, dy;

    public Node(String id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
    }
}

class Edge {
    Node source, target;

    public Edge(Node source, Node target) {
        this.source = source;
        this.target = target;
    }
}

public class ForceAtlas2Layout {
    private static final double REPULSION_STRENGTH = 1000;
    private static final double ATTRACTION_STRENGTH = 0.01;
    private static final double GRAVITY = 0.1;
    private static final double SPEED = 0.1;
    private static final int ITERATIONS = 100;
    private static final double MIN_DISTANCE = 0.1; // Prevent division by zero

    private List<Node> nodes;
    private List<Edge> edges;

    public ForceAtlas2Layout(List<Node> nodes, List<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public void applyLayout() {
        for (int iter = 0; iter < ITERATIONS; iter++) {
            for (Node n : nodes) {
                n.dx = 0;
                n.dy = 0;
            }

            for (Node n1 : nodes) {
                for (Node n2 : nodes) {
                    if (!n1.equals(n2)) {
                        double dx = n1.x - n2.x;
                        double dy = n1.y - n2.y;
                        double distance = Math.sqrt(dx * dx + dy * dy);
                        if (distance < MIN_DISTANCE) distance = MIN_DISTANCE;

                        double force = REPULSION_STRENGTH / (distance * distance + 0.1);

                        n1.dx += (dx / distance) * force;
                        n1.dy += (dy / distance) * force;
                    }
                }
            }

            for (Edge edge : edges) {
                double dx = edge.target.x - edge.source.x;
                double dy = edge.target.y - edge.source.y;
                double distance = Math.sqrt(dx * dx + dy * dy);
                if (distance < MIN_DISTANCE) distance = MIN_DISTANCE;

                double force = ATTRACTION_STRENGTH * (distance * distance);
                edge.source.dx += (dx / distance) * force;
                edge.source.dy += (dy / distance) * force;
                edge.target.dx -= (dx / distance) * force;
                edge.target.dy -= (dy / distance) * force;
            }

            for (Node n : nodes) {
                n.dx -= n.x * GRAVITY;
                n.dy -= n.y * GRAVITY;
            }

            for (Node n : nodes) {
                if (!Double.isNaN(n.dx) && !Double.isNaN(n.dy)) {
                    n.x += n.dx * SPEED;
                    n.y += n.dy * SPEED;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Node> nodes = Arrays.asList(
                new Node("A", Math.random() * 100, Math.random() * 100),
                new Node("B", Math.random() * 100, Math.random() * 100),
                new Node("C", Math.random() * 100, Math.random() * 100),
                new Node("D", Math.random() * 100, Math.random() * 100)
        );

        List<Edge> edges = Arrays.asList(
                new Edge(nodes.get(0), nodes.get(1)),
                new Edge(nodes.get(1), nodes.get(2)),
                new Edge(nodes.get(2), nodes.get(3)),
                new Edge(nodes.get(3), nodes.get(0))
        );

        ForceAtlas2Layout layout = new ForceAtlas2Layout(nodes, edges);
        layout.applyLayout();

        for (Node node : nodes) {
            System.out.println("Node " + node.id + " -> x: " + node.x + ", y: " + node.y);
        }
    }
}