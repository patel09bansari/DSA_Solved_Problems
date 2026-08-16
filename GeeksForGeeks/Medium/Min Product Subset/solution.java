class Solution {
     public int minProd(int[] arr) {
         int n = arr.length;
         if (n == 1) return arr[0];

         int negCount = 0;
         int zeroCount = 0;
         int maxNeg = Integer.MIN_VALUE;
         int minPos = Integer.MAX_VALUE;
         int prod = 1;

         for (int x : arr) {
             if (x == 0) {
                 zeroCount++;
                 continue;
             }
             if (x < 0) {
                 negCount++;
                 maxNeg = Math.max(maxNeg, x);
             } else {
                 minPos = Math.min(minPos, x);
             }
             prod *= x;
         }

         // Case 1: No negative numbers present
         if (negCount == 0) {
             if (zeroCount > 0) return 0;
             return minPos;
         }

         // Case 2: Even number of negative numbers present
         if (negCount % 2 == 0) {
             prod /= maxNeg;
         }

         return prod;
     }
 }