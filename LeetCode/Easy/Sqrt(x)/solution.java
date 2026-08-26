class Solution {
    public int mySqrt(int x) {

        // double s = Math.sqrt(x);
        // return (int) s;




       if (x < 2) return x;

        int left = 1; 
        int right = x;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid <= x / mid) {
                ans = mid;        // Candidate answer found
                left = mid + 1;   // Try finding a larger valid integer
            } else {
                right = mid - 1;  // Too large, search left
            }
        }

        return ans;
    }
}