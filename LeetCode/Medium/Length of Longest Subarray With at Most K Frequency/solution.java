import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            int current = nums[right];
            freq.put(current, freq.getOrDefault(current, 0) + 1);

            // Shrink the window if frequency of nums[right] exceeds k
            while (freq.get(current) > k) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                left++;
            }

            // Update the max window size
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}