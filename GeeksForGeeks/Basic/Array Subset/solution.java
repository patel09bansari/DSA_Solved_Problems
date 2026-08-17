import java.util.Arrays;

class Solution {
    public boolean isSubset(int[] a, int[] b) {
        // Sort both arrays
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0; // Pointer for array 'a'
        int j = 0; // Pointer for array 'b'

        // Traverse both arrays
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                i++; // Move pointer in 'a' to find a matching element
            } else if (a[i] == b[j]) {
                i++; // Match found, move both pointers forward
                j++;
            } else {
                // If a[i] > b[j], b[j] is missing from 'a'
                return false;
            }
        }

        // If we matched all elements of 'b', j will equal b.length
        return j == b.length;
    }
}