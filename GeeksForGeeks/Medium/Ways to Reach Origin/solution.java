class Solution {
    public int ways(int x, int y) {
        int mod = 1000000007;
        int[][] dp = new int[x + 1][y + 1];

        // Base cases: if x = 0 or y = 0, there is only 1 way to reach origin
        for (int i = 0; i <= x; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= y; j++) {
            dp[0][j] = 1;
        }

        // Fill the DP table
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;
            }
        }

        return dp[x][y];
    }
}