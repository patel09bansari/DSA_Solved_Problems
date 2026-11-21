class Solution {
    public int smallestSubWithSum(int[] arr, int x) {
        int n = arr.length;
        int left = 0;
        long currentSum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            currentSum += arr[right];

            while (currentSum > x) {
                minLen = Math.min(minLen, right - left + 1);
                currentSum -= arr[left];
                left++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}