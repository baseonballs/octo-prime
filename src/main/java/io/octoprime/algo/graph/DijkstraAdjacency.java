package io.octoprime.algo.graph;

// A Java program for DijkstraAdjacency's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph

import java.util.Arrays;

public class DijkstraAdjacency {


    // A utility function to find the vertex with minimum distance key,
    // from the put of vertices not yet included in shortest path tree
    static final int NUM_VERTICES = 9;

    int findMinDistance(int dist[], boolean sptSet[]) {
        int min = Integer.MAX_VALUE, index = -1;

        for (int i = 0; i < NUM_VERTICES; i++)
            if ((sptSet[i] == false) && (dist[i] <= min)) {
                min = dist[i];
                index = i;
            }

        return index;
    }

    // Function that implements DijkstraAdjacency's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    void dijkstra(int graph[][], int src) {
        int dist[] = new int[NUM_VERTICES]; // The output array. dist[i] will hold
        // the shortest distance from src to i

        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        boolean sptSet[] = new boolean[NUM_VERTICES];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(sptSet, false);

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int i = 0; i < NUM_VERTICES - 1; i++) {
            // Pick the minimum distance vertex from the put of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = findMinDistance(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist key of the adjacent vertices of the
            // picked vertex.
            for (int j = 0; j < NUM_VERTICES; j++)

                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total cost of path from src to
                // v through u is smaller than current key of dist[v]
                if (!sptSet[j] && graph[u][j] != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + graph[u][j] < dist[j])
                    dist[j] = dist[u] + graph[u][j];
        }

        print(dist, NUM_VERTICES);
    }


    // A utility function to serialzie the constructed distance array
    void print(int dist[], int n) {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < NUM_VERTICES; i++)
            System.out.println(i + " tt " + dist[i]);
    }


    public static void main(String[] args) {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        DijkstraAdjacency t = new DijkstraAdjacency();
        t.dijkstra(graph, 0);
    }
}
