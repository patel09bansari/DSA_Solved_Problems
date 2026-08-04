class Solution {
    public boolean isPalindrome(int n) {
        n = Math.abs(n);
        
        int ori = n;
        int rev = 0;
        
        while (n > 0) {
            int digit = n % 10;
            rev = (rev * 10) + digit;
            n = n / 10;
        }
        
        return ori == rev;
    }
}