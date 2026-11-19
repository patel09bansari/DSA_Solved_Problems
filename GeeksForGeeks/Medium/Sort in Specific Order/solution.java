import java.util.Arrays;

class Solution {
    public void sortIt(int[] arr) {
        int n = arr.length;

        // Step 1: Make all odd numbers negative
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                arr[i] = -arr[i];
            }
        }

        // Step 2: Sort the array in ascending order
        Arrays.sort(arr);

        // Step 3: Restore the odd numbers back to positive
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                arr[i] = -arr[i];
            }
        }
    }
}