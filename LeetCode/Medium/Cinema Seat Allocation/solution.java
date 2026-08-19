import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Map row number -> bitmask of reserved seats
        Map<Integer, Integer> rowMasks = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            // Set the col-th bit for this row
            rowMasks.put(row, rowMasks.getOrDefault(row, 0) | (1 << col));
        }

        // Start with the maximum theoretical capacity for n empty rows
        int maxFamilies = 2 * n;

        // Bitmasks for each 4-seat block configuration
        // Left:   seats 2, 3, 4, 5 -> (1<<2) | (1<<3) | (1<<4) | (1<<5) = 0b0000111100 = 60
        // Right:  seats 6, 7, 8, 9 -> (1<<6) | (1<<7) | (1<<8) | (1<<9) = 0b1111000000 = 960
        // Middle: seats 4, 5, 6, 7 -> (1<<4) | (1<<5) | (1<<6) | (1<<7) = 0b0011110000 = 240
        int leftMask = 60;    
        int rightMask = 960;  
        int middleMask = 240; 

        for (int mask : rowMasks.values()) {
            boolean canLeft = (mask & leftMask) == 0;
            boolean canRight = (mask & rightMask) == 0;
            boolean canMiddle = (mask & middleMask) == 0;

            if (canLeft && canRight) {
                // Both fit -> 2 groups (no loss)
                continue;
            } else if (canLeft || canRight || canMiddle) {
                // Only 1 group fits -> subtract 1
                maxFamilies -= 1;
            } else {
                // No groups fit -> subtract 2
                maxFamilies -= 2;
            }
        }

        return maxFamilies;
    }
}