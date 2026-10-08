import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);
        long currentSum = 0;
        int left = 0;
        int maxFreq = 0;

        for (int right = 0; right < arr.length; right++) {
            currentSum += arr[right];

            // Check if operations needed to make all elements in window [left, right] 
            // equal to arr[right] exceeds k
            while ((long) (right - left + 1) * arr[right] - currentSum > k) {
                currentSum -= arr[left];
                left++;
            }

            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }
}