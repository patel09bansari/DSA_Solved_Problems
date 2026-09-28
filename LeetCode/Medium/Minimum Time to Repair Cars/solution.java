class Solution {
    public long repairCars(int[] ranks, int cars) {
        // Find maximum rank
        long maxRank = 0;
        for (int i = 0; i < ranks.length; i++) {
            if (ranks[i] > maxRank) {
                maxRank = ranks[i];
            }
        }

        // Search space using long to prevent overflow
        long left = 1;
        long right = maxRank * (long) cars * cars; 
        long ans = right;

        // Binary search on time
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long carsRepaired = 0;

            // Cars fixed in mid time
            for (int i = 0; i < ranks.length; i++) {
                carsRepaired += (long) Math.sqrt(mid / ranks[i]);
            }

            // Check if cars repaired meet or exceed target
            if (carsRepaired >= cars) {
                ans = mid; 
                right = mid - 1; // Try to find a smaller time
            } else {
                left = mid + 1; // Need more time
            }
        }
        return ans;
    }
}