import java.util.*;

class Solution {
    public int scoreOfParentheses(String s) {
        
        Stack<Integer> stack = new Stack<>();
        
        // Start with outermost level
        stack.push(0);
        
        for (char ch : s.toCharArray()) {
            
            if (ch == '(') {
                // Start a new nested level
                stack.push(0);
            } 
            else {
                // Get score inside current ()
                int value = stack.pop();
                
                int score;
                
                if (value == 0) {
                    // ()
                    score = 1;
                } else {
                    // (A)
                    score = 2 * value;
                }
                
                // Add score to previous level
                stack.push(stack.pop() + score);
            }
        }
        
        return stack.pop();
    }
}
