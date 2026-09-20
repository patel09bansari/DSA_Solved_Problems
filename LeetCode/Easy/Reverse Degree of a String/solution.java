class Solution {
    public int reverseDegree(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int reversedAlphabetIndex = 'z' - s.charAt(i) + 1;
            int stringIndex = i + 1;
            total += reversedAlphabetIndex * stringIndex;
        }
        return total;
    }
}