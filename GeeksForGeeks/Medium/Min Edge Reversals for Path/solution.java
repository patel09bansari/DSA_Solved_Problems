import java.util.*;

class Solution {
    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
        // Build adjacency list: node -> list of int[]{neighbor, weight}
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(new int[]{v, 0}); // Original edge costs 0 reversals
            adj.get(v).add(new int[]{u, 1}); // Reversed edge costs 1 reversal
        }

        // 0-1 BFS initialization
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Deque<Integer> deque = new ArrayDeque<>();
        dist[src] = 0;
        deque.addFirst(src);

        while (!deque.isEmpty()) {
            int curr = deque.pollFirst();

            if (curr == dst) {
                return dist[dst];
            }

            for (int[] neighbor : adj.get(curr)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];

                if (dist[curr] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[curr] + weight;
                    if (weight == 0) {
                        deque.addFirst(nextNode); // 0-cost edges processed first
                    } else {
                        deque.addLast(nextNode);  // 1-cost edges added to back
                    }
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}