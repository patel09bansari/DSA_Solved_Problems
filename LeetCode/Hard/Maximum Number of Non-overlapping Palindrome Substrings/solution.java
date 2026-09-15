class Solution {
    public int maxPalindromes(String s, int k) {
        int count = 0;
        int lastEnd = -1; // End index of the last chosen non-overlapping palindrome
        int n = s.length();

        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + (center % 2);

            // Expand center until length is at least k
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;
                
                if (len >= k) {
                    // Check if this palindrome is completely after the last selected one
                    if (left > lastEnd) {
                        count++;
                        lastEnd = right; // Greedily take this palindrome
                    }
                    break; // Stop expanding this center once a valid length is processed
                }
                
                left--;
                right++;
            }
        }

        return count;
    }
}