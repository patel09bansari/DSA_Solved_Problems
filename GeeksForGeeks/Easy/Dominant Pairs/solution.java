import java.util.Arrays;

class Solution {
    public int dominantPairs(int[] arr) {
        int n = arr.length;
        int mid = n / 2;

        // Sort both halves independently
        Arrays.sort(arr, 0, mid);
        Arrays.sort(arr, mid, n);

        int count = 0;
        int j = mid;

        // Two-pointer traversal
        for (int i = 0; i < mid; i++) {
            while (j < n && arr[i] >= 5 * arr[j]) {
                j++;
            }
            count += (j - mid);
        }

        return count;
    }
}