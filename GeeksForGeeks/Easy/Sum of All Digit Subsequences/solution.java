class Solution {
    public int subsequenceSum(String s) {
        long mod = 1000000007L;
        int n = s.length();

        // Calculate sum of all digits in the string
        long digitSum = 0;
        for (int i = 0; i < n; i++) {
            digitSum = (digitSum + (s.charAt(i) - '0')) % mod;
        }

        // Calculate (2^(n - 1)) % mod
        long powerOfTwo = modPow(2, n - 1, mod);

        return (int) ((digitSum * powerOfTwo) % mod);
    }

    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}