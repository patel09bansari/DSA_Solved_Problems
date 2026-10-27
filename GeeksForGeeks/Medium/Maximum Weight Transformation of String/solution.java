class Solution {
    public int getMaxWeight(String s) {
        int n = s.length();
        if (n == 0) return 0;

        // dp[i] represents the maximum weight for the substring s[i...n-1]
        int[] dp = new int[n + 1];

        dp[n] = 0;
        dp[n - 1] = 1; // Single character at the end

        for (int i = n - 2; i >= 0; i--) {
            // Choice 1: Leave s[i] single
            int option1 = 1 + dp[i + 1];

            // Choice 2: Form a pair with s[i] and s[i+1]
            int cost = (s.charAt(i) == s.charAt(i + 1)) ? 1 : 0;
            int option2 = 4 - cost + dp[i + 2];

            dp[i] = Math.max(option1, option2);
        }

        return dp[0];
    }
}