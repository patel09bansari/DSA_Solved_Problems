class Solution {
    public int zigzagSequence(int[][] mat) {
        int n = mat.length;
        if (n == 1) return mat[0][0];

        // dp[j] will store the maximum sum ending at column j in the current row
        int[] dp = new int[n];

        // Initialize DP with the first row
        for (int j = 0; j < n; j++) {
            dp[j] = mat[0][j];
        }

        for (int i = 1; i < n; i++) {
            // Find max and second max from previous row's dp state
            int max1 = -1, max2 = -1;
            int max1Idx = -1;

            for (int j = 0; j < n; j++) {
                if (dp[j] > max1) {
                    max2 = max1;
                    max1 = dp[j];
                    max1Idx = j;
                } else if (dp[j] > max2) {
                    max2 = dp[j];
                }
            }

            // Calculate current row's dp values
            int[] nextDp = new int[n];
            for (int j = 0; j < n; j++) {
                if (j == max1Idx) {
                    nextDp[j] = mat[i][j] + max2;
                } else {
                    nextDp[j] = mat[i][j] + max1;
                }
            }

            dp = nextDp;
        }

        // Return maximum value from the last row
        int result = 0;
        for (int val : dp) {
            result = Math.max(result, val);
        }

        return result;
    }
}