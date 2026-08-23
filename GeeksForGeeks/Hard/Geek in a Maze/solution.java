import java.util.*;

class Solution {

    // Class to store state of each cell in BFS
    static class Node {
        int r, c, u, d;
        Node(int r, int c, int u, int d) {
            this.r = r;
            this.c = c;
            this.u = u;
            this.d = d;
        }
    }

    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // If start cell is invalid or an obstacle
        if (mat[r][c] == '#') return 0;

        // Stores max remaining (up, down) moves allowed for visited cells
        int[][] maxU = new int[n][m];
        int[][] maxD = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(maxU[i], -1);
            Arrays.fill(maxD[i], -1);
        }

        // PriorityQueue or Queue prioritizing maximum remaining vertical steps
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> (b.u + b.d) - (a.u + a.d));

        pq.add(new Node(r, c, u, d));
        maxU[r][c] = u;
        maxD[r][c] = d;

        int visitedCount = 0;

        // Directions: Up, Down, Left, Right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            // Count this cell if it's visited for the first time
            if (mat[curr.r][curr.c] == '.') {
                visitedCount++;
                mat[curr.r][curr.c] = 'V'; // Mark as visited in matrix
            }

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && mat[nr][nc] != '#') {
                    int nextU = curr.u;
                    int nextD = curr.d;

                    // Moving Up
                    if (i == 0) {
                        nextU--;
                    }
                    // Moving Down
                    else if (i == 1) {
                        nextD--;
                    }

                    // Check if we have valid moves remaining
                    if (nextU >= 0 && nextD >= 0) {
                        // Only proceed if this path offers more remaining up or down moves
                        if (nextU > maxU[nr][nc] || nextD > maxD[nr][nc]) {
                            maxU[nr][nc] = Math.max(maxU[nr][nc], nextU);
                            maxD[nr][nc] = Math.max(maxD[nr][nc], nextD);
                            pq.add(new Node(nr, nc, nextU, nextD));
                        }
                    }
                }
            }
        }

        return visitedCount;
    }
}