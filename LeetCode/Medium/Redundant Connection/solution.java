class Solution {
    // Array to keep track of the parent/root of each node in the Disjoint Set
    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        
        // Step 1: Initialize each node to be its own parent (each node is its own separate set)
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        // Step 2: Iterate through every edge given in the input array sequentially
        for (int[] edge : edges) {
            // Find the ultimate root of both vertices of the current edge
            int rootX = find(edge[0]);
            int rootY = find(edge[1]);
            
            // Step 3: Check if both nodes already belong to the same connected component
            if (rootX == rootY) {
                // If they share the same root, adding this edge forms a cycle. 
                // Because we process edges in order, this is the redundant connection.
                return edge; 
            }
            
            // Step 4: Otherwise, union the two sets by pointing one root to the other
            parent[rootX] = rootY;
        }
        
        return new int[0]; // Default fallback return (won't be reached for valid inputs)
    }
    
    // Helper function to find the ultimate root of a node with path compression
    private int find(int i) {
        if (parent[i] == i) {
            return i; // Base case: node is its own root
        }
        // Path compression: point the node directly to its ultimate root to speed up future lookups
        return parent[i] = find(parent[i]); 
    }
}