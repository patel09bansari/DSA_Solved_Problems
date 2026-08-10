class Solution {
    public int maxTask(int[] h, int[] l) {
        int n = h.length;
        if (n == 0) return 0;
        if (n == 1) return Math.max(h[0], l[0]);

        int prev2 = 0;
        int prev1 = Math.max(h[0], l[0]);

        for (int i = 1; i < n; i++) {
            // Option 1: Do low-effort task today
            int optionLow = prev1 + l[i];
            
            // Option 2: Do high-effort task today (requires skipping yesterday)
            int optionHigh = prev2 + h[i];
            
            int curr = Math.max(optionLow, optionHigh);
            
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}