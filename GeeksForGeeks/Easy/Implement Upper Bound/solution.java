class Solution {
    int upperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                ans = mid;      // Found a potential upper bound, try finding a smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1;  // Target is greater or equal, look in the right half
            }
        }

        return ans;
    }
}