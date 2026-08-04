class Solution {
    public void bubbleSort(int[] arr) {
        // code here
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            } 
            }
    }
}
//no return type or print as it is void and also in main func it is already defined

//optimized approach
//  for(int i=0; i<arr.length-1; i++){
//             for(int j=0; j<arr.length-1; j++){
// boolean swapped = false;
//                 if(arr[j]>arr[j+1]){
//                     int temp = arr[j];
//                     arr[j]=arr[j+1];
//                     arr[j+1]=temp;
// swapped = true;
//                 }
// if(!swapped){
//     break;
// }
//             } 
//             }

