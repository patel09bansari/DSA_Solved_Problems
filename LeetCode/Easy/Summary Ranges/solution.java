import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];

            // Continue advancing while consecutive elements differ by 1
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }

            // If range contains more than one number, format as "start->nums[i]"
            if (start != nums[i]) {
                result.add(start + "->" + nums[i]);
            } else {
                result.add(String.valueOf(start));
            }
        }

        return result;
    }
}