class Solution {

    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    static Pair bfs(int start, ArrayList<ArrayList<Integer>> adj) {

        int n = adj.size();
        boolean[] visited = new boolean[n];

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(start, 0));
        visited[start] = true;

        Pair farthest = new Pair(start, 0);

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            if (curr.dist > farthest.dist) {
                farthest = curr;
            }

            for (int x : adj.get(curr.node)) {

                int next = x - 1;   // house number → index

                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new Pair(next, curr.dist + 1));
                }
            }
        }

        return farthest;
    }

    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {

        // First BFS: find one endpoint of diameter
        Pair p1 = bfs(0, adj);

        // Second BFS: find diameter
        Pair p2 = bfs(p1.node, adj);

        int diameter = p2.dist;

        // Minimum maximum distance
        return (diameter + 1) / 2;
    }
}