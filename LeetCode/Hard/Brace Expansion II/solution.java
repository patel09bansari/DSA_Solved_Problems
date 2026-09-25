import java.util.*;

class Solution {
    public List braceExpansionII(String expression) {
        Set result = new HashSet<>();
        int idx = expression.indexOf('}');
        
        if (idx == -1) {
            result.add(expression);
            List sortedResult = new ArrayList<>(result);
            Collections.sort(sortedResult);
            return sortedResult;
        }
        
        int start = expression.lastIndexOf('{', idx);
        String before = expression.substring(0, start);
        String after = expression.substring(idx + 1);
        String middle = expression.substring(start + 1, idx);
        
        String[] parts = middle.split(",");
        for (String part : parts) {
            List subResult = braceExpansionII(before + part + after);
            result.addAll(subResult);
        }
        
        List sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult);
        return sortedResult;
    }
}