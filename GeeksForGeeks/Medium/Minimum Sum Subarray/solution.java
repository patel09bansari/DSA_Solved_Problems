class Solution {
    public int minSubarraySum(int[] arr) {
        int minSoFar = arr[0];
        int currMin = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currMin = Math.min(arr[i], currMin + arr[i]);
            minSoFar = Math.min(minSoFar, currMin);
        }

        return minSoFar;
    }
}