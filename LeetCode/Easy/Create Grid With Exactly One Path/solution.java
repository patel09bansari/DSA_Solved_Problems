class Solution {
    public String[] createGrid(int m, int n) {
        String[] result = new String[m];
        
        for (int i = 0; i < m; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                // Keep the top row (i == 0) and the rightmost column (j == n - 1) as free cells
                if (i == 0 || j == n - 1) {
                    row.append('.');
                } else {
                    row.append('#');
                }
            }
            result[i] = row.toString();
        }
        
        return result;
    }
}