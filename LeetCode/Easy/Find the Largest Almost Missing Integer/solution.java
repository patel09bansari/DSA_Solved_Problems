import java.util.HashMap;
import java.util.Map;

class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> subarrayCount = new HashMap<>();

        // Count in how many subarrays of size k each number appears
        for (int i = 0; i <= n - k; i++) {
            boolean[] seen = new boolean[51]; // Track elements in the current subarray
            for (int j = i; j < i + k; j++) {
                if (!seen[nums[j]]) {
                    seen[nums[j]] = true;
                    subarrayCount.put(nums[j], subarrayCount.getOrDefault(nums[j], 0) + 1);
                }
            }
        }

        // Find the largest element that appears in exactly one subarray of size k
        int maxVal = -1;
        for (Map.Entry<Integer, Integer> entry : subarrayCount.entrySet()) {
            if (entry.getValue() == 1) {
                maxVal = Math.max(maxVal, entry.getKey());
            }
        }

        return maxVal;
    }
}