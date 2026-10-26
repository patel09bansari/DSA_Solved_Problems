class Solution {
    public int minDiff(int k, int[] arr) {
        int n = arr.length;

        // If k equals n, removing the whole array leaves nothing (or depends on constraints, but normally min diff would be 0 or handled)
        if (k >= n) return 0;

        int[] prefixMin = new int[n];
        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];
        int[] suffixMax = new int[n];

        prefixMin[0] = arr[0];
        prefixMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixMin[i] = Math.min(prefixMin[i - 1], arr[i]);
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }

        suffixMin[n - 1] = arr[n - 1];
        suffixMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], arr[i]);
            suffixMax[i] = Math.max(suffixMax[i + 1], arr[i]);
        }

        int ans = Integer.MAX_VALUE;

        // Try removing every possible subarray of size k starting at index i
        for (int i = 0; i <= n - k; i++) {
            int currentMin = Integer.MAX_VALUE;
            int currentMax = Integer.MIN_VALUE;

            // Check prefix part before the removed subarray [i, i + k - 1]
            if (i > 0) {
                currentMin = Math.min(currentMin, prefixMin[i - 1]);
                currentMax = Math.max(currentMax, prefixMax[i - 1]);
            }

            // Check suffix part after the removed subarray [i, i + k - 1]
            if (i + k < n) {
                currentMin = Math.min(currentMin, suffixMin[i + k]);
                currentMax = Math.max(currentMax, suffixMax[i + k]);
            }

            ans = Math.min(ans, currentMax - currentMin);
        }

        return ans;
    }
}