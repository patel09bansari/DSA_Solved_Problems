class Solution {
    public int[] countOddEven(int[] arr) {
        int oddCount = 0;
        int evenCount = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                oddCount++;
            } else {
                evenCount++;
            }
        }
        
        return new int[]{oddCount, evenCount};
    }
}