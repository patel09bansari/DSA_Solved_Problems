class Solution {
    public int largestSumCycle(int[] edge) {
        int n = edge.length;
        int[] inDegree = new int[n];

        // 1. Calculate in-degrees of all nodes
        for (int i = 0; i < n; i++) {
            if (edge[i] != -1) {
                inDegree[edge[i]]++;
            }
        }

        // 2. Queue nodes with 0 in-degree (cannot be part of any cycle)
        java.util.Queue<Integer> q = new java.util.LinkedList<>();
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        // 3. Remove non-cycle paths (Kahn's algorithm)
        while (!q.isEmpty()) {
            int u = q.poll();
            vis[u] = true;
            int v = edge[u];
            if (v != -1) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        // 4. Traverse remaining nodes to find the cycle with the maximum sum
        int maxCycleSum = -1;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int currentSum = 0;
                int curr = i;

                while (!vis[curr]) {
                    vis[curr] = true;
                    currentSum += curr;
                    curr = edge[curr];
                }

                maxCycleSum = Math.max(maxCycleSum, currentSum);
            }
        }

        return maxCycleSum;
    }
}