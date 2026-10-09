import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] t = new int[m][n];
        // Initialize the memoization table with -1
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0, m, n, t);
    }

    private int solve(int i, int j, int m, int n, int[][] t) {
        // Base case 1: Reached the destination (bottom-right corner)
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // Base case 2: Out of bounds check
        if (i >= m || j >= n) {
            return 0;
        }

        // Check if the result is already computed
        if (t[i][j] != -1) {
            return t[i][j];
        }

        // Move Down: (i + 1, j) and Move Right: (i, j + 1)
        int down = solve(i + 1, j, m, n, t);
        int right = solve(i, j + 1, m, n, t);

        // Store in the memoization table and return
        return t[i][j] = down + right;
    }
}