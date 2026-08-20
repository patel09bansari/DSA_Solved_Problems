/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    int maxDiff = Integer.MIN_VALUE;

    int maxDiff(Node root) {
        solve(root);
        return maxDiff;
    }

    private int solve(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        // Base case: leaf nodes have no descendants
        if (node.left == null && node.right == null) {
            return node.data;
        }

        // Get the minimum value from left and right subtrees
        int leftMin = solve(node.left);
        int rightMin = solve(node.right);

        int minDescendant = Math.min(leftMin, rightMin);

        // Update maximum difference (Ancestor - Descendant)
        maxDiff = Math.max(maxDiff, node.data - minDescendant);

        // Return the minimum node value in the current subtree
        return Math.min(node.data, minDescendant);
    }
}