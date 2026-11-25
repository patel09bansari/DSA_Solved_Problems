class Solution {
    private static final long MOD = 1_000_000_007L;
    private static final long INV2 = 500_000_004L;

    public int minTime(int a, int b, int d, int l, int r) {
        long A = a, B = b, D = d;
        long normalTime = timeToReach(D, A, B);

        long L = D - r;
        long R = D - l;

        // Binary search for the largest x in [L, R] where timeToReach(x) + 1 < normalTime
        long low = L, high = R, split = L - 1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (timeToReach(mid, A, B) + 1 < normalTime) {
                split = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        long total = 0;

        // 1. Range [L, split]: jump is strictly faster
        if (split >= L) {
            total = (total + sumJumpTimes(L, split, A, B)) % MOD;
        }

        // 2. Range [split + 1, R]: normal movement without jump is faster or equal
        long normalCount = R - split;
        if (normalCount > 0) {
            total = (total + (normalCount % MOD) * (normalTime % MOD)) % MOD;
        }

        return (int) total;
    }

    // Minimum time to reach position x using normal movement
    private long timeToReach(long x, long a, long b) {
        if (x <= a) return x;
        long diff = a - b;
        long c = (x - a + diff - 1) / diff;
        return x + 2 * b * c;
    }

    // Computes sum of (timeToReach(x) + 1) for all x in [L, R]
    private long sumJumpTimes(long L, long R, long a, long b) {
        long count = R - L + 1;
        // Sum of (x + 1) from L to R
        long sumXPlus1 = ((count % MOD) * ((L + R + 2) % MOD) % MOD) * INV2 % MOD;

        // Add 2 * b * sum(c(x)) for x in [L, R]
        long sumC = sumCycles(R, a, b) - sumCycles(L - 1, a, b);
        sumC = (sumC % MOD + MOD) % MOD;

        long extra = (2 * b % MOD) * sumC % MOD;
        return (sumXPlus1 + extra) % MOD;
    }

    // Computes sum of c(x) = max(0, ceil((x - a) / (a - b))) for x in [1, N]
    private long sumCycles(long N, long a, long b) {
        if (N <= a) return 0;
        long m = N - a;
        long diff = a - b;
        long fullBlocks = m / diff;
        long rem = m % diff;

        // Blocks 1 to fullBlocks each have 'diff' elements with cycle value k
        long fbMod = fullBlocks % MOD;
        long fullSum = ((fbMod * (fbMod + 1) % MOD) * INV2 % MOD) * (diff % MOD) % MOD;

        // Remaining elements have cycle value (fullBlocks + 1)
        long remSum = (rem % MOD) * ((fullBlocks + 1) % MOD) % MOD;

        return (fullSum + remSum) % MOD;
    }
}