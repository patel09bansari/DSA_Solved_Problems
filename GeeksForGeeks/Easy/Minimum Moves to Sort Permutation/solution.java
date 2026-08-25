class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;

        // dp[x] stores the length of the consecutive subsequence ending at value x
        int[] dp = new int[n + 1];
        int maxLen = 0;

        for (int x : arr) {
            dp[x] = dp[x - 1] + 1;
            maxLen = Math.max(maxLen, dp[x]);
        }

        return n - maxLen;
    }
}