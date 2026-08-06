class Solution {
    int missingNum(int[] arr) {
        // Size of arr is n - 1, so total elements n including the missing number
        long n = arr.length + 1;
        
        // Expected sum of numbers from 1 to n
        long expectedSum = n * (n + 1) / 2;
        
        // Calculate the actual sum of elements in arr
        long actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }
        
        // The difference gives the missing number
        return (int) (expectedSum - actualSum);
    }
}