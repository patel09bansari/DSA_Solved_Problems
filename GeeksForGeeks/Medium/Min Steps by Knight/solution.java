import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int minStepToReachTarget(int[] knightPos, int[] targetPos, int n) {

        // If already at target
        if (knightPos[0] == targetPos[0] &&
            knightPos[1] == targetPos[1]) {
            return 0;
        }

        // 8 possible knight moves
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

        boolean[][] visited = new boolean[n + 1][n + 1];

        Queue<int[]> queue = new LinkedList<>();

        // {row, column, steps}
        queue.add(new int[]{knightPos[0], knightPos[1], 0});
        visited[knightPos[0]][knightPos[1]] = true;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];
            int steps = current[2];

            // Try all 8 moves
            for (int i = 0; i < 8; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                // Check board boundaries
                if (nx >= 1 && nx <= n &&
                    ny >= 1 && ny <= n &&
                    !visited[nx][ny]) {

                    // Target reached
                    if (nx == targetPos[0] &&
                        ny == targetPos[1]) {
                        return steps + 1;
                    }

                    visited[nx][ny] = true;

                    queue.add(new int[]{
                        nx, ny, steps + 1
                    });
                }
            }
        }

        return -1;
    }
}