class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        //ot passed equals because
        while(low < high){
            int mid = low + (high-low) / 2;
            if(arr[mid] < arr[mid+1] ){
                low = mid + 1;
                } //goes right side incresing side
                else {
                    high = mid; //goes left if something left
                }
        } return low;  //or returb high both works

    }
}