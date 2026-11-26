class Solution {
    public ArrayList<Integer> countVowels(String s, int[][] queries) {
        int n = s.length();
        int[] pref = new int[n + 1];

        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (isVowel(s.charAt(i)) ? 1 : 0);
        }

        ArrayList<Integer> ans = new ArrayList<>(queries.length);
        for (int[] q : queries) {
            ans.add(pref[q[1] + 1] - pref[q[0]]);
        }

        return ans;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}