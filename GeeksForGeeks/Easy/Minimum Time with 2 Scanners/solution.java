class Solution {
    public int minTime(int n, int s1, int s2) {
        long low = 1;
        long high = Math.min((long) s1 * n, (long) s2 * n);
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long scanned = (mid / s1) + (mid / s2);

            if (scanned >= n) {
                ans = mid;
                high = mid - 1; // Try to find a smaller valid time
            } else {
                low = mid + 1;
            }
        }

        return (int) ans;
    }
}