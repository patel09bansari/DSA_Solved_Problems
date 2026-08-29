class Solution {
    public int countSubsequences(String s, int n) {
        int MOD = 1000000007;
        int len = s.length();

        // dp[r] represents the number of subsequences with remainder 'r' modulo n
        int[] dp = new int[n];

        for (int i = 0; i < len; i++) {
            int digit = s.charAt(i) - '0';
            int[] nextDp = dp.clone();

            // Start a new subsequence with the current digit alone
            int singleRem = digit % n;
            nextDp[singleRem] = (nextDp[singleRem] + 1) % MOD;

            // Append current digit to existing subsequences
            for (int r = 0; r < n; r++) {
                if (dp[r] > 0) {
                    int newRem = (r * 10 + digit) % n;
                    nextDp[newRem] = (nextDp[newRem] + dp[r]) % MOD;
                }
            }

            dp = nextDp;
        }

        // dp[0] holds the count of subsequences divisible by n
        return dp[0];
    }
}