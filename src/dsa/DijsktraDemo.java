package dsa;

import java.util.*;

public class DijsktraDemo {
    static void main() {
        Edge[] edges = {
                new Edge("A", "B", 2),
                new Edge("A", "C", 4),
                new Edge("B", "C", 1),
                new Edge("B", "D", 7),
                new Edge("C", "E", 3),
                new Edge("E", "D", 2),
                new Edge("D", "F", 1),
                new Edge("E", "F", 5),
        };
        // Create adjacency list
        Map<String, List<Edge>> graph = new HashMap<>();
        Map<String, Integer> distances = new HashMap<>();
        // Set Infinity
        for (var edge : edges) {
            distances.putIfAbsent(edge.u(), Integer.MAX_VALUE);
            distances.putIfAbsent(edge.v(), Integer.MAX_VALUE);
            graph.putIfAbsent(edge.u(), new ArrayList<>());
            graph.putIfAbsent(edge.v(), new ArrayList<>());
            graph.get(edge.u()).add(edge);
        }
        PriorityQueue<NodeDist> pq = new PriorityQueue<>(
                Comparator.comparingInt(NodeDist::totalWeight)
        );
        String source = "A";
        pq.add(new NodeDist(source, 0));
        distances.put(source, 0);
        Set<String> visited = new HashSet<>();
        while (!pq.isEmpty()) {
            var currentVertex = pq.poll();
            if (!visited.contains(currentVertex.u)) {
                for (var next : graph.get(currentVertex.u)) {
                    if (!visited.contains(next.v())) {
                        var newDist = distances.get(currentVertex.u) + next.weight();
                        if (newDist < distances.get(next.v())) {
                            distances.put(next.v(), newDist);
                            pq.add(new NodeDist(next.v(), newDist));
                        }
                    }
                }
            }
            visited.add(currentVertex.u());
        }
        System.out.println("Starting from node: " + source);
        for (var entry : distances.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    private record NodeDist(String u, int totalWeight) {
    }
}
