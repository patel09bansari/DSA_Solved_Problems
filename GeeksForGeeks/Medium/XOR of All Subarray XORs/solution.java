class Solution {
    public int subarrayXor(int[] arr) {
        int n = arr.length;

        // If length is even, all elements appear an even number of times
        if (n % 2 == 0) {
            return 0;
        }

        // If length is odd, only elements at even indices appear an odd number of times
        int ans = 0;
        for (int i = 0; i < n; i += 2) {
            ans ^= arr[i];
        }

        return ans;
    }
}