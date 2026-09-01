import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int maxEnergy) {
         int m = classroom.length;
        int n = classroom[0].length();
        
        int startX = -1, startY = -1;
        List<int[]> litterList = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    startX = i;
                    startY = j;
                } else if (c == 'L') {
                    litterList.add(new int[]{i, j});
                }
            }
        }
        
        int numLitter = litterList.size();
        int targetMask = (1 << numLitter) - 1;
        
        // Map litter coordinates to bit index
        int[][] litterIdx = new int[m][n];
        for (int[] row : litterIdx) Arrays.fill(row, -1);
        for (int i = 0; i < numLitter; i++) {
            litterIdx[litterList.get(i)[0]][litterList.get(i)[1]] = i;
        }
        
        // bestEnergy[x][y][mask] stores max energy remaining at (x, y) with bitmask 'mask'
        int[][][] bestEnergy = new int[m][n][1 << numLitter];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(bestEnergy[i][j], -1);
            }
        }
        
        // BFS Queue stores: {x, y, mask, currentEnergy}
        Queue<int[]> queue = new LinkedList<>();
        
        // Initial state at 'S'
        queue.offer(new int[]{startX, startY, 0, maxEnergy});
        bestEnergy[startX][startY][0] = maxEnergy;
        
        int moves = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                int r = curr[0], c = curr[1], mask = curr[2], e = curr[3];
                
                // If all litter items are collected
                if (mask == targetMask) {
                    return moves;
                }
                
                // If out of energy, cannot move further
                if (e == 0) continue;
                
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    
                    // Boundary check and obstacle check
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }
                    
                    int nextMask = mask;
                    int nextEnergy = e - 1;
                    char cell = classroom[nr].charAt(nc);
                    
                    // Collect litter
                    if (cell == 'L') {
                        int idx = litterIdx[nr][nc];
                        if (idx != -1) {
                            nextMask |= (1 << idx);
                        }
                    } 
                    // Reset energy at 'R'
                    else if (cell == 'R') {
                        nextEnergy = maxEnergy;
                    }
                    
                    // Pruning: check if we reached this state with strictly more energy
                    if (nextEnergy > bestEnergy[nr][nc][nextMask]) {
                        bestEnergy[nr][nc][nextMask] = nextEnergy;
                        queue.offer(new int[]{nr, nc, nextMask, nextEnergy});
                    }
                }
            }
            moves++;
        }
        
        return -1;
    }
}