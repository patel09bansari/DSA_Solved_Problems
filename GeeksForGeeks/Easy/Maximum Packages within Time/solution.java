class Solution {
    public int maxPackages(int[] arr, int totalTime) {
        int n = arr.length;

        // If totalTime is greater than the number of locations, 
        // the agent can at most visit all available locations.
        if (totalTime > n) {
            totalTime = n;
        }

        int currentSum = 0;

        // Compute sum of the first window of size totalTime
        for (int i = 0; i < totalTime; i++) {
            currentSum += arr[i];
        }

        int maxSum = currentSum;

        // Slide the window across the array
        for (int i = totalTime; i < n; i++) {
            currentSum += arr[i] - arr[i - totalTime];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}