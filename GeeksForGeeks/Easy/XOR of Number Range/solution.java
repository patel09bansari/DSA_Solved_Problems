class Solution {
    // Helper function to find XOR from 1 to n in O(1) time
    private int xorTillN(int n) {
        if (n % 4 == 0) return n;
        if (n % 4 == 1) return 1;
        if (n % 4 == 2) return n + 1;
        return 0; // when n % 4 == 3
    }

    public int findXOR(int l, int r) {
        return xorTillN(r) ^ xorTillN(l - 1);
    }
}