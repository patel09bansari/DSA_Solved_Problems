class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int max=-1;
        int secondMax=-1;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                secondMax=max;
                max=arr[i];
            }
                if(arr[i]<max && arr[i]>secondMax){
                    secondMax = arr[i];
                }
        } 
        return secondMax;
    }
}