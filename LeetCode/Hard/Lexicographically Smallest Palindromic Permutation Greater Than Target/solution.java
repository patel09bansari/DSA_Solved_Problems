import java.util.Arrays;

class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Check if a palindromic permutation is possible
        int oddCount = 0;
        char midChar = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                midChar = (char) ('a' + i);
            }
        }
        if (oddCount > 1) return "";

        int halfLen = n / 2;
        int[] halfCount = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
        }

        // Try prefix matches of length len from halfLen down to 0
        for (int len = halfLen; len >= 0; len--) {
            int[] currentHalfCount = halfCount.clone();
            boolean possible = true;
            char[] prefix = new char[halfLen];

            // Fill prefix up to length len matching target
            for (int i = 0; i < len; i++) {
                char tChar = target.charAt(i);
                if (currentHalfCount[tChar - 'a'] > 0) {
                    prefix[i] = tChar;
                    currentHalfCount[tChar - 'a']--;
                } else {
                    possible = false;
                    break;
                }
            }
            if (!possible) continue;

            // If len == halfLen, check remaining middle/mirror against target
            if (len == halfLen) {
                String candidate = constructPalindrome(prefix, midChar, n % 2 != 0);
                if (candidate.compareTo(target) > 0) {
                    return candidate;
                }
                continue;
            }

            // Next character at index 'len' must be strictly greater than target[len]
            char targetChar = target.charAt(len);
            for (int c = targetChar - 'a' + 1; c < 26; c++) {
                if (currentHalfCount[c] > 0) {
                    int[] nextHalfCount = currentHalfCount.clone();
                    prefix[len] = (char) ('a' + c);
                    nextHalfCount[c]--;

                    // Fill remainder of first half greedily with smallest available characters
                    int idx = len + 1;
                    for (int ch = 0; ch < 26; ch++) {
                        while (nextHalfCount[ch] > 0) {
                            prefix[idx++] = (char) ('a' + ch);
                            nextHalfCount[ch]--;
                        }
                    }

                    String candidate = constructPalindrome(prefix, midChar, n % 2 != 0);
                    if (candidate.compareTo(target) > 0) {
                        return candidate;
                    }
                }
            }
        }

        return "";
    }

    private String constructPalindrome(char[] prefix, char midChar, boolean isOdd) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        if (isOdd) {
            sb.append(midChar);
        }
        for (int i = prefix.length - 1; i >= 0; i--) {
            sb.append(prefix[i]);
        }
        return sb.toString();
    }
}