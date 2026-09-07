import java.util.Arrays;

class Solution {
    public int minCount(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        // dp[i][inc_idx][dec_idx] stores the max elements included considering first i elements
        // inc_idx + 1: last element index used in increasing sequence (0 means none)
        // dec_idx + 1: last element index used in decreasing sequence (0 means none)
        int[][][] dp = new int[n + 1][n + 1][n + 1];

        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        int maxIncluded = solve(0, -1, -1, arr, dp);
        return n - maxIncluded;
    }

    private int solve(int i, int lastInc, int lastDec, int[] arr, int[][][] dp) {
        if (i == arr.length) return 0;

        if (dp[i][lastInc + 1][lastDec + 1] != -1) {
            return dp[i][lastInc + 1][lastDec + 1];
        }

        // Option 1: Skip current element
        int ans = solve(i + 1, lastInc, lastDec, arr, dp);

        // Option 2: Add to strictly increasing subsequence
        if (lastInc == -1 || arr[i] > arr[lastInc]) {
            ans = Math.max(ans, 1 + solve(i + 1, i, lastDec, arr, dp));
        }

        // Option 3: Add to strictly decreasing subsequence
        if (lastDec == -1 || arr[i] < arr[lastDec]) {
            ans = Math.max(ans, 1 + solve(i + 1, lastInc, i, arr, dp));
        }

        return dp[i][lastInc + 1][lastDec + 1] = ans;
    }
}