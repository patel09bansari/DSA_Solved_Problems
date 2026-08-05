import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Remove the element that falls outside the current window of size k
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            
            // set.add returns false if the element already exists in the set
            if (!set.add(nums[i])) {
                return true;
            }
        }
        
        return false;
    }
}