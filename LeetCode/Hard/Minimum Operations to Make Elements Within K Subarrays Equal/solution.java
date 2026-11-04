import java.util.*;

class Solution {
    // Helper class to maintain sliding window median and sums
    static class MedianFinder {
        private final int x;
        private final int leftSize;
        private final int rightSize;
        
        // Use TreeMaps to support frequency counting and efficient removals
        private final TreeMap<Integer, Integer> left = new TreeMap<>();
        private final TreeMap<Integer, Integer> right = new TreeMap<>();
        private int leftCount = 0;
        private int rightCount = 0;
        private long leftSum = 0;
        private long rightSum = 0;

        public MedianFinder(int x) {
            this.x = x;
            this.leftSize = (x + 1) / 2;
            this.rightSize = x - leftSize;
        }

        private void add(TreeMap<Integer, Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        private void remove(TreeMap<Integer, Integer> map, int val) {
            int count = map.get(val);
            if (count == 1) {
                map.remove(val);
            } else {
                map.put(val, count - 1);
            }
        }

        public void addNum(int num) {
            if (left.isEmpty() || num <= left.lastKey()) {
                add(left, num);
                leftSum += num;
                leftCount++;
            } else {
                add(right, num);
                rightSum += num;
                rightCount++;
            }
            balance();
        }

        public void removeNum(int num) {
            if (left.containsKey(num)) {
                remove(left, num);
                leftSum -= num;
                leftCount--;
            } else {
                remove(right, num);
                rightSum -= num;
                rightCount--;
            }
            balance();
        }

        private void balance() {
            while (leftCount > leftSize) {
                int val = left.lastKey();
                remove(left, val);
                leftSum -= val;
                leftCount--;

                add(right, val);
                rightSum += val;
                rightCount++;
            }
            while (leftCount < leftSize && rightCount > 0) {
                int val = right.firstKey();
                remove(right, val);
                rightSum -= val;
                rightCount--;

                add(left, val);
                leftSum += val;
                leftCount++;
            }
        }

        public long getCost() {
            long median = left.lastKey();
            // sum_{R} (r - median) + sum_{L} (median - l)
            // = rightSum - rightCount * median + leftCount * median - leftSum
            return rightSum - (long) rightCount * median + (long) leftCount * median - leftSum;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n]; // cost[i] = cost for window ending at index i

        MedianFinder mf = new MedianFinder(x);
        for (int i = 0; i < n; i++) {
            mf.addNum(nums[i]);
            if (i >= x) {
                mf.removeNum(nums[i - x]);
            }
            if (i >= x - 1) {
                cost[i] = mf.getCost();
            }
        }

        // DP[j][i]: min cost to select j non-overlapping windows of size x from nums[0..i]
        // Space optimized: dp[j] represents min cost for j subarrays up to the current index
        final long INF = (long) 1e18;
        long[][] dp = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                // Option 1: Do not take a subarray ending at i - 1
                dp[i][j] = dp[i - 1][j];

                // Option 2: Take subarray of size x ending at i - 1
                if (j > 0 && i >= x && dp[i - x][j - 1] != INF) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - x][j - 1] + cost[i - 1]);
                }
            }
        }

        return dp[n][k];
    }
}