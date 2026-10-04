class Solution {
    static int findPerimeter(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int perimeter = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    // Each '1' initially adds 4 to the perimeter
                    perimeter += 4;

                    // If the cell above is also '1', subtract 2 (shared edge)
                    if (i > 0 && mat[i - 1][j] == 1) {
                        perimeter -= 2;
                    }

                    // If the cell to the left is also '1', subtract 2 (shared edge)
                    if (j > 0 && mat[i][j - 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }

        return perimeter;
    }
}