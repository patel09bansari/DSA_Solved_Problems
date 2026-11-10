import java.util.HashMap;

class Solution {
    public int firstElementKTime(int[] arr, int k) {
        // If k is 1, the very first element itself meets the condition
        if (k == 1) {
            return arr.length > 0 ? arr[0] : -1;
        }

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : arr) {
            int count = freqMap.getOrDefault(num, 0) + 1;

            // Return immediately as soon as an element hits k occurrences
            if (count == k) {
                return num;
            }

            freqMap.put(num, count);
        }

        return -1;
    }
}