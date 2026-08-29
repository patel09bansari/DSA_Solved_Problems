import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        List<Deque<Integer>> groups = new ArrayList<>();
        Map<Integer, Integer> numToGroup = new HashMap<>();

        // Group elements where consecutive sorted difference <= limit
        int groupIndex = 0;
        groups.add(new ArrayDeque<>());
        groups.get(groupIndex).add(sortedNums[0]);
        numToGroup.put(sortedNums[0], groupIndex);

        for (int i = 1; i < n; i++) {
            if (sortedNums[i] - sortedNums[i - 1] > limit) {
                groupIndex++;
                groups.add(new ArrayDeque<>());
            }
            groups.get(groupIndex).add(sortedNums[i]);
            numToGroup.put(sortedNums[i], groupIndex);
        }

        // Reconstruct the array greedily using the smallest available element from each group
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int gIndex = numToGroup.get(nums[i]);
            result[i] = groups.get(gIndex).pollFirst();
        }

        return result;
    }
}