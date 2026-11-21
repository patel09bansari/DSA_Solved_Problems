import java.util.Arrays;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        int[] newParent = Arrays.copyOf(parent, n);

        // Flat adjacency list for the original tree
        int[] head = new int[n];
        Arrays.fill(head, -1);
        int[] next = new int[n];
        for (int i = 1; i < n; i++) {
            next[i] = head[parent[i]];
            head[parent[i]] = i;
        }

        // Pass 1: Iterative DFS with backtracking to find closest matching ancestor
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        int[] prevAncestor = new int[n];

        int[] stack = new int[2 * n];
        int top = 0;
        stack[top++] = 0;

        while (top > 0) {
            int curr = stack[--top];
            if (curr >= 0) {
                int c = s.charAt(curr) - 'a';
                prevAncestor[curr] = lastSeen[c];
                if (lastSeen[c] != -1) {
                    newParent[curr] = lastSeen[c];
                }
                lastSeen[c] = curr;

                // Push exit marker before children
                stack[top++] = ~curr;
                for (int child = head[curr]; child != -1; child = next[child]) {
                    stack[top++] = child;
                }
            } else {
                int node = ~curr;
                int c = s.charAt(node) - 'a';
                lastSeen[c] = prevAncestor[node];
            }
        }

        // Rebuild flat adjacency list using newParent
        Arrays.fill(head, -1);
        for (int i = 1; i < n; i++) {
            next[i] = head[newParent[i]];
            head[newParent[i]] = i;
        }

        // Pass 2: Iterative BFS order + reverse accumulation for subtree sizes
        int[] order = new int[n];
        int front = 0, back = 0;
        order[back++] = 0;

        while (front < back) {
            int u = order[front++];
            for (int child = head[u]; child != -1; child = next[child]) {
                order[back++] = child;
            }
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for (int i = n - 1; i > 0; i--) {
            int node = order[i];
            ans[newParent[node]] += ans[node];
        }

        return ans;
    }
}