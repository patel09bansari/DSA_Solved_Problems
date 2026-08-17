class Solution {
    // Function to return list containing first n fibonacci numbers using recursion.
    public static int[] fibonacciNumbers(int n) {
        int[] res = new int[n];
        generateFibonacci(n, res);
        return res;
    }

    private static void generateFibonacci(int n, int[] res) {
        if (n == 1) {
            res[0] = 0;
            return;
        }
        if (n == 2) {
            generateFibonacci(1, res);
            res[1] = 1;
            return;
        }

        generateFibonacci(n - 1, res);
        res[n - 1] = res[n - 2] + res[n - 3];
    }
}