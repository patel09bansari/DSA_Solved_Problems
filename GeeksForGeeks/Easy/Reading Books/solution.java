class Solution {
    public int maxPoint(int k, int[] arr1, int[] arr2) {
        int max=0;
    for(int i=0; i<arr1.length; i++){
        for(int j=0; j<arr2.length; j++){
            int div = k/arr1[i];
            int ans = div*arr2[i];
            if(ans>max){
                max=ans;
            }
        }
    } return max;
    }
}




//     int max=0;
//     for(int i=0; i<arr1.length; i++){
//         int j=i;
//             int div = k/arr1[i];
//             int ans = div * arr2[j];
//             if(ans>max){
//                 max=ans;
//             }
//     } 
//     return max;
//     }
// }

