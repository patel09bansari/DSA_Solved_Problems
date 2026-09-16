class Solution {
    public int numberOfSets(int n, int k) {
        long N = n + k - 1;
        long K = 2 * k;
        long MOD = 1_000_000_007;

        if (K > N) return 0;

        // Compute Combination C(N, K) % MOD using Modular Inverse
        long num = 1, den = 1;
        for (int i = 1; i <= K; i++) {
            num = (num * (N - K + i)) % MOD;
            den = (den * i) % MOD;
        }

        return (int) (num * modInverse(den, MOD) % MOD);
    }

    private long modInverse(long n, long mod) {
        return power(n, mod - 2, mod);
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