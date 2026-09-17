class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n]; // minLen[i] stores the minimum subarray length with sum == target up to index i
        java.util.Arrays.fill(minLen, Integer.MAX_VALUE);
        
        int left = 0, currentSum = 0;
        int minResult = Integer.MAX_VALUE;
        int currentMinLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            currentSum += arr[right];

            // Shrink window if sum exceeds target
            while (currentSum > target) {
                currentSum -= arr[left];
                left++;
            }

            // Valid subarray found ending at index `right`
            if (currentSum == target) {
                int len = right - left + 1;
                
                // If there is a valid non-overlapping subarray before `left`
                if (left > 0 && minLen[left - 1] != Integer.MAX_VALUE) {
                    minResult = Math.min(minResult, len + minLen[left - 1]);
                }
                
                currentMinLen = Math.min(currentMinLen, len);
            }

            // Update prefix minimum array
            minLen[right] = currentMinLen;
        }

        return minResult == Integer.MAX_VALUE ? -1 : minResult;
    }
}