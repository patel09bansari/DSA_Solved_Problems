class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0; 
        int maxOpen = 0; 
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else if (c == '*') {
                minOpen--; // Treat '*' as ')'
                maxOpen++; // Treat '*' as '('
            }
            
            // If the maximum possible open parentheses is negative, 
            // it means there are too many ')' to be balanced.
            if (maxOpen < 0) {
                return false;
            }
            
            // The minimum possible open parentheses cannot be negative.
            // If it drops below 0, it means we treated a '*' as a ')' 
            // when we should have treated it as an empty string.
            minOpen = Math.max(minOpen, 0);
        }
        
        // If the minimum possible open parentheses is 0, the string is valid.
        return minOpen == 0;
    }
}