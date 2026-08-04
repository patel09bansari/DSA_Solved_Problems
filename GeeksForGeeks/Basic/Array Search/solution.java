class Solution {
    public int search(int arr[], int x) {
        int index = 0;
        for(int num: arr){
            if(num == x){
                return index;
            }
            index++;
        } 
        return -1;
    }
}
