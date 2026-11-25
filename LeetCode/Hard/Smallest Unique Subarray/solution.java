import java.util.*;

class Solution {
    private static final long MOD1 = 1_000_000_007L;
    private static final long MOD2 = 1_000_000_009L;
    private static final long BASE1 = 1315423911L % MOD1;
    private static final long BASE2 = 2654435761L % MOD2;

    private long[] h1, h2, p1, p2;
    private int n;

    public int smallestUniqueSubarray(int[] nums) {
        n = nums.length;
        h1 = new long[n + 1];
        h2 = new long[n + 1];
        p1 = new long[n + 1];
        p2 = new long[n + 1];
        p1[0] = p2[0] = 1;

        for (int i = 0; i < n; i++) {
            p1[i + 1] = (p1[i] * BASE1) % MOD1;
            p2[i + 1] = (p2[i] * BASE2) % MOD2;
            h1[i + 1] = (h1[i] * BASE1 + nums[i]) % MOD1;
            h2[i + 1] = (h2[i] * BASE2 + nums[i]) % MOD2;
        }

        int low = 1, high = n, ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (hasUnique(mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean hasUnique(int len) {
        Map<Long, Integer> freq = new HashMap<>(n - len + 1);
        for (int i = 0; i + len <= n; i++) {
            long x1 = (h1[i + len] - (h1[i] * p1[len]) % MOD1 + MOD1) % MOD1;
            long x2 = (h2[i + len] - (h2[i] * p2[len]) % MOD2 + MOD2) % MOD2;
            long combined = (x1 << 32) | x2;
            freq.put(combined, freq.getOrDefault(combined, 0) + 1);
        }
        for (int count : freq.values()) {
            if (count == 1) return true;
        }
        return false;
    }
}