import java.util.Arrays;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int INF = 1_000_000;
        
        // cost[i][j] = min changes to make substring s[i..j] a semi-palindrome
        int[][] cost = new int[n][n];
        for (int[] row : cost) {
            Arrays.fill(row, INF);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                cost[i][j] = getSemiPalindromeCost(s, i, j);
            }
        }
        
        // dp[i][p] = min changes to partition prefix of length i into p semi-palindromes
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[0][0] = 0;
        
        for (int p = 1; p <= k; p++) {
            // Each semi-palindrome has length >= 2, so p parts need at least 2*p characters
            for (int i = 2 * p; i <= n; i++) {
                for (int m = 2 * (p - 1); m <= i - 2; m++) {
                    if (dp[m][p - 1] != INF && cost[m][i - 1] != INF) {
                        dp[i][p] = Math.min(dp[i][p], dp[m][p - 1] + cost[m][i - 1]);
                    }
                }
            }
        }
        
        return dp[n][k];
    }
    
    private int getSemiPalindromeCost(String s, int start, int end) {
        int len = end - start + 1;
        int minChanges = Integer.MAX_VALUE;
        
        // Check all proper divisors d of len (1 <= d < len)
        for (int d = 1; d * 2 <= len; d++) {
            if (len % d != 0) continue;
            
            int changes = 0;
            int groupSize = len / d;
            
            // Check each of the d interleaved groups
            for (int rem = 0; rem < d; rem++) {
                int left = 0;
                int right = groupSize - 1;
                while (left < right) {
                    char c1 = s.charAt(start + rem + left * d);
                    char c2 = s.charAt(start + rem + right * d);
                    if (c1 != c2) {
                        changes++;
                    }
                    left++;
                    right--;
                }
            }
            minChanges = Math.min(minChanges, changes);
        }
        
        return minChanges;
    }
}