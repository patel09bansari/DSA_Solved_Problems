class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freeCount = new int[n];
        
        // Step 1: Count how many other items each item i grants for free
        for (int i = 0; i < n; i++) {
            int f_i = items[i][0];
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % f_i == 0) {
                    freeCount[i]++;
                }
            }
        }
        
        // Step 2: Knapsack DP over budget
        int[] dp = new int[budget + 1];
        
        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int firstCopyGain = 1 + freeCount[i];
            
            // Pass 1 (Downwards): Buy the 1st copy of item i (at most once)
            for (int b = budget; b >= price; b--) {
                dp[b] = Math.max(dp[b], dp[b - price] + firstCopyGain);
            }
            
            // Pass 2 (Upwards): Buy unlimited additional copies of item i (+1 each)
            for (int b = price; b <= budget; b++) {
                dp[b] = Math.max(dp[b], dp[b - price] + 1);
            }
        }
        
        return dp[budget];
    }
}