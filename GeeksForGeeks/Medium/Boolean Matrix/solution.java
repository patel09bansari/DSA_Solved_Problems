class Solution {
	void booleanMatrix(int mat[][]) {
		int rows = mat.length;
		int cols = mat[0].length;
		
		boolean[] row = new boolean[rows];
		boolean[] col = new boolean[cols];
		
		for (int i = 0; i<rows; i++) {
			for (int j = 0; j<cols; j++) {
				if (mat[i][j] == 1) {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		for (int i = 0; i<rows; i++) {
			for (int j = 0; j<cols; j++) {
				if (row[i] | col[j]) {
					mat[i][j] = 1; }
				}
			}
			
		}
	}
