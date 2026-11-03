import java.util.*;

class Solution {

    // DSU structure with size tracking
    static class DisjointSet {
        int[] parent;
        int[] size;
        long totalPaths;

        public DisjointSet(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            totalPaths = 0;
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int node) {
            if (node == parent[node]) {
                return node;
            }
            return parent[node] = find(parent[node]);
        }

        public void union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU != rootV) {
                // Add paths formed by combining the two components
                totalPaths += (long) size[rootU] * size[rootV];

                if (size[rootU] < size[rootV]) {
                    parent[rootU] = rootV;
                    size[rootV] += size[rootU];
                } else {
                    parent[rootV] = rootU;
                    size[rootU] += size[rootV];
                }
            }
        }

        public long getTotalPaths() {
            return totalPaths;
        }
    }

    public ArrayList<Integer> maximumWeight(int n, int[][] edges, int[] queries) {
        int qLen = queries.length;

        // Pair up queries with their original indices: {weight, index}
        int[][] queryArr = new int[qLen][2];
        for (int i = 0; i < qLen; i++) {
            queryArr[i][0] = queries[i];
            queryArr[i][1] = i;
        }

        // Sort queries by weight
        Arrays.sort(queryArr, Comparator.comparingInt(a -> a[0]));

        // Sort edges by weight
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));

        DisjointSet dsu = new DisjointSet(n);
        int edgeIndex = 0;
        int numEdges = edges.length;

        // Result array mapped back to original query indices
        int[] ans = new int[qLen];

        for (int i = 0; i < qLen; i++) {
            int maxWeight = queryArr[i][0];
            int originalIdx = queryArr[i][1];

            // Include all edges with weight <= maxWeight
            while (edgeIndex < numEdges && edges[edgeIndex][2] <= maxWeight) {
                dsu.union(edges[edgeIndex][0], edges[edgeIndex][1]);
                edgeIndex++;
            }

            ans[originalIdx] = (int) dsu.getTotalPaths();
        }

        ArrayList<Integer> result = new ArrayList<>(qLen);
        for (int i = 0; i < qLen; i++) {
            result.add(ans[i]);
        }

        return result;
    }
}