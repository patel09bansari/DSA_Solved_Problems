class Solution {
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        
        // Left to Right traversal
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            } else if (right > left) {
                // Invalid state, reset counters
                left = 0;
                right = 0;
            }
        }
        
        left = 0;
        right = 0;
        
        // Right to Left traversal
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                // Invalid state, reset counters
                left = 0;
                right = 0;
            }
        }
        
        return maxLen;
    }
}