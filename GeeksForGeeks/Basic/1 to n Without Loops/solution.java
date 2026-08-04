class Solution {
    public void printTillN(int n) {
        // stop when n reaches 0
        if (n == 0) {
            return;
        }
        
        // First recursively call for n - 1
        printTillN(n - 1);
        
        // Print the current number followed by a space
        System.out.print(n + " ");
    }
}