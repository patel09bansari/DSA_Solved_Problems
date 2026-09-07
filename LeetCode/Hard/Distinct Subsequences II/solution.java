class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        
        // dp[i] stores the total number of distinct non-empty subsequences 
        // that end with the character ('a' + i).
        long[] last = new long[26];

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            
            // Sum of all distinct subsequences formed so far + 1 (for the single character c itself)
            long currentSum = 1;
            for (int i = 0; i < 26; i++) {
                currentSum = (currentSum + last[i]) % MOD;
            }
            
            // Update the count of subsequences ending with character c
            last[idx] = currentSum;
        }

        // Sum up the total distinct subsequences across all ending characters
        long result = 0;
        for (long count : last) {
            result = (result + count) % MOD;
        }

        return (int) result;
    }
}