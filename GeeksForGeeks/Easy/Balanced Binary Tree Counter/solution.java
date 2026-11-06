class Solution {
    public int countBT(int h) {
        if (h == 0 || h == 1) return 1;

        long MOD = 1000000007L;
        long prev2 = 1; // dp[0]
        long prev1 = 1; // dp[1]
        long current = 0;

        for (int i = 2; i <= h; i++) {
            current = (prev1 * ((prev1 + 2 * prev2) % MOD)) % MOD;
            prev2 = prev1;
            prev1 = current;
        }

        return (int) current;
    }
}