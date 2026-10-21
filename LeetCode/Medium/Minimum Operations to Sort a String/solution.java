class Solution {
    public int minOperations(String s) {
        int n = s.length();
        
        // Check if already sorted
        boolean sorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) {
            return 0;
        }
        
        // If length is 2 and not sorted, it's impossible because we can only sort proper substrings
        if (n == 2) {
            return -1;
        }
        
        char minChar = 'z' + 1;
        char maxChar = 'a' - 1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c < minChar) minChar = c;
            if (c > maxChar) maxChar = c;
        }
        
        // Check if 1 operation is possible:
        // Case A: minChar is at index 0 (and not whole string, which is checked since n > 1)
        // Case B: maxChar is at index n - 1
        boolean minAtStart = (s.charAt(0) == minChar);
        boolean maxAtEnd = (s.charAt(n - 1) == maxChar);
        
        if (minAtStart || maxAtEnd) {
            return 1;
        }
        
        // Check if 3 operations are required:
        // This happens if minChar appears in a proper prefix or maxChar appears in a proper suffix.
        // Wait, let's look at the condition: if no min exists in any proper prefix and no max exists in any proper suffix -> 3, else 2.
        // Actually, if maxChar is at index 0 (and nowhere else?) or minChar is at index n-1?
        boolean hasMinInProperPrefix = false;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == minChar) {
                hasMinInProperPrefix = true;
                break;
            }
        }
        
        boolean hasMaxInProperSuffix = false;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == maxChar) {
                hasMaxInProperSuffix = true;
                break;
            }
        }
        
        if (!hasMinInProperPrefix && !hasMaxInProperSuffix) {
            return 3;
        }
        
        return 2;
    }
}