class Solution {
    public String maxSumOfSquares(int num, int sum) {
        // Check if it's possible: min sum needed is 0 (or 1 if leading digit cannot be 0, but since num digits can have leading zeros unless specified... wait, n is a positive integer so the first digit cannot be 0 if num > 1, or if num=1, sum must be 1-9).
        // Max possible sum with 'num' digits is num * 9.
        if (sum < 0 || (long) num * 9 < sum) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            int remainingPositions = num - 1 - i;
            // We want to pick the largest possible digit d (from 9 down to 0)
            // such that the remaining sum can be formed by the remaining positions.
            // That means: sum - d <= remainingPositions * 9  =>  d >= sum - remainingPositions * 9
            // Also, d <= sum and d <= 9.
            // If i == 0 and num > 1, the first digit cannot be 0 unless sum == 0 (which is invalid since sum >= 1).
            
            int low = Math.max(0, sum - remainingPositions * 9);
            int high = Math.min(9, sum);
            
            int chosen = -1;
            for (int d = high; d >= low; d--) {
                // If it's the very first digit and num > 1, we usually can't have leading zeros, 
                // but a positive integer with `num` digits means the first digit is 1-9 anyway since low will be at least 1 if necessary.
                if (i == 0 && num > 1 && d == 0) continue;
                chosen = d;
                break;
            }
            
            if (chosen == -1) {
                return "";
            }
            
            sb.append(chosen);
            sum -= chosen;
        }

        return sum == 0 ? sb.toString() : "";
    }
}