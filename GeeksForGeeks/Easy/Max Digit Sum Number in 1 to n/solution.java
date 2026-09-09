class Solution {
    public int findMax(int n) {
        String s = String.valueOf(n);
        int len = s.length();

        int bestNum = n;
        int maxSum = getDigitSum(n);

        // Try reducing each digit position to maximize trailing 9s
        for (int i = 0; i < len; i++) {
            int digit = s.charAt(i) - '0';
            if (digit == 0) continue;

            // Build candidate: same prefix up to i-1, (digit - 1) at i, rest 9s
            StringBuilder candidateStr = new StringBuilder();
            candidateStr.append(s, 0, i);
            candidateStr.append(digit - 1);
            for (int j = i + 1; j < len; j++) {
                candidateStr.append('9');
            }

            int candidate = Integer.parseInt(candidateStr.toString());
            int sum = getDigitSum(candidate);

            if (sum > maxSum || (sum == maxSum && candidate > bestNum)) {
                maxSum = sum;
                bestNum = candidate;
            }
        }

        return bestNum;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}