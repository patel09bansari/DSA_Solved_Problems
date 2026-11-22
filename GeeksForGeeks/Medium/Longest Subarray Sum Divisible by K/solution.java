import java.util.Arrays;

class Solution {
    public int longestSubarrayDivK(int[] arr, int k) {
        // Array stores the first seen index for each remainder (0 to k - 1).
        // Using an int[] array instead of HashMap avoids boxing overhead and is faster.
        int[] firstSeen = new int[k];
        Arrays.fill(firstSeen, -2);

        // Remainder 0 is conceptually seen at index -1 (before array starts)
        firstSeen[0] = -1;

        long prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Normalize negative remainders into [0, k - 1]
            int rem = (int) (((prefixSum % k) + k) % k);

            if (firstSeen[rem] != -2) {
                maxLen = Math.max(maxLen, i - firstSeen[rem]);
            } else {
                firstSeen[rem] = i;
            }
        }

        return maxLen;
    }
}