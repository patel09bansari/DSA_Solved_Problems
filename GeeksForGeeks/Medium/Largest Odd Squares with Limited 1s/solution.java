import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        int n = mat.length;
        int m = mat[0].length;

        // Build 2D Prefix Sum Array (1-indexed for convenience)
        int[][] pref = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pref[i + 1][j + 1] = mat[i][j] + pref[i][j + 1] + pref[i + 1][j] - pref[i][j];
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int[] q : queries) {
            int r = q[0];
            int c = q[1];

            // Maximum radius expansion within matrix bounds
            int low = 0;
            int high = Math.min(Math.min(r, n - 1 - r), Math.min(c, m - 1 - c));
            int bestL = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                // Subgrid coordinates for radius mid
                int r1 = r - mid;
                int c1 = c - mid;
                int r2 = r + mid;
                int c2 = c + mid;

                // Query sum in range [r1..r2][c1..c2] using 2D prefix sum
                int sum = pref[r2 + 1][c2 + 1] - pref[r1][c2 + 1] - pref[r2 + 1][c1] + pref[r1][c1];

                if (sum <= k) {
                    bestL = mid;   // Valid expansion, try larger
                    low = mid + 1;
                } else {
                    high = mid - 1; // Too many 1s, try smaller
                }
            }

            if (bestL == -1) {
                result.add(-1);
            } else {
                result.add(2 * bestL + 1);
            }
        }

        return result;
    }
}