class Solution {
    public String compress(String s) {
        int n = s.length();

        // Compute the KMP prefix function (LPS array)
        int[] lps = new int[n];
        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }

        StringBuilder result = new StringBuilder();
        int i = n - 1;

        // Traverse backwards and replace repeated prefixes with '*'
        while (i >= 0) {
            // Check if the current prefix s[0..i] can be formed by doubling s[0..len-1]
            if (i % 2 == 1) {
                int halfLen = (i + 1) / 2;
                int len = lps[i];

                // Keep reducing using LPS until we find a match of length halfLen or smaller
                while (len > halfLen) {
                    len = lps[len - 1];
                }

                if (len == halfLen) {
                    result.append('*');
                    i = halfLen - 1; // Move to the end of the first half
                    continue;
                }
            }

            result.append(s.charAt(i));
            i--;
        }

        // Since we processed backwards, reverse the string before returning
        return result.reverse().toString();
    }
}