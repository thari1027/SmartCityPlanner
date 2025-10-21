package SmartCity;

import java.util.*;

public class Graph {
    private Map<String, List<String>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    // Add a location (vertex)
    public void addLocation(String location) {
        adjList.putIfAbsent(location, new ArrayList<>());
    }

    // Remove a location (vertex)
    public void removeLocation(String location) {
        adjList.remove(location);
        for (List<String> connections : adjList.values()) {
            connections.remove(location);
        }
    }

    // Add a road (edge)
    public void addRoad(String from, String to) {
        if (adjList.containsKey(from) && adjList.containsKey(to)) {
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        } else {
            System.out.println("❌ One or both locations do not exist.");
        }
    }

    // Remove a road (edge)
    public void removeRoad(String from, String to) {
        if (adjList.containsKey(from) && adjList.containsKey(to)) {
            adjList.get(from).remove(to);
            adjList.get(to).remove(from);
        }
    }

    // Display all connections
    public void displayConnections() {
        if (adjList.isEmpty()) {
            System.out.println("No locations in the system.");
            return;
        }

        System.out.println("\n🌉 City Road Connections:");
        for (String location : adjList.keySet()) {
            System.out.println(location + " -> " + adjList.get(location));
        }
    }

    // BFS traversal using a queue
    public void bfsTraversal(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("❌ Location not found.");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.offer(start);

        System.out.print("\n🧭 BFS Traversal: ");
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");
            for (String neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println();
    }

    // ✅ DFS traversal using recursion
    public void dfsTraversal(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("❌ Location not found.");
            return;
        }

        Set<String> visited = new HashSet<>();
        System.out.print("\n🧭 DFS Traversal: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    // Helper method for DFS
    private void dfsHelper(String current, Set<String> visited) {
        visited.add(current);
        System.out.print(current + " ");
        for (String neighbor : adjList.get(current)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }
}
