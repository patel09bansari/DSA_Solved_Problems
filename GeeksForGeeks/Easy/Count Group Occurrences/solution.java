class Solution {
    int getCount(String s, int k) {
        int[] groupCount = new int[26];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            // A group starts at i = 0 or when the character changes
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                groupCount[s.charAt(i) - 'a']++;
            }
        }

        int result = 0;
        for (int count : groupCount) {
            if (count == k) {
                result++;
            }
        }

        return result;
    }
}