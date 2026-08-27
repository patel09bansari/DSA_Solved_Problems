import java.util.Arrays;

class Solution {
    public int maxArea(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] hist = new int[n][m];

        // Step 1: Calculate consecutive 1s vertically for each column
        for (int j = 0; j < m; j++) {
            hist[0][j] = mat[0][j];
            for (int i = 1; i < n; i++) {
                hist[i][j] = (mat[i][j] == 0) ? 0 : hist[i - 1][j] + 1;
            }
        }

        int maxArea = 0;

        // Step 2 & 3: Sort each row and calculate the max area
        for (int i = 0; i < n; i++) {
            Arrays.sort(hist[i]);

            // Calculate area considering sorted heights (right to left for non-increasing order)
            for (int j = m - 1; j >= 0; j--) {
                int height = hist[i][j];
                int width = m - j;
                maxArea = Math.max(maxArea, height * width);
            }
        }

        return maxArea;
    }
}