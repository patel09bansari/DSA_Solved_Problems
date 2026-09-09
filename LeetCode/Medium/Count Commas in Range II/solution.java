class Solution {
    public long countCommas(long n) {
        long totalCommas = 0;
        
        // Define the lower boundaries where the number of commas increases
        // 1,000 -> 1 comma
        // 1,000,000 -> 2 commas
        // 1,000,000,000 -> 3 commas
        // 1,000,000,000,000 -> 4 commas
        // 1,000,000,000,000,000 -> 5 commas
        long[] lowerBounds = {
            1_000L,
            1_000_000L,
            1_000_000_000L,
            1_000_000_000_000L,
            1_000_000_000_000_000L
        };
        
        for (int i = 0; i < lowerBounds.length; i++) {
            if (n >= lowerBounds[i]) {
                long upperBound = (i + 1 < lowerBounds.length) ? lowerBounds[i + 1] - 1 : Long.MAX_VALUE;
                long count = Math.min(n, upperBound) - lowerBounds[i] + 1;
                totalCommas += count * (i + 1);
            }
        }
        
        return totalCommas;
    }
}