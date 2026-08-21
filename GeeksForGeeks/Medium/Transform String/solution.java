class Solution {
    int transform(String s1, String s2) {
        // If lengths don't match, transformation is impossible
        if (s1.length() != s2.length()) {
            return -1;
        }

        // Check if both strings have the same character frequencies
        int[] freq = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i)]++;
            freq[s2.charAt(i)]--;
        }

        for (int count : freq) {
            if (count != 0) {
                return -1;
            }
        }

        // Two pointers starting from the end of both strings
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int operations = 0;

        while (i >= 0) {
            if (s1.charAt(i) == s2.charAt(j)) {
                // Characters match, move both pointers
                j--;
            } else {
                // Character needs to be moved to the front
                operations++;
            }
            i--;
        }

        return operations;
    }
}