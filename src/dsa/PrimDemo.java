package dsa;

import java.util.*;

import static dsa.Util.mockEdges;

public class PrimDemo {
    static void main() {
        var edges = mockEdges();
        // Adjacency list
        Map<String, Set<Edge>> adjList = new HashMap<>();
        for (var edge : edges) {
            adjList.putIfAbsent(edge.u(), new HashSet<>());
            adjList.get(edge.u()).add(edge);
            adjList.putIfAbsent(edge.v(), new HashSet<>());
            adjList.get(edge.v()).add(new Edge(edge.v(), edge.u(), edge.weight()));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::weight));
        String startNode = "H";
        int cost = 0;
        List<Edge> edgesToVisit = new ArrayList<>();
        int target = adjList.size() - 1;
        Set<String> visited = new HashSet<>();

        pq.addAll(adjList.get(startNode));
        visited.add(startNode);
        while (!pq.isEmpty() && edgesToVisit.size() < target) {
            Edge edge = pq.poll();
            if (visited.add(edge.v())) {
                cost += edge.weight();
                edgesToVisit.add(edge);
                // Load all edges from next vertex to PriorityQueue
                pq.addAll(adjList.get(edge.v()));
            }
        }
        System.out.println("Cost: " + cost);
        System.out.println("Edges: " + edgesToVisit);
    }
}
