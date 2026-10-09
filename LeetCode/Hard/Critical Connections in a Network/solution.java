import java.util.*;

class Solution {
    private int timer = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // Step 1: Build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> edge : connections) {
            int u = edge.get(0), v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] tin = new int[n];
        int[] low = new int[n];
        boolean[] vis = new boolean[n];
        List<List<Integer>> bridges = new ArrayList<>();

        // Step 2: Run DFS from node 0
        dfs(0, -1, tin, low, vis, adj, bridges);
        return bridges;
    }

    private void dfs(int node, int parent, int[] tin, int[] low, boolean[] vis, 
                     List<List<Integer>> adj, List<List<Integer>> bridges) {
        vis[node] = true;
        tin[node] = low[node] = timer++;

        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) continue;
            
            if (vis[neighbor]) {
                // Back-edge: update low of current node
                low[node] = Math.min(low[node], tin[neighbor]);
            } else {
                // Forward-edge: visit unvisited neighbor
                dfs(neighbor, node, tin, low, vis, adj, bridges);
                low[node] = Math.min(low[node], low[neighbor]);
                
                // If the lowest vertex reachable from neighbor is after current node's tin, it's a bridge
                if (low[neighbor] > tin[node]) {
                    bridges.add(Arrays.asList(node, neighbor));
                }
            }
        }
    }
}