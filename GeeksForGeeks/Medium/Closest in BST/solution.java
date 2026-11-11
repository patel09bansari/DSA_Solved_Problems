/*
class Node {
    int data;
    Node left, right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int minDiff(Node root, int k) {
        int minDiff = Integer.MAX_VALUE;
        Node curr = root;

        while (curr != null) {
            minDiff = Math.min(minDiff, Math.abs(curr.data - k));

            if (minDiff == 0) {
                return 0;
            }

            if (k < curr.data) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return minDiff;
    }
}