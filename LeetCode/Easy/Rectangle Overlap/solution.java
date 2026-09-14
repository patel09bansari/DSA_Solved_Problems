class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // Two rectangles overlap if they overlap on both the X-axis and Y-axis projections.
        // Left boundary < Right boundary AND Bottom boundary < Top boundary
        return Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2]) &&
               Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]);
    }
}