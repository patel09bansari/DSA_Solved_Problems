import java.util.*;

class Solution {
    class SegmentTree {
        int n;
        int[] tree;

        public SegmentTree(int size) {
            n = size;
            tree = new int[4 * n];
        }

        public void build(int node, int start, int end, int[] initialMasks) {
            if (start == end) {
                tree[node] = initialMasks[start];
                return;
            }
            int mid = (start + end) / 2;
            build(2 * node, start, mid, initialMasks);
            build(2 * node + 1, mid + 1, end, initialMasks);
            tree[node] = tree[2 * node] ^ tree[2 * node + 1];
        }

        public void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = val;
                return;
            }
            int mid = (start + end) / 2;
            if (idx <= mid) {
                update(2 * node, start, mid, idx, val);
            } else {
                update(2 * node + 1, mid + 1, end, idx, val);
            }
            tree[node] = tree[2 * node] ^ tree[2 * node + 1];
        }

        public int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) return 0;
            if (l <= start && end <= r) return tree[node];
            int mid = (start + end) / 2;
            return query(2 * node, start, mid, l, r) ^ query(2 * node + 1, mid + 1, end, l, r);
        }
    }

    private List<List<Integer>> adj;
    private int[] parent, depth, heavy, head, pos;
    private int curPos;

    private int dfs1(int u, int p, int d) {
        parent[u] = p;
        depth[u] = d;
        int size = 1;
        int maxSubtree = 0;
        heavy[u] = -1;
        for (int v : adj.get(u)) {
            if (v != p) {
                int subtree = dfs1(v, u, d + 1);
                size += subtree;
                if (subtree > maxSubtree) {
                    maxSubtree = subtree;
                    heavy[u] = v;
                }
            }
        }
        return size;
    }

    private void dfs2(int u, int h) {
        head[u] = h;
        pos[u] = curPos++;
        if (heavy[u] != -1) {
            dfs2(heavy[u], h);
        }
        for (int v : adj.get(u)) {
            if (v != parent[u] && v != heavy[u]) {
                dfs2(v, v);
            }
        }
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        parent = new int[n];
        depth = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];
        curPos = 0;

        dfs1(0, -1, 0);
        dfs2(0, 0);

        int[] initialMasks = new int[n];
        char[] charArr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            initialMasks[pos[i]] = 1 << (charArr[i] - 'a');
        }

        SegmentTree st = new SegmentTree(n);
        st.build(1, 0, n - 1, initialMasks);

        List<Boolean> answer = new ArrayList<>();

        for (String qStr : queries) {
            String[] parts = qStr.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                charArr[u] = c;
                st.update(1, 0, n - 1, pos[u], 1 << (c - 'a'));
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int pathMask = 0;

                while (head[u] != head[v]) {
                    if (depth[head[u]] > depth[head[v]]) {
                        int temp = u; u = v; v = temp;
                    }
                    pathMask ^= st.query(1, 0, n - 1, pos[head[v]], pos[v]);
                    v = parent[head[v]];
                }
                if (depth[u] > depth[v]) {
                    int temp = u; u = v; v = temp;
                }
                pathMask ^= st.query(1, 0, n - 1, pos[u], pos[v]);

                // A string can form a palindrome if at most one bit is set
                if ((pathMask & (pathMask - 1)) == 0) {
                    answer.add(true);
                } else {
                    answer.add(false);
                }
            }
        }

        return answer;
    }
}