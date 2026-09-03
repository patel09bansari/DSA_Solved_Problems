class Solution {
    public int maxDiffSum(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;

        // Base cases for index 0
        int prevOriginal = 0; // dp[0][0]
        int prevReplaced = 0; // dp[0][1]

        for (int i = 1; i < n; i++) {
            // New state when arr[i] keeps its original value
            int currOriginal = Math.max(
                prevOriginal + Math.abs(arr[i] - arr[i - 1]),
                prevReplaced + Math.abs(arr[i] - 1)
            );

            // New state when arr[i] is replaced with 1
            int currReplaced = Math.max(
                prevOriginal + Math.abs(1 - arr[i - 1]),
                prevReplaced + Math.abs(1 - 1)
            );

            // Update previous state values for next iteration
            prevOriginal = currOriginal;
            prevReplaced = currReplaced;
        }

        return Math.max(prevOriginal, prevReplaced);
    }
}