import java.util.*;

class Solution {
    public int minTime(int[] duration, int[][] dependencies) {
        int n = duration.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[n];
        for (int[] dep : dependencies) {
            int u = dep[0];
            int v = dep[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] maxTime = new int[n];

        // Add all nodes with 0 in-degree to the queue
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
            maxTime[i] = duration[i];
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            count++;

            for (int v : adj.get(u)) {
                // The time to complete the dependent module is the max of its current calculated time 
                // and the time to complete the prerequisite + the dependent's duration.
                maxTime[v] = Math.max(maxTime[v], maxTime[u] + duration[v]);
                inDegree[v]--;

                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        // If count != n, a cyclic dependency exists
        if (count != n) {
            return -1;
        }

        int ans = 0;
        for (int time : maxTime) {
            ans = Math.max(ans, time);
        }

        return ans;
    }
}