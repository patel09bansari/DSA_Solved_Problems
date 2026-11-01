class Solution {
    public int maximumSubarray(int[] arr) {
        int n = arr.length;

        // noSquare stores max sum ending at i with 0 squares used
        long noSquare = arr[0];
        // oneSquare stores max sum ending at i with 1 square used
        long oneSquare = (long) arr[0] * arr[0];

        long maxSum = Math.max(noSquare, oneSquare);

        for (int i = 1; i < n; i++) {
            long val = arr[i];
            long squaredVal = val * val;

            // For oneSquare, we can either:
            // 1. Square the current element and add it to previous noSquare sum
            // 2. Keep current element normal and add it to previous oneSquare sum
            long nextOneSquare = Math.max(squaredVal, Math.max(val + oneSquare, squaredVal + noSquare));

            // For noSquare, it's standard Kadane's: either start fresh or extend previous noSquare
            long nextNoSquare = Math.max(val, val + noSquare);

            noSquare = nextNoSquare;
            oneSquare = nextOneSquare;

            maxSum = Math.max(maxSum, Math.max(noSquare, oneSquare));
        }

        return (int) maxSum;
    }
}