class Solution {
    private int[][][] dp;
    private String numStr;
    private int digitToAvoid;

    public int countWithout(int n, int d) {
        if (n <= 0) return 0;

        numStr = String.valueOf(n);
        digitToAvoid = d;

        // dp[index][isTight][hasStarted]
        dp = new int[numStr.length()][2][2];
        for (int i = 0; i < numStr.length(); i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(0, 1, 0);
    }

    private int solve(int index, int isTight, int hasStarted) {
        if (index == numStr.length()) {
            return hasStarted == 1 ? 1 : 0;
        }

        if (dp[index][isTight][hasStarted] != -1) {
            return dp[index][isTight][hasStarted];
        }

        int limit = (isTight == 1) ? (numStr.charAt(index) - '0') : 9;
        int count = 0;

        for (int digit = 0; digit <= limit; digit++) {
            // Only reject digit if it matches 'd' AND it's a real digit (not a leading zero)
            if (digit == digitToAvoid && (hasStarted == 1 || digit > 0)) {
                continue;
            }

            int nextTight = (isTight == 1 && digit == limit) ? 1 : 0;
            int nextStarted = (hasStarted == 1 || digit > 0) ? 1 : 0;

            count += solve(index + 1, nextTight, nextStarted);
        }

        return dp[index][isTight][hasStarted] = count;
    }
}