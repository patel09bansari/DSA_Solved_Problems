class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int Sum = 0;
        int actualSum = 0;

        // Loop 1: Find the sum of all numbers that SHOULD be there (0 to n)
        for (int i = 0; i <= n; i++) {
            Sum += i;
        }

        // Loop 2: Find the sum of all numbers that ARE there
        for (int i = 0; i < n; i++) {
            actualSum += nums[i];
        }

        // The difference is our missing number
        return Sum - actualSum;
    }
}