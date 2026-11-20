class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int flipsStartingWithZero = 0;

        for (int i = 0; i < n; i++) {
            char expected = (i % 2 == 0) ? '0' : '1';
            if (s.charAt(i) != expected) {
                flipsStartingWithZero++;
            }
        }

        int flipsStartingWithOne = n - flipsStartingWithZero;
        return Math.min(flipsStartingWithZero, flipsStartingWithOne);
    }
}