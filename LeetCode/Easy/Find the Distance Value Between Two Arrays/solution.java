import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int distanceValue = 0;

        for (int val : arr1) {
            if (isValid(arr2, val, d)) {
                distanceValue++;
            }
        }

        return distanceValue;
    }

    private boolean isValid(int[] arr, int val, int d) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (Math.abs(arr[mid] - val) <= d) {
                return false; // Found an element within distance d
            } else if (arr[mid] < val) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return true; // No element within distance d
    }
}