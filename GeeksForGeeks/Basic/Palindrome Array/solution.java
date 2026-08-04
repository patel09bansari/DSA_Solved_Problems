class Solution {
    public static boolean isPalindrome(int[] arr) {
        int s=0; 
        int e=arr.length-1;
        while(s<e) {
            if(arr[s]!=arr[e]){
                return false;
            }
            s++;
            e--;
        } return true;

}
}
