class Solution {
    public String smallestNumber(String num, long t) {
        long tempT = t;
        int[] req = new int[10];
        int[] primes = {2, 3, 5, 7};
        
        for (int p : primes) {
            while (tempT % p == 0) {
                req[p]++;
                tempT /= p;
            }
        }
        
        if (tempT > 1) {
            return "-1";
        }

        int n = num.length();
        int zeroPos = num.indexOf('0');
        int maxPrefixLen = (zeroPos == -1) ? n : zeroPos;

        // Precompute total counts for prefix up to maxPrefixLen
        int c2 = 0, c3 = 0, c5 = 0, c7 = 0;
        for (int k = 0; k < maxPrefixLen; k++) {
            int d = num.charAt(k) - '0';
            c2 += getFactor(d, 2);
            c3 += getFactor(d, 3);
            c5 += getFactor(d, 5);
            c7 += getFactor(d, 7);
        }

        for (int i = maxPrefixLen; i >= 0; i--) {
            // Subtract factors of num[i] as we back-track i to maintain prefix factor counts in O(1)
            if (i < maxPrefixLen) {
                int prevD = num.charAt(i) - '0';
                c2 -= getFactor(prevD, 2);
                c3 -= getFactor(prevD, 3);
                c5 -= getFactor(prevD, 5);
                c7 -= getFactor(prevD, 7);
            }

            // Check if num itself works when i == n
            if (i == n) {
                if (req[2] <= c2 && req[3] <= c3 && req[5] <= c5 && req[7] <= c7) {
                    return num;
                }
                continue;
            }

            int startDigit = (i == maxPrefixLen && zeroPos != -1) 
                             ? 1 
                             : (num.charAt(i) - '0' + 1);

            for (int d = startDigit; d <= 9; d++) {
                int nc2 = c2 + getFactor(d, 2);
                int nc3 = c3 + getFactor(d, 3);
                int nc5 = c5 + getFactor(d, 5);
                int nc7 = c7 + getFactor(d, 7);

                int rem2 = Math.max(0, req[2] - nc2);
                int rem3 = Math.max(0, req[3] - nc3);
                int rem5 = Math.max(0, req[5] - nc5);
                int rem7 = Math.max(0, req[7] - nc7);

                int remLen = n - 1 - i;
                if (getMinDigitsNeeded(rem2, rem3, rem5, rem7) <= remLen) {
                    return num.substring(0, i) + d + buildMinSuffix(rem2, rem3, rem5, rem7, remLen);
                }
            }
        }

        // Increment length if no valid prefix found for length n
        for (int len = n + 1; ; len++) {
            if (getMinDigitsNeeded(req[2], req[3], req[5], req[7]) <= len) {
                return buildMinSuffix(req[2], req[3], req[5], req[7], len);
            }
        }
    }

    private int getFactor(int digit, int prime) {
        if (digit == 0) return 0;
        int count = 0;
        while (digit % prime == 0) {
            count++;
            digit /= prime;
        }
        return count;
    }

    private int getMinDigitsNeeded(int r2, int r3, int r5, int r7) {
        int c9 = r3 / 2;
        int rem3 = r3 % 2;

        int c8 = r2 / 3;
        int rem2 = r2 % 3;

        int c6 = 0;
        if (rem3 == 1 && rem2 == 1) {
            c6 = 1;
            rem3 = 0;
            rem2 = 0;
        }

        int c4 = rem2 / 2;
        rem2 %= 2;

        return c9 + c8 + r7 + r5 + c6 + c4 + rem3 + rem2;
    }

    private String buildMinSuffix(int r2, int r3, int r5, int r7, int targetLen) {
        StringBuilder sb = new StringBuilder();
        int cur2 = r2, cur3 = r3, cur5 = r5, cur7 = r7;

        for (int pos = 0; pos < targetLen; pos++) {
            int remLen = targetLen - 1 - pos;

            for (int d = 1; d <= 9; d++) {
                int next2 = Math.max(0, cur2 - getFactor(d, 2));
                int next3 = Math.max(0, cur3 - getFactor(d, 3));
                int next5 = Math.max(0, cur5 - getFactor(d, 5));
                int next7 = Math.max(0, cur7 - getFactor(d, 7));

                if (getMinDigitsNeeded(next2, next3, next5, next7) <= remLen) {
                    sb.append(d);
                    cur2 = next2;
                    cur3 = next3;
                    cur5 = next5;
                    cur7 = next7;
                    break;
                }
            }
        }

        return sb.toString();
    }
}