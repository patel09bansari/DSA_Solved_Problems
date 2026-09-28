/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // Step 1: Find the peak index of the mountain array
        int peak = findPeak(mountainArr);
        
        // Step 2: Search the left (ascending) side
        int leftResult = leftbinarySearch(mountainArr, 0, peak, target);
        if (leftResult != -1) {
            return leftResult; // Return immediately to get the minimum index
        }
        
        // Step 3: If not found on the left, search the right (descending) side
        return rightbinarySearch(mountainArr, peak + 1, mountainArr.length() - 1, target);
    }

//Helper functions
        //1. peak element
        private int findPeak(MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length()-1;
        while(left < right){
            int mid = left + (right - left) / 2;
        if(mountainArr.get(mid) < mountainArr.get(mid+1)){
            left = mid + 1;
        } else {
            right = mid;
        }
    } return left;
    }

    //Helper left binary search
    private int leftbinarySearch(MountainArray mountainArr, int left, int right, int target){
        while(left <= right){
         int mid = left + (right - left) / 2;
        if(mountainArr.get(mid) == target){
            return mid;
        } else if(target < mountainArr.get(mid)){
            right = mid - 1;
        } else {
            left = mid + 1;
        }
        } return -1;
    }

    //Helper right binary search 
    private int rightbinarySearch(MountainArray mountainArr, int left, int right, int target){
        while(left <= right){
        int mid = left + (right - left) / 2;
           if(mountainArr.get(mid) == target){
            return mid; 
        } else if(target < mountainArr.get(mid)){
            left = mid + 1;
        } else {
            right = mid - 1;
        }
     } return -1;
    }
}
