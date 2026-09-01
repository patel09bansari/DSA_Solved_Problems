class Solution {
    void pushZerosToEnd(int[] arr) {
        int l = 0;
        int r = 0;
        while(r<arr.length){
           
             if(arr[r] != 0) {
            int temp = arr[r];
            arr[r]=arr[l];
            arr[l]=temp;
            l++;    
            } r++;
        } 
    }
}