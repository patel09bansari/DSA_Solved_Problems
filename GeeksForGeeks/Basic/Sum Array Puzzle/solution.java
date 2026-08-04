class Solution {
    public void sumArray(int[] arr) {
        int sum=0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        for(int i=0; i<arr.length; i++){
            arr[i] = sum-arr[i];
        }
    }
}



// First we will sum up the whole array and then in another loop we will just 
// subtract the arr[i] element from the total sum 