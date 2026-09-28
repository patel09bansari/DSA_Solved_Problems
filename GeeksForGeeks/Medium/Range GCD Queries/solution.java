import java.util.ArrayList;

class Solution {
    private int[] tree;
    private int n;

    // Function to build the segment tree
    private void buildTree(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        buildTree(arr, 2 * node, start, mid);
        buildTree(arr, 2 * node + 1, mid + 1, end);
        tree[node] = gcd(tree[2 * node], tree[2 * node + 1]);
    }

    // Function to update an element in the segment tree
    private void updateTree(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx >= start && idx <= mid) {
            updateTree(2 * node, start, mid, idx, val);
        } else {
            updateTree(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = gcd(tree[2 * node], tree[2 * node + 1]);
    }

    // Function to query GCD in range [l, r]
    private int queryTree(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0; // Identity element for GCD is 0
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        int p1 = queryTree(2 * node, start, mid, l, r);
        int p2 = queryTree(2 * node + 1, mid + 1, end, l, r);

        if (p1 == 0) return p2;
        if (p2 == 0) return p1;
        return gcd(p1, p2);
    }

    // Helper function to calculate GCD using Euclidean algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public ArrayList processQueries(int[] arr, int[][] queries) {
        n = arr.length;
        tree = new int[4 * n];
        buildTree(arr, 1, 0, n - 1);

        ArrayList result = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            if (type == 0) {
                int l = q[1];
                int r = q[2];
                result.add(queryTree(1, 0, n - 1, l, r));
            } else if (type == 1) {
                int idx = q[1];
                int val = q[2];
                updateTree(1, 0, n - 1, idx, val);
            }
        }

        return result;
    }
}