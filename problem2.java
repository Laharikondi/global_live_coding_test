import java.util.*;

public class problem2{

    // Helper class to represent a graph edge
    static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static Map<Integer, Integer> dijkstra(Map<Integer, List<Edge>> graph, int source) {
        Map<Integer, Integer> distances = new HashMap<>();
        for (Integer vertex : graph.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(source, 0);

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        priorityQueue.add(new int[]{source, 0});

        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            int currentVertex = current[0];
            int currentDistance = current[1];

            if (currentDistance > distances.get(currentVertex)) {
                continue;
            }

            for (Edge edge : graph.get(currentVertex)) {
                int neighbor = edge.target;
                int newDist = currentDistance + edge.weight;

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    priorityQueue.add(new int[]{neighbor, newDist});
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new Edge(1, 4), new Edge(2, 1)));
        graph.put(1, Arrays.asList(new Edge(3, 1)));
        graph.put(2, Arrays.asList(new Edge(1, 2), new Edge(3, 5)));
        graph.put(3, new ArrayList<>());

        int source = 0;
        Map<Integer, Integer> shortestPaths = dijkstra(graph, source);

        System.out.println(shortestPaths);  
    }
}