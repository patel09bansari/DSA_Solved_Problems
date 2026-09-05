import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestSubseq(int[] arr) {
        // Map to store the maximum length of subsequence ending with a specific value
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLength = 0;

        for (int num : arr) {
            // Get the length of subsequences ending in (num - 1) and (num + 1)
            int len1 = dp.getOrDefault(num - 1, 0);
            int len2 = dp.getOrDefault(num + 1, 0);

            // The current length for 'num' will be 1 + max of adjacent choices
            int currentLen = 1 + Math.max(len1, len2);

            dp.put(num, currentLen);
            maxLength = Math.max(maxLength, currentLen);
        }

        return maxLength;
    }
}