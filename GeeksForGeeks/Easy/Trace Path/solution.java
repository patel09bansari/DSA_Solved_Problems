class Solution {
    public boolean isPossible(int n, int m, String s) {
        int maxRow = 0, minRow = 0;
        int maxCol = 0, minCol = 0;
        int currRow = 0, currCol = 0;

        for (char c : s.toCharArray()) {
            if (c == 'L') {
                currCol--;
            } else if (c == 'R') {
                currCol++;
            } else if (c == 'D') {
                currRow--;
            } else if (c == 'U') {
                currRow++;
            }

            maxRow = Math.max(maxRow, currRow);
            minRow = Math.min(minRow, currRow);
            maxCol = Math.max(maxCol, currCol);
            minCol = Math.min(minCol, currCol);
        }

        int totalRows = maxRow - minRow + 1;
        int totalCols = maxCol - minCol + 1;

        return totalRows <= n && totalCols <= m;
    }
}