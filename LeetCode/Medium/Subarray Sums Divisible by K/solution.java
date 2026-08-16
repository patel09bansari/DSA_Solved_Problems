class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] remainderCounts = new int[k];
        remainderCounts[0] = 1; // Base case: prefix sum of 0 appears once
        
        int prefixSum = 0;
        int count = 0;
        
        for (int num : nums) {
            prefixSum += num;
            
            // Normalize remainder to handle negative values in Java
            int remainder = ((prefixSum % k) + k) % k;
            
            // Add the frequency of this remainder seen so far
            count += remainderCounts[remainder];
            
            // Increment the count of this remainder
            remainderCounts[remainder]++;
        }
        
        return count;
    }
}