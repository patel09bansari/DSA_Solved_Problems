/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;

        int firstCriticalIndex = -1;
        int lastCriticalIndex = -1;
        int minDistance = Integer.MAX_VALUE;

        while (curr.next != null) {
            ListNode next = curr.next;

            // Check if current node is a local maxima or minima
            boolean isLocalMaxima = curr.val > prev.val && curr.val > next.val;
            boolean isLocalMinima = curr.val < prev.val && curr.val < next.val;

            if (isLocalMaxima || isLocalMinima) {
                if (firstCriticalIndex == -1) {
                    firstCriticalIndex = index;
                } else {
                    // Update minimum distance using adjacent critical points
                    minDistance = Math.min(minDistance, index - lastCriticalIndex);
                }
                lastCriticalIndex = index;
            }

            prev = curr;
            curr = next;
            index++;
        }

        // If fewer than 2 critical points were found
        if (firstCriticalIndex == lastCriticalIndex) {
            return new int[]{-1, -1};
        }

        int maxDistance = lastCriticalIndex - firstCriticalIndex;
        return new int[]{minDistance, maxDistance};
    }
}