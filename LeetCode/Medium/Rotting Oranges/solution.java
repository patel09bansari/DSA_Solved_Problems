import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        
        // Step 1: Add all rotten oranges to queue & count fresh ones
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }
        
        // If there are no fresh oranges, 0 minutes are needed
        if (freshOranges == 0) return 0;
        
        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // Step 2: BFS traversal level by level
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedAny = false;
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                for (int[] dir : directions) {
                    int nRow = curr[0] + dir[0];
                    int nCol = curr[1] + dir[1];
                    
                    // If neighbor is a fresh orange, rot it
                    if (nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols && grid[nRow][nCol] == 1) {
                        grid[nRow][nCol] = 2;
                        queue.offer(new int[]{nRow, nCol});
                        freshOranges--;
                        rottedAny = true;
                    }
                }
            }
            
            if (rottedAny) {
                minutes++;
            }
        }
        
        // Step 3: Check if all fresh oranges rotted
        return freshOranges == 0 ? minutes : -1;
    }
}