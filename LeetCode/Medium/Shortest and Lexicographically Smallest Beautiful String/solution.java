class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int count = 0;
        int left = 0;
        String ans = "";

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                count++;
            }

            // Shrink window from the left if we have enough '1's
            while (count == k) {
                String sub = s.substring(left, right + 1);

                // Update answer if it's shorter, or same length but lexicographically smaller
                if (ans.isEmpty() || sub.length() < ans.length() || 
                   (sub.length() == ans.length() && sub.compareTo(ans) < 0)) {
                    ans = sub;
                }

                if (s.charAt(left) == '1') {
                    count--;
                }
                left++;
            }
        }

        return ans;
    }
}