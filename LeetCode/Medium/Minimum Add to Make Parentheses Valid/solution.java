class Solution {
    public int minAddToMakeValid(String s) {
        int openCount = 0;
        int minAddsRequired = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                openCount++;
            } else {
                // If we encounter a closing parenthesis, check if there's an unmatched opening one
                if (openCount > 0) {
                    openCount--;
                } else {
                    // No matching opening parenthesis, so we need to add one
                    minAddsRequired++;
                }
            }
        }

        // Add any remaining unmatched opening parentheses that need closing counterparts
        return minAddsRequired + openCount;
    }
}