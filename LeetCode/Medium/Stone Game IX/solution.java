class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[3];
        for (int stone : stones) {
            cnt[stone % 3]++;
        }

        if (cnt[0] % 2 == 0) {
            // Even number of 0s: Alice wins if both 1s and 2s are available
            return cnt[1] >= 1 && cnt[2] >= 1;
        } else {
            // Odd number of 0s: Alice wins if the absolute difference between 1s and 2s is >= 3
            return Math.abs(cnt[1] - cnt[2]) > 2;
        }
    }
}