import java.util.PriorityQueue;

class Solution {
    public int minComputation(int[] files) {
        // Create a min-heap to always get the smallest file sizes
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int file : files) {
            minHeap.add(file);
        }

        int totalCost = 0;

        // Combine files until only one file remains
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();

            int mergeCost = first + second;
            totalCost += mergeCost;

            minHeap.add(mergeCost);
        }

        return totalCost;
    }
}