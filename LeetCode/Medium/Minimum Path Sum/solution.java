class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    // For cells in the middle, take the minimum from the top or left cell
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                } 
                else if (i > 0) {
                    // For the first column, only the top cell is available
                    grid[i][0] += grid[i - 1][0];
                } 
                else if (j > 0) {
                    // For the first row, only the left cell is available
                    grid[0][j] += grid[0][j - 1];
                }
            }
        }
        
        // Return the bottom-right corner element which contains the minimum path sum
        return grid[m - 1][n - 1];
    }
}