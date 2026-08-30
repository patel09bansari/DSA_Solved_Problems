import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int n = l.length;
        long[] pref = new long[n];

        pref[0] = r[0] - l[0] + 1;
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + (r[i] - l[i] + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int k : rank) {
            // Binary search to find the first interval where pref[mid] >= k
            int low = 0, high = n - 1;
            int intervalIdx = n - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (pref[mid] >= k) {
                    intervalIdx = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // Calculate the exact mark within the found interval
            long prevCount = (intervalIdx > 0) ? pref[intervalIdx - 1] : 0;
            long offset = k - prevCount - 1;
            result.add((int) (l[intervalIdx] + offset));
        }

        return result;
    }
}