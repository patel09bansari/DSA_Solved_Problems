class Solution {
    public int minimumSum(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0, j = n - 1;

        // Step 1: Make the string a palindrome by matching characters from both ends
        while (i < j) {
            if (arr[i] != '?' && arr[j] != '?') {
                if (arr[i] != arr[j]) return -1;
            } else if (arr[i] != '?') {
                arr[j] = arr[i];
            } else if (arr[j] != '?') {
                arr[i] = arr[j];
            }
            i++;
            j--;
        }

        // Step 2: Replace remaining '?' characters with the nearest non-'?' character
        char prev = ' ';
        for (i = 0; i < n; i++) {
            if (arr[i] != '?') {
                prev = arr[i];
                break;
            }
        }

        // If all characters are '?'
        if (prev == ' ') {
            return 0;
        }

        // Fill leading '?' with the first available non-'?' character
        for (i = 0; i < n; i++) {
            if (arr[i] == '?') {
                arr[i] = prev;
            } else {
                prev = arr[i];
            }
        }

        // Step 3: Calculate the sum of absolute differences between adjacent characters
        int sum = 0;
        for (i = 0; i < n - 1; i++) {
            sum += Math.abs(arr[i] - arr[i + 1]);
        }

        return sum;
    }
}