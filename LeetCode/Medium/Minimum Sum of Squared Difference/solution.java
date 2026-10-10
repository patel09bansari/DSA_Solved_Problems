import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long totalOps = (long) k1 + k2;
        
        Map<Integer, Long> diffCount = new HashMap<>();
        long totalDiffSum = 0;
        for (int i = 0; i < n; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            if (d > 0) {
                diffCount.put(d, diffCount.getOrDefault(d, 0L) + 1L);
                totalDiffSum += d;
            }
        }
        
        if (totalDiffSum <= totalOps) {
            return 0;
        }
        
        Integer[] diffs = diffCount.keySet().toArray(new Integer[0]);
        Arrays.sort(diffs, Collections.reverseOrder());
        
        for (int i = 0; i < diffs.length && totalOps > 0; i++) {
            int curr = diffs[i];
            int next = (i + 1 < diffs.length) ? diffs[i + 1] : 0;
            
            long count = diffCount.get(curr);
            long diffHeight = (long)(curr - next);
            long opsNeeded = count * diffHeight;
            
            if (totalOps >= opsNeeded) {
                totalOps -= opsNeeded;
                diffCount.remove(curr);
                if (next > 0) {
                    diffCount.put(next, diffCount.get(next) + count);
                }
            } else {
                long step = totalOps / count;
                long remainder = totalOps % count;
                
                int newDiff = curr - (int)step;
                diffCount.remove(curr);
                
                diffCount.put(newDiff, diffCount.getOrDefault(newDiff, 0L) + count - remainder);
                if (newDiff - 1 >= 0) {
                    diffCount.put(newDiff - 1, diffCount.getOrDefault(newDiff - 1, 0L) + remainder);
                }
                totalOps = 0;
                break;
            }
        }
        
        long ans = 0;
        for (Map.Entry<Integer, Long> entry : diffCount.entrySet()) {
            long d = entry.getKey();
            long count = entry.getValue();
            ans += d * d * count;
        }
        
        return ans;
    }
}