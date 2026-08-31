class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
         int left = 0; 
        int right = n-1;

        while(left <= right){
            int mid = left + (right-left) / 2;

            if(nums[mid]==target){
                return mid;
            }

            //comparing mid with left part
            //checking left hallf is sorted or not
            else if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target <= nums[mid]){
                right = mid - 1; 
                } else {
                    left = mid + 1;
                }
            }
            else {
                   if(target <= nums[right] && target >= nums[mid]){
                    left = mid+1;
                    } else {
                        right = mid - 1;
                    }
            } 
       
    } return -1;
} 
}