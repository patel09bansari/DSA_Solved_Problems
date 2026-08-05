class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] temp = new int[1001];
        int size = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                
                // If we find a match
                if (nums1[i] == nums2[j]) {
                    
                    // Check if we already added this number to temp
                    boolean alreadyAdded = false;
                    for (int k = 0; k < size; k++) {
                        if (temp[k] == nums1[i]) {
                            alreadyAdded = true;
                            break;
                        }
                    }

                    // If it's a new common number, save it
                    if (!alreadyAdded) {
                        temp[size++] = nums1[i];
                    }

                    break; // Move to the next element in nums1
                }
            }
        }

        // Return exact size array
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = temp[i];
        }

        return result;
    }
}