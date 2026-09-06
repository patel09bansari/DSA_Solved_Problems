class Solution {
    public long pairAndSum(int[] arr) {
        long totalSum = 0;
        int n = arr.length;

        for (int k = 0; k < 32; k++) {
            long count = 0;

            // Count numbers with the k-th bit set
            for (int i = 0; i < n; i++) {
                if ((arr[i] & (1 << k)) != 0) {
                    count++;
                }
            }

            // Number of pairs with the k-th bit set in both numbers
            long pairs = (count * (count - 1)) / 2;

            // Add the contribution of the k-th bit to the total sum
            totalSum += pairs * (1L << k);
        }

        return totalSum;
    }
}