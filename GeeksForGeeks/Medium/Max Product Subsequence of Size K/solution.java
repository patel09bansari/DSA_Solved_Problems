import java.util.Arrays;

class Solution {
    long maxProduct(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);

        long ans = 1;

        // If all elements are negative and k is odd,
        // picking the largest negative numbers gives the maximum product (closest to 0).
        if (arr[n - 1] <= 0 && k % 2 != 0) {
            for (int i = n - 1; i >= n - k; i--) {
                ans *= arr[i];
            }
            return ans;
        }

        int i = 0;
        int j = n - 1;

        // If k is odd, take the largest positive element first
        if (k % 2 != 0) {
            ans *= arr[j];
            j--;
            k--;
        }

        // Pick pairs from either end to maximize positive product
        while (k > 0) {
            long leftProduct = (long) arr[i] * arr[i + 1];
            long rightProduct = (long) arr[j] * arr[j - 1];

            if (leftProduct > rightProduct) {
                ans *= leftProduct;
                i += 2;
            } else {
                ans *= rightProduct;
                j -= 2;
            }
            k -= 2;
        }

        return ans;
    }
}