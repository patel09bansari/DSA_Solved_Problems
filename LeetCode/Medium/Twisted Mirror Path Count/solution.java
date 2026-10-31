class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;

        int[][][] jumpR = new int[m][n][2];
        int[][][] jumpD = new int[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                jumpR[i][j] = getLanding(i, j + 1, 0, grid, m, n);
                jumpD[i][j] = getLanding(i + 1, j, 1, grid, m, n);
            }
        }

        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;

                int[] landR = jumpR[i][j];
                if (landR[0] != -1) {
                    dp[landR[0]][landR[1]] = (dp[landR[0]][landR[1]] + dp[i][j]) % MOD;
                }

                int[] landD = jumpD[i][j];
                if (landD[0] != -1) {
                    dp[landD[0]][landD[1]] = (dp[landD[0]][landD[1]] + dp[i][j]) % MOD;
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }

    private int[] getLanding(int r, int c, int dir, int[][] grid, int m, int n) {
        while (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
            if (dir == 0) {
                r = r + 1;
                dir = 1;
            } else {
                c = c + 1;
                dir = 0;
            }
        }

        if (r >= 0 && r < m && c >= 0 && c < n) {
            return new int[]{r, c};
        }
        return new int[]{-1, -1};
    }
}