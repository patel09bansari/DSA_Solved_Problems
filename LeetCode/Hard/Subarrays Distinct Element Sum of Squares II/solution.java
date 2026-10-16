class Solution {
    private static final int MOD = 1000000007;

    // Segment tree arrays
    long[] sum;      // stores sum of distinct counts
    long[] sumSq;    // stores sum of squares of distinct counts
    long[] lazy;     // lazy propagation values

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sum = new long[4 * n];
        sumSq = new long[4 * n];
        lazy = new long[4 * n];

        java.util.Map<Integer, Integer> lastOccurrence = new java.util.HashMap<>();
        long totalSumSq = 0;
        long currentSumSq = 0;

        for (int j = 0; j < n; j++) {
            int val = nums[j];
            int last = lastOccurrence.getOrDefault(val, -1);

            // Update the segment tree for the range [last + 1, j] by adding 1
            update(1, 0, n - 1, last + 1, j, 1);

            lastOccurrence.put(val, j);

            // sumSq[1] holds the sum of squares of all subarrays ending at current index j
            currentSumSq = sumSq[1];
            totalSumSq = (totalSumSq + currentSumSq) % MOD;
        }

        return (int) totalSumSq;
    }

    private void pushDown(int node, int l, int r) {
        if (lazy[node] != 0 && l != r) {
            int mid = l + (r - l) / 2;
            apply(2 * node, l, mid, lazy[node]);
            apply(2 * node + 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }
    }

    private void apply(int node, int l, int r, long val) {
        long len = (r - l + 1);
        // sumSq_new = sumSq + 2*sum*val + val^2*len
        sumSq[node] = (sumSq[node] + 2 * val * sum[node] + val * val * len) % MOD;
        // sum_new = sum + val*len
        sum[node] = (sum[node] + val * len) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    private void update(int node, int l, int r, int ql, int qr, long val) {
        if (ql > r || qr < l) {
            return;
        }
        if (ql <= l && r <= qr) {
            apply(node, l, r, val);
            return;
        }
        pushDown(node, l, r);
        int mid = l + (r - l) / 2;
        update(2 * node, l, mid, ql, qr, val);
        update(2 * node + 1, mid + 1, r, ql, qr, val);
        
        sum[node] = (sum[2 * node] + sum[2 * node + 1]) % MOD;
        sumSq[node] = (sumSq[2 * node] + sumSq[2 * node + 1]) % MOD;
    }
}