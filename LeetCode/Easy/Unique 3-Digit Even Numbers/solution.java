import java.util.Arrays;

class Solution {
    public int totalNumbers(int[] digits) {
        // Count frequency of each available digit (0-9)
        int[] availableCounts = new int[10];
        for (int digit : digits) {
            availableCounts[digit]++;
        }

        int count = 0;

        // Iterate through all 3-digit even numbers
        for (int num = 100; num <= 998; num += 2) {
            int d1 = num / 100;       // Hundreds place
            int d2 = (num / 10) % 10; // Tens place
            int d3 = num % 10;        // Units place

            // Count required frequency for digits in the current number
            int[] neededCounts = new int[10];
            neededCounts[d1]++;
            neededCounts[d2]++;
            neededCounts[d3]++;

            // Check if available digit frequencies are sufficient
            boolean possible = true;
            for (int d = 0; d < 10; d++) {
                if (neededCounts[d] > availableCounts[d]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                count++;
            }
        }

        return count;
    }
}