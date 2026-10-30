class Solution {
    public int cntSubsets(int[] arr, int l, int r) {
        long MOD = 1000000007;
        int n = arr.length;

        // Find maximum element to size our frequency array adequately
        int maxVal = 0;
        for (int x : arr) {
            maxVal = Math.max(maxVal, x);
        }

        // Frequency array
        int[] freq = new int[maxVal + 2];
        for (int x : arr) {
            freq[x]++;
        }

        // Precompute powers of 2 modulo 10^9 + 7
        long[] pow2 = new long[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        long totalSubsetsSum = 0;
        long prefixProduct = 1;

        for (int k = 0; k <= r; k++) {
            if (k > 0 && freq[k - 1] == 0) {
                break; // If a precursor is missing, all subsequent MEX values are impossible
            }

            if (k > 0) {
                long waysForPrev = (pow2[freq[k - 1]] - 1 + MOD) % MOD;
                prefixProduct = (prefixProduct * waysForPrev) % MOD;
            }

            if (k >= l && k <= r) {
                int countGreaterThanK = 0;
                for (int x = k + 1; x < freq.length; x++) {
                    countGreaterThanK += freq[x];
                }

                long ways = (prefixProduct * pow2[countGreaterThanK]) % MOD;
                totalSubsetsSum = (totalSubsetsSum + ways) % MOD;
            }

            if (freq[k] == 0) {
                break;
            }
        }

        return (int) totalSubsetsSum;
    }
}