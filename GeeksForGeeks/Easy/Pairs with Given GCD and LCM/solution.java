class Solution {
    public int pairCount(int x, int y) {
        // LCM must be divisible by GCD
        if (y % x != 0) {
            return 0;
        }

        int N = y / x;
        int count = 0;

        // Iterate up to sqrt(N) to find factors p and q
        for (int p = 1; p * p <= N; p++) {
            if (N % p == 0) {
                int q = N / p;

                // Check if p and q are coprime
                if (gcd(p, q) == 1) {
                    if (p == q) {
                        count += 1; // Pair (p, p)
                    } else {
                        count += 2; // Pairs (p, q) and (q, p)
                    }
                }
            }
        }

        return count;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}