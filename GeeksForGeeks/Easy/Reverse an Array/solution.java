// 

class Solution {
    public void reverseArray(int arr[]) {
        int n = arr.length;
        // Create a temporary array of the same size
        int[] temp = new int[n];
        
        // Transfer elements in reverse order to temp
        for (int i = 0; i < n; i++) {
            temp[i] = arr[n - 1 - i];
        }
        
        // Copy the reversed elements back into the original array
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }
}