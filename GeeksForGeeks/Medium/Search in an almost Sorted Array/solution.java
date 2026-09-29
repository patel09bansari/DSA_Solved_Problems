class Solution {
    public int findTarget(int arr[], int target) {
        int start = 0;
        int n = arr.length-1;
        int end = n;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == arr[mid]){
                return mid;
            } if (mid - 1 >= start && arr[mid-1] == target){
                return mid - 1;
            } if (mid + 1 <= end && arr[mid+1] == target){
                return mid + 1;
            } if (target > arr[mid]){
                start = mid + 2;
            } else {
                end = mid - 2;
            }
        } return -1;
    }
}