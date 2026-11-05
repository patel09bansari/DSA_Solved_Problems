class Solution {
    public int getMinimumDays(String s, int[] p) {
        int n = s.length();
        char[] arr = s.toCharArray();

        int duplicates = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                duplicates++;
            }
        }

        // If already valid without any replacements
        if (duplicates == 0) {
            return 0;
        }

        for (int day = 0; day < n; day++) {
            int idx = p[day];

            // Check left neighbor
            if (idx > 0 && arr[idx] != '?' && arr[idx] == arr[idx - 1]) {
                duplicates--;
            }
            // Check right neighbor
            if (idx < n - 1 && arr[idx] != '?' && arr[idx] == arr[idx + 1]) {
                duplicates--;
            }

            // Replace character with '?'
            arr[idx] = '?';

            if (duplicates == 0) {
                return day + 1;
            }
        }

        return 0;
    }
}