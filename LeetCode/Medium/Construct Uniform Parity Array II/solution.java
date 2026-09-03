class Solution {
    public boolean uniformArray(int[] nums1) {
        int minVal = Integer.MAX_VALUE;
        boolean hasOdd = false;
        boolean hasEven = false;

        for (int num : nums1) {
            minVal = Math.min(minVal, num);
            if (num % 2 != 0) {
                hasOdd = true;
            } else {
                hasEven = true;
            }
        }

        // If all elements already have the same parity, it's always true
        if (!hasOdd || !hasEven) {
            return true;
        }

        // If mixed parities, we need the minimum element to be odd
        return minVal % 2 != 0;
    }
}