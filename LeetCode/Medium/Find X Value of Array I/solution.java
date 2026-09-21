class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            long[] nextDp = new long[k];
            int v = num % k;

            // Subarray starting at the current element
            nextDp[v]++;

            // Extend existing subarrays
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    nextDp[(r * v) % k] += dp[r];
                }
            }

            // Accumulate counts for each remainder
            for (int r = 0; r < k; r++) {
                result[r] += nextDp[r];
            }

            dp = nextDp;
        }

        return result;
    }
}