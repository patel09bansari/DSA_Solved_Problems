import java.util.*;

class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        int target = n * n;

        // Map moves for ladders and snakes
        int[] board = new int[target + 1];
        Arrays.fill(board, -1);

        for (int i = 0; i < lad.length; i += 2) {
            board[lad[i]] = lad[i + 1];
        }
        for (int i = 0; i < sn.length; i += 2) {
            board[sn[i]] = sn[i + 1];
        }

        // BFS initialization
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[target + 1];

        queue.offer(1);
        visited[1] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr == target) {
                    return moves;
                }

                // Try all 6 dice outcomes
                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next > target) break;

                    // Take snake or ladder if available
                    if (board[next] != -1) {
                        next = board[next];
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}