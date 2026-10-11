class Solution {
    public void mergeTwoParts(int[] arr) {
        int n = arr.length;
        int breakPoint = -1;

        // Find the break point where the order is violated
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                breakPoint = i;
                break;
            }
        }

        // If no break point is found, the array is already sorted
        if (breakPoint == -1) {
            return;
        }

        int[] temp = new int[n];
        int i = 0;                  // Pointer for first sorted part (0 to breakPoint)
        int j = breakPoint + 1;     // Pointer for second sorted part (breakPoint + 1 to n - 1)
        int k = 0;                  // Pointer for temp array

        while (i <= breakPoint && j < n) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements from the first part, if any
        while (i <= breakPoint) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from the second part, if any
        while (j < n) {
            temp[k++] = arr[j++];
        }

        // Copy back merged elements to the original array
        for (int idx = 0; idx < n; idx++) {
            arr[idx] = temp[idx];
        }
    }
}