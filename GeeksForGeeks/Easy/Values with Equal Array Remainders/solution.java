import java.util.Arrays;

class Solution {
    public int sameMod(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return -1;
        }

        // Find the overall GCD of differences relative to arr[0]
        int g = 0;
        for (int i = 1; i < n; i++) {
            int diff = Math.abs(arr[i] - arr[0]);
            g = gcd(g, diff);
        }

        // If all elements are equal, differences are 0, yielding infinite k
        if (g == 0) {
            return -1;
        }

        // Count all positive divisors of g
        int divisorCount = 0;
        for (int i = 1; (long) i * i <= g; i++) {
            if (g % i == 0) {
                divisorCount++; // i is a divisor
                if (i * i != g) {
                    divisorCount++; // g / i is also a divisor
                }
            }
        }

        return divisorCount;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}