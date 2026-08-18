class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mapS = new int[256]; // Last seen position + 1 for s
        int[] mapT = new int[256]; // Last seen position + 1 for t

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // If the last seen positions don't match, mapping is broken
            if (mapS[c1] != mapT[c2]) {
                return false;
            }

            // Store i + 1 (since default value in array is 0)
            mapS[c1] = i + 1;
            mapT[c2] = i + 1;
        }

        return true;
    }
}