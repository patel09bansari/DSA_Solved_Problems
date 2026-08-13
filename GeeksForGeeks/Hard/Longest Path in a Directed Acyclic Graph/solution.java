import java.util.*;

class Solution {
    public int[] maxDistance(int V, int src, ArrayList<ArrayList<Integer>> edges) {
        // Step 1: Build adjacency list
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            adj.get(u).add(new int[]{v, w});
        }

        // Step 2: Perform Topological Sort using DFS
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSort(i, adj, visited, stack);
            }
        }

        // Step 3: Initialize distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[src] = 0; // Distance to source is 0

        // Step 4: Process vertices in topological order
        while (!stack.isEmpty()) {
            int u = stack.pop();

            // Only relax edges if the current vertex is reachable
            if (dist[u] != Integer.MIN_VALUE) {
                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0];
                    int weight = neighbor[1];

                    if (dist[u] + weight > dist[v]) {
                        dist[v] = dist[u] + weight;
                    }
                }
            }
        }

        return dist;
    }

    private void topologicalSort(int u, ArrayList<ArrayList<int[]>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;
        for (int[] neighbor : adj.get(u)) {
            int v = neighbor[0];
            if (!visited[v]) {
                topologicalSort(v, adj, visited, stack);
            }
        }
        stack.push(u);
    }
}