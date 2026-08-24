class Solution {
    public int prefixStrings(int n) {
        long MOD = 1000000007;

        // C_0 = 1
        long ans = 1;

        for (int i = 1; i <= n; i++) {
            // C_i = C_{i-1} * (2 * (2*i - 1)) / (i + 1)
            long num = 2 * (2L * i - 1) % MOD;
            long den = modInverse(i + 1, MOD);

            ans = (ans * num) % MOD;
            ans = (ans * den) % MOD;
        }

        return (int) ans;
    }

    // Fermat's Little Theorem to compute (base^(MOD - 2)) % MOD
    private long modInverse(long base, long mod) {
        return power(base, mod - 2, mod);
    }

    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}