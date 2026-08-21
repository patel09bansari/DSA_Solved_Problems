class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long low = 1;
        long minCoin = coins[0];
        for (int c : coins) {
            minCoin = Math.min(minCoin, c);
        }
        long high = minCoin * k;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (countAmounts(coins, mid) >= k) {
                ans = mid;
                high = mid - 1; // Try to find a smaller valid amount
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private long countAmounts(int[] coins, long target) {
        int n = coins.length;
        long count = 0;

        // Iterate through all non-empty subsets using bitmasking
        for (int mask = 1; mask < (1 << n); mask++) {
            long currentLcm = 1;
            int bitCount = Integer.bitCount(mask);

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    currentLcm = lcm(currentLcm, coins[i]);
                    // Break early if LCM exceeds target to prevent overflow
                    if (currentLcm > target) break;
                }
            }

            if (bitCount % 2 == 1) {
                count += target / currentLcm;
            } else {
                count -= target / currentLcm;
            }
        }
        return count;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}