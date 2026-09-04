import java.util.ArrayList;

class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();

        // If m is greater than or equal to n, bird can visit all trees
        if (m >= n) {
            int totalSum = 0;
            for (int val : arr) {
                totalSum += val;
            }
            return totalSum;
        }

        // Calculate sum of the first window of size m
        int currentSum = 0;
        for (int i = 0; i < m; i++) {
            currentSum += arr.get(i);
        }

        int maxSum = currentSum;

        // Slide the window across the circular array
        for (int i = 1; i < n; i++) {
            // Subtract the element leaving the window and add the new element entering
            currentSum = currentSum - arr.get(i - 1) + arr.get((i + m - 1) % n);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}