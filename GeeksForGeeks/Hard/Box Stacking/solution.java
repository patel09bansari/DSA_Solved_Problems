import java.util.*;

class Solution {

    static class Box {
        int h, w, l;

        Box(int h, int w, int l) {
            this.h = h;

            // Store base as smaller x larger
            this.w = Math.min(w, l);
            this.l = Math.max(w, l);
        }
    }

    public int maxHeight(int[] height, int[] width, int[] length) {

        int n = height.length;

        // 3 rotations for every box
        Box[] boxes = new Box[3 * n];

        int k = 0;

        for (int i = 0; i < n; i++) {

            // Rotation 1
            boxes[k++] = new Box(
                height[i],
                width[i],
                length[i]
            );

            // Rotation 2
            boxes[k++] = new Box(
                width[i],
                height[i],
                length[i]
            );

            // Rotation 3
            boxes[k++] = new Box(
                length[i],
                height[i],
                width[i]
            );
        }

        // Sort by base dimensions
        Arrays.sort(boxes, new Comparator<Box>() {
            public int compare(Box a, Box b) {

                if (a.w != b.w) {
                    return Integer.compare(a.w, b.w);
                }

                return Integer.compare(a.l, b.l);
            }
        });

        int m = boxes.length;

        /*
         * dp[i] = maximum stack height
         * with boxes[i] as the bottom box.
         */
        int[] dp = new int[m];

        int ans = 0;

        for (int i = 0; i < m; i++) {

            dp[i] = boxes[i].h;

            for (int j = 0; j < i; j++) {

                /*
                 * j is smaller, so it can be placed
                 * on top of i.
                 */
                if (boxes[j].w < boxes[i].w &&
                    boxes[j].l < boxes[i].l) {

                    dp[i] = Math.max(
                        dp[i],
                        boxes[i].h + dp[j]
                    );
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}