class Solution {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;

        // Continue while pointers don't overlap and end characters match
        while (left < right && s.charAt(left) == s.charAt(right)) {
            char ch = s.charAt(left);

            // Move left pointer past all identical contiguous characters
            while (left <= right && s.charAt(left) == ch) {
                left++;
            }

            // Move right pointer past all identical contiguous characters
            while (left <= right && s.charAt(right) == ch) {
                right--;
            }
        }

        // Remaining length between left and right pointers
        return right - left + 1;
    }
}