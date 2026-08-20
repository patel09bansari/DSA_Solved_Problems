// class Solution {
//     public int[] sortedSquares(int[] nums) {
//         int result[] = new int[nums.length];
//         int s=0;
//         int e=nums.length-1;

//         //result
//         for(int i=nums.length-1; i>=0; i--){
//             int sSquare = nums[s]*nums[s];
//             int eSquare = nums[e]*nums[e];

//             if(sSquare > eSquare){
//                 result[i] = sSquare;
//                 s++;
//             } else {
//               result[i] = eSquare;
//               e--;

//             }
//         }
//         return result;
//         // Arrays.sort(result);
//         //  return r+esult;
//     }
// }


import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        // Step 1: Square each element in the array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        
        // Step 2: Sort the array in non-decreasing order
        Arrays.sort(nums);
        
        // Return the modified array
        return nums;
    }
}