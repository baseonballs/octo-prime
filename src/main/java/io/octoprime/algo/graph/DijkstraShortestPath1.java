package io.octoprime.algo.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraShortestPath1 {

    /*
     localize class def since this structure is specific to the dijkstra algorithm implementation;
     */
    static class Node implements Comparable<Node> {

        public final String key;
        public Node parent;

        public Edge[] edges;
        public double minDistance = Double.POSITIVE_INFINITY;

        public Node(String name) {
            key = name;
        }

        public String toString() {
            return key;
        }

        public int compareTo(Node node) {
            return Double.compare(minDistance, node.minDistance);
        }

    }

    //define Edge
    static class Edge {
        public final Node target;
        public final double cost;

        public Edge(Node node, double val) {
            target = node;
            cost = val;
        }
    }

    public static void computePaths(Node source) {
        source.minDistance = 0;

        /*
        use priority queue to take advantage of natural order of elements inserted into queue.
         */
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        queue.add(source);

        while (!queue.isEmpty()) {
            Node u = queue.poll();

			/*visit the edges, starting from
			the nearest node(smallest minDistance)*/
            for (Edge e : u.edges) {

                Node v = e.target;
                double weight = e.cost;

                //relax(u,v,cost)
                double distanceFromU = u.minDistance + weight;
                if (distanceFromU < v.minDistance) {

					/*remove v from queue for updating
					the minDistance key*/
                    queue.remove(v);
                    v.minDistance = distanceFromU;
                    v.parent = u;
                    queue.add(v);
                }
            }
        }
    }

    public static List<Node> getShortestPathTo(Node target) {

        //trace path from target to source
        List<Node> path = new ArrayList<Node>();
        for (Node node = target; node != null; node = node.parent) {
            path.add(node);
        }

        //reverse the order such that it will be from source to target
        Collections.reverse(path);

        return path;
    }

    public static Node[] initializeGraph() {
        //initialize the graph base on the Romania map
        Node n1 = new Node("Arad");
        Node n2 = new Node("Zerind");
        Node n3 = new Node("Oradea");
        Node n4 = new Node("Sibiu");
        Node n5 = new Node("Fagaras");
        Node n6 = new Node("Rimnicu Vilcea");
        Node n7 = new Node("Pitesti");
        Node n8 = new Node("Timisoara");
        Node n9 = new Node("Lugoj");
        Node n10 = new Node("Mehadia");
        Node n11 = new Node("Drobeta");
        Node n12 = new Node("Craiova");
        Node n13 = new Node("Bucharest");
        Node n14 = new Node("Giurgiu");

        //initialize the edges
        n1.edges = new Edge[]{
                new Edge(n2, 75),
                new Edge(n4, 140),
                new Edge(n8, 118)
        };

        n2.edges = new Edge[]{
                new Edge(n1, 75),
                new Edge(n3, 71)
        };

        n3.edges = new Edge[]{
                new Edge(n2, 71),
                new Edge(n4, 151)
        };

        n4.edges = new Edge[]{
                new Edge(n1, 140),
                new Edge(n5, 99),
                new Edge(n3, 151),
                new Edge(n6, 80),
        };

        n5.edges = new Edge[]{
                new Edge(n4, 99),
                new Edge(n13, 211)
        };

        n6.edges = new Edge[]{
                new Edge(n4, 80),
                new Edge(n7, 97),
                new Edge(n12, 146)
        };

        n7.edges = new Edge[]{
                new Edge(n6, 97),
                new Edge(n13, 101),
                new Edge(n12, 138)
        };

        n8.edges = new Edge[]{
                new Edge(n1, 118),
                new Edge(n9, 111)
        };

        n9.edges = new Edge[]{
                new Edge(n8, 111),
                new Edge(n10, 70)
        };

        n10.edges = new Edge[]{
                new Edge(n9, 70),
                new Edge(n11, 75)
        };

        n11.edges = new Edge[]{
                new Edge(n10, 75),
                new Edge(n12, 120)
        };

        n12.edges = new Edge[]{
                new Edge(n11, 120),
                new Edge(n6, 146),
                new Edge(n7, 138)
        };

        n13.edges = new Edge[]{
                new Edge(n7, 101),
                new Edge(n14, 90),
                new Edge(n5, 211)
        };

        n14.edges = new Edge[]{
                new Edge(n13, 90)
        };

        Node[] nodes = {n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14};

        return nodes;

    }

    public static void main(String[] args) {
        Node[] nodes = initializeGraph();

        computePaths(nodes[0]);

        /*
        Print the paths starting from source to destination; also qualify the cost of the path traversal.
         */
        for (Node n : nodes) {
            System.out.println("Distance to " +
                    n + ": " + n.minDistance);
            List<Node> path = getShortestPathTo(n);
            System.out.println(" path: " + path);
        }
    }

}
