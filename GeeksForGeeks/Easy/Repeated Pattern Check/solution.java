class Solution {
    public boolean findPattern(String s) {
        int i = 0;
        int n = s.length();

        while (i < n) {
            int countX = 0;
            while (i < n && s.charAt(i) == 'x') {
                countX++;
                i++;
            }

            // A valid block must start with at least one 'x'
            if (countX == 0) {
                return false;
            }

            int countY = 0;
            while (i < n && s.charAt(i) == 'y') {
                countY++;
                i++;
            }

            // Number of 'y's must match the preceding 'x's
            if (countX != countY) {
                return false;
            }
        }

        return true;
    }
}