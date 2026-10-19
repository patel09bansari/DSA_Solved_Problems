class Solution {
    public int goodIndices(int[] arr) {
        int n = arr.length;
        // 0: unvisited, 1: good (escapes), 2: bad (cycle or zero)
        int[] state = new int[n];
        int goodCount = 0;

        for (int i = 0; i < n; i++) {
            if (dfs(i, arr, state) == 1) {
                goodCount++;
            }
        }

        return goodCount;
    }

    private int dfs(int curr, int[] arr, int[] state) {
        // If out of bounds, it escapes -> Good
        if (curr < 0 || curr >= arr.length) {
            return 1;
        }

        // If already computed, return the cached result
        if (state[curr] != 0) {
            return state[curr];
        }

        // If current element is 0, it's a dead end -> Bad
        if (arr[curr] == 0) {
            return state[curr] = 2;
        }

        // Mark as visiting (using -1 temporarily to detect cycles)
        state[curr] = -1;

        int nextIndex = curr + arr[curr];
        int result = dfs(nextIndex, arr, state);

        // Save and return the final state (1 for good, 2 for bad)
        return state[curr] = result;
    }
}