import java.util.*;

class Solution {

    public String findLongestWord(String s, List<String> d) {

        // Store positions of each character in s
        List<Integer>[] pos = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }

        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a'].add(i);
        }

        String answer = "";

        for (String word : d) {

            int prev = -1;
            boolean possible = true;

            for (int j = 0; j < word.length(); j++) {

                int c = word.charAt(j) - 'a';

                // Find first position > prev
                int index = upperBound(pos[c], prev);

                if (index == pos[c].size()) {
                    possible = false;
                    break;
                }

                prev = pos[c].get(index);
            }

            if (possible) {

                if (word.length() > answer.length()) {
                    answer = word;
                }
                else if (word.length() == answer.length()
                         && word.compareTo(answer) < 0) {
                    answer = word;
                }
            }
        }

        return answer;
    }

    // First index whose value is greater than target
    private int upperBound(List<Integer> list, int target) {

        int low = 0;
        int high = list.size();

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (list.get(mid) <= target) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        return low;
    }
}