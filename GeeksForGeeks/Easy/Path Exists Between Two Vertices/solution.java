class Solution {
    public boolean checkPath(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        if (u == v) return true;

        int n = adj.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();

        visited[u] = true;
        q.offer(u);

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int neighbor : adj.get(curr)) {
                if (neighbor == v) return true;

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }

        return false;
    }
}