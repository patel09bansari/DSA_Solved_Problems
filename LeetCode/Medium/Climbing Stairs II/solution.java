import java.util.Arrays;

class Solution {
    public int climbStairs(int n, int[] costs) {
        // dp[j] stores the minimum cost to reach step j
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // Base case: starting at step 0 with 0 cost
        dp[0] = 0;

        for (int j = 1; j <= n; j++) {
            // Note: costs is 1-indexed in problem description, 
            // so costs[j] corresponds to costs[j - 1] in 0-indexed Java array.
            int stepCost = costs[j - 1];

            // You can jump to step j from j - 1, j - 2, or j - 3
            for (int k = 1; k <= 3; k++) {
                int i = j - k;
                if (i >= 0 && dp[i] != Integer.MAX_VALUE) {
                    int jumpCost = stepCost + k * k; // (j - i)^2 = k^2
                    dp[j] = Math.min(dp[j], dp[i] + jumpCost);
                }
            }
        }

        return dp[n];
    }
}