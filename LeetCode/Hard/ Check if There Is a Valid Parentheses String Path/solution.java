class Solution {
    private Boolean[][][] memo;
    private int m, n;
    private char[][] grid;

    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        
        // A valid parentheses path must have an even length.
        if ((m + n - 1) % 2 != 0) return false;
        
        // The max possible open count is bounded by the grid dimensions.
        int maxOpen = m + n;
        memo = new Boolean[m][n][maxOpen + 1];
        
        return dfs(0, 0, 0);
    }

    private boolean dfs(int r, int c, int open) {
        // If the cell has '(' add 1, else subtract 1
        if (grid[r][c] == '(') {
            open++;
        } else {
            open--;
        }
        
        // If open drops below 0, this path is invalid
        if (open < 0) return false;
        
        // If open exceeds the bounds, clamp or return false safely
        if (open >= memo[0][0].length) return false;
        
        // If we reach the bottom-right cell
        if (r == m - 1 && c == n - 1) {
            return open == 0;
        }
        
        // Check memoization table
        if (memo[r][c][open] != null) {
            return memo[r][c][open];
        }
        
        boolean res = false;
        
        // Move Down
        if (r + 1 < m) {
            res = res || dfs(r + 1, c, open);
        }
        
        // Move Right
        if (!res && c + 1 < n) {
            res = res || dfs(r, c + 1, open);
        }
        
        return memo[r][c][open] = res;
    }
}