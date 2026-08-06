class Solution {
    public int countMinOperations(int[] arr) {
        int totalIncrements = 0;
        int maxDoubles = 0;

        for (int num : arr) {
            int currentDoubles = 0;

            while (num > 0) {
                // If the number is odd, we need an increment operation
                if ((num & 1) == 1) {
                    totalIncrements++;
                    num--;
                }
                
                // If the number is still > 0, we divide by 2 (double operation)
                if (num > 0) {
                    num /= 2;
                    currentDoubles++;
                }
            }

            // The overall double operations needed is governed by the maximum value
            maxDoubles = Math.max(maxDoubles, currentDoubles);
        }

        return totalIncrements + maxDoubles;
    }
}