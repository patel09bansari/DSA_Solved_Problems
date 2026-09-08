import java.util.ArrayList;

class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length;

        // 8 directions: Up, Down, Left, Right, 4 Diagonals
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (mat[r][c] == word.charAt(0)) {
                    if (search2D(mat, r, c, word, dx, dy)) {
                        ArrayList<Integer> coord = new ArrayList<>();
                        coord.add(r);
                        coord.add(c);
                        result.add(coord);
                    }
                }
            }
        }
        return result;
    }

    private boolean search2D(char[][] mat, int row, int col, String word, int[] dx, int[] dy) {
        int len = word.length();
        int n = mat.length;
        int m = mat[0].length;

        for (int dir = 0; dir < 8; dir++) {
            int currR = row;
            int currC = col;
            int k;

            for (k = 0; k < len; k++) {
                if (currR < 0 || currR >= n || currC < 0 || currC >= m) {
                    break;
                }
                if (mat[currR][currC] != word.charAt(k)) {
                    break;
                }
                currR += dx[dir];
                currC += dy[dir];
            }

            if (k == len) {
                return true;
            }
        }
        return false;
    }
}