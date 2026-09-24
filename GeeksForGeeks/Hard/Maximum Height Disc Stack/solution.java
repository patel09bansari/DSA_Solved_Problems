import java.util.Arrays;

class Solution {

    // Fenwick Tree (Binary Indexed Tree) to maintain prefix maximums of heights
    static class FenwickTree {
        int size;
        int[] tree;

        FenwickTree(int size) {
            this.size = size;
            this.tree = new int[size + 1];
            Arrays.fill(tree, 0);
        }

        void update(int index, int val) {
            for (; index <= size; index += index & -index) {
                tree[index] = Math.max(tree[index], val);
            }
        }

        int query(int index) {
            int maxVal = 0;
            for (; index > 0; index -= index & -index) {
                maxVal = Math.max(maxVal, tree[index]);
            }
            return maxVal;
        }
    }

    public int maxStackHeight(int[] r, int[] h) {
        int n = r.length;
        Disc[] discs = new Disc[n];
        for (int i = 0; i < n; i++) {
            discs[i] = new Disc(r[i], h[i]);
        }

        // Sort by radius ascending. If radii are equal, sort by height ascending.
        Arrays.sort(discs, (a, b) -> {
            if (a.r != b.r) return Integer.compare(a.r, b.r);
            return Integer.compare(a.h, b.h);
        });

        // Coordinate compress heights to fit into a Fenwick tree if needed, 
        // or since height values are up to 1000 (based on constraints 1 <= r[i], h[i] <= 1000), 
        // max height bound is small, or we can compress heights.
        int maxH = 0;
        for (int i = 0; i < n; i++) {
            maxH = Math.max(maxH, discs[i].h);
        }

        FenwickTree bit = new FenwickTree(maxH);
        int overallMax = 0;

        // Process discs in groups with the same radius to avoid violating strict inequality
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && discs[j].r == discs[i].r) {
                j++;
            }

            // Query results for the current batch
            int[] currentMaxHeights = new int[j - i];
            for (int k = i; k < j; k++) {
                // We need strictly smaller radius and strictly smaller height: discs[k].h - 1
                int prevMax = bit.query(discs[k].h - 1);
                currentMaxHeights[k - i] = prevMax + discs[k].h;
                overallMax = Math.max(overallMax, currentMaxHeights[k - i]);
            }

            // Update BIT with current batch after processing all of them with the same radius
            for (int k = i; k < j; k++) {
                bit.update(discs[k].h, currentMaxHeights[k - i]);
            }

            i = j;
        }

        return overallMax;
    }

    static class Disc {
        int r, h;
        Disc(int r, int h) {
            this.r = r;
            this.h = h;
        }
    }
}