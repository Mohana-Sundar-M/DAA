package Exp4;

import java.util.*;;
public class exp4 {

    // Edge class to represent graph edges
    static class Edge {
        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Graph represented using adjacency list
    static class Graph {
        int vertices;
        List<List<Edge>> adjacencyList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new ArrayList<>();

            for (int i = 0; i < vertices; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        // Add edge (undirected graph)
        void addEdge(int source, int destination, int weight) {
            adjacencyList.get(source).add(new Edge(destination, weight));
            adjacencyList.get(destination).add(new Edge(source, weight));
        }
    }

    // Dijkstra's algorithm
    public static void dijkstra(Graph graph, int source) {
        int vertices = graph.vertices;

        // Distance array
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Priority Queue (min-heap)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{source, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentVertex = current[0];
            int currentDistance = current[1];

            // Skip outdated entries
            if (currentDistance > distance[currentVertex]) {
                continue;
            }

            // Explore neighbors
            for (Edge edge : graph.adjacencyList.get(currentVertex)) {
                int newDist = distance[currentVertex] + edge.weight;

                if (newDist < distance[edge.destination]) {
                    distance[edge.destination] = newDist;
                    pq.offer(new int[]{edge.destination, newDist});
                }
            }
        }

        // Print shortest distances
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " \t\t " + distance[i]);
        }
    }

    // Main method
    public static void main(String[] args) {

        Graph graph = new Graph(6);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 5, 2);

        int sourceVertex = 0;
        dijkstra(graph, sourceVertex);
    }
}
