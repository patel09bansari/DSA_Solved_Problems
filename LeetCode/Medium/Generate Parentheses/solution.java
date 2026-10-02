import java.util.ArrayList;
import java.util.List;

class Solution {
    public List generateParenthesis(int n) {
        List result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    
    private void backtrack(List result, StringBuilder current, int open, int close, int max) {
        // Base case: if the current string length is 2 * n, it's a valid combination
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }
        
        // If we haven't used all open parentheses, we can add one
        if (open < max) {
            current.append("(");
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
        
        // If we have more open parentheses than close ones, we can add a close parenthesis
        if (close < open) {
            current.append(")");
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }
}