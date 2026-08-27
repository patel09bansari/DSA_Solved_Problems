import java.util.Arrays;

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Try matching a prefix of length i (from n down to 0)
        // target[0...i-1] matched, target[i] bumped to a larger char
        for (int i = n - 1; i >= 0; i--) {
            // Check if s can form target[0...i-1]
            int[] prefixFreq = new int[26];
            boolean possible = true;
            for (int k = 0; k < i; k++) {
                prefixFreq[target.charAt(k) - 'a']++;
                if (prefixFreq[target.charAt(k) - 'a'] > freq[target.charAt(k) - 'a']) {
                    possible = false;
                    break;
                }
            }

            if (!possible) continue;

            // Remaining available characters after filling prefix target[0...i-1]
            int[] remFreq = new int[26];
            for (int c = 0; c < 26; c++) {
                remFreq[c] = freq[c] - prefixFreq[c];
            }

            // Look for the smallest char > target[i] available in remFreq
            int targetChar = target.charAt(i) - 'a';
            int bumpChar = -1;
            for (int c = targetChar + 1; c < 26; c++) {
                if (remFreq[c] > 0) {
                    bumpChar = c;
                    break;
                }
            }

            if (bumpChar != -1) {
                // Construct the result string
                StringBuilder sb = new StringBuilder();
                sb.append(target, 0, i);
                sb.append((char) ('a' + bumpChar));
                remFreq[bumpChar]--;

                // Append remaining characters in ascending order
                for (int c = 0; c < 26; c++) {
                    while (remFreq[c] > 0) {
                        sb.append((char) ('a' + c));
                        remFreq[c]--;
                    }
                }
                return sb.toString();
            }
        }

        return "";
    }
}