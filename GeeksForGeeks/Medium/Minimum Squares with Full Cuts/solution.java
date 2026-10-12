class Solution {
    public int minSquares(int n, int m) {
        int count = 0;

        while (n > 0 && m > 0) {
            if (n == m) {
                count += 1;
                break;
            }

            if (n < m) {
                // Swap to ensure n is always the larger dimension
                int temp = n;
                n = m;
                m = temp;
            }

            // Cut out as many squares of size m x m as possible
            count += n / m;
            n = n % m;
        }

        return count;
    }
}