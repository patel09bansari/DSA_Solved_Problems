class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        int m = mat.length;
        int n = mat[0].length;
        
        int low = 0;
        int high = (m*n) - 1;
        
        while(low<=high){
            int mid = low + (high - low) / 2;
            
            //konsa row an dkonsa col 
            int row = mid / n;
            int col = mid % n;
            
            if(mat[row][col] == x){
                return true;
            }
            else if(x > mat[row][col]){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        } return false;
    }
}
