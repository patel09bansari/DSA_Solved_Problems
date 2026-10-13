import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> update(int n, int[] updates) {
        int[] arr = new int[n];

        // Count frequencies of updates (converting 1-based to 0-based indexing for our array)
        for (int j : updates) {
            arr[j - 1]++;
        }

        // Propagate the updates from left to right
        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
            arr[i] = currentSum;
        }

        // Convert to ArrayList<Integer>
        ArrayList<Integer> result = new ArrayList<>(n);
        for (int val : arr) {
            result.add(val);
        }

        return result;
    }
}