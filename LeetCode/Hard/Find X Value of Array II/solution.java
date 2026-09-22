class Solution {
    static class Node {
        // count[r] = number of prefixes in this segment whose product mod k is r
        long[] count = new long[5];
        // prod = product of all elements in this segment mod k
        int prod = 1;
    }

    private Node[] tree;
    private int n;
    private int K;

    private Node merge(Node left, Node right) {
        Node res = new Node();
        res.prod = (left.prod * right.prod) % K;
        
        for (int r = 0; r < K; r++) {
            res.count[r] += left.count[r];
            int newRem = (left.prod * r) % K;
            res.count[newRem] += right.count[r];
        }
        return res;
    }

    private void build(int[] nums, int node, int start, int end) {
        if (start == end) {
            int rem = nums[start] % K;
            tree[node] = new Node();
            tree[node].prod = rem;
            tree[node].count[rem] = 1;
            return;
        }
        int mid = start + (end - start) / 2;
        build(nums, 2 * node, start, mid);
        build(nums, 2 * node + 1, mid + 1, end);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            int rem = val % K;
            tree[node] = new Node();
            tree[node].prod = rem;
            tree[node].count[rem] = 1;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private Node query(int node, int start, int end, int l, int r) {
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        if (r <= mid) {
            return query(2 * node, start, mid, l, r);
        }
        if (l > mid) {
            return query(2 * node + 1, mid + 1, end, l, r);
        }
        Node left = query(2 * node, start, mid, l, r);
        Node right = query(2 * node + 1, mid + 1, end, l, r);
        return merge(left, right);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.K = k;
        this.tree = new Node[4 * n];

        build(nums, 1, 0, n - 1);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int targetX = queries[i][3];

            update(1, 0, n - 1, idx, val);

            Node resNode = query(1, 0, n - 1, start, n - 1);
            result[i] = (int) resNode.count[targetX];
        }

        return result;
    }
}