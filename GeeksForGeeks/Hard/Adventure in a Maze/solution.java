import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {
        int n = grid.length;
        int MOD = 1000000007;

        int[][] pathCount = new int[n][n];
        int[][] maxAdventure = new int[n][n];

        // Base case: starting point
        pathCount[0][0] = 1;
        maxAdventure[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                long totalWays = 0;
                int maxAdv = 0;

                // Check coming from Left cell (i, j - 1)
                if (j > 0 && pathCount[i][j - 1] > 0) {
                    int prevVal = grid[i][j - 1];
                    // Cell on left must allow moving Right (value 1 or 3)
                    if (prevVal == 1 || prevVal == 3) {
                        totalWays = (totalWays + pathCount[i][j - 1]) % MOD;
                        maxAdv = Math.max(maxAdv, maxAdventure[i][j - 1] + grid[i][j]);
                    }
                }

                // Check coming from Top cell (i - 1, j)
                if (i > 0 && pathCount[i - 1][j] > 0) {
                    int prevVal = grid[i - 1][j];
                    // Cell above must allow moving Down (value 2 or 3)
                    if (prevVal == 2 || prevVal == 3) {
                        totalWays = (totalWays + pathCount[i - 1][j]) % MOD;
                        maxAdv = Math.max(maxAdv, maxAdventure[i - 1][j] + grid[i][j]);
                    }
                }

                pathCount[i][j] = (int) totalWays;
                maxAdventure[i][j] = maxAdv;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(pathCount[n - 1][n - 1]);
        result.add(maxAdventure[n - 1][n - 1]);

        return result;
    }
}