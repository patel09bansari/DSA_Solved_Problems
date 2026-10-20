import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> lexicographicallyLargest(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;

        int i = 0;
        while (i < n) {
            int j = i;
            // Find the contiguous segment with the same parity
            while (j < n && (arr[j] % 2) == (arr[i] % 2)) {
                j++;
            }

            // Extract the segment, sort it in descending order to get the largest lexicographical arrangement
            ArrayList<Integer> segment = new ArrayList<>();
            for (int k = i; k < j; k++) {
                segment.add(arr[k]);
            }
            segment.sort(Collections.reverseOrder());

            // Add sorted elements to the result
            result.addAll(segment);

            // Move to the next segment
            i = j;
        }

        return result;
    }
}