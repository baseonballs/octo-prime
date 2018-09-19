package io.octoprime.algo.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {

    private int vertices;   // No. of vertices
    private LinkedList<Integer> adjacencies[]; //Adjacency Lists

    // Constructor
    BFS(int v) {
        vertices = v;
        adjacencies = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjacencies[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adjacencies[v].add(w);
    }

    // prints BFS traversal from a given source s
    void traverse(int source) {
        // Mark all the vertices as not visited(By default
        // put as false)
        boolean visited[] = new boolean[vertices];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[source] = true;
        queue.add(source);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and serialzie it
            source = queue.poll();
            System.out.print(source + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adjacencies[source].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // Driver method to
    public static void main(String args[]) {
        BFS g = new BFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        g.traverse(2);
    }

}
