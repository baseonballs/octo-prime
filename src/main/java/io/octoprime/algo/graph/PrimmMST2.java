package io.octoprime.algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimmMST2 {

    public class Node implements Comparable<Node> {
        int vertice, key;

        Node(int vertice, int key) {
            this.vertice = vertice;
            this.key = key;
        }

        @Override
        public int compareTo(Node o) {
            return this.key - o.key;
        }
    }

    public class AdjList {
        ArrayList<Node> nodes;
    }

    public class Graph {
        int V;
        AdjList[] adjLists;
    }


    private Graph createGraph(int v) {
        Graph graph = new Graph();
        graph.V = v;
        graph.adjLists = new AdjList[v];
        for (int i = 0; i < v; i++) {
            AdjList adjList = new AdjList();
            adjList.nodes = new ArrayList<>(); //initialize its node list too
            graph.adjLists[i] = adjList;
        }
        return graph;
    }

    private void addEdge(Graph graph, int src, int dest, int key) {
        Node srcNode = new Node(src, key);
        Node destNode = new Node(dest, key);
        graph.adjLists[src].nodes.add(destNode);
        graph.adjLists[dest].nodes.add(srcNode);
    }

    private void printGraph(Graph graph) {
        for (int i = 0; i < graph.V; i++) {
            System.out.print(i + " ->");
            for (Node node : graph.adjLists[i].nodes) {
                System.out.print(" " + node.vertice);
            }
            System.out.println();
        }
    }

    private void getPrimsMST(Graph graph) {
        Node keys[] = new Node[graph.V];
        int parent[] = new int[graph.V];
        boolean mstSet[] = new boolean[graph.V];

        for (int i = 0; i < graph.V; i++) {
            keys[i] = new Node(i, Integer.MAX_VALUE);
            parent[i] = -1;
            mstSet[i] = false;
        }
        keys[0].key = 0;
        Queue<Node> pQueue = new PriorityQueue<>(Arrays.asList(keys));


        while (pQueue.size() > 1) {
            Node u = pQueue.remove();
            mstSet[u.vertice] = true;

            for (Node node : graph.adjLists[u.vertice].nodes) {

                if (!mstSet[node.vertice] && node.key < keys[node.vertice].key) {
                    pQueue.remove(keys[node.vertice]); //remove that node from q

                    keys[node.vertice].key = node.key; //change key
                    parent[node.vertice] = u.vertice;

                    pQueue.add(keys[node.vertice]); //add back
                    //remove add can me made single function by using a visited flag
                    //remove_add() in O(lg(n))
                }

            }
        }
        print_mst(keys, parent, graph);

    }

    private void print_mst(Node[] keys, int[] parent, Graph graph) {
        for (int i = 1; i < graph.V; i++) {
            System.out.println(parent[keys[i].vertice] + "-" + keys[i].vertice + " " + keys[i].key);
        }
    }

    public static void main(String[] args) {
        int V = 9;
        PrimmMST2 mst = new PrimmMST2();
        Graph graph = mst.createGraph(V);
        mst.addEdge(graph, 0, 1, 4);
        mst.addEdge(graph, 0, 7, 8);
        mst.addEdge(graph, 1, 2, 8);
        mst.addEdge(graph, 1, 7, 11);
        mst.addEdge(graph, 2, 3, 7);
        mst.addEdge(graph, 2, 8, 2);
        mst.addEdge(graph, 2, 5, 4);
        mst.addEdge(graph, 3, 4, 9);
        mst.addEdge(graph, 3, 5, 14);
        mst.addEdge(graph, 4, 5, 10);
        mst.addEdge(graph, 5, 6, 2);
        mst.addEdge(graph, 6, 7, 1);
        mst.addEdge(graph, 6, 8, 6);
        mst.addEdge(graph, 7, 8, 7);


        // print the adjacency list representation of the above graph
        mst.printGraph(graph);
        System.out.println();
        mst.getPrimsMST(graph);

    }
}
