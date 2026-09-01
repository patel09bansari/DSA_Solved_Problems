class Solution {
    public int palindromicStrings(int n, int k) {
        long MOD = 1000000007;
        long totalCount = 0;

        for (int len = 1; len <= n; len++) {
            // Number of distinct characters needed to form a palindrome of length 'len'
            int requiredChars = (len + 1) / 2;

            if (requiredChars > k) {
                continue;
            }

            // Calculate permutations P(k, requiredChars) % MOD
            long count = 1;
            for (int i = 0; i < requiredChars; i++) {
                count = (count * (k - i)) % MOD;
            }

            totalCount = (totalCount + count) % MOD;
        }

        return (int) totalCount;
    }
}