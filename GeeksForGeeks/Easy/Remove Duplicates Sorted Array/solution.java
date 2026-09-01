class Solution {
    ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(arr.length < 0){
            return ans;
        }
        int l = 0;
        int r = 1;
        
        ans.add(arr[0]);
        while(r<arr.length){
            if(arr[l] != arr[r]){
                l = r;
                ans.add(arr[r]);
            } r++;
        } return ans;
    }
}
