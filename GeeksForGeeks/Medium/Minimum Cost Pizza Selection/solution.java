class Solution {
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        // Find the maximum single pizza area to safely size our DP array
        int maxArea = x + Math.max(s, Math.max(m, l));
        int[] dp = new int[maxArea + 1];

        // Initialize DP array with a large value
        java.util.Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // Iterate through all possible total areas
        for (int i = 0; i <= maxArea; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;

            // Try buying a Small pizza
            if (i + s <= maxArea) {
                dp[i + s] = Math.min(dp[i + s], dp[i] + cs);
            }
            // Try buying a Medium pizza
            if (i + m <= maxArea) {
                dp[i + m] = Math.min(dp[i + m], dp[i] + cm);
            }
            // Try buying a Large pizza
            if (i + l <= maxArea) {
                dp[i + l] = Math.min(dp[i + l], dp[i] + cl);
            }
        }

        // Find the minimum cost for any area >= x
        int minCost = Integer.MAX_VALUE;
        for (int i = x; i <= maxArea; i++) {
            minCost = Math.min(minCost, dp[i]);
        }

        return minCost;
    }
}