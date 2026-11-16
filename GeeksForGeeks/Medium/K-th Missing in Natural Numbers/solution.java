import java.util.Arrays;

class Solution {
    public int findKthSmall(int[] arr, int k) {
        // Sort the array in-place to process elements in increasing order
        Arrays.sort(arr);

        int ans = k;
        for (int num : arr) {
            if (num <= ans) {
                ans++;
            } else {
                break;
            }
        }

        return ans;
    }
}