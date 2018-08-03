package io.octoprime.algo.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


class DijkstraShortestPath {

    public static class Edge {

        private double weight;
        private Vertex source;
        private Vertex destination;

        public Edge(double weight, Vertex startVertex, Vertex targetVertex) {
            this.weight = weight;
            this.source = startVertex;
            this.destination = targetVertex;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public Vertex getSource() {
            return source;
        }

        public void setSource(Vertex source) {
            this.source = source;
        }

        public Vertex getDestination() {
            return destination;
        }

        public void setDestination(Vertex destination) {
            this.destination = destination;
        }
    }

    public static class Vertex implements Comparable<Vertex> {

        private String name;
        private List<Edge> neighborsList;
        private boolean visited;
        private Vertex predecessor;
        private double distance = Double.MAX_VALUE;

        public Vertex(String name) {
            this.name = name;
            this.neighborsList = new ArrayList<>();
        }

        public void addNeighbour(Edge edge) {
            this.neighborsList.add(edge);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Edge> getNeighborsList() {
            return neighborsList;
        }

        public void setNeighborsList(List<Edge> neighborsList) {
            this.neighborsList = neighborsList;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public Vertex getPredecessor() {
            return predecessor;
        }

        public void setPredecessor(Vertex predecessor) {
            this.predecessor = predecessor;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        @Override
        public String toString() {
            return this.name;
        }

        @Override
        public int compareTo(Vertex otherVertex) {
            return Double.compare(this.distance, otherVertex.getDistance());
        }
    }


    public void computeShortestPaths(Vertex source) {

        source.setDistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(source);
        source.setVisited(true);

        while (!priorityQueue.isEmpty()) {
            // Getting the minimum distance vertex from priority queue
            Vertex v = priorityQueue.poll();

            for (Edge edge : v.getNeighborsList()) {

                Vertex target = edge.getDestination();
                if (!target.isVisited()) {
                    double newDistance = v.getDistance() + edge.getWeight();

                    if (newDistance < target.getDistance()) {
                        priorityQueue.remove(target);
                        target.setDistance(newDistance);
                        target.setPredecessor(v);
                        priorityQueue.add(target);
                    }
                }
            }
            v.setVisited(true);
        }
    }

    public List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> path = new ArrayList<>();

        for (Vertex v = target; v != null; v = v.getPredecessor()) {
            path.add(v);
        }

        Collections.reverse(path);
        return path;
    }


    public static void main(String[] args) {

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");

        a.addNeighbour(new Edge(10, a, c));
        a.addNeighbour(new Edge(17, a, b));
        c.addNeighbour(new Edge(5, c, b));
        c.addNeighbour(new Edge(9, c, d));
        c.addNeighbour(new Edge(11, c, e));
        b.addNeighbour(new Edge(1, b, d));
        d.addNeighbour(new Edge(6, d, e));

        DijkstraShortestPath shortestPath = new DijkstraShortestPath();
        shortestPath.computeShortestPaths(a);

        System.out.println("======================================");
        System.out.println("Calculating minimum distance");
        System.out.println("======================================");

        System.out.println("Minimum distance from A to B: " + b.getDistance());
        System.out.println("Minimum distance from A to C: " + c.getDistance());
        System.out.println("Minimum distance from A to D: " + d.getDistance());
        System.out.println("Minimum distance from A to E: " + e.getDistance());

        System.out.println("=====================	=================");
        System.out.println("Calculating Paths");
        System.out.println("======================================");

        System.out.println("Shortest Path from A to B: " + shortestPath.getShortestPathTo(b));
        System.out.println("Shortest Path from A to C: " + shortestPath.getShortestPathTo(c));
        System.out.println("Shortest Path from A to D: " + shortestPath.getShortestPathTo(d));
        System.out.println("Shortest Path from A to E: " + shortestPath.getShortestPathTo(e));
    }

}
