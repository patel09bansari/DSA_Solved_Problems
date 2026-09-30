class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            // Place '(' based on odd/even index, and flip the logic for ')'
            ans[i] = seq.charAt(i) == '(' ? i & 1 : 1 - (i & 1);
        }
        
        return ans;
    }
}