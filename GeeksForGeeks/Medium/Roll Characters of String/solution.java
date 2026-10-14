class Solution {
    public String findRollOut(String s, int[] roll) {
        int n = s.length();
        int[] freq = new int[n + 1];

        // Count the frequency of rolls for each prefix length
        for (int r : roll) {
            freq[0]++;
            if (r < n) {
                freq[r]--;
            }
        }

        // Compute the cumulative roll counts from left to right
        int currentRolls = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            currentRolls += freq[i];
            // Apply the rolls with modulo arithmetic for 'a' through 'z'
            chars[i] = (char) ('a' + (chars[i] - 'a' + currentRolls) % 26);
        }

        return new String(chars);
    }
}