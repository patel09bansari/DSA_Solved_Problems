import java.util.Arrays;

class Solution {

    // Function to check if it's possible to place 'c' cows with at least 'minAllowedDistance'
    public static boolean isPossible(int[] stalls, int n, int c, int minAllowedDistance) {
        int cowsPlaced = 1;
        int lastPosition = stalls[0]; // Place the first cow in the first stall

        for (int i = 1; i < n; i++) {
            // Check if the distance from the last placed cow is greater than or equal to minAllowedDistance
            if (stalls[i] - lastPosition >= minAllowedDistance) {
                cowsPlaced++;
                lastPosition = stalls[i]; // Update the last placed position
            }

            // If all cows are placed successfully
            if (cowsPlaced == c) {
                return true;
            }
        }
        return false;
    }

    // Required method signature for GeeksforGeeks
    public static int aggressiveCows(int[] arr, int k) {
        int n = arr.length;

        // Step 1: Sort the stalls array
        Arrays.sort(arr);

        int start = 1; // Minimum possible distance
        int end = arr[n - 1] - arr[0]; // Maximum possible distance (Max - Min)
        int ans = -1;

        // Step 2: Binary Search on the answer range
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isPossible(arr, n, k, mid)) {
                ans = mid;           // Store the valid distance
                start = mid + 1;     // Try for a larger minimum distance
            } else {
                end = mid - 1;       // Try for a smaller distance
            }
        }

        return ans;
    }
}