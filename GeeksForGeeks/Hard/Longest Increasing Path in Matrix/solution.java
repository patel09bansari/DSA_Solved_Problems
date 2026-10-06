class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longIncPath(int[][] matrix, int n, int m) {
        if (matrix == null || n == 0 || m == 0) return 0;

        int[][] memo = new int[n][m];
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, i, j, n, m, memo));
            }
        }

        return maxLen;
    }

    private int dfs(int[][] matrix, int r, int c, int n, int m, int[][] memo) {
        if (memo[r][c] != 0) {
            return memo[r][c];
        }

        int maxLength = 1;

        for (int[] dir : DIRECTIONS) {
            int nextR = r + dir[0];
            int nextC = c + dir[1];

            if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m && matrix[nextR][nextC] > matrix[r][c]) {
                maxLength = Math.max(maxLength, 1 + dfs(matrix, nextR, nextC, n, m, memo));
            }
        }

        memo[r][c] = maxLength;
        return maxLength;
    }
}