import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        // Build adjacency list for directed graph
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj[u].add(new int[]{v, w}); // Directed edge only
        }
        
        // Priority queue stores: [current_weight_sum, node, consecutive_count]
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        
        // dist[u][count] stores the minimum weight to reach node u with a given consecutive count
        long[][] dist = new long[n][k + 1];
        for (long[] row : dist) {
            Arrays.fill(row, Long.MAX_VALUE);
        }
        
        // Start from node 0
        pq.offer(new long[]{0, 0, 1});
        dist[0][1] = 0;
        
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int u = (int) curr[1];
            int count = (int) curr[2];
            
            if (u == n - 1) {
                return (int) d;
            }
            
            if (d > dist[u][count]) {
                continue;
            }
            
            for (int[] neighbor : adj[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];
                
                char nextChar = labels.charAt(v);
                char currChar = labels.charAt(u);
                
                int nextCount = (nextChar == currChar) ? count + 1 : 1;
                
                if (nextCount <= k) {
                    if (d + weight < dist[v][nextCount]) {
                        dist[v][nextCount] = d + weight;
                        pq.offer(new long[]{d + weight, v, nextCount});
                    }
                }
            }
        }
        
        return -1;
    }
}