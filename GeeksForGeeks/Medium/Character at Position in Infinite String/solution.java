import java.util.ArrayList;
import java.util.List;

class Solution {
    public char posInfinite(String s, int pos) {
        long p = pos;
        List<Long> lengths = new ArrayList<>();

        long currLen = s.length();
        lengths.add(currLen);

        int step = 0;
        while (currLen < p) {
            step++;
            currLen = 2 * currLen + step;
            lengths.add(currLen);
        }

        for (int i = step; i >= 1; i--) {
            long prevLen = lengths.get(i - 1);
            long totalLen = lengths.get(i);

            if (p <= prevLen) {
                // Position is in the first half (S_{i-1}), no change to p
                continue;
            } else if (p <= prevLen + i) {
                // Position falls in the middle '$' block
                return '$';
            } else {
                // Position falls in reverse(S_{i-1}), mirror it back
                p = totalLen - p + 1;
            }
        }

        return s.charAt((int) (p - 1));
    }
}