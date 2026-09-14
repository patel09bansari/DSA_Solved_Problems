import java.util.*;

class Solution {
    // Renamed method to match GFG's driver code
    public int shortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length; // Fixed to use actual column length

        // 1. Mark unsafe cells using a boolean grid
        boolean[][] safe = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(safe[i], true);
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    safe[i][j] = false;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                            safe[ni][nj] = false;
                        }
                    }
                }
            }
        }

        // 2. Multi-source BFS initialization with proper generic type
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            if (safe[i][0]) {
                q.add(new int[]{i, 0, 1}); // {row, col, distance}
                visited[i][0] = true;
            }
        }

        // 3. BFS Traversal
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            // Reached the rightmost column
            if (c == m - 1) {
                return dist;
            }

            for (int k = 0; k < 4; k++) {
                int nr = r + dx[k];
                int nc = c + dy[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && safe[nr][nc] && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return -1;
    }
}
