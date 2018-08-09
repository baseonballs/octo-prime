package io.octoprime.algo.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// link: https://java2blog.com/breadth-first-search-in-java/

public class BFSNeighborList {


    private Queue<Node> queue;
    static ArrayList<Node> nodes = new ArrayList<>();

    static class Node {
        int data;
        boolean visited;
        List<Node> neighbours;

        Node(int data) {
            this.data = data;
            this.neighbours = new ArrayList<>();

        }

        void addneighbours(Node neighbourNode) {
            this.neighbours.add(neighbourNode);
        }

        List<Node> getNeighbours() {
            return neighbours;
        }

        public void setNeighbours(List<Node> neighbours) {
            this.neighbours = neighbours;
        }
    }

    private BFSNeighborList() {
        queue = new LinkedList<>();
    }

    private void bfs(Node node) {
        queue.add(node);
        node.visited = true;
        while (!queue.isEmpty()) {

            Node element = queue.remove();
            System.out.print(element.data + "\t");
            List<Node> neighbours = element.getNeighbours();
            for (Node n : neighbours) {
                if (n != null && !n.visited) {
                    queue.add(n);
                    n.visited = true;
                }
            }

        }
    }

    public static void main(String arg[]) {

        Node node40 = new Node(40);
        Node node10 = new Node(10);
        Node node20 = new Node(20);
        Node node30 = new Node(30);
        Node node60 = new Node(60);
        Node node50 = new Node(50);
        Node node70 = new Node(70);

        node40.addneighbours(node10);
        node40.addneighbours(node20);
        node10.addneighbours(node30);
        node20.addneighbours(node10);
        node20.addneighbours(node30);
        node20.addneighbours(node60);
        node20.addneighbours(node50);
        node30.addneighbours(node60);
        node60.addneighbours(node70);
        node50.addneighbours(node70);
        System.out.println("The BFS traversal of the graph is ");
        BFSNeighborList bfsExample = new BFSNeighborList();
        bfsExample.bfs(node40);

    }
}
