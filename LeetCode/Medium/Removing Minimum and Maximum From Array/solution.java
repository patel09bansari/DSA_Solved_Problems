class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;

        int minIdx = 0;
        int maxIdx = 0;

        // Find indices of minimum and maximum elements
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        int i = Math.min(minIdx, maxIdx);
        int j = Math.max(minIdx, maxIdx);

        // Option 1: Remove both from front
        int frontOnly = j + 1;

        // Option 2: Remove both from back
        int backOnly = n - i;

        // Option 3: Remove left from front, right from back
        int bothSides = (i + 1) + (n - j);

        return Math.min(frontOnly, Math.min(backOnly, bothSides));
    }
}