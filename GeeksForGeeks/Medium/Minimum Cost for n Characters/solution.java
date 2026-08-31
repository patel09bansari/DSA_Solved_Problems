class Solution {
    public int minCost(int n, int i, int d, int c) {
        long[] dp = new long[n + 1];
        dp[0] = 0;

        for (int k = 1; k <= n; k++) {
            // Option 1: Always possible by inserting 1 character to dp[k-1]
            dp[k] = dp[k - 1] + i;

            // Option 2: Double from k/2 if k is even
            if (k % 2 == 0) {
                dp[k] = Math.min(dp[k], dp[k / 2] + c);
            } 
            // Option 3: If k is odd, double from (k+1)/2 and delete 1
            else {
                dp[k] = Math.min(dp[k], dp[(k + 1) / 2] + c + d);
            }
        }

        return (int) dp[n];
    }
}