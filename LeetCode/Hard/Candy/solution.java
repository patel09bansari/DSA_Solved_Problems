class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int candies[] = new int[n];

        // Initially, every child gets one candy
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        // Satisfy the left-neighbour condition
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Satisfy the right-neighbour condition
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(
                    candies[i], candies[i + 1] + 1
                );
            }
        }
        
        int total = 0;
        for (int c : candies) {
            total += c;
        }
        return total;
    }

    }