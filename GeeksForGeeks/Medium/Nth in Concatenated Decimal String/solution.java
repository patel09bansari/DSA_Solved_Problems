class Solution {
    public char nthCharacter(int n) {
        long len = 1;      // Length of the current numbers (1-digit, 2-digit, etc.)
        long count = 9;    // Number of integers with the current length
        long start = 1;    // The first number of the current length

        // Step 1: Find the range where the n-th character lies
        while (n > len * count) {
            n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }

        // Step 2: Find the exact number containing the n-th character
        long targetNumber = start + (n - 1) / len;

        // Step 3: Find the specific digit within that number
        int digitIndex = (int)((n - 1) % len);
        String s = Long.toString(targetNumber);

        return s.charAt(digitIndex);
    }
}