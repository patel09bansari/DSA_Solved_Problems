import java.util.*;

class Solution {
    public ArrayList<Integer> findPairs(int[] arr) {
        int n = arr.length;
        Map<Integer, int[]> sumMap = new HashMap<>();
        int[] best = null;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];

                if (!sumMap.containsKey(sum)) {
                    sumMap.put(sum, new int[]{i, j});
                } else {
                    int[] prev = sumMap.get(sum);
                    int a = prev[0], b = prev[1];

                    // Ensure all 4 indices are distinct
                    if (a != i && a != j && b != i && b != j) {
                        int[] curr = new int[]{a, b, i, j};
                        if (best == null || isLexSmaller(curr, best)) {
                            best = curr;
                        }
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>(4);
        if (best == null) {
            result.add(-1);
            result.add(-1);
            result.add(-1);
            result.add(-1);
        } else {
            for (int idx : best) {
                result.add(idx);
            }
        }
        return result;
    }

    private boolean isLexSmaller(int[] cand, int[] best) {
        for (int k = 0; k < 4; k++) {
            if (cand[k] != best[k]) {
                return cand[k] < best[k];
            }
        }
        return false;
    }
}