class Solution {
    // Please change the array in-place
    public void insertionSort(int arr[]) {
        // code here
        //first is always sorted so key is 0+1=i
        for(int i=1; i<arr.length; i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
        
        
        //created space 
        
        
        
        
        //adds element or key in that space 
    }
}