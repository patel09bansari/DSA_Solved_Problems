import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freq = new int[n + 1];
        long minPrice = Long.MAX_VALUE;

        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }

        // multiples[f] = total count of items whose factor is a multiple of f
        int[] multiples = new int[n + 1];
        for (int f = 1; f <= n; f++) {
            if (freq[f] == 0) continue;
            for (int m = f; m <= n; m += f) {
                multiples[f] += freq[m];
            }
        }

        // Pair each item with {price, gain}
        int[][] itemInfo = new int[n][2];
        for (int i = 0; i < n; i++) {
            int f = items[i][0];
            int p = items[i][1];
            int gain = multiples[f] - 1; // exclude itself (i != j)
            itemInfo[i][0] = p;
            itemInfo[i][1] = gain;
        }

        // Sort items by price ascending
        Arrays.sort(itemInfo, Comparator.comparingInt(a -> a[0]));

        long remBudget = budget;
        long totalItems = 0;

        for (int[] info : itemInfo) {
            long price = info[0];
            long gain = info[1];

            if (gain == 0) continue;
            if (price >= 2 * minPrice) break;

            long canBuy = Math.min(gain, remBudget / price);
            totalItems += canBuy * 2;
            remBudget -= canBuy * price;
        }

        // Spend any leftover budget on the single cheapest item (value = 1 per copy)
        totalItems += remBudget / minPrice;

        return (int) totalItems;
    }
}