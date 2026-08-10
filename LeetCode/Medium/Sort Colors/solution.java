class Solution {
    public void sortColors(int[] nums) {
        int l =0;
		int m = 0;
        int h = nums.length-1;
		//dutch national flag algo

        //mid from start to high
		while(m<=h){
            // if(nums[l]==0){
            //     l++;
            // }
            // if(nums[h]==2){
            //     h--;
            // }

		    if(nums[m]==0){
		        int temp = nums[m];
		        nums[m]=nums[l];
		        nums[l]=temp;
		        l++;
                m++;
		    }
           else if(nums[m]==1){
                m++;
            }
            // if(nums[m]==2)
           else {
		        int temp = nums[m];
		        nums[m]=nums[h];
		        nums[h]=temp;
		        h--;
                // m++;
		    }
        }
    }
}