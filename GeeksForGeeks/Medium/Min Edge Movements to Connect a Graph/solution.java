class Solution {
    public int minEdgesReq(int n, int[][] edges) {
        int m = edges.length;
        
        // Base case: To connect n nodes, we need at least n - 1 edges
        if (m < n - 1) {
            return -1;
        }

        DisjointSet ds = new DisjointSet(n);
        
        for (int[] edge : edges) {
            ds.unionByRank(edge[0], edge[1]);
        }

        // Count the number of connected components
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findParent(i) == i) {
                components++;
            }
        }

        // Minimum operations required = components - 1
        return components - 1;
    }
}

class DisjointSet {
    int[] parent;
    int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int findParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findParent(parent[node]); // Path compression
    }

    public void unionByRank(int u, int v) {
        int ultimateParentU = findParent(u);
        int ultimateParentV = findParent(v);

        if (ultimateParentU == ultimateParentV) return;

        if (rank[ultimateParentU] < rank[ultimateParentV]) {
            parent[ultimateParentU] = ultimateParentV;
        } else if (rank[ultimateParentV] < rank[ultimateParentU]) {
            parent[ultimateParentV] = ultimateParentU;
        } else {
            parent[ultimateParentV] = ultimateParentU;
            rank[ultimateParentU]++;
        }
    }
}