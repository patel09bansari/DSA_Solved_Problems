import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        long cost = 0;
        int r = n - 1;
        
        // Stores indices of running maximum blocks in increasing order of values
        Deque<Integer> dq = new ArrayDeque<>();

        for (int l = n - 1; l >= 0; l--) {
            // Merge smaller blocks to the right into nums[l]
            while (!dq.isEmpty() && nums[dq.peekFirst()] <= nums[l]) {
                int curr = dq.pollFirst();
                int next = dq.isEmpty() ? r + 1 : dq.peekFirst();
                cost += (long) (next - curr) * (nums[l] - nums[curr]);
            }
            dq.offerFirst(l);

            // Shrink window from the right if operations exceed k
            while (cost > k) {
                cost -= (nums[dq.peekLast()] - nums[r]);
                r--;
                if (dq.peekLast() > r) {
                    dq.pollLast();
                }
            }

            // All subarrays starting at l and ending in [l, r] are valid
            ans += (r - l + 1);
        }

        return ans;
    }
}