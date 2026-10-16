class Solution {
    public int countAlwaysFound(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMin = new int[n];

        // Compute prefix maximums from the left
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        // Compute suffix minimums from the right
        rightMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }

        int count = 0;

        // An element arr[i] is always found if:
        // 1. It is greater than all elements to its left (or i == 0)
        // 2. It is smaller than all elements to its right (or i == n - 1)
        for (int i = 0; i < n; i++) {
            boolean greaterThanLeft = (i == 0) || (arr[i] > leftMax[i - 1]);
            boolean smallerThanRight = (i == n - 1) || (arr[i] < rightMin[i + 1]);

            if (greaterThanLeft && smallerThanRight) {
                count++;
            }
        }

        return count;
    }
}