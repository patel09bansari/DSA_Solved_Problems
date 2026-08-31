class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //checking if matrix is empty and if empty then return false
        // if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        //     return false;
        // }

        int m = matrix.length;
        int n = matrix[0].length;

        //initializing as 1D array
        int low = 0;
        int high = (m * n) - 1;

        while(low <= high){
            //cal mid
            int mid = low + (high - low) / 2;

            //cal row and col of ele at mid index
            int row = mid / n;
            int col = mid % n;

            if(matrix[row][col] == target){
                return true;
            }

            else if(matrix[row][col] < target){
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        } return false;
    }
}