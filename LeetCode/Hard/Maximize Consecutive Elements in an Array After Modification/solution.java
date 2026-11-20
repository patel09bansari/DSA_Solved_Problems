import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        
        // dp.get(val) stores the max length of a consecutive sequence ending at val
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;

        for (int num : nums) {
            // Option 1: Increment num to num + 1
            int lenPlusOne = dp.getOrDefault(num, 0) + 1;
            dp.put(num + 1, Math.max(dp.getOrDefault(num + 1, 0), lenPlusOne));

            // Option 2: Keep num as is
            int lenSame = dp.getOrDefault(num - 1, 0) + 1;
            dp.put(num, Math.max(dp.getOrDefault(num, 0), lenSame));

            maxLen = Math.max(maxLen, Math.max(dp.get(num), dp.get(num + 1)));
        }

        return maxLen;
    }
}