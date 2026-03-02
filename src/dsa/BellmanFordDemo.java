package dsa;

import java.util.HashMap;
import java.util.Map;

public class BellmanFordDemo {
    static void main() {
        Edge[] edges = {
                new Edge("A", "B", 5),
                new Edge("A", "C", 4),
                new Edge("B", "D", 3),
                new Edge("D", "C", -10),
        };
        Map<String, Integer> distances = new HashMap<>();
        for (var edge : edges) {
            distances.putIfAbsent(edge.u(), Integer.MAX_VALUE);
            distances.putIfAbsent(edge.v(), Integer.MAX_VALUE);
        }
        String source = "A";
        distances.put(source, 0);
        var round = distances.size() - 1;
        for (int i = 0; i < round; i++) {
            for (var edge : edges) {
                if (distances.get(edge.u()) != Integer.MAX_VALUE) {
                    var nextDist = distances.get(edge.u()) + edge.weight();
                    if (nextDist < distances.get(edge.v())) {
                        distances.put(edge.v(), nextDist);
                    }
                }
            }
        }
        // Check for negative weight cycles
        for (var edge : edges) {
            if (distances.get(edge.u()) != Integer.MAX_VALUE) {
                var nextDist = distances.get(edge.u()) + edge.weight();
                if (nextDist < distances.get(edge.v())) {
                    throw new RuntimeException("Negative weight cycle detected");
                }
            }
        }
        System.out.println("Starting from node: " + source);
        for (var entry : distances.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
