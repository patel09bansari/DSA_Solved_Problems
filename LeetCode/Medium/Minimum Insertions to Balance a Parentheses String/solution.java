class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int open = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                open++;
            } else {
                // If the next character is also ')', consume it
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    // We need one ')' to make a pair
                    ans++;
                }
                
                // Check if we have an open '(' to match this ')' pair
                if (open > 0) {
                    open--;
                } else {
                    // No matching '(', we need to insert one '('
                    ans++;
                }
            }
        }
        
        // Any remaining unmatched '(' needs two ')' each
        ans += open * 2;
        
        return ans;
    }
}